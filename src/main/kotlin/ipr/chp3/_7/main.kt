/**
 * Переопределение методов и свойств
 * */

package ipr.chp3._7

/**
 * Чтобы функции и свойства базового класа можно было переопределить, к ним применяется аннотация open.
 * При переопределении в производном классе к этим функциям применяется аннотация override.
 *
 * * Запрет переопределения
 * для запрета переопределения функций в классах-наследниках для этого применяется ключевое слово final
 *
 * * Обращение к реализации из базового класса
 * С помощью ключевого слова super в производном классе можно обращаться к реализации из базового класса.
 *
 * */
fun main() {

    val worker = Worker(_name = "tom", _age = 25, _address = "pushkina 28d")

    println(worker.getFullName())

}

open class Person(protected var _name: String, protected var _age: Int) {

    open var name
        set(name) {
            if (name.length > 2) {
                _name = name
            }
        }
        get() = _name

    open var age
        set(name) {
            if (name.length > 2) {
                _name = name
            }
        }
        get() = _name

    open fun getFullName(): String {
        return "$_name $_age"
    }

    // метода запрещен для переопределения
    final fun dispaly() {
        println("$_name $_age")
    }

}

class Worker(_name: String, _age: Int, var _address: String) : Person(_name, _age) {

    var address: String
        set(address) {
            _address = address
        }
        get() = _address

    // переопределение родительского свойства name
    override var name: String
        get() = super.name
        set(name) {
            if (name.length > 5) {
                _name = name
            }
        }

    // переопределение родительского метода getFullName
    override fun getFullName(): String {
        // super вызов родительского метода
        return "${super.getFullName()} $address"
    }


}