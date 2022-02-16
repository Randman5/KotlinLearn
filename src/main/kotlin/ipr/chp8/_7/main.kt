/**
 * Фильтрация данных
 * */

package ipr.chp8._7

import kotlinx.coroutines.flow.*

/**
 * * Оператор filter
 * выполняет фильтрацию объектов в потоке. В качестве параметра он принимает функцию-условие,
 * которая получает объект потока и возвращает true (если объект подходит фильтрацию) и false (если не проходит)
 *
 * * takeWhile
 * Кроме того, Kotlin предоставляет еще ряд операций фильтрации для различных ситуаций. Например,
 * оператор takeWhile выбирает из потока элементы, пока будет истино некоторое условие:
 *
 * * dropWhile
 * Оператор dropWhile противоположен по своему действию оператору takeWhile.
 * dropWhile удаляет из потока элементы, пока они не начнут соответствовать некоторому условию:
 * */


suspend fun main() {
    val peopleFlow = listOf(
        Person("Tom", 37),
        Person("Bill", 5),
        Person("Sam", 14),
        Person("Bob", 21),
    ).asFlow()

    // * filter
    println("// * filter")
    peopleFlow.filter{ person -> person.age > 17}
        .collect { person -> println("name: ${person.name}   age:  ${person.age} ")}

    // * takeWhile
    println("// * takeWhile")
    // будет добавлять данные в поток пока условие true
    peopleFlow.takeWhile { person -> person.age >= 37 || person.age < 5  }
        .map { person -> person.name  }
        .collect {
            println(it)
        }

    // * dropWhile
    println("// * dropWhile")
    // будет удалять данные из потока пока условие true
    peopleFlow.dropWhile { person ->  person.age > 5  } //пока числа больше 5 будет их удалять
        .map { person -> person.name  }
        .collect {
            println(it)
        }

}

data class Person(val name: String, val age: Int)

