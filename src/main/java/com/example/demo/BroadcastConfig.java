package com.example.demo;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BroadcastConfig {

  //Criando a fila e o FanoutExchange
  @Bean
  public Declarables fanoutBindings(@Value("${queue}") String queueName){
    Queue queue = new Queue(queueName, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE);
    FanoutExchange fanoutExchange = new FanoutExchange("my-fanout", Boolean.FALSE, Boolean.TRUE);
    //Inserindo a fila no FanoutExchange
    return new Declarables(queue,fanoutExchange, BindingBuilder.bind(queue).to(fanoutExchange));
  }
}
