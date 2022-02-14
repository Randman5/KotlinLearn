/**
 * Функции first, last, single
 * */

package ipr.chp8._5

import kotlinx.coroutines.flow.*

/**
 * * Методы first / firstOrNull
 * Метод first() получает первый объект списка
 * Также метод first() может в качестве параметра принимать функцию-условие, которая возвращает объект Boolean.
 * Тогда first() возвращает первый элемент потока, который соответствует этому условию
 * В случае если поток пуст или элемент не найден функция firs выбросит исключение. \
 * В качестве альтернативы можно использовать firstOrNull которая вместо выброса исключение вернет null
 *
 * * Методы last / lastOrNull аналогичны методу first / firstOrNull только не имеет перегрузки для принятия лямбды
 *
 * * Методы single / singleOrNull
 * Функция single() возвращает единственный элемент потока, если поток содержит только один элемент.
 * Если поток не содержит элементов, генерируется исключение NoSuchElementException,
 * а если в потоке больше одного элемента - исключение IllegalStateException.
 * */

suspend fun main() {
    val userFlow = listOf("Tom", "Bob", "Kate", "Sam", "Alice").asFlow()

    // * Методы first / firstOrNull
    println("Методы first / firstOrNull")
    println("first / firstOrNull")
    val firstUser = userFlow.first()
    println("First User: $firstUser") // Tom
    val firstUser2 = userFlow.first { name -> name.length > 3 }
    println("First User: $firstUser2") // First User: Kate
    val firstUser3 = userFlow.firstOrNull { name -> name.length > 1000 }
    println("First User: $firstUser3") // First User: Kate

    // * Методы last / lastOrNull
    println("\nМетоды last / lastOrNull")
    val lastUser = userFlow.last()
    println("lastUser $lastUser") // Alice
    val lastUser2 = userFlow.lastOrNull() // если бы список был пуст вернуло бы null
    println("lastUser $lastUser2") // Alice

    // * Методы single / singleOrNull
    println("\nМетоды last / lastOrNull")
    val userFlowSingle = listOf("Tom").asFlow()
    try {
        val singleUser = userFlowSingle.single()
        println("Single User: $singleUser")
    } catch (e: Exception) {
        println(e.message)
    }

    // альтернатива singleOrNull
    val singleUser = userFlow.singleOrNull()
    if (singleUser != null){
        println("Single User: $singleUser")

    } else {
        println("Not found")
    }

}