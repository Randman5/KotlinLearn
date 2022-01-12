/**
 * Делегирование
 * */

package ipr.chp3._13

/**
 * * Делегирование
 * представляет паттерн объектно-ориентированного программирования, который позволяет одному объекту делегировать/перенаправить все запросы другому объекту
 * После указания применяемого интерфейса идет ключевое слово by, а после него - объект, которому будут делегироваться вызовы
 *
 * */
fun main() {

    Derived(BaseImpl()).someWork()

    // пример делегирования с параметрами
    val selector = Selector()
    val tom = UserSelector(selector)
    tom.statusWithSet(true)

}


interface Base {
    fun someWork()
}

class BaseImpl() : Base {
    override fun someWork() {
        print("someWork")
    }
}

// делегирование выполнения контрактных методов экземпляру класса BaseImpl() "Base by base"
class Derived(base: Base) : Base by base

// пример делегирования с параметрами

interface OnOff {
    var on: Boolean
    fun on()
    fun off()
    fun statusWithSet(status: Boolean)
}

class Selector(on: Boolean = false) : OnOff {

    override var on: Boolean = on

    override fun on() {
        on = true
    }

    override fun off() {
        on = false
    }

    override fun statusWithSet(status: Boolean) {
        on = status
        println("status: $on")
    }
}

class UserSelector(selector: OnOff) : OnOff by selector

//Множественное делегирование
class userSelectorBase(selector: OnOff, base: Base): OnOff by selector, Base by base

//Переопределение функций
//Класс может переопределять часть функций интерфейса, в этом случае выполнение этих функций не делегируется.
class userSelectorOverrideFun(selector: OnOff, base: Base): OnOff by selector {

    // все методы делегированы selector кроме текущего
    override fun statusWithSet(status: Boolean) {
        println("method overriding")
    }
}

