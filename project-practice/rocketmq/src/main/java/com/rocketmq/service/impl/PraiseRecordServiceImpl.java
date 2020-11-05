package com.rocketmq.service.impl;

import com.rocketmq.dao.PraiseMapper;
import com.rocketmq.entity.PraiseRecord;
import com.rocketmq.service.PraiseRecordService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author jieqin
 */
@Service
public class PraiseRecordServiceImpl implements PraiseRecordService {

    @Resource
    private PraiseMapper praiseMapper;

    @Override
    public void insert(PraiseRecord praiseRecord) {
        praiseMapper.insert(praiseRecord);
    }
}
