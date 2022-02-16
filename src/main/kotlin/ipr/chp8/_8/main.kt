/**
 * Сведение данных. Функции reduce и fold
 * */

package ipr.chp8._8

import kotlinx.coroutines.flow.*
/**
 * * Оператор reduce
 * сводит все значения потока к одному значению
 * Первый параметр при первом запуске представляет первый объект потока,
 * а при последующих запусках - результат функции над предыдущими объектами. А второй параметр функции - следующий объект.
 *
 * * Функция fold
 * Функция fold также сводит все элементы потока в один. Но в отличие от оператора reduce оператор fold в качестве первого параметра принимает начальное значение
 *
 * */

suspend fun main() {

    val numberFlow = listOf(1, 2, 3, 4, 5).asFlow()
    //reduce
    // при первом проходе a = 1 b = 2, при втором проходе a = 3, b = 3, при третьем проходе a = 6 b = 4 и т.д
    val reducedValue = numberFlow.reduce{ a, b -> a + b }
    println(reducedValue)   // 15

    // fold
    val userFlow = listOf("Tom", "Bob", "Kate", "Sam", "Alice").asFlow()
    val foldedValue = userFlow.fold("Users:") { a, b -> "$a $b" }
    println(foldedValue)   // Users: Tom Bob Kate Sam Alice

}
