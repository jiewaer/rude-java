package com.rocketmq.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Rocket枚举
 * @author jieqin
 */
public interface RocketConstant {

    interface Topic{
        String PRAISE_TOPIC = "praise_topic";
    }

    interface ConsumerGroup{
        String PRAISE_CONSUMER = "praise_consumer";
    }

}
