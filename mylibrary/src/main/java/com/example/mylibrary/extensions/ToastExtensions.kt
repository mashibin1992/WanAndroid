package com.example.mylibrary.extensions

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mylibrary.R

fun String.toast(context: Context) {
    val toast = Toast(context)
    toast.apply {
        val layout = LayoutInflater
            .from(context)
            .inflate(
                R.layout.custom_toast_layout,
                null,
                false)
//        layout.textView.text = this
//        layout.imageView.setBackgroundResource(imageSrc)
        setGravity(Gravity.CENTER, 0, 0)
        duration = Toast.LENGTH_SHORT
        view = layout
        show()
    }

}