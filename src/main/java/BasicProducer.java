

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;


public class BasicProducer {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
    logger.info("The Producer has Started!!");
    Properties properties=new Properties();
    properties.put(ProducerConfig.CLIENT_ID_CONFIG,AppConfigs.APPLICATION_ID);
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConfigs.BROKERS_LIST);
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    KafkaProducer<Integer,String> producer= new KafkaProducer<>(properties);
    for (int i=0;i<200;i++){
        producer.send(new ProducerRecord<>(AppConfigs.TOPIC_NAME,i,"Hello-Kafka-"+i),((recordMetadata, e) -> {
            if(e==null){
                logger.info("Partition: {}, Offset: {}, Timestamp: {}",
                        recordMetadata.partition(),recordMetadata.offset(),recordMetadata.timestamp());
            }else {
                logger.error("The message can't be produced");
            }
        }));
    }

    logger.info("The Producer is completed");
    producer.close();


    }


}
