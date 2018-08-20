package com.wang.db;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4 0004.
 */
public class DBHelper {
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1:3306/experimentdb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String USER="root";
    private static final String PASSWORD="root";
    private static Connection conn;
    public static Connection getConnection(){
        Connection conn=null;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn=DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean excuteUpdate(String sql,List<Object> params){
        int res=0;
        Connection conn=null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;

        try {
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);

            if(params!=null){
                for(int i=0;i<params.size();i++){
                    pstmt.setObject(i+1, params.get(i));
                }
            }

            res=pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(rs, pstmt, conn);
        }

        return res>0?true:false;
    }

    public static <T> List<T> executeQuery(String sql,List<Object> params,Class<T> cls) throws Exception{
        Connection conn=null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        List<T> data=new ArrayList<T>();

        try {
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);

            if(params!=null){
                for(int i=0;i<params.size();i++){
                    pstmt.setObject(i+1, params.get(i));
                }
            }

            rs=pstmt.executeQuery();

            ResultSetMetaData rsd=rs.getMetaData();
            while(rs.next()){
                T m=cls.getDeclaredConstructor().newInstance();

                for(int i=0;i<rsd.getColumnCount();i++){
                    String col_name=rsd.getColumnName(i+1);
                    Object value=rs.getObject(col_name);
                    Field field=cls.getDeclaredField(col_name);
                    field.setAccessible(true);
                    field.set(m, value);
                }
                data.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(rs, pstmt, conn);
        }
        return data;
    }
}
