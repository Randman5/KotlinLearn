/**
 * Введение в асинхронные потоки
 * */

package ipr.chp8._1
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * * Корутины позволяют возвращать одиночные значения. Для этого мы можем, к примеру, создавать корутину с помощью построителя async.
 * Но Kotlin также позволяет создавать асинхронные потоки (Asynchronous Flow), которые возвращают набор объектов.
 *
 * * Запуск Flow
 * Стоит отметить, что асинхронный поток не запускается, пока не будет применена терминальная операция над получаемыми даными, например, функция collect()
 * */
suspend fun main() = coroutineScope {
    getUsers().collect { name ->
        println(name)
    }
}

/**
 * Для создания асинхронного потока данных применяется интерфейс Flow. То есть по сути асинхронный поток - это объект Flow.
 * Он типизируется типом тех данных, которые должны передаваться в потоке. В данном случае передаем строки, поэтому Flow типизируется типом String.
 *
 * При этом при определении функции-потока (в данном случае функции getUsers) необязательно использовать модификатор suspend.
 * Для создания объекта Flow применяется специальная функция flow()
 *
 * emit(значение) - передает значение в поток
 * */
fun getUsers(): Flow<String> = flow {
    val database = listOf("tom", "bob", "jhon",)
    var i = 1
    for (name in database) {
        // имитация получение значений из бд
        delay(400L)
        println("Emit $i name")
        emit(name) // емитируем значение
        i++
    }
}