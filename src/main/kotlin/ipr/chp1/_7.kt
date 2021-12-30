/**
 * Условные конструкции
 * */

package ipr.chp1


/**
 * * Условные конструкции позволяют направить выполнение программы по одному из путей в зависимости от условия.
 * if...else
 * when
 * */
fun main() {
    val a = 10
    // условная конструкция
    if(a > 10) {
        println("a равно 10")
    } else if (a < 10) {
        println("a меньше 10")
    } else {
        println("a равно 10")
    }

    //возвращение значения из if
    val returnIfValue = if (a > 10) {
        11
    } else if ( a < 10) {
        9
    } else {
        10
    }
    println(returnIfValue)

    //конструкция when
    when(a) {
        in 10..20 -> {
            println(a)
        }
        23 -> println("a = 23")
        else -> println("none")
    }

    when(a) {
        10, 20 -> 1
        in 0..10 -> 2
        else -> 3
    }

    val value: Int = when(a) {
        10, 20 -> 1
        in 0..10 -> 2
        else -> 3
    }
    println(value)

    //when и динамически вычисляемые значения
    val value2: Int = when(a + 2) {
        10 - 20 -> 1
        in 0..10 -> 2
        else -> 3
    }
    println(value2)




}