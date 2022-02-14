/**
 * Функции count, take и drop. Количество элементов в потоке
 * */

/**
 * * Функция count
 * Оператор count получает количество объектов в потоке
 * Также мы можем передать в функцию count() условие в виде функции, которая возвращает объект Boolean, то есть true или false.
 * Тогда функция count() возвратит количество элементов, которые соответствуют этому условию
 *
 * * Функция take
 * Оператор take ограничивает количество элементов в потоке. В качестве параметра она принимает количество элементов с начала потока,
 * которые надо оставить в потоке
 *
 * * Функция drop
 * Оператор drop удаляет из потока определенное количество элементов.
 * В качестве параметра она принимает количество элементов с начала потока, которые надо убрать из потока
 *
 * */
package ipr.chp8._4

import kotlinx.coroutines.flow.*

suspend fun main () {

    val userFlow = listOf("Tom", "Bob", "Kate", "Sam", "Alice").asFlow()

    // * Функция count
    println("Функция count")
    println("Count: ${userFlow.count()}")       // Count: 5
    val count = userFlow.count{ username -> username.length > 3 }
    println("Count: $count")       // Count: 2

    // * Функция take
    println("\nФункция take")
    userFlow.take(3).collect{user -> println(user)}

    // * Функция drop
    println("\nФункция drop")
    userFlow.drop(3).collect{user -> println(user)}
}