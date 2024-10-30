package com.cibt;

import com.cibt.dao.CustomerAddressBookDAO;
import com.cibt.dao.impl.CustomerAddressBookDAOImpl;
import com.cibt.models.AddressBook;
import com.cibt.models.Customer;

/* import com.cibt.models.ExpenseHeading;
import com.cibt.dao.ExpenseHeadingDAO;
import com.cibt.dao.impl.ExpenseHeadingDAOImpl; */

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        try {
            /* ExpenseHeadingDAO headingDAO = new ExpenseHeadingDAOImpl();

            // int result = headingDAO.insert(new ExpenseHeading(10, "test test"));
            // int result = headingDAO.delete(11);

            for(ExpenseHeading heading : headingDAO.fetchAll()) {
                System.out.println(heading.getHeadingTitle());
            } */

            CustomerAddressBookDAO customerAddressBookDAO = new CustomerAddressBookDAOImpl();

            // int result = customerAddressBookDAO.insert(new AddressBook(4, "Australia", "Kograh", "456 main street", "sid@gmail.com", "1323122"));
            // int result = customerAddressBookDAO.insert(new Customer(1, "Drabin Shrestha", 3));
            // int result = customerAddressBookDAO.update(new Customer(2, "Deep Shrestha", null));
            
            // int result = customerAddressBookDAO.deleteAddressBook(4);
            // System.out.println(result); 

            for(Customer customer : customerAddressBookDAO.fetchAll()) {
                // System.out.printf("%s %s", customer.getCustomerName(), customer.getAddressBook().getCity());
                System.out.println(customer.toJson());
            }

        } catch(Exception e) {
            e.getMessage();
        }
    }
}
