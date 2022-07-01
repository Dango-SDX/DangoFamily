@file:JvmName("Utils")

package com.yumi.dango.test

import java.lang.StringBuilder

/**
 *
 * @author Created by yumi on 2022/6/30 15:25
 */

fun log(msg: Any?, tag: String = "dango") {
    println("[$tag] [${Thread.currentThread().name}] : $msg")
}