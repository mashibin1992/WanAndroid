//package com.example.mylibrary.net.interceptor
//
//import com.example.mylibrary.net.constants.BaseConfig
//import okhttp3.*
//import org.json.JSONException
//import org.json.JSONObject
//import java.util.*
//
//class RequestInterceptor : Interceptor {
//
////    var incInt = AtomicLong(1)
//
//    private companion object {
//
//        private const val APP_ID = "app-id"
//        private const val TIME_STAMP = "timestamp"
//        private const val NONCE = "nonce"
//        private const val DEVICE_ID = "device-id"
//        private const val LANG = "lang"
//        private const val CLIENT = "client"
//        private const val VERSION = "version"
//        private const val BUNDLE_ID = "bundle-id"
//        private val signFilters = setOf(
//            APP_ID, TIME_STAMP, NONCE, DEVICE_ID, LANG, CLIENT, VERSION, BUNDLE_ID
//        )
//    }
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val builder = chain.request().newBuilder()
//        builder.addHeader(APP_ID, BaseConfig.appId)
//        builder.addHeader(TIME_STAMP, System.currentTimeMillis().toString())
//        builder.addHeader(NONCE, (UUID.randomUUID().toString() + System.nanoTime()).md5Hex())
//        builder.addHeader(DEVICE_ID, DeviceId.getMbEncodeDeviceId())
//        builder.addHeader(LANG, Locale.getDefault().language)
//        builder.addHeader(CLIENT, "Android")
//        builder.addHeader(VERSION, BaseConfig.versionName)
//        builder.addHeader(BUNDLE_ID, BaseConfig.applicationId)
//        builder.addHeader("User-Agent", getJdbmallUserAgent())
//        val request = builder.build()
//        val map = request.headers().toMultimap().filterSignEntry().toMutableMap()
//        request.url().queryParameterNames().iterator().forEach {
//            val values = request.url().queryParameterValues(it).filterNotNull()
//            if (values.isNotEmpty()) {
//                map[it] = values
//            }
//        }
//        val body = request.body()
//        // 这种签名方式不能正确的处理集合类型，我们与服务端约定如果是集合类型就用 json string
//        if (request.method().equals("post", true) && body is FormBody) {
//            for (i in 0 until body.size()) {
//                val element = body.value(i)
//                if (element.isNotEmpty()) {
//                    map[body.name(i)] = listOf(element)
//                }
//            }
//        }
//        decorateForJsonRequestBody(request, body, map)
//        builder.addHeader(
//            "Cookie",
//            Cookie.Builder().name("jdbmall_key").value(LoginHelper.getA2())
//                .domain("jd.com")
//                .build()
//                .toString()
//        )
//        builder.addHeader("sign", SecurityUtil.sign(map, BaseConfig.appSecret))
//        AddressUtil.getAddressGlobal()?.let {
//            builder.addHeader("aid", "${it.idProvince}_${it.idCity}_${it.idArea}_${it.idTown}")
//        }
//        builder.addHeader("build-version", BaseConfig.buildVersion.toString())
//        builder.addHeader("channel", BaseConfig.channel)
//        builder.addHeader("build", BaseInfo.getAppVersionCode().toString())
//        builder.addHeader("version-code", BaseInfo.getAppVersionCode().toString())
//        return chain.proceed(builder.build())
//    }
//
//    private fun decorateForJsonRequestBody(
//        request: Request,
//        body: RequestBody?,
//        map: MutableMap<String, List<String>>
//    ) {
//        if (request.method().equals("post", true) && checkBodyJsonType(body)) {
//            val sink = Buffer().apply { body?.writeTo(this) }
//            try {
//                val json = JSONObject(String(sink.readByteArray()))
//                for (key in json.keys())
//                    if (json[key].toString().isNotEmpty()) map[key] = listOf(json[key].toString())
//            } catch (e: JSONException) {
//                // no-op
//            }
//        }
//    }
//
//    private fun checkBodyJsonType(body: RequestBody?): Boolean {
//        return body is RequestBody && body !is FormBody && body !is MultipartBody
//    }
//
//    private fun MutableMap<String, List<String>>.filterSignEntry() = filter {
//        signFilters.contains(it.key)
//    }
//}
