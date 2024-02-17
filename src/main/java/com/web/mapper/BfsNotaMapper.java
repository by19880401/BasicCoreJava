package com.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.entity.BfsNota;
import com.web.entity.BfsNotaDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper // 启动类加了mapperscan扫描，此处不需
@Repository
public interface BfsNotaMapper extends BaseMapper<BfsNota> {
    /**
     * 【不推荐】OneToMany一对多查询，常规方式，查询的性能和效率低
     *
     * @param idNumAsParam
     * @return
     */
    @Select("select * from bfs_nota where id=#{idNum}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "f_notaunikey", property = "fNotaunikey"),// 注意：这里的fNotaunikey，会以参数的形式传到BfsNotaDetailMapper的getDetailListByMainTableKey方法中，所以它这里的名称，要与getDetailListByMainTableKey中@Param("fNotaunikey")保持一致
            @Result(column = "f_head", property = "fHead"),
            @Result(column = "f_msgtype", property = "fMsgtype"),
            @Result(column = "f_drivercode", property = "fDrivercode"),
            @Result(column = "f_qr_cdrivercode", property = "fQrCdrivercode"),
            @Result(column = "f_qr_fdatetime", property = "fQrFdatetime"),
            @Result(column = "f_qr_randomnum", property = "fQrRandomnum"),
            @Result(column = "f_notaunikey" /* 主表的列名,这里的f_notaunikey是要传递给下面查询里需要的参数 */, property = "details" /* 这里是BfsNota类里的details字段 */,
                    many = @Many(select = "com.web.mapper.BfsNotaDetailMapper.getDetailListByMainTableKey"))
    })
    List<BfsNota> findList(@Param("idNum") Integer idNumAsParam);// 注意：注解里的idNum需与上述@Select语句中的#{idNum}一致


    /***************************************************Start****************************************************************/

    /**
     * 【推荐】OneToMany一对多查询，高效的方式
     *
     * @param idNumAsParam
     * @return
     */
    @Select("select m.*,\n" +//也可以将m表的字段全部列出，但要与s表的字段冠以不同的前缀，以示区别
            "       s.id             s_id,\n" +
            "       s.f_notaunikey   s_f_notaunikey,\n" +
            "       s.f_detailunikey s_f_detailunikey,\n" +
            "       s.f_moneyslogan  s_f_moneyslogan,\n" +
            "       s.f_keynum       s_f_keynum,\n" +
            "       s.f_backcode     s_f_backcode,\n" +
            "       s.f_detailbacksx s_f_detailbacksx,\n" +
            "       s.f_drvercode    s_f_drvercode,\n" +
            "       s.f_btime        s_f_btime,\n" +
            "       s.f_coupons      s_f_coupons,\n" +
            "       s.f_couponcount  s_f_couponcount,\n" +
            "       s.f_couponvalue  s_f_couponvalue,\n" +
            "       s.f_revision     s_f_revision\n" +
            "from bfs_nota m\n" +
            "         left join bfs_nota_detail s on\n" +
            "    m.f_notaunikey = s.f_notaunikey\n" +
            "where m.id = #{idNum}")
    @Results({
            @Result(property = "id", column = "id", id = true),                  // <1> 必须要写这一行，这里的id指m表的id，因为s表的id被定义为s_id
            @Result(column = "f_notaunikey", property = "fNotaunikey"),
            @Result(column = "f_head", property = "fHead"),
            @Result(column = "f_msgtype", property = "fMsgtype"),
            @Result(column = "f_drivercode", property = "fDrivercode"),
            @Result(column = "f_qr_cdrivercode", property = "fQrCdrivercode"),
            @Result(column = "f_qr_fdatetime", property = "fQrFdatetime"),
            @Result(column = "f_qr_randomnum", property = "fQrRandomnum"),
            @Result(property = "details", many = @Many(resultMap = "willisTestDetailMap", columnPrefix = "s_"))  // <2>不同之处在这里
    })
    List<BfsNota> findListWithHighPerformance(@Param("idNum") Integer idNumAsParam);

    /**
     * 上述<2>补充：
     * 这个@Result(property = "details", many = @Many(resultMap = "willisTestDetailMap", columnPrefix = "s_"))中
     * property = "details"，代表子查询的查询结果关联的实体属性，就是BfsNota中的details字段。
     * resultMap = "willisTestDetailMap" 指向getDetailListById方法上的@Results注解里的id值.
     * 事实上，getDetailListById这个方法并没有被真的调用，甚至上面 Select 注解中的 SQL 语句也不会被执行。定义这个方法只是因为 @Results 注解必需要依存于一个方法，换句话来说，这个方法只是占位符而已。
     * columnPrefix, 会为 willisTestDetailMap 中的所有列名都加上一个 s_ 前缀，这样一来就能匹配上联合查询 SQL语句中实际返回的列名（例如 s_id）了
     *
     * TODO 重要：经过测试，上面的 Mapper 完美地完成了任务。值得一提的是，引用的ResultMap不一定要定义在同一个 Mapper中，也可以用全限定名去引用 Mapper 外部的 ResultMap
     *
     * @param id
     * @return
     */
    /*@Select("select * from bfs_nota_detail where id=#{id}")
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
    List<BfsNotaDetail> getDetailListById(@Param("id") Integer id);*/
    /***************************************************End****************************************************************/

}
