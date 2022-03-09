package com.example.myapplication.net.demo

import androidx.annotation.Keep

/**
 * 推荐两列列表
 *
 * @param bn             商品品牌
 * @param brokerInfo     埋点信息
 * @param c3             商品三级分类
 * @param corpNewPrice   企业新人价
 * @param corpPrice      企业价格
 * @param currPrice      当前生效价格
 * @param img            商品主图URL
 * @param jdPrice        主站价格
 * @param lineationPrice 划线价
 * @param selfGoods      是否为自营商品
 * @param skuId          商品编码
 * @param skuName        商品名称
 * @param skuType        商品类型 1-普通商品 2-预约商品 3-闪购商品 4-秒杀商品 5-预售商品
 * @param spu            商品SPU
 * @param up             双价格优先显示的标识 15、企业会员价，20 企业新人价
 */
@Keep
data class ProductData(
    val bn: String = "",
    val brokerInfo: String = "",
    val c3: String = "",
    val corpNewPrice: String = "",
    val corpPrice: String = "",
    val currPrice: String = "",
    val img: String = "",
    val jdPrice: String = "",
    val lineationPrice: String = "",
    val selfGoods: Boolean = false,
    val skuId: String = "",
    val skuName: String = "",
    val skuType: String = "",
    val spu: String = "",
    val up: Int = -1,
    // 以下为客户端拼接的字段
    var indexOfPage: Int = 1
)
