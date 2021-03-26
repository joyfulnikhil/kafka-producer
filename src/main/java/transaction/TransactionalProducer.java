package transaction;

import config.AppConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

/*
* To enable transaction, the below 2 mandatory topic level configuration:
* 1. Replication Factor >=3
* 2. min.insync.replicas>=2
*
*We can't have 2 producer with same transaction Id.
*
* */
public class TransactionalProducer {

    public static final Logger logger=LogManager.getLogger();

    public static void main(String[] args) {

        logger.info("In the Transactional Producer");
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BROKERS_LIST);
        props.put(ProducerConfig.CLIENT_ID_CONFIG,AppConfigs.APPLICATION_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,AppConfigs.TRANSACTION_ID);

        KafkaProducer<Integer,String> producer= new KafkaProducer<>(props);

        producer.initTransactions();

        logger.info("Starting the 1st transaction");

        producer.beginTransaction();
        try {
            producer.send(new ProducerRecord<>(AppConfigs.TRANSACTION_TOPICS[0],1,"Transaction-Message-1"),
                    new TransactionEventCallback(1));
            producer.send(new ProducerRecord<>(AppConfigs.TRANSACTION_TOPICS[1],2,"Transaction-Message-2"),
                    new TransactionEventCallback(2));
            producer.commitTransaction();
        }catch (Exception e){
            logger.error(e.getMessage());
            producer.abortTransaction();
            producer.close();
            throw new RuntimeException(e);
        }


        logger.info("Starting the 2nd transaction");

        producer.beginTransaction();
        try {
            producer.send(new ProducerRecord<>(AppConfigs.TRANSACTION_TOPICS[0],3,"Transaction-Message-3"),
                    new TransactionEventCallback(3));
            producer.send(new ProducerRecord<>(AppConfigs.TRANSACTION_TOPICS[1],4,"Transaction-Message-4"),
                    new TransactionEventCallback(4));
            producer.abortTransaction();
        }catch (Exception e){
            logger.error(e.getMessage());
            producer.abortTransaction();
            producer.close();
            throw new RuntimeException(e);
        }

        producer.close();


    }
}
