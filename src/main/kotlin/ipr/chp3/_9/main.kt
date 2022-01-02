/**
 * Интерфейсы
 * */

package ipr.chp3._9

/**
 * Для определения интерфейса применяется ключевое слово interface
 *
 * для вызова метода с одинаковым названием из разных интерфейсов или классов используется super<имя класса/интерфейса>.метод
 *
 * */
fun main() {
    val car = Car("машина", 100)
    println(car.name)
    car.move()
    car.stop()

    val aircraft = Aircraft("Самолет", 300)
    println(aircraft.name)
    aircraft.move()
    aircraft.stop()

    // так же интерфейс может хранить ссылку на значение любого класса
    val movable:Movable = aircraft

    // но через переменную интерфейса можно вызвать только те методы и свойства которые определены в интерфейсе
    movable.move()
    movable.stop()
}

interface Movable {
    var speed: Int  // объявление свойства
    fun move()      // определение функции без реализации
    fun stop() {     // определение функции с реализацией по умолчанию
        println("Остановка")
    }
}

interface Engine {
    fun stop() {
        println("Engine stopped")
    }
}

class Car(name: String, speed: Int) : Movable, Engine{

    var name: String = name
        get() = field
        set(name) {
            field = name
        }

    override var speed: Int = speed
        get() = speed
        set(speed) {
            field = speed
        }

    // метод обязательный для реализации
    override fun move() {
        println("$name: я еду")
    }

    override fun stop() {
        //вызов реализации метода с одинаковым названием из интерфейса Movable
        super<Movable>.stop()
        //вызов реализации метода с одинаковым названием из интерфейса Engine
        super<Engine>.stop()
    }
}

class Aircraft(name: String, speed: Int) : Movable {

    var name: String = name
        get() = field
        set(name) {
            field = name
        }

    // переопределение обязательное свойство
    override var speed: Int = speed
        get() = speed
        set(speed) {
            field = speed
        }

    // метод обязательный для реализации
    override fun move() {
        println("$name: я лечу")
    }

    // метод не обязательный к определению, но переопределю реализацию
    override fun stop() {
        println("$name приземлился")
    }

}