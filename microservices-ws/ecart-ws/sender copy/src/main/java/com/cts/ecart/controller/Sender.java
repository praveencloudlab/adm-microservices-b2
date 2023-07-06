package com.cts.ecart.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Sender {

	@Autowired
	private RabbitTemplate rt;

	@Bean
	public Queue f1() {
		return new Queue("Q1", false);
	}

	@GetMapping("/test/{msg}")
	@ResponseBody
	public String f2(@PathVariable String msg) {
		rt.convertAndSend("Q1", msg);
		return "Message Sent to Rabbit MQ";
	}

}
