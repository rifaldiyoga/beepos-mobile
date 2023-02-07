package com.bits.bee.bpmc.domain.printer.bt.bluebamboo.connector

/**
 * P25ConnectionException.
 *
 * @author Lorensius W. L. T <lorenz></lorenz>@londatiga.net>
 */
class P25ConnectionException(msg: String?) : Exception(msg) {
    var error: String? = ""

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }

    init {
        error = msg
    }
}