package com.today.event.consumer;


import com.today.api.goods.scala.events.PublishedSkuEvent;
import com.today.api.goods.scala.events.SkuAttributeUpdateApprovedEvent;
import com.today.binlog.BinlogEvent;
import com.today.eventbus.annotation.BinlogListener;
import com.today.eventbus.annotation.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author with struy.
 * Create by 2018/3/3 20:39
 * email :yq1724555319@gmail.com
 */
@KafkaConsumer(groupId = "eventConsumer111", topic = /*"goods_1.0.0_event"*/"Binlog")
public class EventConsumer {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    //    @KafkaListener(serializer = SkuAttributeUpdateApprovedEventSerializer.class)
    public void goodsEvent(SkuAttributeUpdateApprovedEvent event) {


        System.out.println(event.toString());
    }

    //    @KafkaListener(serializer = PublishedSkuEventSerializer.class)
    public void goodsPublishSkuEvent(PublishedSkuEvent event) {

        System.out.println(event.toString());
    }


    @BinlogListener
    public void binlogListener(List<BinlogEvent> events) {


        events.forEach(event -> {
            System.out.println(event.toString());
        });

    }
}
