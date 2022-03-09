package com.example.mylibrary.net.demo.response

import androidx.annotation.Keep

interface IBusinessData {

    fun checkData(): CheckResult {
        return CheckResult()
    }

}

/**
 * 数据检查结果
 * @param reason 出错理由
 * @param result 检查结果
 */
@Keep
data class CheckResult(
    val result: Boolean = true,
    val reason: String = ""
)