package com.rocketmq.controller;

import com.rocketmq.entity.PraiseRecordVO;
import com.rocketmq.entity.ServerResponse;
import com.rocketmq.enums.RocketConstant;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 消息控制器
 * @author jieqin
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    /**
     * RocketMQ多种消息发送模式，asyncSend，syncSend，sendOneWay，同步，异步，只发送-不管结果（异步）
     */
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping("/praise")
    public ServerResponse praise(@RequestBody PraiseRecordVO vo) {
        rocketMQTemplate.sendOneWay(RocketConstant.Topic.PRAISE_TOPIC, MessageBuilder.withPayload(vo).build());
        return ServerResponse.success();
    }

}

