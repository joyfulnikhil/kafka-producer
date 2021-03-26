package multithread;

import config.AppConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadProducer {

    private static final Logger logger= LogManager.getLogger();
    public static void main(String[] args) {

        Properties props= new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BROKERS_LIST);
        props.put(ProducerConfig.CLIENT_ID_CONFIG,AppConfigs.APPLICATION_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        KafkaProducer<String, String> producer= new KafkaProducer<>(props);

        ExecutorService es= Executors.newFixedThreadPool(2);
        List<Runnable> tasks= Arrays.asList(new FileHandler(producer,AppConfigs.EVENT_FILES[0],AppConfigs.TOPIC_NAME),
                new FileHandler(producer,AppConfigs.EVENT_FILES[1],AppConfigs.TOPIC_NAME));
        CompletableFuture<?> [] futures=tasks.stream()
                .map(task-> CompletableFuture.runAsync(task,es))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        es.shutdown();

        producer.close();
    }
}
