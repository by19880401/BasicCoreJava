package com.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.entity.BfsNotaDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper // 启动类加了mapperscan扫描，此处不需
@Repository
public interface BfsNotaDetailMapper extends BaseMapper<BfsNotaDetail> {

    @Select("select * from bfs_nota_detail where f_notaunikey=#{fNotaunikey}")
    @Results({@Result(column = "id", property = "id", id = true),
            @Result(column = "f_notaunikey", property = "fNotaunikey"),
            @Result(column = "f_detailunikey", property = "fDetailunikey"),
            @Result(column = "f_moneyslogan", property = "fMoneyslogan"),
            @Result(column = "f_keynum", property = "fKeynum"),
            @Result(column = "f_backcode", property = "fBackcode"),
            @Result(column = "f_detailbacksx", property = "fDetailbacksx"),
            @Result(column = "f_drvercode", property = "fDrvercode"),
            @Result(column = "f_btime", property = "fBtime"),
            @Result(column = "f_coupons", property = "fCoupons"),
            @Result(column = "f_couponcount", property = "fCouponcount"),
            @Result(column = "f_couponvalue", property = "fCouponvalue"),
            @Result(column = "f_revision", property = "fRevision")
    })
    List<BfsNotaDetail> getDetailListByMainTableKey(@Param("fNotaunikey") String fKey);//注意：这里的@Param("fNotaunikey")，要与BfsNotaMapper的findList方法里的@Result(column = "f_notaunikey",property = "fNotaunikey")注解保持一致


    @Select("select * from bfs_nota_detail where id=#{id}")
    @Results(id = "willisTestDetailMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "f_notaunikey", property = "fNotaunikey"),
            @Result(column = "f_detailunikey", property = "fDetailunikey"),
            @Result(column = "f_moneyslogan", property = "fMoneyslogan"),
            @Result(column = "f_keynum", property = "fKeynum"),
            @Result(column = "f_backcode", property = "fBackcode"),
            @Result(column = "f_detailbacksx", property = "fDetailbacksx"),
            @Result(column = "f_drvercode", property = "fDrvercode"),
            @Result(column = "f_btime", property = "fBtime"),
            @Result(column = "f_coupons", property = "fCoupons"),
            @Result(column = "f_couponcount", property = "fCouponcount"),
            @Result(column = "f_couponvalue", property = "fCouponvalue"),
            @Result(column = "f_revision", property = "fRevision")
    })
    List<BfsNotaDetail> getDetailListById(@Param("id") Integer id);
}
