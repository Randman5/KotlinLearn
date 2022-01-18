/**
 * Обработка исключений
 * */

package ipr.chp5._1

/**
 * Для обработки исключений применяется конструкция try..catch..finally.
 * В блок try помещаются те действия, которые потенциально могут вызвать исключение (например, передача файла по сети, открытие файла и т.д.).
 * Блок catch перехватывает возникшее исключение и обрабатывает его. Блок finally выполняет некоторые завершающие действия.
 *

try {
// код, генерирующий исключение
}
catch (e: Exception) {
// обработка исключения
}
finally {
// постобработка
}

 *
 * * Оператор throw
 * Для генерации исключения применяется оператор throw, после которого указывается объект исключения
 *
 * * Возвращение значения
 * Конструкция try может возвращать значение.
 * */
fun main() {
    tryCatchtest()
    tryCatchInfo()
    tryCatchAny()
    testThrow()
    println(tryCatchReturn())// вернет 25 так как не было вызвано исключение

}

/**
 * функция для демонстрации работы try..catch..finally
 * @return Unit(Void)
 * */
fun tryCatchtest() {
    println("\ntryCatchtest()")
    try { // блок потенциально содержащий исключение
        val x: Int = 0
        val z: Int = 0 / x // исключение
        println("z = $z")
    } catch (e: Exception) { // блок обработки исключения
        println("Exception")
        println(e.message) // информация об исключение(сообщение об исключении)
    } finally { // блок с завершающими действиями будет выполнен в любом случае
        println("final try catch fun")
    }
}

/**
 * функция для демонстрации получения информации об исключение
 * @return Unit(Void)
 * */
fun tryCatchInfo() {
    println("\ntryCatchInfo()")
    try { // блок потенциально содержащий исключение
        val x: Int = 0
        val z: Int = 0 / x // исключение
        println("z = $z")
    } catch (e: Exception) { // блок обработки исключения
        println("Exception")
        println(e.message) // информация об исключение(сообщение об исключении)

        //stackTrace: трассировка стека исключения - набор строк, где было сгенерировано исключение
        for (line in e.stackTrace) {
            println("at $line") //вывод информ
        }

        e.printStackTrace() //stackTrace: вывод трассировки стека исключения
    }
}

/**
 * функция для демонстрации обработки нескольких исключений
 * @return Unit(Void)
 * */
fun tryCatchAny() {
    println("\ntryCatchAny()")
    try {
        val array = arrayOf(1, 2, 3)
        println(array[4]) // ArrayIndexOutOfBoundsException
    } catch (e: ArrayIndexOutOfBoundsException) { // первый блок catch
        println("индекс элемента находится за границами существующего диапазона")
        e.printStackTrace()
    } catch (e: Exception) { // второй блок catch
        e.printStackTrace() //stackTrace: вывод трассировки стека исключения
    }
    // блоки обрабатываются в порядке написания
}

// throw генерация исключений
fun throwException() {
    throw Exception("thrown exception")
}

fun testThrow() {
    println("\ntestThrow()")
    try {
        throwException()
    } catch (e: Exception) {
        println(e.message)
    }
}

//Возвращение значения
fun tryCatchReturn():Int {
    return try {
        5*5
    } catch (e: Exception){
        0
    }
}