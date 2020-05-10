package eu.iwha.androiddatasource

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class AndroidDataSourceApplication {

    @GetMapping("/data/order/{orderId}")
    fun getOrder(@PathVariable("orderId") orderId: String): Order =
            when(orderId) {
                "1" -> Order("Jan Kowalski", "GTD David Allen")
                "2" -> Order("Adam Nowak", "Bocian Kajtek Autor Nieznany")
                else -> Order("Unknown", "Unknown")
            }

    data class Order(val name: String, val offer: String)
}

fun main(args: Array<String>) {
    runApplication<AndroidDataSourceApplication>(*args)
}