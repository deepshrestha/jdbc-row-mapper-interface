package com.cibt.dao;

import java.util.List;

import com.cibt.models.ExpenseHeading;

public interface ExpenseHeadingDAO {
    int insert(ExpenseHeading heading) throws Exception;
    int update(ExpenseHeading heading) throws Exception;
    int delete(int id) throws Exception;
    List<ExpenseHeading> fetchAll() throws Exception;
}