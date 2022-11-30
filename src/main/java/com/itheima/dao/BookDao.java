package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 19856
 * @creator 2022/11/13-22:09
 */
@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {




}
