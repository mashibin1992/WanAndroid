package com.example.mylibrary.extensions

import android.app.Activity
import android.app.Service
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <reified T : Activity> Activity.go() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Fragment.go() {
    startActivity(Intent(this.context, T::class.java))
}

inline fun <reified T : Activity> Activity.go(bundle: Bundle) {
    startActivity(Intent(this, T::class.java).apply {
        this.putExtras(bundle)
    })
}

inline fun <reified T : Activity> Fragment.go(bundle: Bundle) {
    startActivity(Intent(this.context, T::class.java).apply {
        this.putExtras(bundle)
    })
}

inline fun <reified T : Activity> Activity.goForResult(requestCode: Int) {
    startActivityForResult(Intent(this, T::class.java), requestCode)
}

inline fun <reified T : Service> Activity.goService() = startService(Intent(this, T::class.java))
