package com.example.wanandroid

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initConfigInfo()
    }


    private fun initConfigInfo() {
//        BaseConfig.versionName = BuildConfig.VERSION_NAME
//        BaseConfig.versionCode = BuildConfig.VERSION_CODE
//        BaseConfig.applicationId = BuildConfig.APPLICATION_ID
//        BaseConfig.channel = BuildConfig.CHANNEL
//        BaseConfig.appId = BuildConfig.APP_ID
//        BaseConfig.appSecret = BuildConfig.APP_SECRET
//        BaseConfig.mPassAppKey = BuildConfig.MPASS_APP_KEY
//        BaseConfig.mPassAppSecret = BuildConfig.MPASS_APP_SECRET
//        BaseConfig.analyticsId = BuildConfig.ANALYTICS_ID
//        BaseConfig.privacyVersionCode = BuildConfig.PRIVACY_VERSION_CODE
//        BaseConfig.guideVersionCode = BuildConfig.GUIDE_VERSION_CODE
//        BaseConfig.buildVersion = BuildConfig.BUILD_VERSION
    }
}