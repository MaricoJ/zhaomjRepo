package com.evan.wj.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.List;

@TableName("AdminMenu")
public class AdminMenu {
    @TableId("id")
    private int id;
    private String path;
    private String name;
    private String nameZh;
    private String iconCls;
    private String component;
    private int parentId;
    //储存子节点
    List<AdminMenu> children;

}
