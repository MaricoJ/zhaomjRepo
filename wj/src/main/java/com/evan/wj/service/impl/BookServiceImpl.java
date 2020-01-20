package com.evan.wj.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.evan.wj.dao.BookMapper;
import com.evan.wj.pojo.Book;
import com.evan.wj.service.BookService;
import org.springframework.stereotype.Service;

@Service("BookService")
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
