package com.example.kafka_demo;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author wangxiang w00448499 2019/1/17 20:18
 * 使用官方的kafka clints包进行编程实现
 */
public class OrgKafkaProducer {

     //获取配置公共参数
     public Properties getProperty(){

         Properties props = new Properties();
         props.put("bootstrap.servers","192.168.101.36:9092");
         props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
         props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
         props.put("acks","-1");
         props.put("retries",3);
         props.put("batch.size",323840);
         props.put("linger.ms",10);
         props.put("buffer.memory",335554432);
         props.put("max.block.ms",3000);

         return props;
     }

     //Producer 的第一个demo
     public void ProducerDemo01(){

         Producer<String,String> producer = new KafkaProducer<String, String>(getProperty());
         for (int i = 0; i < 10;i++){
             producer.send(new ProducerRecord<>("my-topic",Integer.toString(i),Integer.toString(i)));
         }

         producer.close();
     }


    public static void main(String[] args) {

        OrgKafkaProducer orgKafkaProducer = new OrgKafkaProducer();
        orgKafkaProducer.ProducerDemo01();

    }

}
