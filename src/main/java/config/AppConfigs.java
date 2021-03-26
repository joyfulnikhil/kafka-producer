package config;

public final class AppConfigs {

    private AppConfigs(){}

    public static final String BROKERS_LIST="localhost:9092,localhost:9093";
    public static final String APPLICATION_ID="kafka-basic-producer";
    public static final String TOPIC_NAME="kafka-basics-01";
    public static final String[] EVENT_FILES={"data/NSE05NOV2018BHAV.csv","data/NSE06NOV2018BHAV.csv"};
    public static final String[] TRANSACTION_TOPICS={"kafka-transactions-01","kafka-transactions-02"};
    public static final String TRANSACTION_ID="tx-01";
}
