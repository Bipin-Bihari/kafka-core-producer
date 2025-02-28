package com.course.kafka;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.course.kafka.producer.HelloKafkaProducer;
import com.course.kafka.producer.KafkaKeyProducer;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner{
	@Autowired
    private KafkaKeyProducer producer;
	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//producer.sendHello("Timotius " +ThreadLocalRandom .current().nextInt());
		for(int i=0;i<=10_000;i++) {
			var key="key-"+i%4;
			var value="value "+i+ " with key " +key;
			producer.send(key, value);
			TimeUnit.SECONDS.sleep(1);
		}
		
	}

}
