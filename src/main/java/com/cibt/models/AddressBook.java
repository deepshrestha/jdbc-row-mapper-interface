package com.cibt.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressBook {
    
    private int id;
    private String country;
    private String city;
    private String streetAddress;
    private String email;
    private String phoneNumber;

    public AddressBook() {
    }

    public AddressBook(int id, String country, String city, String streetAddress, String email, String phoneNumber) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.streetAddress = streetAddress;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String toJson() {
        return "{\"id\": " + id + ", \"street_address\": \"" + streetAddress + "\", \"city\": \"" +city + "\", \"phone_number\":  \"" + phoneNumber +"}";
    }
}