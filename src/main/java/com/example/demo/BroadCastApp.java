package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BroadCastApp {

  public static void main(String[] args) {
    SpringApplication.run(BroadCastApp.class, args);
  }

  //Consumindo Mensagem
  @RabbitListener(queues = "${queue}")
  public void receiveMessage(String message){
    System.out.println("Mensagem Recebida : " + message);
  }
}
