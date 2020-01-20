package com.evan.wj.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.evan.wj.dao.CategoryMapper;
import com.evan.wj.pojo.Category;
import com.evan.wj.service.CategoryService;
import org.springframework.stereotype.Service;


@Service("CategoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
