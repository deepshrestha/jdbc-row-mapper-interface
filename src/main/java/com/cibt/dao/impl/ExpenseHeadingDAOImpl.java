package com.cibt.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.cibt.dao.ExpenseHeadingDAO;
import com.cibt.db.JdbcTemplate;
import com.cibt.db.RowMapper;
import com.cibt.models.ExpenseHeading;

public class ExpenseHeadingDAOImpl implements ExpenseHeadingDAO {
    
    private JdbcTemplate<ExpenseHeading> template = new JdbcTemplate<>();

    @Override
    public int insert(ExpenseHeading heading) throws Exception {
        String sql = "INSERT INTO tbl_expense_header(heading_title) VALUES(?)";
        return template.update(sql, new Object[] {
            heading.getHeadingTitle()
        });
    }

    @Override
    public int update(ExpenseHeading heading) throws Exception {
        String sql = "UPDATE tbl_expense_header SET heading_title = ? WHERE id = ?";

        return template.update(sql, new Object[] {
            heading.getHeadingTitle(), heading.getId()
        });
    }

    @Override
	public List<ExpenseHeading> fetchAll() throws Exception {
        String sql = "SELECT * FROM tbl_expense_header";
        return template.query(sql, new RowMapper<ExpenseHeading>(){

            @Override
            public ExpenseHeading mapRow(ResultSet rs) throws Exception {
                ExpenseHeading heading = new ExpenseHeading();
                heading.setId(rs.getInt("id"));
                heading.setHeadingTitle(rs.getString("heading_title"));
                return heading;
            }
        });
	}

    @Override
    public int delete(int id) throws Exception {
        String sql = "DELETE FROM tbl_expense_header WHERE id=?";

        return template.update(sql, new Object[] {
            id
        });
    }

}