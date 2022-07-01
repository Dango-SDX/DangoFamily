package com.yumi.dango.test

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

/**
 *
 * @author Created by yumi on 2022/6/30 15:22
 */
fun main() {
    fun2()
}

private fun fun1() {
    GlobalScope.launch(Dispatchers.IO) {
//    runBlocking {
        flow {
            for (i in 1..5) {
                delay(100)
                emit(i)
            }
        }.collect {
            log(it)
        }
    }
}

private fun fun2() {
    GlobalScope.launch(Dispatchers.IO) {
//    runBlocking {
        flow {
            for (i in 1..50) {
                delay(100)
                emit(i)
            }
        }.onStart {
            log("onStart")
        }.onCompletion {
            log("onCompletion")
        }.collect {
            log(it)
        }
    }

    runBlocking {
        delay(20_000)
    }

}


private fun fun3() {
    runBlocking {
        flow {
            for (i in 1..5) {
                delay(100)
                emit(i)
                if (i == 3) throw Exception("my error")
            }
        }.onStart {
            println("onStart")
        }.onCompletion {
            println("onCompletion")
        }.collect {
            println(it)
        }
    }
}


