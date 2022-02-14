/**
 * Создание асинхронного потока
 * */

package ipr.chp8._2

import kotlinx.coroutines.flow.*

/**
 * Для создания асинхронного потока можно применять различные способы
 * но выделяются основные 3 способа
 *
 * * Функция flow
 * Функция-построитель потока flow() позволяет задать логику передачи объектов в поток. Она может применяться как к отдельной функции, так и сама по себе
 * пример рассмотрен в пакете ipr.chp8._1
 *
 * * Функция flowOf
 * Специальная функция-строитель flowOf() создает поток из набора переданных в функцию значений.
 *
 * * Метод asFlow
 * Стандартные коллекции и последовательности в Kotlin имеют метод расширения asFlow(),
 * который позволяет преобразовать коллекцию или последовательность в поток:
 * */

suspend fun main() {
    flowIn()
    flowOfExample()
    toFlowExample()
}

//Определять поток в виде отдельной функции, как в примере выше, необязательно.
suspend fun flowIn() {
    val userFlow = flow {
        val usersList = listOf("Tom", "Bob", "Sam")
        for (item in usersList) {
            emit(item)
        }
    }
    userFlow.collect { user ->
        println(user)
    }
}

suspend fun flowOfExample() {
    val numberFlow: Flow<Int> = flowOf(1, 2, 3, 5, 8)
    numberFlow.collect { n -> println(n) }
}

suspend fun toFlowExample() {
    // преобразование последовательности в поток
    val numberFlow: Flow<Int> = (1..5).asFlow()
    numberFlow.collect { n -> println(n) }

    // преобразование коллекции List<String> в поток
    val userFlow = listOf("Tom", "Sam", "Bob").asFlow()
    userFlow.collect { user ->
        println(user)
    }
}