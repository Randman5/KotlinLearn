/**
 * Вложенные классы и интерфейсы
 * */

package ipr.chp3._10

/**
 * * Вложенные классы или nested classes
 * Стоит учитывать, что вложенный (nested) класс по умолчанию не имеет доступа к свойствам и функциям внешнего класса
 *
 * * Внутренние (inner) классы
 * Чтобы вложенный класс мог иметь доступ к свойствам и функциям внешнего класса, необходимо определить вложенный класс с ключевым словом inner.
 *
 * * Совпадение имен
 * внутренний класс может обратиться к свойствам и функциям внешнего через конструкцию this@название_класса.имя_свойства_или_функции
 * */
fun main() {
    // создание экземпляра вложенного класса
    val userAcc = Person.Account("qwerty", "123456");
    userAcc.showDetails()

    val p2 = Person2("tom", "12345")
    p2.showDetails()

    val p3 = Person3("tom", "12345")
    p3.account.showDetails() // UserName: tom  Password: hide
    p3.showPas = true
    p3.account.showDetails() // UserName: tom  Password: 12345

}

// внешний класса
class Person {

    // Вложенный класс
    class Account(val username: String, val password: String) {

        fun showDetails() {
            println("UserName: $username  Password: $password")
        }
    }
}


// внешний класса
class Person2(username: String, password: String) {

    private val account: Account = Account(username, password)

    // Вложенный класс если необходимо ограничить доступ к этому классу то нужно указать модификатор доступа
    private class Account(val username: String, val password: String)

    fun showDetails() {
        println("UserName: ${account.username}  Password: ${account.password}")
    }
}

// интерфейс может содержать вложенные классы и интерфейсы
interface SomeInterface {
    class NestedClass
    interface NestedInterface
}


// класс может содержать вложенные классы и интерфейсы
class SomeClass : SomeInterface {
    class NestedClass
    interface NestedInterface
}


//Внутренние (inner) классы
class Person3(username: String, password: String, var showPas: Boolean = false) {

    val account: Account = Account(username, password)


    inner class Account(private val username: String, private val password: String) {

        fun showDetails() {
            println("UserName: ${account.username}  Password: ${
                if (showPas) account.password else Array<Char>(password.length) { '*' }.joinToString("")
            }")
        }
    }
}

//совпадение имен
class A{
    private val n: Int = 1
    inner class B{
        private val n: Int = 1
        fun action(){
            println(n)          // n из класса B
            println(this.n)     // n из класса B
            println(this@B.n)   // n из класса B
            println(this@A.n)   // n из класса A
        }
    }
}