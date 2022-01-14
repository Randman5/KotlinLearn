/**
 * Обобщенные классы и функции
 * */

package ipr.chp4._1


/**
 * Обобщение
 * * синтаксис при объявлении класса
 * class Person<T>(val id: T, val name: String) где T обобщенный тип
 *
 * * синтаксис при объявлении функции
 *  fun <Z> printWithValue(value:Z) где Z обобщенный тип
 * */
fun main() {

    // создание объекта обобщенного класса <Int> можно опустить
    val p1 = Person<Int>(1,"name")
    println(p1)

    // создание объекта обобщенного класса с двумя параметрами
    val p2 = Person2(1,"name")
    println(p1)

    // тип <Int> можно опустить котлин автоматически определит тип
    p2.printWithValue<Int>(25)
    p2.printWithValue("string value")
    p2.printWithValue(true)


}

//обобщенный тип в классе
class Person<T>(val id: T, val name: String)

//Применение нескольких параметров
class Person2<T, V>(val id: T, val name: V) {

    // обобщенная функция
    fun <Z> printWithValue(value:Z) {
        println("$id $name $value")
    }
}


