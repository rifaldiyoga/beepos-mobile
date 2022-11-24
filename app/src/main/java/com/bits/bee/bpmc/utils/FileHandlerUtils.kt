package com.bits.bee.bpmc.utils

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import java.io.*
import java.util.*

class FileHandlerUtils {

    companion object{

        fun createFolder(path: String){
            if (!isFileExist(path)){
                val dir = File(path)
                dir.mkdir()
            }
        }

        private fun isFileExist(path: String): Boolean{
            val file: File = File(path)
            return file.exists()
        }

        private fun deleteFile(path: String): Boolean {
            val file = File(path)
            return file.delete()
        }

        fun saveBitmap(ctx: Context, img: Bitmap, path: String, imgTitle: String): String{
            try {
                if (img.isRecycled() || img == null) {
                    return ""
                }
            }catch (o: Exception){
                return ""
            }

            try {
                var returnPath: String? = null

                var tempPath = BPMConstants.getDatapath() + path
                val dir = File(tempPath)
                if (!isFileExist(tempPath)){
                    dir.mkdir()
                }else {
                    if (isFileExist("$tempPath$imgTitle.jpg")) {
                        val file = File(tempPath + imgTitle + ".jpg")
                        return file.absolutePath
                    }
                }

                var fos: OutputStream? = null
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    val resolver: ContentResolver = ctx.getContentResolver()
                    val contentValues = ContentValues()
                    contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, "$imgTitle.jpg")
                    contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                    contentValues.put(
                        MediaStore.MediaColumns.RELATIVE_PATH,
                        Environment.DIRECTORY_PICTURES + path
                    )
                    val imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                    fos = Objects.requireNonNull(imageUri)?.let { resolver.openOutputStream(it) }!!
                    returnPath = imageUri?.let { getRealPathFromURI(ctx, it) }
//                    img.rotate(90F)

                    img.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                    Objects.requireNonNull(fos).close()
                }else{
                    val bytes = ByteArrayOutputStream()
//                    img.rotate(90F)
                    img.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
                    val file = File(dir,  "$imgTitle.jpg")

                    if (!file.exists()) {
                        Log.d("path", file.toString())
                        try {
                            fos = FileOutputStream(file)
                            fos.write(bytes.toByteArray())
                            fos.flush()
                            fos.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                    returnPath = file.absolutePath
                }

                return returnPath ?: ""
            }catch (ex: Exception){
                ex.printStackTrace()
                return ""
            }

        }

        private fun getRealPathFromURI(context: Context, imageUri: Uri): String? {
            val result: String
            val cursor = context.contentResolver.query(imageUri, null, null, null, null)
            if (cursor == null) { // Source is Dropbox or other similar local file path
                result = imageUri.getPath().toString()
            } else {
                cursor.moveToFirst()
                val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                result = cursor.getString(idx)
                cursor.close()
            }
            return result
        }

        fun checkDirPath(path: String): Bitmap{
            val dir = File(path)
            var myBitmap: Bitmap? = null
            if (dir.exists()){
                myBitmap = BitmapFactory.decodeFile(dir.absolutePath)
            }
            return myBitmap!!
        }

        private fun Bitmap.rotate(degrees: Float): Bitmap {
            val matrix = Matrix().apply { postRotate(degrees) }
            return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
        }

        fun rotateBitmap(original: Bitmap, degrees: Float): Bitmap? {
            val width = original.width
            val height = original.height
            val matrix = Matrix()
            matrix.preRotate(degrees)
            val rotatedBitmap = Bitmap.createBitmap(original, 0, 0, width, height, matrix, true)
            val canvas = Canvas(rotatedBitmap)
            canvas.drawBitmap(original, 5.0f, 0.0f, null)
            return rotatedBitmap
        }

        fun bitMapScale(bitmap: Bitmap, MAX_SIZE: Int): Bitmap{
            val ratio: Int = 1024 / bitmap.getWidth()
            val height: Int = bitmap.getHeight() * ratio
            bitmap.setDensity(480)
            val bitmapResult = Bitmap.createScaledBitmap(bitmap, 1024, height, true)

            val ratioSquare: Double
            val bitmapHeight: Int
            val bitmapWidth: Int
            bitmapHeight = bitmapResult.height
            bitmapWidth = bitmapResult.width
            ratioSquare = (bitmapHeight * bitmapWidth / MAX_SIZE).toDouble()
            if (ratioSquare <= 1) return bitmapResult
            val ratio2 = Math.sqrt(ratioSquare)
            Log.d("mylog", "Ratio: $ratio")
            val requiredHeight = Math.round(bitmapHeight / ratio2).toInt()
            val requiredWidth = Math.round(bitmapWidth / ratio2).toInt()
            return Bitmap.createScaledBitmap(bitmapResult, requiredWidth, requiredHeight, true)
        }
    }
}