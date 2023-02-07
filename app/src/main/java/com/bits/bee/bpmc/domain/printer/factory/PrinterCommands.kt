package com.bits.bee.bpmc.domain.printer.factory

/**
 * Created by https://goo.gl/UAfmBd on 2/6/2017.
 */
object PrinterCommands {
    val HT = byteArrayOf(0x9)
    val LF = byteArrayOf(0x0A)
    val CR = byteArrayOf(0x0D)
    val ESC = byteArrayOf(0x1B)
    val DLE = byteArrayOf(0x10)

    //    public static final byte[] GS = new byte[]{0x1D};
    val FS = byteArrayOf(0x1C)
    val STX = byteArrayOf(0x02)
    val US = byteArrayOf(0x1F)
    val CAN = byteArrayOf(0x18)
    val CLR = byteArrayOf(0x0C)
    val EOT = byteArrayOf(0x04)
    private const val ESC_CHAR = 0x1B.toChar()
    private const val GS = 0x1D.toChar()
    private val LINE_FEED = byteArrayOf(0x0A)
    val CUT_PAPER = byteArrayOf(GS.code.toByte(), 0x56, 0x00)
    private val INIT_PRINTER = byteArrayOf(ESC_CHAR.code.toByte(), 0x40)
    var SELECT_BIT_IMAGE_MODE_NEW = byteArrayOf(0x1B, 0x2A, 33, 128.toByte(), -128)
    val INIT = byteArrayOf(0x1b, 0x40)
    var FEED_LINE = byteArrayOf(10)
    var SELECT_FONT_A = byteArrayOf(0x1b, 0x21, 0x00)
    var SELECT_FONT_B = byteArrayOf(0x1b, 0x21, 0x01)
    var SELECT_FONT_EMPHASIZE = byteArrayOf(0x1b, 0x21, 0x08)
    var SELECT_FONT_DOUBLE_SIZE = byteArrayOf(0x1b, 0x21, 0x30)
    var SELECT_FONT_UNDERLINE = byteArrayOf(0x1b, 0x21, 0x80.toByte())
    var SET_BAR_CODE_HEIGHT = byteArrayOf(29, 104, 100)
    var PRINT_BAR_CODE_1 = byteArrayOf(29, 107, 2)
    var SEND_NULL_BYTE = byteArrayOf(0x00)
    var SELECT_PRINT_SHEET = byteArrayOf(0x1B, 0x63, 0x30, 0x02)
    var FEED_PAPER_AND_CUT = byteArrayOf(0x1D, 0x56, 66, 0x00)
    var SELECT_CYRILLIC_CHARACTER_CODE_TABLE = byteArrayOf(0x1B, 0x74, 0x11)
    var SELECT_BIT_IMAGE_MODE = byteArrayOf(0x1B, 0x2A, 33, -128, 0)
    var SELECT_BIT_IMAGE_MODE_CENTER = byteArrayOf(0x1B, 0x2A, 33, 255.toByte(), 3)

    //    public static byte[] SELECT_BIT_IMAGE_MODE = {0x1B, 0x2A, 33, 255, 3};
    //        public static byte[] SELECT_BIT_IMAGE_MODE = new byte[] {0x1B, 0x2A, 33, (byte) 255, 3};
    //    public static byte[] SELECT_BIT_IMAGE_MODE = new byte[] {0x1B, 0x2A, 1, (byte)255, 0};
    val SET_LINE_SPACE_24 = byteArrayOf(ESC_CHAR.code.toByte(), 0x33, 24)
    var SET_LINE_SPACING_24 = byteArrayOf(0x1B, 0x33, 24)
    var SET_LINE_SPACING_30 = byteArrayOf(0x1B, 0x33, 30)
    var TRANSMIT_DLE_PRINTER_STATUS = byteArrayOf(0x10, 0x04, 0x01)
    var TRANSMIT_DLE_OFFLINE_PRINTER_STATUS = byteArrayOf(0x10, 0x04, 0x02)
    var TRANSMIT_DLE_ERROR_STATUS = byteArrayOf(0x10, 0x04, 0x03)
    var TRANSMIT_DLE_ROLL_PAPER_SENSOR_STATUS = byteArrayOf(0x10, 0x04, 0x04)
    val ESC_FONT_COLOR_DEFAULT = byteArrayOf(0x1B, 'r'.code.toByte(), 0x00)
    val FS_FONT_ALIGN = byteArrayOf(0x1C, 0x21, 1, 0x1B, 0x21, 1)
    val ESC_ALIGN_LEFT = byteArrayOf(0x1b, 0x61, 0x00)
    val ESC_ALIGN_RIGHT = byteArrayOf(0x1b, 0x61, 0x02)
    val ESC_ALIGN_CENTER_IMAGE = byteArrayOf(0x1b, 0x61, 1)
    val ESC_ALIGN_CENTER = byteArrayOf(0x1b, 0x61, 0x01)
    val ESC_CANCEL_BOLD = byteArrayOf(0x1B, 0x45, 0)

    /******************* HT SETTING  */ //    public static final byte[] ESC_HORIZONTAL_CENTER = new byte[]{0x1B, 0x20, 0x1B, 0x20};
    //        public static final byte[] ESC_HORIZONTAL_CENTER = new byte[] { 0x1B, 0x44, 7, 00};
    val ESC_HORIZONTAL_CENTER = byteArrayOf(0x1b, 0x44, 0, 0x01)
    val ESC_CANCLE_HORIZONTAL_CENTER = byteArrayOf(0x1B, 0x44, 0, 0)
    /******************* HT SETTING  */
    /** */
    val ESC_HORIZONTAL_CENTERS = byteArrayOf(27, 76, 80, 80)
    val ESC_CANCLE_HORIZONTAL_CENTERS = byteArrayOf(0x1B, 0x44, 0)

    /** */
    val ESC_ENTER = byteArrayOf(0x1B, 0x4A, 0x40)
    val PRINTE_TEST = byteArrayOf(0x1D, 0x28, 0x41)
}