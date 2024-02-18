package com.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.entity.TagsItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagItemMapper extends BaseMapper<TagsItem> {

    @Select("select * from tags_item where id=#{id}")
    @Results(id = "tagItemResultMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "label", property = "label"),
            @Result(column = "ftag_id", property = "tagId")
    })
    List<TagsItem> getDetailListById(@Param("id") Long id);
}
