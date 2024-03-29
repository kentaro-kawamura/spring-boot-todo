package com.kawamura.todo

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.*

fun LocalDateTime.format(): String = this.format(englishDateFormatter)

//private val dayLookUp = (1..31).associate { it.toLong() to getOrdinal(it) }
//
//private val englishDateFormatter = DateTimeFormatterBuilder()
//    .appendPattern("yyyy-mm-dd")
//    .appendLiteral("")
//    .appendText(ChronoField.DAY_OF_MONTH, dayLookUp)
//    .appendLiteral("")
//    .appendPattern("yyyy")
//    .toFormatter(Locale.ENGLISH)
//
private val englishDateFormatter = DateTimeFormatterBuilder()
    .appendPattern("yyyy-mm-dd")
    .toFormatter(Locale.JAPAN)

//private fun getOrdinal(n: Int) = when {
//    n in 11..13 -> "${n}th"
//    n % 10 == 1 -> "${n}st"
//    n % 10 == 2 -> "${n}nd"
//    n % 10 == 3 -> "${n}rd"
//    else -> "${n}th"
//}
//
//fun String.toSlug() = lowercase(Locale.getDefault())
//    .replace("¥n", "")
//    .replace("[^a-z¥¥d¥¥s]".toRegex(), "")
//    .split("")
//    .joinToString("-")
//    .replace("-+".toRegex(), "-")
