package com.rocketmq.entity;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 点赞记录
 * @author jieqin
 */
@Data
public class PraiseRecord implements Serializable {
    private Long id;
    private Long uid;
    private Long liveId;
    private LocalDateTime createTime;
}

