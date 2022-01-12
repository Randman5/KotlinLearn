/**
 * Data-классы
 * */

package ipr.chp3._11

/**
 * * Data-классы
 * Иногда классы бывают необходимы только для хранения некоторых данных.
 * В Kotlin такие классы называются data-классы. Они определяются с модификатором data
 * При компиляции такого класса компилятор автоматически добавляет в класс функции с определенной реализацией,
 * которая учитывает свойства класса, которые определены в первичном конструкторе
 *
 * автоматически переопределяет методы
 * equals(): сравнивает два объекта на равенство
 * hashCode(): возвращает хеш-код объекта
 * toString(): возвращает строковое представление объекта
 * copy(): копирует данные объекта в другой объект
 *
 * */
fun main() {
    // создание экземпляра вложенного класса
    val person = Person("tom",25)
    println(person.toString()) // из-за модификатора data метод автоматически переопределен Person(name=tom, age=25)
    val person2 = Person2("tom",25)
    println(person2.toString()) // метод переопределен и выведет Name: tom  Age: 25

    //пример Декомпозиция data-классов
    val (username, userage) = person
    println("$username $userage")
}

// функции hashcode, tostring, equals работают по параметрам первичного конструктора
data class Person(val name: String, val age: Int)

data class Person2(val name: String, val age: Int) {


    //Если вдруг не устраивает реализация по умолчанию методы можно переопределить
    override fun toString(): String {
        return "Name: $name  Age: $age"
    }
}

