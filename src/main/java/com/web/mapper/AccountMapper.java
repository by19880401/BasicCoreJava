package com.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.entity.Account;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper extends BaseMapper<Account> {

    @Select("select bcja.*,\n" +
            "       item.id as item_id,\n" +
            "       item.\"label\" as item_label,\n" +
            "       item.f_tag_id as item_tag_id\n" +
            "from\n" +
            "       basic_core_java_account bcja\n" +
            "left join tags_item item on\n" +
            "       bcja.tag_id = item.f_tag_id\n" +
            "where\n" +
            "       bcja.id = 1")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "country", property = "country"),
            @Result(column = "access", property = "access"),
            @Result(column = "address", property = "address"),
            @Result(column = "signature", property = "signature"),
            @Result(column = "unread_count", property = "unreadCount"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "title", property = "title"),
            @Result(column = "notify_count", property = "notifyCount"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "name", property = "name"),
            @Result(column = "email", property = "email"),
            @Result(column = "department", property = "department"),
            @Result(property = "tags", column = "tag_id", many = @Many(resultMap = "com.web.mapper.TagItemMapper.tagItemResultMap", columnPrefix = "item_"))
    })
    List<Account> findAccounts();
}
