package no.tretoen.frokost.openapi.demoserverapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class DemoServerAppApplication

fun main(args: Array<String>) {
    runApplication<DemoServerAppApplication>(*args)
}
