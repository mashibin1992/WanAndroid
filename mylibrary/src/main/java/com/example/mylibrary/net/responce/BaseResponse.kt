package com.example.mylibrary.net.responce

class BaseResponse<T>(
    val data: T?,
    val errorCode: Int,
    val errorMsg: String
)