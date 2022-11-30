package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


/**
 * @author 19856
 * @creator 2022/11/14-20:58
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAll(){
        R r = new R(true, bookService.list());
        return r;
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        R r = new R(bookService.save(book));
        if (book.getName().equals("1")){
           throw  new IOException("123");
        }
        boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功^^":"添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        R r = new R(bookService.modify(book));
        return r;
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Integer id){
        R r = new R(bookService.delete(id));
        return r;
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id){
        R r = new R(true, bookService.getById(id));
        return r;

    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage")Integer currentPage,@PathVariable("pageSize")Integer pageSize,Book book){

        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值，那么重新执行查询操作,使用最大页码值作为当前页码值
        if (currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        R r = new R(true,page);
        return r;
    }





}
