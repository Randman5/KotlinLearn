/**
 * Async, await и Deferred
 * */

package ipr.chp7._4

import kotlinx.coroutines.*

/**
 * * async
 * Наряду с launch в пакете kotlinx.coroutines есть еще один построитель корутин - функция async.
 * Эта функция применяется, когда надо получить из корутины некоторый результат.
 *
 * async-корутина возвращает объект Deferred, который ожидает получения результата корутины. (Интерфейс Deferred унаследован от интерфейса Job,
 * поэтому для также доступны весь функционал, определенный для интефейса Job)
 *
 * Для получения результата из объекта Deferred применяется функция await()
 *
 * Если установить отложенный запуск start = CoroutineStart.LAZY то начать выполнение корутины можно не только с помощью метода start() но и await()
 * */

suspend fun main() = coroutineScope {
    val valueForFact = 5
    // указал тип Deferred<Int> для примера
    val value: Deferred<Int> = async { factorial(valueForFact) } // async возвращает результат
    println(value.await())// ожидание результата
}

suspend fun factorial(value: Int): Int {
    var fact = 0
    for (i in 1..value) {
        println(i)
        fact+=i
        delay(400)
    }
    return fact
}