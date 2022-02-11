/**
 * Отмена выполнения корутин
 * */

package ipr.chp7._6

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.getCancellationException
import kotlin.coroutines.CoroutineContext

/**
 * Для отмены выполнения корутины у объекта Job может применяться метод cancel():
 * Также вместо двух методов cancel() и join() можно использовать один сборный метод cancelAndJoin():
 * */
suspend fun main() {
    val con = cancelCoroutine()
//     если вызывать корутину вне контекста то это не окажет воздействия
//        delay(500L) // бесполезно
//        println("Прерву корутину") // бесполезно
//        context.cancel() // бесполезно

    // работающий пример так как все вызовы происходят в контексте coroutineScope
//    val sc = SomeClass()
//    sc.runCoroutine()
//    delay(400L)
//    sc.release()

    // пример с генерацией исключения
//    tryCatchDef()

}


suspend fun cancelCoroutine() = coroutineScope {
    val downloader: Job = launch {
        println("Начинаем загрузку файлов")
        for (i in 1..5) {
            if (!isActive) break
            println("Загружен файл $i")
            delay(500L)
        }
        println("Finished with $isActive")
    }
    delay(800L)     // установим задержку, чтобы несколько файлов загрузились
    println("Надоело ждать, пока все файлы загрузятся. Прерву-ка я загрузку...")
    downloader.cancel()    // отменяем корутину
    downloader.join()      // ожидаем завершения корутины
    println("Работа программы завершена")
    coroutineContext + downloader
}

// все методы класса в контексте корутины
class SomeClass() : CoroutineScope {

    var wasCancelled = false
    private val scopeJob by lazy { Job() }
    override val coroutineContext: CoroutineContext by lazy { Dispatchers.Main + scopeJob }

    fun runCoroutine() {
        launch(Dispatchers.IO) {
            for (i in 1..10) {
                if (!isActive) {
                    println("Coroutine was cancelled")
                    wasCancelled = true
                    break
                }
                println("загружен файл $i")
                delay(100)
            }
            println("Finished with $isActive")
        }
    }

    fun release() {
        scopeJob.cancel()
    }
}

// пример с генерацией исключения
suspend fun tryCatchDef() = coroutineScope {

    val job = launch {
        try {
            println("Начинаем загрузку файлов")
            for(i in 1..5){
                println("Загружен файл $i")
                delay(500L)
            }
        }
        catch (e: CancellationException ){
            println("Загрузка файлов прервана")
        }
        finally{
            println("Загрузка завершена")
        }
    }
    delay(500L)
    job.cancelAndJoin()// генерирует CancellationException

}