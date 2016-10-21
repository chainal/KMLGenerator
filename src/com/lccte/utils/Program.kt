package com.lccte.utils

import com.lccte.utils.trans.PositionUtil
import java.io.File
import java.lang.Math.sqrt
import java.lang.Math.abs
import java.lang.Math.sin
import java.lang.Math.cos
import java.lang.Math.PI

/**
 * kml generator
 * Created by liuchuang on 16/10/21.
 */

data class LonLat(val lon: Double, val lat: Double)

fun main(args: Array<String>) {

    if (args.size < 4) {
        println("usage: filePath lonIndex latIndex separator1 separator2 ...")
        return
    }

    val filePath = args[0]
    val lonIndex = args[1].toInt()
    val latIndex = args[2].toInt()
    val listSeparator = args.slice(3..(args.size-1))

    println("filePath:$filePath lonIndex:$lonIndex latIndex:$latIndex listSeparator:$listSeparator")

    fun LonLat.reverseTransform(): LonLat {
        val gps = PositionUtil.gcj_To_Gps84(lat, lon)
        return LonLat(gps.wgLon, gps.wgLat)
    }

    val parseLine = { line: String ->
        fun String.trimDouble() = trim().toDouble()

        val listStr = line.split(*listSeparator.toTypedArray())

        try {
            LonLat(listStr[lonIndex].trimDouble(), listStr[latIndex].trimDouble())
        } catch (e: Exception) {
            null
        }
    }

    println(File(filePath).readLines().map { parseLine(it)?.reverseTransform() }.filterNotNull()
            .map { "${it.lon},${it.lat},0" }.joinToString(" "))


}
