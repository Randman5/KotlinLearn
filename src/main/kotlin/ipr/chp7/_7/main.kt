/**
 * Каналы
 * */

package ipr.chp7._7

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.coroutines.CoroutineContext

/**
 * Каналы позволяют передавать потоки данных. В Kotlin каналы представлены интерфейсом Channel, у которого следует выделить два основных метода
 * * abstract suspend fun send(element: E): Unit
 * Отправляет объект element в канал
 * * abstract suspend fun receive(): E
 * Получает данные из канала
 * */
suspend fun main() {
    //channeltest()// получаем данные из канала
    //channeltest2() // пример закрытия канала
    prodCon()
}

suspend fun channeltest() = coroutineScope {
    val channel = Channel<Int>()
    launch {
        for (n in 1..5) {
            delay(500L)
            channel.send(n)
        }
    }
    // потребление данных из канала, !!! если ожидать др кол-во данных то метод receive будет висеть и ждать пока ему не отправят ещё данные!!!
    // допустем если установить repeat(6) а отправленно будет 5 то он будет ждать пока ему не отправят ещё 1 объект
    repeat(5) {
        val number = channel.receive()
        println(number)
    }
    println("End")
}

// пример закрытия канала
suspend fun channeltest2() = coroutineScope {
    val channel = Channel<Int>()
    launch {
        for (n in 1..5) {
            channel.send(n)
            delay(400L)
        }
        channel.close()
    }
    for (value in channel) {
        println(value)
    }
    println("End")
}

//Паттерн producer-consumer позволят использовать канал внутри coroutineScope расширяя scope
fun CoroutineScope.getUsers(): ReceiveChannel<String> = produce {
    val users = listOf("Tom", "Bob", "Sam")
    for (user in users) {
        send(user)
    }
}

suspend fun prodCon() = coroutineScope {
    //Для потребления данных из канала может применяться метод consumeEach() объекта ReceiveChannel, который по сути заменяет цикл for
    getUsers().consumeEach {
        println(it)
    }
}

suspend fun channeltest3() = coroutineScope<Channel<Int>> {
    val channel = Channel<Int>()
    launch {
        for (n in 1..5) {
            channel.send(n)
            delay(400L)
        }
        channel.close()
    }
    channel
}



