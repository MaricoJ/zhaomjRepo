package com.evan.wj.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Search;
import com.evan.wj.service.BookService;
import com.evan.wj.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;
    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> bookList(){
        List<Book> bookList=bookService.selectList(new EntityWrapper<Book>());
        return bookList;
    }
    @CrossOrigin
    @PostMapping("/api/books")
    public Book insertOrUpdateBook(@RequestBody Book book){
        bookService.insertOrUpdate(book);
        return book;
    }
    @CrossOrigin
    @PostMapping("/api/delete")
    public void deleteBook(@RequestBody Book book){
        bookService.deleteById(book.getId());
    }
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> bookListByCategory(@PathVariable("cid") int cid){
        if(cid==0) {
            List<Book> bookList = bookService.selectList(new EntityWrapper<Book>());
            return bookList;
        }else {
            List<Book> bookList = bookService.selectList(new EntityWrapper<Book>()
                    .eq("cid", cid)
            );
            return bookList;
        }
    }

    @CrossOrigin
    @PostMapping("api/search")
    public List<Book> searchBook(@RequestBody Search search){
        String keywords=search.getKeywords();
        List<Book> bookList=bookService.selectList(new EntityWrapper<Book>()
                .like(StringUtils.isNotEmpty(keywords),"title",keywords)
                .or()
                .like(StringUtils.isNotEmpty(keywords),"author",keywords)
        );
        return bookList;
    }

    @CrossOrigin
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

















}
