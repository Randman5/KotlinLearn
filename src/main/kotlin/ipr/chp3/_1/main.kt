/**
 * Классы и объекты
 * */

package ipr.chp3._1

/**
 * Для определения класса применяется ключевое слово class
 * * синтаксис определения класса
 * class Имя класса {}
 *
 * * Свойства
 * Каждый класс может хранить некоторые данные или состояние в виде свойств
 *
 * * Функции класса (member functions)
 * Класс также может содержать функции. Функции определяют поведение объектов данного класса. Такие функции еще называют member functions или функции-члены класса.
 *
 * */
fun main() {
    // создание объекта
    val undefined = Person()

    //получение свойств объекта
    println("${undefined.name} ${undefined.age}") // вывод undefined 0

    //mutable var свойство можно изменить даже если объект immutable
    undefined.age = 25

    println("${undefined.name} ${undefined.age}") // вывод undefined 25

    //вызов функций членов(member functions) из экземпляра класса Person
    undefined.sayHello() // вывод Hello, my name is undefined
    undefined.go("home") // вывод undefined goes to home
    println(undefined.personToString()) // вывод Name: undefined  Age: 25

}

/**
 * Класс Person(человек)
 * */
class Person {

    //immutable свойство
    val name: String = "Undefined"

    //mutable свойство
    var age: Int = 0

    //Функции класса (member functions)

    /**
     * Функция для вывода приветствия объекта
     * */
    fun sayHello() {
        println("Hello, my name is $name")
    }

    /**
     * Функция для вывода направления объекта
     * @param location направление объекта
     * */
    fun go(location: String) {
        println("$name goes to $location")
    }

    /**
     * Функция для получения информации об объекте
     * @return свойство объекта
     * */
    fun personToString(): String {
        return "Name: $name  Age: $age"
    }

}