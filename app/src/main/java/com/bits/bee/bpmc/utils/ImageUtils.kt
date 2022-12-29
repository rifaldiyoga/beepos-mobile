package com.bits.bee.bpmc.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.amazonaws.auth.BasicAWSCredentials
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.utils.BPMConstants.Companion.AWS_KEY
import com.bits.bee.bpmc.utils.BPMConstants.Companion.AWS_SECRET
import com.squareup.picasso.Picasso
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


/**
 * Created by aldi on 02/09/22.
 */
class ImageUtils {

    companion object {

        private var shareTargetsArray: MutableList<com.squareup.picasso.Target?> = ArrayList()

        fun downloadImage(context: Context, bucketKey : String, objKey : String) : String{
            val path = BPMConstants.getDatapath() + BPMConstants.BPM_PRODUKPATH

            FileHandlerUtils.createFolder(path)

            val amazonS3 = CloudKilatS3Client(BasicAWSCredentials(AWS_KEY, AWS_SECRET))
            amazonS3.endpoint = "https://sgp1.digitaloceanspaces.com"

            val url = amazonS3.generatePresignedUrl(bucketKey, objKey, Date(System.currentTimeMillis() + 60 * 60 * 100000))

            val tempUrl = url.toString()
//            item.setTempUrl()
            val bitmapTarget = object : com.squareup.picasso.Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    val file = File(path, objKey.replace('/', '_'))

                    var outputStream: FileOutputStream? = null

                    try {
                        outputStream = FileOutputStream(file)
                        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                        outputStream.flush()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } finally {
                        try {
                            outputStream?.let {
                                outputStream.close()
                            }
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    e?.printStackTrace()
                    Log.e("Download Image : ", e?.message ?: "")
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    Log.e("Download Image : ", "Preload")
                }

            }
            Log.e("Download Image : ", tempUrl)
            shareTargetsArray.add(bitmapTarget)
            Picasso.get()
                .load(tempUrl)
                .into(bitmapTarget)

            return path
        }

        fun generateFromInitial(context : Context, name1: String, customFontSize : Int? = null): Drawable {
            val generatorCol = ColorGenerator.MATERIAL
            val text = getInitial(name1)

            val color = generatorCol.getColor(name1)

            val font = customFontSize ?: getFontSize(text.length)

            val hexColor = String.format("#%06X", 0xFFFFFF and color)
            val txtColor: String = ViewUtils.pickTextColorBasedOnBg(hexColor)

            return TextDrawable.builder()
                .beginConfig()
                .fontSize(font)
                .useFont(ResourcesCompat.getFont(context, R.font.nunito_sans))
                .textColor(Color.parseColor(txtColor))
                .endConfig()
                .buildRect(text.uppercase(), color)
        }

        fun getInitial(title: String): String {
            val lists = title.split(" ").toTypedArray()
            val list: MutableList<String> = ArrayList()
            for (s in lists) {
                if (s.isNotEmpty()) {
                    list.add(s)
                }
            }
            return when {
                list.size == 1 -> {
                    list[0][0].toString()
                }
                list.size == 2 -> {
                    list[0][0].toString() + list[1][0]
                }
                list.size >= 3 -> {
                    list[0][0].toString() + list[1][0] + list[2][0]
                }
                else -> "I"
            }
        }

        fun getFontSize(length : Int) : Int {
            var font = 50
            if (length == 4) font = 44
            if (length == 5) font = 34
            return font
        }

    }

}