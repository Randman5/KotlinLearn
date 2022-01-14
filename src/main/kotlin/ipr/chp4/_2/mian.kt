/**
 * Ограничения обобщений
 * */

package ipr.chp4._2


/**
 * Ограничения обобщений
 *
 * */
fun main() {

    println(getBiggest(1, 3))// вывод 3

    // пример передачи обобщенного типа с множественным ограничением
    //!!! Стоит учитывать что тип T ограничен не одним из нескольких ограничений, а всеми сразу, то есть объект должен реализовывать все ограничения!!!
    fill(object : Fillable, Drinkable {
        override fun fill() = println("кружка наполнена пивом")
        override fun drink() = println("Выпил кружку пива")
    })

    // не рабочий приме если хоть одно из ограничений не соблюдено, а именно входящий параметр не реализует интерфейс Drinkable
    //    fill(object : Barrel {
    //        override fun fill() = println("Бочка наполнена пивом")
    //        override fun drink() = println("Выпил кружку пива")
    //    })

    //Ограничение в классах
    VendingMachine<BeerCup>().fillAndDrink(BeerCup())// автомат работает только с определенными напитками, а именно пивом
}

// пояснения
/**
 * Comparable<T> Интерфейс отвечающий за операции сравнение
 * */

//Функция, которая ограничивает тип T тем что тип T должен реализовать интерфейс Comparable<T>
fun <T : Comparable<T>> getBiggest(o1: T, o2: T): T {
    return if (o1 > o2) o1 else o2
}

/**
 * синтаксис нескольких ограничений
 * Если параметра типа надо установить несколько ограничений, то все они указываются после возвращаемого типа функции после слова where через запятую в форме
 * параметр_типа: ограничений
 * */

open interface Fillable {
    fun fill()
}

open interface Drinkable {
    fun drink()
}

open interface Givable {
    fun giveAway()
}

// !!!!!!!!!!!!!!!!!
// Стоит учитывать что тип T ограничен не одним из нескольких ограничений, а всеми сразу, то есть объект/тип должен реализовывать все ограничения,
// а именно оба интерфейса Fillable и Drinkable, если входной параметр типа Т реализует только 1 из интерфейсов то входящий тип не корректен
// !!!!!!!!!!!!!!!!!
//Установка нескольких ограничений
fun <T> fill(o: T) where T : Fillable, T : Drinkable {
    o.fill()
    o.drink()
}


//Если интересно VendingMachine это автомат для продажи еды напитков и тд
//Пример Ограничения в классах
// T это выдаваемая продукция в данном случае это напитки
class VendingMachine<T> where T : Fillable, T : Givable {
    fun fillAndDrink(cup: T) {
        cup.fill()
        cup.giveAway()
    }
}

class BeerCup: Fillable, Givable {
    override fun fill() = println("Кружка наполнена пивом")
    override fun giveAway() = println("Выдача кружки пива")
}





