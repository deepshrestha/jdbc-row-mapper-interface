package com.cibt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate<T> {
    public List<T> query(String sql, RowMapper<T> rowMapper) throws Exception {
        List<T> rows = new ArrayList<>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        /* Statement stmt = conn.createStatement();
        stmt.execute(sql);
        ResultSet rs = stmt.getResultSet(); */

        while(rs.next()) {
            rows.add(rowMapper.mapRow(rs));
        }

        rs.close();
        conn.close();
        return rows;
    }

    public void setParameters(PreparedStatement stmt, Object[] params) throws Exception {
        int i = 1;
        for(Object param : params) {
            stmt.setObject(i, param);
            i++;
        }
    }

    public int update(String sql, Object[] params) throws Exception {
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        setParameters(stmt, params);
        
        int result = stmt.executeUpdate();
        conn.close();
        return result;
    }
}