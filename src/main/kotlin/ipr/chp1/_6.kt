/**
 * Условные выражения
 * */

package ipr.chp1

/**
 * * Операции отношения
 * > (больше чем): возвращает true, если первый операнд больше второго. Иначе возвращает false
 * < (меньше чем): возвращает true, если первый операнд меньше второго. Иначе возвращает false
 * >= (больше чем или равно): возвращает true, если первый операнд больше или равен второму
 * <= (меньше чем или равно): возвращает true, если первый операнд меньше или равен второму.
 * == (равно): возвращает true, если оба операнда равны. Иначе возвращает false
 * != (не равно): возвращает true, если оба операнда НЕ равны
 *
 * * Логические операции
 * and: возвращает true, если оба операнда равны true.
 * or: возвращает true, если хотя бы один из операндов равен true.
 * xor: возвращает true, если только один из операндов равен true. Если операнды равны, возвращается false
 * !: возвращает true, если операнд равен false. И, наоборот, если операнд равен true, возвращается false.
 * in: возвращает true, если операнд имеется в некоторой последовательности.
 * */
fun main() {
    // Операции отношения

    val five = 5
    val two = 2
    println("$five > $two (больше чем): возвращает true, если первый операнд больше второго. Иначе возвращает false")
    val moreThan = five > two
    println(moreThan)

    println("$five < $two (меньше чем): возвращает true, если первый операнд меньше второго. Иначе возвращает false")
    val lessThan = five < two
    println(lessThan)

    println("$five >= $two (больше чем или равно): возвращает true, если первый операнд больше или равен второму")
    val greaterThanOrEqual = five >= two
    println(greaterThanOrEqual)

    println("$five <= $two (меньше чем или равно): возвращает true, если первый операнд меньше или равен второму")
    val lessThanOrEqual = five <= two
    println(lessThanOrEqual)

    println("$five == $two (больше чем или равно): возвращает true, если первый операнд больше или равен второму")
    val equal = five == two
    println(equal)

    println("$five != $two (не равно): возвращает true, если оба операнда НЕ равны")
    val notEqual = five != two
    println(notEqual)

    //Логические операции

    val trueValue = true
    val falseValue = false

    println("and: возвращает true, если оба операнда равны true.")
    val andRes = trueValue and falseValue // = true and false = false
    println(andRes)

    println("or: возвращает true, если хотя бы один из операндов равен true")
    val orRes = trueValue or falseValue // = true or false = true
    println(orRes)

    println("xor: возвращает true, если только один из операндов равен true. Если операнды равны, возвращается false")
    val xorRes = trueValue xor falseValue // = true or false = true
    println(xorRes)

    println(" !: возвращает true, если операнд равен false. И, наоборот, если операнд равен true, возвращается false.")
    val inverseRes = !trueValue // = !true = false
    println(inverseRes)

    // так же поддерживается инверсия то есть не находится в последовательности five !in 1..6 = false
    println("in: возвращает true, если операнд имеется в некоторой последовательности.")
    val inRes = five in 1..6// = число five(5) есть в последовательности от 1 до 6 значит true
    println(inRes)



}