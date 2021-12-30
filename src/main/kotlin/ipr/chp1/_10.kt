/**
 * Массивы
 * */

package ipr.chp1

/**
 * В Kotlin массивы представлены типом Array.
 * val|var <имя переменной>: Array<тип хранимых значений>
 * arrayOf() можно передать набор значений, которые будут составлять массив
 * <имя переменной>[индекс элемента]: получить элемент по индексу
 * .indices: возвращает последовательность существующих индексов в массиве
 *
 * * Массивы для базовых типов
 * BooleanArray
 * ByteArray
 * ShortArray
 * IntArray
 * LongArray
 * CharArray
 * FloatArray
 *
 * * Многомерные массивы
 * синтаксис двумерного массива
 * val|var <имя переменной>: Array<Array<тип хранимых значений>>
 *
 * */
fun main() {
    val numbers: Array<Int> = arrayOf(1,2,3,4,5) // массив типа int от 1 до 5
    println("вывод массива")
    for (num in numbers) println(num)

    //получение элемента по индексу
    println("получение элемента по индексу")
    println(numbers[0]) // 1

    //присвоение значения элементу массива по индексу
    println("присвоение значения элементу массива по индексу")
    numbers[0] = 10 // теперь первым элементом в массиве является число 10

    println("значение массива после присвоения 0 элементу числа 10")
    for (num in numbers) println(num)

    // 2 способ инициализации массива с использованием конструктора класса Array
    println("2 способ инициализации массива с использованием конструктора класса Array")
    /*
     Первый параметр указывает, сколько элементов будет в массиве в данном случае 3
     Второй параметр представляет выражение, которое генерирует элементы массива
     */
    val numbers2: Array<Int> = Array(3, {5}) // [5, 5, 5]
    // вывод списка сгенерированного конструктором Array(3, {5})
    println("вывод списка сгенерированного конструктором Array(3, {5})")
    for (num in numbers2) println(num)

    // второй пример генерации элементов выражением
    var i = 1;
    val numbers3 = Array(3, { i++ * 2}) // [2, 4, 6]
    println("вывод списка сгенерированного конструктором Array(3, { i++ * 2})")
    for (num in numbers3) println(num)

    // пример перебора циклом while
    println("пример перебора циклом while")
    var itr:Int = 1
    while (itr in numbers3.indices) { // numbers3.indices возвращает последовательность существующих индексов в массиве
        println(numbers3[itr])
        itr++
    }

    //Проверка наличия элемента в массиве
    println("Проверка наличия элемента в массиве")
    println(1 in numbers) // true так как элемент присутствует в массиве


    //Массивы для базовых типов
    val arr1: BooleanArray = booleanArrayOf(true, false) // так же есть способ создания через конструктор BooleanArray(2, {true})
    val arr2: ByteArray = byteArrayOf(1,2,3) // так же есть способ создания через конструктор byteArrayOf(2, {1})
    val arr3: ShortArray = shortArrayOf(1,2,3) // так же есть способ создания через конструктор ShortArray(2, {5})
    val arr4: IntArray = intArrayOf(1,2,3) // так же есть способ создания через конструктор IntArray(2, {5})
    val arr5: LongArray = longArrayOf(1,2,3) // так же есть способ создания через конструктор LongArray(2, {10})
    val arr6: CharArray = charArrayOf('a','b','c') // так же есть способ создания через конструктор CharArray(2, {'a'})
    val doubles: DoubleArray = doubleArrayOf(2.4, 4.5, 1.2) // так же есть способ создания через конструктор DoubleArray(2, {1.2})
    val arr7: FloatArray = floatArrayOf(1.3F,2.2F,3.1F) // так же есть способ создания через конструктор FloatArray(2, {3.3F})

    //Многомерные массивы
    val table: Array<Array<Int>> = arrayOf(arrayOf(1,2,3),arrayOf(3,4,5),arrayOf(6,7,8))
    // получение элемента по индексу
    println("получение элемента по индексу")
    println(table[0][2]) // получено число 3

    //перебор многомерного массива
    println("перебор многомерного массива")
    for(subArray in table){
        for (num in subArray) {
            print(num)
        }
        println()
    }

}
