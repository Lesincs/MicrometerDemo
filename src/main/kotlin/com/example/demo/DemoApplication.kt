package com.example.demo

import brave.sampler.Sampler
import org.springframework.boot.actuate.autoconfigure.tracing.TracingProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate


@SpringBootApplication
class DemoApplication{
	@Bean
	fun restTemplate(builder: RestTemplateBuilder): RestTemplate? {
		// Do any additional configuration here
		return builder.build()
	}

	@Bean
	fun braveSampler(properties: TracingProperties): Sampler {
		return Sampler.ALWAYS_SAMPLE
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
