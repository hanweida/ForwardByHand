package groupId;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

public class KafkaToFlinkSQL {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
//        DataStream<String> dataStream = env.fromElements("Alice", "Bob", "John");

//// interpret the insert-only DataStream as a Table
//        Table inputTable = tableEnv.fromDataStream(dataStream);
//
//// register the Table object as a view and query it
//        tableEnv.createTemporaryView("InputTable", inputTable);
//        Table resultTable = tableEnv.sqlQuery("SELECT UPPER(f0) FROM InputTable");
//
//// interpret the insert-only Table as a DataStream again
//        DataStream<Row> resultStream = tableEnv.toDataStream(resultTable);
//
//// add a printing sink and execute in DataStream API
//        resultStream.print();
//        env.execute();


   String ddlSource = "CREATE TABLE KafkaTable (\n" +
           "  `behavior` STRING \n" +
           ") WITH (\n" +
           "  'connector' = 'kafka',\n" +
           "  'topic' = 'test',\n" +
           "  'properties.bootstrap.servers' = '127.0.0.1:9093',\n" +
           "  'properties.group.id' = 'jerry',\n" +
           "  'scan.startup.mode' = 'earliest-offset',\n" +
           "  'format' = 'raw'\n" +
           ")";

        tableEnv.executeSql(ddlSource);

        Table table = tableEnv.from("KafkaTable");
        Table result = tableEnv.sqlQuery("select behavior from KafkaTable group by behavior");

        DataStream<Row> dataStream = tableEnv.toChangelogStream(result);
        dataStream.print();
        env.execute();
    }


//    public static void main(String[] args) throws Exception {
//        StreamExecutionEnvironment blinkStreamEnv = StreamExecutionEnvironment.getExecutionEnvironment();
//        blinkStreamEnv.setParallelism(1);
//        EnvironmentSettings blinkStreamSettings = EnvironmentSettings.newInstance()
//                .useBlinkPlanner()
//                .inStreamingMode()
//                .build();
//        StreamTableEnvironment blinkStreamTableEnv = StreamTableEnvironment.create(blinkStreamEnv, blinkStreamSettings);
//
//        String ddlSource = "CREATE TABLE user_behavior (\n" +
//                "    user_id BIGINT,\n" +
//                "    item_id BIGINT,\n" +
//                "    category_id BIGINT,\n" +
//                "    behavior STRING,\n" +
//                "    ts TIMESTAMP(3)\n" +
//                ") WITH (\n" +
//                "    'connector.type' = 'kafka',\n" +
//                "    'connector.version' = 'universal',\n" +
//                "    'connector.topic' = 'user_behavior',\n" +
//                "    'connector.startup-mode' = 'latest-offset',\n" +
//                "    'connector.properties.zookeeper.connect' = 'localhost:2181',\n" +
//                "    'connector.properties.bootstrap.servers' = 'localhost:9093',\n" +
//                "    'format.type' = 'json'\n" +
//                ")";
//
//        String ddlSink = "CREATE TABLE user_behavior_es (\n" +
//                "    user_id BIGINT,\n" +
//                "    item_id BIGINT\n" +
//                ") WITH (\n" +
//                "    'connector.type' = 'kafka',\n" +
//                "    'connector.version' = '0.11',\n" +
//                "    'connector.hosts' = 'http://localhost:9200',\n" +
//                "    'connector.index' = 'user_behavior_es',\n" +
//                "    'connector.document-type' = 'user_behavior_es',\n" +
//                "    'format.type' = 'json',\n" +
//                "    'update-mode' = 'append',\n" +
//                "    'connector.bulk-flush.max-actions' = '10'\n" +
//                ")";
//
//        //提取读取到的数据，然后只要两个字段，写入到 ES
//        String sql = "insert into user_behavior_es select user_id, item_id from user_behavior";
//
//        System.out.println(ddlSource);
//        System.out.println(ddlSink);
//        blinkStreamTableEnv.sqlUpdate(ddlSource);
//        blinkStreamTableEnv.sqlUpdate(ddlSink);
//        blinkStreamTableEnv.sqlUpdate(sql);
//
//        blinkStreamTableEnv.execute("Blink Stream SQL Job2 —— read data from kafka，sink to es");
//
//    }
}
