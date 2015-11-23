package com.jupiter.kafka.source;

import com.jupiter.kafka.ConfluentConfiguration;
import io.confluent.kafka.serializers.KafkaAvroDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.SpelExpressionConverterConfiguration;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.kafka.inbound.KafkaMessageDrivenChannelAdapter;
import org.springframework.integration.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hmohamed on 11/21/15.
 */
@Configuration
@Import({SpelExpressionConverterConfiguration.class, ConfluentConfiguration.class})
@EnableBinding(Source.class)
public class ConfluentSourceConfiguration {

    @Autowired
    KafkaMessageListenerContainer kafkaMessageListenerContainer;

    @Autowired
    KafkaAvroDecoder avroDecoder;

    @Autowired
    private Source channels;

    @Bean
    public KafkaMessageDrivenChannelAdapter kafkaSource() {
        KafkaMessageDrivenChannelAdapter adapter
                = new KafkaMessageDrivenChannelAdapter(kafkaMessageListenerContainer);

        adapter.setKeyDecoder(avroDecoder);
        adapter.setPayloadDecoder(avroDecoder);
        adapter.setOutputChannel(channels.output());
        return adapter;
    }
}
