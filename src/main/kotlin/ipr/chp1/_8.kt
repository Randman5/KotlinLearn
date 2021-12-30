/**
 * Циклы
 * */

package ipr.chp1

/**
 * * Циклы в языке kotlin
 * for: for( переменная in последовательность ){выполняемые инструкции}
 * while: while(условие) {выполняемые инструкции ока условие истинно}
 * do Whiel: do{ выполняемые инструкции} while(условие)
 *
 * break: позволяет выйти из тела цикла
 * continue: позволяет перейти на следующую итерацию цикла
 * */
fun main() {

    // Цикл for
    println("for")
    for (i in 1..6) {
        println(i)
        if (i > 3) break
        else continue
    }

    println("вложенный for")
    // вложенный циклы
    for (i in 1..9) {
        for (j in 1..9) {
            print("i = $i j = $j \t")
        }
        println()
    }

    //цикл while
    println("while")
    var i = 0
    while (i < 10) {

        println(i)
        i++
    }

    // цикл do while
    println("do while")
    do {
        println(i)
        i--;
    } while (i > 0)
}