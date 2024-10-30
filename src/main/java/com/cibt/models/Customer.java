package com.cibt.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    
    private int id;
    private String customerName;
    private AddressBook addressBook;

    public Customer() {
    }

    public Customer(int id, String customerName, AddressBook addressBook) {
        this.id = id;
        this.customerName = customerName;
        this.addressBook = addressBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook address) {
        this.addressBook = address;
    }

    public String toJson() {
        return "{\"id\":"+id+",\"customer_name\":\""+customerName+"\",\"address\":" + addressBook.toJson()+"}";
    }

}