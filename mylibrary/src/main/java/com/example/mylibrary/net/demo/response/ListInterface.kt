package com.example.myapplication.net.demo.response

import androidx.annotation.Keep

@Keep
interface ListInterface<ITEM> {

    fun getRespList(): List<ITEM>

    fun getNextIndex() : Int
}