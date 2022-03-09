package com.example.mylibrary.net.exception

import java.lang.Exception

/**
 * 接口报错
 */
class ApiException(msg: String) : Exception(msg) {

    var errorMessage = ""

    var url: String = ""

    var code: String = ""

    var respString: String = ""

    var checkResult: String = ""

    override fun toString(): String {
        return "ApiException(errorMessage='$errorMessage', url='$url', code='$code', \ncheckResult=$checkResult, \n" +
                "respString='$respString')"
    }


}