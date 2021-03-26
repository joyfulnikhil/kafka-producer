package multithread;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class FileHandler implements Runnable {

    private static final Logger logger=LogManager.getLogger();
    private KafkaProducer<String, String> producer;
    private String fileLocation;
    private String topicName;

    public FileHandler(KafkaProducer<String, String> producer, String fileLocation, String topicName){
        this.producer=producer;
        this.fileLocation=fileLocation;
        this.topicName=topicName;
    }

    @Override
    public void run() {

        logger.info("Processing started in {}",Thread.currentThread().getName());
        File file= new File(fileLocation);

        try(Scanner scanner= new Scanner(file)) {
            while (scanner.hasNext()){
                String line=scanner.nextLine();
                producer.send(new ProducerRecord<>(topicName,null,line),((recordMetadata, e) -> {
                    if(e==null){
                        logger.info("Partition: {}, Offset: {}, Timestamp: {}",
                                recordMetadata.partition(),recordMetadata.offset(),recordMetadata.timestamp());
                    }else {
                        logger.error("The message can't be produced");
                    }
                }));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
