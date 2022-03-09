package com.example.mylibrary.net.demo.response

open class BaseResponse(
    val code: Int = 0,
    val message: String = "",
    val time: Long = System.currentTimeMillis()
) : INetworkBaseResponse, IBusinessData {

    override fun isSucceeded(): Boolean {
        return code == 200
    }

    override fun getErrorMessage(): String {
        return message
    }

    override fun getErrorCode() = code

    override fun toString(): String {
        return "BaseResponse(code=$code, message='$message')"
    }

    /**
     * 检查数据有效性
     * @return CheckResult为检查结果，true为数据有效， false为数据失效
     */
    override fun checkData(): CheckResult {
        return super.checkData()
    }
}