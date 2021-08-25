package com.attachments.firstdemoapi

import com.attachments.firstdemoapi.controller.PersonController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class FirstdemoapiApplication

fun main(args: Array<String>) {
	runApplication<FirstdemoapiApplication>(*args)
}
