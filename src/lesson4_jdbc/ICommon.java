/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson4_jdbc;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mam
 */
public abstract class ICommon <T> {
    Statement statement;
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;
    ResultSet resultSet;
    
    public abstract T[] selectAll();
    public abstract T[] selectByName(String name);
    public abstract T selectById(int id);
    
    public abstract int insert(T object);
    public abstract int update(T object);
    public abstract int delete(int id);
    
}
