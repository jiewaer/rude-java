package com.rocketmq.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author jieqin
 */
@Data
public class PraiseRecordVO {
    private Long id;
    private Long uid;
    private Long liveId;
    private LocalDateTime createTime;
}
