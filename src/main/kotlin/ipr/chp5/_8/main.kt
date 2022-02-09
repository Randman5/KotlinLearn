/**
 * Инфиксная нотация
 * */

package ipr.chp5._8

/**
 * *
 *
 * */
fun main(args: Array<String>) {
    val box = Box<Toy>(10)
    box put Toy("Buzz Lightyear") // вызов infix ной функции
    box put Toy("Sheriff Woody") // вызов infix ной функции
    println(box)
    box put Toy("slinky dog") // вызов infix ной функции
    println(box)
    box.pop()
    println(box)
}

class Toy(val name:String){
    override fun toString(): String {
        return name
    }
}

class Box<T>(val size: Int, _items: MutableList<T> = mutableListOf()) {
    constructor(size: Int, _item: T) : this(size, mutableListOf<T>(_item))

    val items = _items


    infix fun put(obj: T) {
        if (items.count() < size) {
            items.add(obj)
        }
    }

    fun pop() {
        items.removeLast()
    }

    fun take(): T {
        try {
            return items.last()
        } finally {
            items.removeLast()
        }
    }

    override fun toString(): String {
        return items.toString()
    }
}