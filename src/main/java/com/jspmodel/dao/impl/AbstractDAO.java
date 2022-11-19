package com.jspmodel.dao.impl;

import com.jspmodel.dao.GenericDAO;
import com.jspmodel.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AbstractDAO<T> implements GenericDAO<T> {
    protected Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Registered");
            return DriverManager.getConnection("jdbc:sqlserver://MSI\\MSSQLSERVER;databaseName=barberShop;encrypt=true;" +
                    "trustServerCertificate=true;","sa", "sa");
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    private void setParameter(PreparedStatement statement, Object...parameters){
        try{
            for (int i = 0; i < parameters.length; i++){
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof  String){
                    statement.setString(index, (String)parameter);
                } else if (parameter instanceof Integer){
                    statement.setInt(index, (Integer)parameter);
                } else if (parameter instanceof Time){
                    statement.setTime(index, (Time) parameter);
                } else if (parameter instanceof Date){
                    statement.setDate(index, (Date) parameter);
                } else if (parameter instanceof Float){
                    statement.setFloat(index, (Float) parameter);
                } else if (parameter instanceof Boolean){
                    statement.setBoolean(index, (Boolean)parameter);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public <T> List<T> query(String sql, RowMapper<T> row, Object... parameters) {

        List<T> results = new ArrayList<>();
        PreparedStatement statement = null;
        Connection connection = getConnection();
        ResultSet resultSet = null;

        if (connection != null){
            try{
                statement = connection.prepareStatement(sql);
                setParameter(statement, parameters);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    results.add(row.mapRow(resultSet));
                }
                return results;
            } catch (SQLException e){
                return null;
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e){
                    return  null;
                }
            }
        }
        return  null;
    }

    @Override
    public Integer insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            System.out.println("DONE");
            resultSet = statement.getGeneratedKeys();
            System.out.println("DONE");
            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            try{
                connection.rollback();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
        } finally {
            try{
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
        } finally{
            try{
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

}
