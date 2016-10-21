package com.lccte.utils

/**
 * kml generator
 * Created by liuchuang on 16/10/21.
 */

fun main(args: Array<String>) {

    if (args.size < 4) {
        println("usage: filePath lonIndex latIndex separator1 separator2 ...")
        return
    }

    val filePath = args[0]
    val lonIndex = args[1]
    val latIndex = args[2]
    val listSeparator = args.slice(3..(args.size-1))

    println("filePath:$filePath lonIndex:$lonIndex latIndex:$latIndex listSeparator:$listSeparator")


}
