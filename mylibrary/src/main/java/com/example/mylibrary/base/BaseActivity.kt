package com.example.mylibrary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        initView()
        initData()
    }

    abstract fun setLayout(): Int

    abstract fun initView()

    abstract fun initData()
}
