package com.cibt.dao;

import java.util.List;

import com.cibt.models.AddressBook;
import com.cibt.models.Customer;;

public interface CustomerAddressBookDAO {
    int insert(Customer customer) throws Exception;
    int update(Customer customer) throws Exception;
    int delete(int id) throws Exception;
    List<Customer> fetchAll() throws Exception;
    int insert(AddressBook addressBook) throws Exception;
    int deleteAddressBook(int id) throws Exception;
}