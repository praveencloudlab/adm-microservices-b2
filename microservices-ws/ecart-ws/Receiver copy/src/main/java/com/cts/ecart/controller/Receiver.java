package com.cts.ecart.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Receiver {

	
	@RabbitListener(queues = "Q1")
	public void f2(String msg) {
		System.out.println(">>>>> Reciver:: Message: "+msg);
		//return "Message:: "+msg;
	}

}
