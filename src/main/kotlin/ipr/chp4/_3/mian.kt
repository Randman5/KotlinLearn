/**
 * Вариантность, ковариантность и контравариантность
 * */

package ipr.chp4._3


/**
 * * Вариантность описывает, как обобщенные типы, типизированные классами из одной иерархии наследования, соотносятся друг с другом.
 *
 * * Инвариантность
 * предполагает, что, если у нас есть классы Base и Derived, где Derived - производный класс от Base,
 * то класс C<Base> не является ни базовым классом для С<Derived>, ни производным
 *
 * * Ковариантость
 * Ковариантость предполагает, что, если у нас есть классы Base и Derived, где Base - базовый класс для Derived,
 * то класс SomeClass<Base> является базовым классом для SomeClass<Derived>
 * Для определения обобщенного типа как ковариантного параметр обощения определяется с ключевым словом out
 *
 * */
fun main() {

}

//Инвариантность
/*
инвариантность предполагает что тип val emailMsg: Messenger<Message> не может хранить объект другого типа обобщения,
то есть val emailMsg: Messenger<Message> = EmailMessage("текст") будет ошибочным
так как val emailMsg: Messenger<Message> может хранить только объекты типа Messenger<Message> но не Messenger<EmailMessage>
*/
open class Message(val text: String)
class EmailMessage(text: String): Message(text)
interface Messenger<T: Message>
//пример
/*
fun changeMessengerToEmail(obj: Messenger<EmailMessage>){
    val messenger: Messenger<Message> = obj   // ! Ошибка
}
fun changeMessengerToDefault(obj: Messenger<Message>){
    val messenger: Messenger<EmailMessage> = obj      // ! Ошибка
}

Правильный пример
fun changeMessengerToDefault(obj: Messenger<Message>){
    val messenger: Messenger<Message> = obj
}
fun changeMessengerToEmail(obj: Messenger<EmailMessage>){
    val messenger: Messenger<EmailMessage> = obj
}
 */




//Ковариантость
/*
в данном случае обобщенный тип помечен модификатором out это значит что тип может принимать любой объект для которого
 MessageKov является родителем, или реализует данный интерфейс
*/
interface MessengerKov<out T: MessageKov>
open class MessageKov(val text: String)
class EmailMessageKov(text: String): MessageKov(text)


//пример
//fun changeMessengerToEmail(obj: MessengerKov<EmailMessageKov>){
//    val messenger: MessengerKov<MessageKov> = obj // будет корректно работать в отличие от предыдущего примера, где указанна ошибка
//}


// так же модификатор out означает что функция может возвращать T
/*
open class Message(val text: String)
class EmailMessage(text: String): Message(text)

interface Messenger<out T: Message>{
    fun writeMessage(text: String): T // Возвращаемый параметр должен строго быть тем же что и указан при реализации обобщенного интерфейса
}


//так же тип out T: Message е может быть входным параметром

interface Messenger<out T: Message>{
    fun writeMessage(text: T): T // text: T ошибка
}


class EmailMessenger(): Messenger<EmailMessage>{
    override fun writeMessage(text: String): EmailMessage { // так как реализует Messenger<EmailMessage> то и возвращаемый параметр может быть только типа EmailMessage
        return EmailMessage("Email: $text")
    }
}
*/

//Контравариантность
//Контравариантость предполагает, что, если у нас есть классы Base и Derived, где Base - базовый класс для Derived,
// то объекту SomeClass<Derived> мы можем присвоить значение SomeClass<Base>
// (при ковариантности, наоборот, - объекту SomeClass<Base> можно присвоить значение SomeClass<Derived>)

//Для определения обобщенного типа как контравариантного параметр обобщения определяется с ключевым словом in
interface MessengerKont<in T: MessageKont>
open class MessageKont(val text: String)
class EmailMessageKont(text: String): MessageKont(text)

//то есть наоборот
fun changeMessengerToEmail(obj: MessengerKont<MessageKont>){
    val messenger: MessengerKont<EmailMessageKont> = obj // разрешает присвоение родительского класса в переменную типа наследника
}

