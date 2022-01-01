/**
 * Функции высокого порядка
 * */

package ipr.chp2

/**
 * * Функции высокого порядка (high order function) -
 * это функции, которые либо принимают функцию в качестве параметра, либо возвращают функцию, либо и то, и другое.
 * */
fun main() {

    val incrementedValue = doWork(5, ::printValueInc) // вернет число 6 и выведет на консоль

    for (i in 1..3) {
        val func = getFun(i)
        println(func(5,2))
    }

}


/**
 * Функция для увеличения числа на 1 и вывода его на экран
 * @param value значение для увеличения на 1 и вывода в консоль
 * @return наибольшее число Int
 * */
fun printValueInc(value:Int): Int{
    val incremented = value + 1
    println(incremented)
    return incremented
}

/**
 * Функция высокого порядка
 * @param value значение для обработки функцией func
 * @param func функция для выполнения действий над целым числом
 * @return наибольшее число Int
 * */
fun doWork(value: Int, func: (Int) ->Int): Int{
    return func(value)
}

/**
 * Функция высокого порядка
 * @param value значение для обработки функцией func
 * @param func функция для выполнения действий над целым числом
 * @return выбранную функцию для сложения или умножения
 * */
fun getFun(funNum: Int):(Int, Int) ->Int = when(funNum){
    1 -> ::sum
    2 -> ::getBiggest
    else -> ::difference
}