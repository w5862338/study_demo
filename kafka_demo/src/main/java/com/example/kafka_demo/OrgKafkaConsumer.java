package com.example.kafka_demo;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @author wangxiang w00448499 2019/1/25 17:02
 */
public class OrgKafkaConsumer {

    //获取配置公共参数
    public Properties getProperty(){

        String groupID = "test-group";

        Properties props = new Properties();
        props.put("bootstrap.servers","192.168.101.36:9092");
        props.put("group.id",groupID);
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        return props;
    }

    //Consumer 的第一个demo
    public void ConsumerDemo01(){
        String topicName = "my-topic";
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(getProperty());

        //创建consumer 实例
        consumer.subscribe(Arrays.asList(topicName));
        System.out.println("完成创建");

        try {
            while (true){
                ConsumerRecords<String,String> records = consumer.poll(1000);
                for (ConsumerRecord<String,String> record : records){
                    System.out.println("offset = "+record.offset()+"key = "+record.key()+ "value = "+ record.value());
                }
            }
        }finally {
            consumer.close();
        }
    }

    public static void main(String[] args) {
        OrgKafkaConsumer orgKafkaConsumer = new OrgKafkaConsumer();
        orgKafkaConsumer.ConsumerDemo01();
    }
}

















