package com.example.mylibrary.net

class BaseResponse<T>(
    val data: T?,
    val errorCode: Int,
    val errorMsg: String
)