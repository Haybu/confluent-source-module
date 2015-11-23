package com.jupiter.kafka;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.integration.x.kafka.*;
import org.springframework.xd.module.options.spi.Mixin;
import org.springframework.xd.module.options.spi.ModuleOption;

/**
 * Created by hmohamed on 7/3/15.
 */
//@Data
//@ConfigurationProperties
public class ConfluentKafkaSourceModuleOptionsMetadata {

    // from KafkaSourceModuleOptionsMetadata
    private String topic = "";
    private String topics = "";
    private String partitions = "";
    private String initialOffsets = "";
    private KafkaSourceModuleOptionsMetadata.OffsetStorageStrategy offsetStorage;
    private int streams;
    private String groupId;
    private String encoding;
    private int offsetUpdateTimeWindow;
    private int offsetUpdateCount;
    private int offsetUpdateShutdownTimeout;
    private int queueSize;

    // from KafkaZKOptionMixin.class
    private String zkconnect = "localhost:2181";
    private int zksessionTimeout = 6000;
    private int zkconnectionTimeout = 6000;
    private int zksyncTime = 2000;

    // from KafkaConsumerOptionsMixin.class
    private int socketTimeout = 30000;
    private int socketBufferBytes = 2097152;
    private int fetchMaxBytes = 1048576;
    private int fetchMinBytes = 1;
    private int fetchMaxWait = 100;
    private AutoOffsetResetStrategy autoOffsetReset;

    // from KafkaOffsetTopicOptionsMixin.class
    private int kafkaOffsetTopicSegmentSize = 262144000;
    private String kafkaOffsetTopicName = "${xd.stream.name}-${xd.module.name}-offsets";
    private int kafkaOffsetTopicRetentionTime = '\uea60';
    private int kafkaOffsetTopicRequiredAcks = 1;
    private int kafkaOffsetTopicMaxSize = 1048576;
    private int kafkaOffsetTopicBatchBytes = 200;
    private int kafkaOffsetTopicBatchTime = 1000;


    private String registryUrl = "";
    private boolean autoCommit = false;

}
