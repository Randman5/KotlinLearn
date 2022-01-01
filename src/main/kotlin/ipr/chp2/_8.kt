/**
 * Анонимные функции
 * */

package ipr.chp2

/**
 * Анонимные функции выглядят как обычные за тем исключением, что они не имеют имени
 * Синтаксис fun(переменная: Тип): возвращаемый тип {выполняемые действия} или = выполняемые действия
 * */
fun main() {

    // Пример анонимной функции
    val messageWithNum = fun(num: Int): Int {
        println("Hello $num")
        return num
    }

    //Анонимная функция как аргумент функции
    doWork(10, messageWithNum)
    doWork(5, fun(num: Int): Int {
        val incNum = num + 1
        println(incNum)
        return incNum
    })

    //получение и использование анонимной функции сигнатуру функции (: (str1:String, str2:String) -> Boolean) описывать необязательно
    val eq: (str1:String, str2:String) -> Boolean = getEqualsFun()
    println(eq("a","a"))// true
}

/**
 * Пример возвращения анонимной функции
 * Возвращяемый тип функции (: (str1:String, str2:String) -> Boolean) описывать необязательно, написал для примера
 * @return функция сравнения двух строк
 * */
fun getEqualsFun(): (str1:String, str2:String) -> Boolean = fun(str1:String, str2:String):Boolean = str1 == str2

// Сокращенная версия работает так же как и полная запись выше
// fun getEqualsFun() = fun(str1:String, str2:String) = str1 == str2


