/**
 * launch и Job
 * */

package ipr.chp7._3

import kotlinx.coroutines.*
import java.time.Duration
import kotlin.time.ExperimentalTime

/**
 *  *Прежде всего, launch(), как правило, применяется, когда нам не надо возвращать результат из корутины и когда нам ее надо выполнять одновременно с другим кодом.
 *
 * * Job
 * Построитель корутин launch возвращает объект Job, с помощью которого можно управлять запущеной корутиной
 *
 * * Отложенное выполнение
 * По умолчанию построитель корутин launch создает и сразу же запускает корутину.
 * Однако Kotlin также позволяет применять технику отложенного запуска корутины (lazy-запуск), при котором корутина запускается при вызове метода start() объекта Job.
 * Для установки отложенного запуска в функцию launch() передается значение start = CoroutineStart.LAZY
 * */
suspend fun main() = coroutineScope {
//    jobExample()
//    lazyLaunch()
//    calc1to10().start() // не будет работать
    println("End")
}

// пример с ожиданием выполнения асинхронных вычислений
suspend fun jobExample() = coroutineScope<Unit> {
    val job = launch {
        for (i in 1..10) {
            println(i)
            delay(400L)
        }
    }
    print("Start")
    job.join() // ожидает выполнения
    println("End") // выполнится после того как асинхронная функция выполнится
}

// пример позднего запуска (Отложенное выполнение)
@OptIn(ExperimentalTime::class)
suspend fun lazyLaunch() = coroutineScope {
    val job = launch(start = CoroutineStart.LAZY) {
        println("coroutine start")

    }

    delay(kotlin.time.Duration.Companion.seconds(1)) // имитация каких либо синхронных действий перед запуском
    job.start()// запус асинхронного выполнения
    println("other job")
}

// не понимаю почему не могу запустить job который возвращает функция?????????
// ответ скорее всего функция ожидает запуска job из этого контекста но он не происходит и происходит зацикливание так как параметр запуска lazy
// то есть job бязан быть запущен но он не запускается и функция ожидает его бесконечно
suspend fun calc1to10() = coroutineScope {
    println("start jobs")
    launch(start = CoroutineStart.LAZY) {
        for (i in 1..10) {
            println(i)
        }
    }
}