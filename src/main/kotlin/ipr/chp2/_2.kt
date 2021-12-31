/**
 * Переменное количество параметров. Vararg
 * */

package ipr.chp2

/**
 * Функция может принимать переменное количество параметров одного типа, используя ключевое слово vararg
 * Оператор * (spread operator) позволяет передать параметру в качестве значения элементы из массива
 * */
fun main() {
    displayStrings("asd", "fgh", "jkl")
    // вызов функции c входным параметром vararg с доп параметрами
    displayStringsUntil(until = "fgh","asd", "fgh", "jkl")
    //Оператор *
    val nums = arrayOf("asd", "fgh", "jkl")
    displayStrings(*nums) // позволяет передать массив как последовательность vararg

}

/**
 * Функция для вывода строк в консоль
 * @param sequence vararg список строк
 * @return Unit(void) по умолчанию
 * */
fun displayStrings(vararg sequence: String) {
    for (str in sequence) println(str)
}

/**
 * Функция для вывода строк в консоль до определенной строки
 * @param until строка, пока end не будет найдено список будет выводится
 * @param sequence vararg список чисел
 * @return Unit(void) по умолчанию
 * */
fun displayStringsUntil(until: String,vararg sequence: String) {
    for (str in sequence) {
        if (until == str) break
        println(str)
    }
}
