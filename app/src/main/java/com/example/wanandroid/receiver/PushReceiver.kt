//package com.example.wanandroid.receiver
//
//import android.content.Context
//import android.text.TextUtils
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import cn.jpush.android.service.JPushMessageReceiver
//import com.example.wanandroid.R
//import com.google.gson.Gson
//
//class PushReceiver: JPushMessageReceiver() {
//
//    //长连接通道接收推送消息
//    fun onPushMessage(context: Context?, msg: String?) {
//        if (context == null) {
//            return
//        }
//        try {
//            val payLoad = Gson().fromJson(msg, PushPayLoad::class.java)
//            val builder = NotificationCompat.Builder(context, "普通")
//                .setSmallIcon(R.drawable.hero)
////                .setContentTitle(payLoad.title)
////                .setContentText(payLoad.payload)
//                .setContentTitle("测试")
//                .setContentText("呵呵呵")
//                .setAutoCancel(true)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            // Issue the notification.
//            NotificationManagerCompat.from(context).notify(1, builder.build())
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//
//    //接收获取的设备信息
//    fun onToken(context: Context?, deviceToken: String?, deviceModel: Int) {
////        LogX.d(TAG, "DT is $deviceToken, model is $deviceModel")
//    }
//
//    //注意： 此处不需要调用，MixPushManager.openPushInfo(this,msg); ，如调用，请删除
//    fun onClickMessage(context: Context?, msg: String?, notificationId: Int) {
//        //{"msgType":3,"deviceTokenSrc":5,"msgId":"f76c7552915348439f84fbdd0848caf4","extras":{"landPageUrl":""},"echo":"","flowId":"202110131742401795799473158024"}
////        LogX.d(TAG, "click message is $msg, notificationId is $notificationId")
////            val pushLink = Gson().fromJson(msg, PushClickLink::class.java)
////            val landPageUrl = pushLink.extras.landPageUrl
////            if (TextUtils.isEmpty(landPageUrl)) {
////                context?.toMain(0)
////            } else {
////                context?.toMain(link = landPageUrl)
////            }
//    }
//}
