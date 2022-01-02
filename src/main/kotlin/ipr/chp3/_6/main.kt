/**
 * Геттеры и сеттеры
 * */

package ipr.chp3._6

/**
 * Синтаксис getter/setter
 * var имя_свойства[: тип_свойства] [= инициализатор_свойства]
 * set(имя переменной) {инструкции}
 * get() {инструкции}
 * */

fun main() {
    val p = Person()
    println("${p.name} ${p.age}")
}

class Person(private var _name: String = "Undefined", private var _age: Int = 0) {

    //setter getter для приватного поля _name
    var name: String
        set(name) {
            if (name.isNotEmpty()) {
                _name = name
            }
        }
        get() = _name

    //setter getter для приватного поля _age
    var age: Int
        set(age) {
            if (age > 0) {
                _age = age
            }
        }
        get() = _age

    // если getter и setter привязан на прямую к данному свойству то текущее поле обозначено как field
    var id: Int = 1
        set(value){
            if(value > 0)
                field = value
        }

}

//свойство высокого порядка доступное только внутри файла
private var _highLevelProp = "Undefined"
// getter и setter для свойства высокого порядка
var highLevelProp: String
    set(value) {
        if (value.isNotEmpty()) {
            _highLevelProp = value

        }
    }
    get() = _highLevelProp