/**
 * Однострочные и локальные функции
 * */

package ipr.chp2

/**
 * * Однострочные функции (single expression function)
 * синтаксис fun имя_функции (параметры_функции) = тело_функции
 *
 * * Локальные функции. Функции которые могут быть определены внутри других функция
 *
 * */
fun main() {
    println(difference(10, 2))
    withLocal()
}

/**
 * Однострочная функция (single expression function)
 * Функция для нахождения разности между двумя целыми числами
 * @param num1 уменьшаемое
 * @param num2 вычитаемое
 * @return разность
 * */
fun difference(num1:Int, num2: Int): Int = num1 - num2

/**
 * Функция внутри которой локальная (single expression function) функция для конкатенации строк
 * */
fun withLocal() {
    fun concat(str1: String, str2:String) = "$str1$str2"
    println(concat("Hello ", "Kotlin"))
}