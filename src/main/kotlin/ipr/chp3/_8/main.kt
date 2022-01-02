/**
 * Абстрактные классы и методы
 * */

package ipr.chp3._8

/**
 * Абстрактные классы - это классы, определенные с модификатором abstract
 * абстрактные классы можно только унаследовать, так же нельзя создать экземпляр абстрактного класса
 *
 * перед абстрактным классом не надо указывать аннотацию open, как при наследовании неабстрактных классов.
 *
 * */
fun main() {

    val p = Person("vasiliy", 25)
    println(p.name)
    p.hello()
    p.walk()

}

// open не нужно указывать
abstract class Human(var name:String) {

    // Не абстрактный метод
    fun hello() = println("Hello i'm $name")

    // Абстрактный метод walk который обязан реализовать класс наследник
    abstract fun walk()

    abstract var age:Int

}

// наследование абстрактного класса
class Person(name: String, age:Int): Human(name) {

    // определение реализации метода walk
    override fun walk(){
        println("$name walk")
    }

    // переопределение абстрактного свойства
    override var age:Int = age
        set(age) {
        field = age
    }
    get() = field

}