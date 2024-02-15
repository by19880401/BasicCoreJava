package com.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 测试mybatis-plus的一对多关系
 * 主表
 *
 * @Author Willis
 * @Date 2024/2/15 16:23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BfsNota implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String fNotaunikey;
    private String fHead;
    private String fMsgtype;
    private String fDrivercode;
    private String fQrCdrivercode;
    private LocalDateTime fQrFdatetime;
    private String fQrRandomnum;
    private List<BfsNotaDetail> details;
}
