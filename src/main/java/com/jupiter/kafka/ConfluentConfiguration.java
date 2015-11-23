package com.jupiter.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.kafka.core.ZookeeperConfiguration;

/**
 * Created by hmohamed on 11/21/15.
 */
@Configuration
//@EnableConfigurationProperties(ConfluentKafkaSourceModuleOptionsMetadata.class)
@ImportResource("classpath:config/kafka-confluent.xml")
public class ConfluentConfiguration {

    /**
    @Autowired
    ConfluentKafkaSourceModuleOptionsMetadata props;

    public ZookeeperConfiguration zookeeperConfiguration() {
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration("xx");
        return null;

    }
    */

}
