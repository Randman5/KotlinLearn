/**
 * Область корутины
 * */

package ipr.chp7._2

import kotlinx.coroutines.*

/**
 * coroutineScope - выполняется не блокируя основной поток
 * runBlocking - блокирует основной поток пока не выполнится
 * */

suspend fun main() {
//    doWork() //обычная корутина

//    doWork2() // паралельное выпонение 2х корутин

//    doWork3() // выполнение корутины с блокировкой основного потока
//    println("вывод после выполнения цикла doWork3()")

    innerCoroutine()
}

suspend fun doWork() = coroutineScope<Unit> {
    launch {
        delayCycle()
    }
}

suspend fun delayCycle() {
    for (i in 1..10) {
        delay(400L)
        println(i)
    }
}

// Запуск нескольких корутин
//Подобным образом можно запускать в одной функции сразу несколько корутин. И они будут выполняться одновременно.
suspend fun doWork2() = coroutineScope<Unit> {
    // выполняются параллельно
    launch { delayCycle() }
    launch { delayCycle() }
    println("несколько корутин")
}

suspend fun doWork3() = runBlocking {
    launch { delayCycle() }
}

//Вложенные корутины
suspend fun innerCoroutine() = coroutineScope {

    launch {
        println("Outer coroutine")
        launch {
            println("Inner coroutine")
            delay(400L)
        }
    }

    println("End of Main")
}