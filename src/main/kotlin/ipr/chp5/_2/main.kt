/**
 * Null и nullable-типы
 * */

package ipr.chp5._2

/**
 * * Ключевое слово null представляет специальный литерал, который указывает, что переменная не имеет как такового значения. То есть у нее по сути отсутствует значение
 * типам Int или String или любых других классов нельзя просто присвоить null
 * null можно установить только для nullble типов что бы тип стал nullable нужно добавить знак "?" в конце типа пример: val num: Int? = null
 * Nullable-типы могут представлять и создаваемые разработчиком классы
 *
 * * Nullable типы имеют ряд ограничений
 * Значения nullable-типов нельзя присвоить напрямую переменным, которые не допускают значения null
 * У объектов nullable-типов нельзя вызвать напрямую те же функции и свойства, которые есть у обычных типов
 * Нельзя передавать значения nullable-типов в качестве аргумента в функцию, где требуется конкретное значение, которое не может представлять null
 *
 * * Оператор ?: который позволяет предоставить альтернативное значение, если присваиваемое значение равно null
 *
 * * Оператор ?. позволяет объединить проверку значения объекта на null и обратиться к функциям или свойствам этого объекта.
 *
 * * Оператор !! (not-null assertion operator) принимает один операнд. Если операнд равен null,
 * то генерируется исключение. Если операнд не равен null, то возвращается его значение.
 * */
fun main() {
    val n = null
    println(null)// null

    // nullable тип
    val num: Int? = null

    //nullable тип созданный разработчиком
    var person: Person? = null
    person = Person("Tom")

    // Оператор ?:
    val notNullNum: Int = num ?: 0 // если num = null, то в notNullNum будет передано значение ноль

    // Оператор ?.
    person?.printName() // вызов функции если переменная person != null, если person = null то выражение вернет null

    //Оператор !!
    try {
        println(num!!.plus(5))
    } catch (e: Exception) {
        println(e.message)
    }

}

class Person(val name: String) {
    fun printName() {
        println(name)
    }
}
