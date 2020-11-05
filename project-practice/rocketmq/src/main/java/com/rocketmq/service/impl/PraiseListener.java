package com.rocketmq.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.rocketmq.entity.PraiseRecord;
import com.rocketmq.entity.PraiseRecordVO;
import com.rocketmq.enums.RocketConstant;
import com.rocketmq.service.PraiseRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 点赞服务
 * @author jieqin
 */
@Service
@RocketMQMessageListener(topic = RocketConstant.Topic.PRAISE_TOPIC, consumerGroup = RocketConstant.ConsumerGroup.PRAISE_CONSUMER)
@Slf4j
public class PraiseListener implements RocketMQListener<PraiseRecordVO>, RocketMQPushConsumerLifecycleListener {
    @Resource
    private PraiseRecordService praiseRecordService;

    @Override
    public void onMessage(PraiseRecordVO vo) {
        PraiseRecord praiseRecord = new PraiseRecord();
        BeanUtil.copyProperties(vo, praiseRecord);
        praiseRecordService.insert(praiseRecord);
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        // 每次拉取的间隔，单位为毫秒
        consumer.setPullInterval(2000);
        // 设置每次从队列中拉取的消息数为16
        consumer.setPullBatchSize(16);
    }
}

