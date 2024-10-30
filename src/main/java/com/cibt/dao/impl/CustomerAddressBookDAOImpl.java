package com.cibt.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.cibt.dao.CustomerAddressBookDAO;
import com.cibt.db.JdbcTemplate;
import com.cibt.db.RowMapper;
import com.cibt.models.AddressBook;
import com.cibt.models.Customer;

public class CustomerAddressBookDAOImpl implements CustomerAddressBookDAO {
    
    private JdbcTemplate<Customer> template = new JdbcTemplate<>();

    @Override
	public List<Customer> fetchAll() throws Exception {
        String sql = "SELECT c.id, a.id as address_book_id, c.customer_name, a.country, a.city, a.street_address, a.email, a.phone_number FROM tbl_customer c JOIN tbl_address_book a ON (c.address_book_id = a.id)";
        return template.query(sql, new RowMapper<Customer>(){
        
            @Override
            public Customer mapRow(ResultSet rs) throws Exception {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                
                customer.setId(rs.getInt("id"));
                customer.setCustomerName(rs.getString("customer_name"));

                AddressBook addressBook = new AddressBook();
                addressBook.setId(rs.getInt("address_book_id"));
                addressBook.setCity(rs.getString("city"));
                addressBook.setCountry(rs.getString("country"));
                addressBook.setEmail(rs.getString("email"));
                addressBook.setPhoneNumber(rs.getString("phone_number"));
                addressBook.setStreetAddress(rs.getString("street_address"));
                customer.setAddressBook(addressBook);
                
                return customer;
            }
        });
	}

    @Override
    public int insert(Customer customer) throws Exception {
        String sql = "INSERT INTO tbl_customer (customer_name, address_book_id) VALUES (?, ?)";

        return template.update(sql, new Object[] {
            customer.getCustomerName(),
            customer.getAddressBook().getId()
        });
    }

    @Override
    public int update(Customer customer) throws Exception {
        String sql = "UPDATE tbl_customer SET customer_name=? WHERE id=?";

        return template.update(sql, new Object[] {
            customer.getCustomerName(),
            customer.getId()
        });
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "DELETE FROM tbl_customer WHERE id=?";

        return template.update(sql, new Object[] {
            id
        });
    }

    @Override
    public int insert(AddressBook addressBook) throws Exception {
        String sql = "INSERT INTO tbl_address_book (country, city, street_address, email, phone_number) VALUES (?, ?, ? , ? , ?)";

        return template.update(sql, new Object[] {
            addressBook.getCountry(),
            addressBook.getCity(),
            addressBook.getStreetAddress(),
            addressBook.getEmail(),
            addressBook.getPhoneNumber()
        });
    }

    @Override
    public int deleteAddressBook(int id) throws Exception {
        String sql = "DELETE FROM tbl_address_book WHERE id=?";
        
        return template.update(sql, new Object[] {
            id
        });
    }

}