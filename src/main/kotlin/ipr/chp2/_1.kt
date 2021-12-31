/**
 * Функции и их параметры
 * */

package ipr.chp2


/**
 * Синтаксис функции
 * fun имя_функции (параметры) : возвращаемый_тип {выполняемые инструкции}
 * По умолчанию все параметры функции равносильны val-переменным, то есть immutable поэтому их значение нельзя изменить
 * Если параметр является сложным объектом то можно изменять значения внутри этого объекта
 *
 * */
fun main() {
    //вызов функции
    printKotlin()
    printUser("Руслан", 21)
    displayCar("Ford", 200)
    displayCar()

    //Именованные аргументы можно передавать параметры не по порядку, а по наименованию аргумента
    displayCar(maxSpeed = 200, brand = "Opel")

    // пример с передачей сложного объекта
    val array:Array<Int> = arrayOf(1,2,3,4,5)
    // данные изменятся по ссылке
    elementsInc(array)
    array.forEach { println(it) }
}



/**
 * !!!Функции которые определены вне других функций или классов называют функциями верхнего уровня (top-level functions)!!!
 * */
/**
 * Top-level функция для вывода текста "kotlin"
 * без параметров возвращаемый тип Unit(void) по умолчанию
 * */
fun printKotlin() {
    println("kotlin")
}

// Передача параметров
/**
 * Top-level функция для вывода информации о пользователе с параметрами
 * @param name String имя пользователя
 * @param age Int возраст пользователя
 * @return Unit(void) по умолчанию
 * */
fun printUser(name:String, age: Int) {
    println("$name $age")
}

// параметры по умолчанию
/**
 * Top-level функция для вывода информации о машине
 * @param brand марка машины Default "none"
 * @param maxSpeed максимальная скорость Default 0
 * @return Unit(void) по умолчанию
 * */
fun displayCar(brand:String = "none", maxSpeed: Int = 0) {
    println("Brand: $brand\n max speed: $maxSpeed")
}

// пример с передачей сложного объекта
/**
 * Top-level функция для увелечения каждого элемента на 1
 * @param array входной массив целых чисел
 * @return Unit(void) по умолчанию
 * */
fun elementsInc(array: Array<Int>) {
    for (i in array.indices) {
        array[i]++
    }
}


