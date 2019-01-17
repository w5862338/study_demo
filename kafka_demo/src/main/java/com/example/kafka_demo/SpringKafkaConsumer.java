package com.example.kafka_demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author wangxiang w00448499 2019/1/17 19:39
 * 使用Spring Kafka jar包进行编程实现
 */
@Component
public class SpringKafkaConsumer {

//    @KafkaListener(topics = {"wx_topic"})
//    public void receive(String message){
//        System.out.println("wx_topic:"+message);
//    }
}
