package com.evan.wj.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.evan.wj.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
