package com.jspmodel.dao;

import com.jspmodel.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List query(String sql, RowMapper<T> rowMapper, Object... parameters);
    Integer insert(String sql, Object... parameters);
    void update(String sql, Object... parameters);

}
