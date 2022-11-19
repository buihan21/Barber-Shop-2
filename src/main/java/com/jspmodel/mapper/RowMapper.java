package com.jspmodel.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T mapRow(ResultSet res);
}
