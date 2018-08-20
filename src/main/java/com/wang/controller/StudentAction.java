package com.wang.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wang.entity.StudentEntity;
import com.wang.model.StudentModel;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4 0004.
 */
public class StudentAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    public StudentEntity entity;
    public void setEntity(StudentEntity entity) {
        this.entity = entity;
    }
    public StudentEntity getEntity() {
        return this.entity;
    }
    private StudentModel model;
    public void setModel(StudentModel model) {
        this.model = model;
    }
    public String list() {
        List<StudentEntity> list = this.model.list();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("studentList", list);
        return SUCCESS;
    }
    public String add() {
        System.out.println(this.entity);
        this.model.add(this.entity);
        return SUCCESS;
    }
    public String delete() {
        System.out.println(this.entity.getID());
        this.model.delete(this.entity.getID());
        return SUCCESS;
    }
}
