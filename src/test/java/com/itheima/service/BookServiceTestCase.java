package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 19856
 * @creator 2022/11/14-20:12
 */
@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    BookService bookService;

    @Test
    public void testGetById(){
        System.out.println(bookService.getById("1"));
    }

    @Test
    public void testSave(){
        Book book = new Book(null, "测试数据", "测试名字", "测试描述数据");
        bookService.save(book);
        System.out.println("新增完成");
    }

    @Test
    void testUpdate(){
        Book book = new Book(15, "测试数据1", "测试名字", "测试描述数据");
        bookService.updateById(book);
        System.out.println("修改完成");
    }

    @Test
    public void testDelete(){
        bookService.removeById(2);
    }

    @Test
    public void testGetAll(){
        bookService.list();
    }

    @Test
    public void testGetPage(){
        IPage<Book> page = new Page<>(2, 5);
        bookService.page(page);
        System.out.println(page.getCurrent());//当前页码
        System.out.println(page.getSize());//最大值
        System.out.println(page.getTotal());//总共多少数据
        System.out.println(page.getPages());//总页数

        System.out.println(page.getRecords());//数据

    }



}
