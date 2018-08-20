package com.wang.model;

import com.wang.db.DBHelper;
import com.wang.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4 0004.
 */
public class StudentModel {
    public List<StudentEntity> list(){
        List<StudentEntity>list = new ArrayList<StudentEntity>();
        String sql = "select * from student";
        try {
            list = (List<StudentEntity>) DBHelper.executeQuery(sql, null, StudentEntity.class);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public boolean add(StudentEntity entity) {
        String sql = "insert into student(name,gender,age) values(?,?,?)";
        List<Object>params = new ArrayList<Object>();
        params.add(entity.getName());
        params.add(entity.getGender());
        params.add(entity.getAge());
        return DBHelper.excuteUpdate(sql, params);
    }
    public boolean delete(int ID) {
        String sql = "delete from student where ID=?";
        List<Object>params = new ArrayList<Object>();
        params.add(ID);
        return DBHelper.excuteUpdate(sql, params);
    }
}
