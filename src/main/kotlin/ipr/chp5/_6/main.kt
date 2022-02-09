/**
 * Делегированные свойства
 * */

package ipr.chp5._6
import kotlin.reflect.KProperty

/**
 * Свойства делегируются при помощи ключевого слова by <делегат>()
 * */
fun main(args: Array<String>) {
    val tom = Person("tom")
    tom.name = "entony"
    val str = tom.name
}

class Person(private var _name: String) {

    // Делегирование свойства name делегату NameLoggerDelegate(_name)
    var name: String by NameLoggerDelegate(_name)
}

/**
 * Делегат для логирования свойств
 * */
class NameLoggerDelegate(private var personName: String) {

    operator fun getValue(thisRef: Person, property:KProperty<*>): String {
        println("${thisRef.javaClass} getValue: ${personName}")
        return personName
    }

    operator fun setValue(thisRef: Person, property: KProperty<*>, value: String) {
        personName = value
        println("${thisRef.javaClass} setValue: $value")
    }

}
