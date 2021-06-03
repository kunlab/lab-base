package com.kunlab.base.core.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 消息生产者实现类
 * @author likun
 * @date 2021/6/3
 */
public class MqProducer {

    public <Msg> void execute(RabbitTemplate template, Msg o) {
        template.convertAndSend(o);
    }

    public <Msg> void execute(RabbitTemplate template, String routingKey, Msg o) {
        template.convertAndSend(routingKey, o);
    }
}
