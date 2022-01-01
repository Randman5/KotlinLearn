/**
 * Перегрузка функций
 * */

package ipr.chp2

/**
 * Перегрузка функций (function overloading) представляет определение нескольких функций с одним и тем же именем,
 * но с различными параметрами. Параметры перегруженных функций могут отличаться по количеству,
 * типу или по порядку в списке параметров.
 * */

fun main() {

    //уже перегружена и существует в другом файле в данном пакете
    println(sum(1, 2))

    println(sum(1.6, 2.4)) //sum(a: Double, b: Double): Double
    println(sum(1, 2, 4)) //  sum(a: Int, b: Int, c: Int) : Int
    println(sum(1, 2.8)) // sum(a: Int, b: Double) : Double
    println(sum(1.8, 2)) // sum(a: Double, b: Int) : Double

}

/**
 * Перегрузка функции sum подсчета суммы 2-х чисел типа double
 * @param a первое слагаемое
 * @param b второе слагаемое
 * @return сумма 2-х слагаемых
 * */
fun sum(a: Double, b: Double): Double {
    return a + b
}

/**
 * Перегрузка функции sum для подсчета суммы 3-х чисел типа Int
 * @param a первое слагаемое
 * @param b второе слагаемое
 * @param с третье слагаемое
 * @return сумма 2-х слагаемых
 * */
fun sum(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

/**
 * Перегрузка функции sum для подсчета суммы 2-х чисел типа Int и double
 * @param a первое слагаемое Int
 * @param b второе слагаемое Double
 * @return сумма 2-х слагаемых Double
 * */
fun sum(a: Int, b: Double): Double {
    return a + b
}

/**
 * Перегрузка функции sum для подсчета суммы 2-х чисел типа double и Int
 * @param a первое слагаемое Double
 * @param b второе слагаемое Int
 * @return сумма 2-х слагаемых Double
 * */
fun sum(a: Double, b: Int): Double {
    return a + b
}