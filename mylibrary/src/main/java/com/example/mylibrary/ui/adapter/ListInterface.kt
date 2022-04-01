package com.example.mylibrary.ui.adapter

import androidx.annotation.Keep

@Keep
interface ListInterface<ITEM> {

    fun getRespList(): List<ITEM>

    fun getNextIndex() : Int
}