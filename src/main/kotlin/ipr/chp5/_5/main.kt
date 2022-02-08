/**
 * Перегрузка операторов
 * */

package ipr.chp5._5

import ipr.chp3._12.operate

/**
 * * Перегрузка операторов
 * Для определения оператора для типа определяется функция с ключевым словом operator
 * синтаксис

operator fun название_оператора([параметры_оператора]) : возвращаемый_тип{
// действия функции оператора
}

 *
 * * Список операторов для переопределения
 * Унарные операторы
 * +a  |  a.unaryPlus()
 * -a  |  a.unaryMinus()
 * !a  |  a.not()
 *
 * Инкремент/декремент
 * ++a / a++  |  a.inc()
 * --a / a--  |  a.dec()
 *
 * Бинарные арифметические операторы
 * a + b  |  a.plus(b)
 * a - b  |  a.minus(b)
 * a * b  |  a.times(b)
 * a / b  |  a.div(b)
 * a % b  |  a.rem(b)
 * a..b   |  a.rangeTo(b)
 *
 * Операторы сравнения
 * a == b  |  a?.equals(b) ?: (b === null)
 * a != b  |  !(a?.equals(b) ?: (b === null))
 * a > b   |  a.compareTo(b) > 0
 * a < b   |  a.compareTo(b) < 0
 * a >= b  |  a.compareTo(b) >= 0
 * a <= b  |  a.compareTo(b) <= 0
 *
 * Операторы присвоения
 * a += b   |  a.plusAssign(b)
 * a -= b   |  a.minusAssign(b)
 * a *= b   |  a.timesAssign(b)
 * a /= b   |  a.divAssign(b)
 * a %= b   |  a.remAssign(b)
 *
 * Оператор in
 * a in b   |  b.contains(a)
 * a !in b  |  !b.contains(a)
 *
 * Операторы доступа по индексу
 * a[i]     |  a.get(i)
 * a[i, j]  |  a.get(i, j)
 * a[i_1, ..., i_n]  |  a.get(i_1, ..., i_n)
 * a[i] = b  |  a.set(i, b)
 * a[i, j] = b  |  a.set(i, j, b)
 * a[i_1, ..., i_n] = b  |  a.set(i_1, ..., i_n, b)
 *
 * Операторы вызова
 * a()  |  a.invoke()
 * a(i)  |  a.invoke(i)
 * a(i, j)  |  a.invoke(i, j)
 * a(i_1, ..., i_n)  |  a.invoke(i_1, ..., i_n)
 *
 * */
fun main() {
    val value: Value = Value(5) + Value(10)
    println(value)
    println(Value(5) == Value(10)) // вывод false
    val value2 = value.invoke(15, 3)
    println(value2.value)// вывод 45

    println(value[1]) // Вывод ford

    println("ford" in value)// true


}

class Value(var value: Int) {
    // Перегрузка оператора '+'
    operator fun plus(value: Value): Value {
        this.value += value.value
        return this
    }

    //Перегрузка оператора '='
    override operator fun equals(obj: Any?): Boolean {
        return this.value == (obj as Value).value
    }


    private val cars = arrayOf("volvo", "ford", "opel")

    operator fun get(i: Int): String {
        return cars[i]
    }

    operator fun contains(value: String): Boolean {
        return value in cars
    }

    operator fun invoke(value: Int, multiply: Int): Value {
        return Value(value * multiply)
    }

    override fun toString(): String {
        return value.toString()
    }
}
