package com.bits.bee.bpmc.utils

/**
 * Created by aldi on 02/03/22.
 */
class Resource<out T>(val status: Status, val data: T?, val message: String?, val code: Int?) {

    enum class Status {
        LOADING, SUCCESS, ERROR, NOINTERNET
    }

    companion object {
        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null, null, )
        }

        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null,)
        }

        fun <T> error(data: T?, msg: String, code: Int = -1): Resource<T> {
            return Resource(Status.ERROR, data, msg, code,)
        }

        fun <T> timeout(data: T?, msg: String): Resource<T> {
            return Resource(Status.ERROR, data, msg, 502)
//            return Resource(Status.TIMEOUT, data, msg, null,)
        }

        fun <T> unauthorized(data: T?, msg: String, code: Int): Resource<T> {
            return Resource(Status.ERROR, data, msg, 502)
//            return Resource(Status.UNAUTHORIZED, data, msg, code,)
        }

        fun <T> noInternet(data: T?, msg: String, code: Int): Resource<T> {
            return Resource(Status.NOINTERNET, data, msg, 502)
        }
    }

}