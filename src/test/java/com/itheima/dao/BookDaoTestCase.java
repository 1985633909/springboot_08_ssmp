package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 19856
 * @creator 2022/11/13-22:14
 */
@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    public void testSave(){
        Book book = new Book(null, "测试数据", "测试名字", "测试描述数据");
        bookDao.insert(book);
        System.out.println("新增完成");
    }

    @Test
    void testDelete(){
//        bookDao.deleteById(10);
    }

    @Test
    void testGetAll(){
        List<Book> books = bookDao.selectList(null);
        books.forEach(System.out::println);
    }

    @Test
    public void testGetPage(){

//        QueryWrapper queryWrapper = new QueryWrapper();
        LambdaQueryWrapper<Book> queryWrapper1 = new LambdaQueryWrapper<>();

        String name = "测试名字";
        queryWrapper1.like(name != null,Book::getName,name);

        IPage page = new Page(1,5);
        bookDao.selectPage(page,queryWrapper1);
        System.out.println(page.getCurrent());//当前页码
        System.out.println(page.getSize());//最大值
        System.out.println(page.getTotal());//总共多少数据
        System.out.println(page.getPages());//总页数
        System.out.println(page.getRecords());//数据


    }

    @Test
    public void testGetPage2(){

//        QueryWrapper queryWrapper = new QueryWrapper();
//        LambdaQueryWrapper<Book> queryWrapper1 = new LambdaQueryWrapper<>();
//
//        String name = "测试名字";
//        queryWrapper1.like(name != null,Book::getName,name);

        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());//当前页码
        System.out.println(page.getSize());//最大值
        System.out.println(page.getTotal());//总共多少数据
        System.out.println(page.getPages());//总共几页
        System.out.println(page.getRecords());//数据


    }


}
