/**
 * Объединение потоков
 * */

package ipr.chp8._9

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.zip


/**
 * * zip
 * Оператор zip позволяет объединить два потока данных
 * Оператор zip принимает два параметра. Первый параметр - поток данных, с которым надо выполнить объединение. Второй параметр - собственно функция объединения.
 * Она принимает соответствующие элементы обоих потоков в качестве параметров и возвращает результат их объединения.
 *
 * */
suspend fun main() {
    val names = listOf("Tom", "Bob", "Sam").asFlow()
    val ages = listOf(37, 41, 25).asFlow()
    names.zip(ages) { name, age -> Person(name, age) }
        .collect { person -> println("Name: ${person.name}   Age: ${person.age}") }
}

data class Person(val name: String, val age: Int)
