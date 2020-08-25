package com.lipnus.sbu.model.rawsheet

data class Entry(
    val content: Content,
    val gsxname: GsxName,
    val gsxmoney: GsxMoney
)



data class GsxName(
    val t: String
)

data class GsxMoney(
    val t: String
)

data class Content(
    val t: String
)