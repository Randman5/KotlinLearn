/**
 * Преобразование данных. Функции map и transform
 * */

package ipr.chp8._6

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

/**
 * * Функция map
 * Оператор map() преобразует данные потока. В качестве параметра он принимает функцию преобразования.
 * Функция преобразования принимает в качестве единственного параметра объект из потока и возвращает преобразованные данные.
 *
 * * Функция transform
 * Оператор transform также позволяет выполнять преобразование объектов в потоке.
 * В отличие от map она позволяет использовать функцию emit(), чтобы передавать в поток произвольные объекты.
 *
 * */

class Person(val name: String, val age: Int)

suspend fun main() {
    // * Функция map
    val userList = listOf(
        Person("Tom", 37),
        Person("Sam", 41),
        Person("Bob", 21)
    ).asFlow()

    // создает из потока объектов Person новый поток объектов String
    userList.map { person ->
        person.name
    }.collect { name ->
        println(name)
    }

    // разобранный пример
    val strFlow: Flow<String> = userList.map { person -> person.name }
    strFlow.collect { name -> println(name) }

    // пример с конвертацией в анонимный класс
    userList.map { person ->
        object {
            val name = person.name
            val isAdult = person.age > 17
        }
    }.collect { user -> println("name: ${user.name}   adult:  ${user.isAdult} ") }

    // * Функция transform

    userList.transform { person ->
        if (person.age > 17) {
            emit(person.name)// передача в collect только избранные объекты
        }
    }.collect { personName -> println(personName) }
}