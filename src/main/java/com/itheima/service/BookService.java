package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

/**
 * @author 19856
 * @creator 2022/11/14-16:00
 */

public interface BookService extends IService<Book> {
    Boolean delete(Integer id);
    Boolean saveBook(Book book);
    Boolean modify(Book book);

    IPage<Book> getPage(int currentPage,int pageSize,Book book);

}
