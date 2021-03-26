package transaction;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionEventCallback implements Callback {

    private static final Logger logger= LogManager.getLogger();

    private int messageID;

    public TransactionEventCallback(int messageID){
        this.messageID=messageID;
    }
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if(e==null){
            logger.info("Message id: {}, Partition: {}, Offset: {}",messageID,recordMetadata.partition(),recordMetadata.offset());
        }else {
            logger.error(e.getMessage());
        }

    }
}
