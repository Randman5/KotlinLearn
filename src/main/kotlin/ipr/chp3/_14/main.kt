/**
 * Анонимные классы и объекты
 * */

package ipr.chp3._14

/**
 * * Анонимные классы
 * не используют ключевое слово class для определения. Они не имеют имени,
 * но как и обычные классы могут наслдовать другие классы или применять интерфейсы. Объекты анонимных классов называют анонимыми объктами
 *
 * * Наследование анонимных объектом
 * При наследовании после слова object через двоеточия указывается имя наследуемого класса или его первичный конструктор:
 *
 * * Анонимный объект как аргумент функции
 * Анонимный объект может передаваться в качестве аргумента в вызов функции
 *
 * * Анонимный объект как результат функции
 * Функция может возвращать анонимный объект
 * !!!Чтобы мы могли обращаться к свойствам и функциям анонимного объекта, функция, которая возвращает этот объект, должна быть приватной, как в примере выше.
 * Если функция имеет модификатор public или private inline, то в этом случае свойства и функции анонимного класса (за исключением унаследованных) недоступны!!!
 *
 * */
fun main() {

    // для определения анонимного объекта используется ключевое слово object
    val tom = object {
        val name = "tom"
        val age = 32
        override fun toString(): String {
            return "$name $age"
        }
    }
    println(tom) // вывод tom 32

    // пример наследования
    val steve = object : Person("Steve", 25) {
        var job: String = "Programmer"
        override fun toString(): String {
            return return "$name $age $job"
        }
    }
    println(steve) //вывод Steve 25 Programmer

    //Анонимный объект как аргумент функции
    printClass(object : Person("Max", 69) {
        var job: String = "Programmer"
        override fun toString(): String {
            return return "$name $age $job"
        }
    })

    //Анонимный объект как результат функции
    println(getTom30Programmer())




}

open class Person(val name: String, val age: Int) {
    override fun toString(): String {
        return "$name $age"
    }
}

fun printClass(person: Person) {
    println(person)
}

/**
 * Функция возвращает анонимный объект
 * Функция private поэтому свойство job доступно
 * @return анонимный объект унаследованный от person
 * */
private fun getTom30Programmer() = object : Person("Tom", 30) {
    var job: String = "Programmer"
    override fun toString(): String {
        return "$name $age $job"
    }
}




