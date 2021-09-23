package com.attachments.firstdemoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class FirstdemoapiApplication

fun main(args: Array<String>) {
	runApplication<FirstdemoapiApplication>(*args)
}

@Bean
fun restTemplate(): RestTemplate {
	return RestTemplate()
}
