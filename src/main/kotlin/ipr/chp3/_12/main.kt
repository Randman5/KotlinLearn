/**
 * Перечисления enums
 * */

package ipr.chp3._12

/**
 * * Для определения перечисления применяются ключевые слова enum class
 * Синтаксис enum class название(val название переменной: тип)
 *
 * * Встроенные свойства и вспомогательные методы
 * name: возвращает название константы в виде строки
 * ordinal: возвращает порядковый номер константы
 *
 * *  вспомогательные функции:
 * valueOf(value: String): возвращает объект перечисления по названию константы
 * values(): возвращает массив констант текущего перечисления
 *
 * */
fun main() {

    val day = Day.MONDAY
    println(day)

    val day2 = Day2.MONDAY.value
    println(day2)

    println(Day3.MONDAY.value)

    println(Day3.MONDAY.getDuration(Day3.SUNDAY))

    println("""
        values: ${Day3.values().contentToString()}, valueOf(MONDAY) ordinal: ${Day3.valueOf("MONDAY").ordinal}
    """.trimIndent())

    AnonimClass.DAY.printName()

    // Перечисление классов реализующих методы интерфейса
    DayTime.DAY.printName()
    DayTime.DAY.ss()
    DayTime.NIGHT.ss()

    //Хранение состояния
    print(operate(1,2,Operation.ADD)) // вывод 3


}

enum class Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

//Классы перечислений, как и обычные классы также могут иметь конструктор.
// Кроме того, для констант перечисления также может вызываться конструктор для их инициализации
enum class Day2(val value: Int) {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(100500)
}

enum class Day3(val value: String) {
    MONDAY("понедельник"), TUESDAY("вторник"), WEDNESDAY("среда"),
    THURSDAY("четверг"), FRIDAY("пятница"), SATURDAY("суббота"), SUNDAY("воскресенье");

    fun getDuration(day: Day3): Int {
        return kotlin.math.abs(ordinal - day.ordinal);
    }
}


//Анонимные классы и реализация интерфейсов

//Анонимные классы
enum class AnonimClass {
    DAY {
        override val startHour = 6
        override val endHour = 21
        override fun printName() {
            println("День")
        }
    },
    NIGHT {
        override val startHour = 22
        override val endHour = 5
        override fun printName() {
            println("Ночь")
        }
    };

    abstract fun printName();
    abstract val startHour: Int
    abstract val endHour: Int
}

// реализация интерфейсов

interface PrintName {
    open fun printName()
}

enum class DayTime: PrintName {
    DAY {
        override fun printName() {
            println("День")
        }
        override fun ss() {
            println("ssDAY")
        }
    },
    NIGHT {
        override fun printName() {
            println("Ночь")
        }
    };

    open fun ss() {
        println("ss")
    }
}

//Хранение состояния
enum class Operation {
    ADD,
    SUBTRACT
}

fun operate(n1:Int, n2:Int, op: Operation):Int = when(op) {
    Operation.ADD -> n1 + n2
    Operation.SUBTRACT -> n1 - n2
}


