/**
 * Модификаторы видимости
 * */

package ipr.chp3._5

/**
 * * private: классы, объекты, интерфейсы, а также функции и свойства, определенные вне класса,
 *   с этим модификатором видны только в том файле, в котором они определены. Члены класса с этим модификатором видны только в рамках своего класса
 *
 * * protected: члены класса с этим модификатором видны в классе, в котором они определены, и в классах-наследниках
 *
 * * internal: классы, объекты, интерфейсы, функции, свойства, конструкторы с этим модификатором видны в любой части модуля,
 *   в котором они определены. Модуль представляет набор файлов Kotlin, скомпилированных вместе в одну структурную единицу.
 *   Это может быть модуль IntelliJ IDEA или проект Maven
 *
 * * public: классы, функции, свойства, объекты, интерфейсы с этим модификатором видны в любой части программы.
 *   (При этом если функции или классы с этим модификатором определены в другом пакете их все равно нужно импортировать)
 *
 *
 * */
fun main() {
   A1()
}

//класс доступен только в текущем модуле
internal open class A1(t1: String = "", t2:String = "", t3:String = "") {
    // обратиться можно только внутри данного класса
    private var t1:String = t1

    // обратиться можно только внутри данного класса и класса наследника
    protected var t2:String = t2

    // обратиться  можно только внутри данного модуля
    internal var t3:String = t3
}

// виден только в данном файле
private class A2()

// виден везде
class A3()

//Модификаторы объектов и типов верхнего уровня
// Классы, а также переменные и функции, которые определены вне других классов, также могут иметь модификаторы public, private и internal.
private val s1:Int = 1


