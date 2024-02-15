package com.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 测试mybatis-plus的一对多关系
 * 子表
 *
 * @Author Willis
 * @Date 2024/2/15 16:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BfsNotaDetail implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String fNotaunikey;
    private String fDetailunikey;
    private String fMoneyslogan;
    private String fKeynum;
    private String fBackcode;
    private String fDetailbacksx;
    private String fDrvercode;
    private LocalDateTime fBtime;
    private String fCoupons;
    private Integer fCouponcount;
    private Integer fCouponvalue;
    private String fRevision;
}
