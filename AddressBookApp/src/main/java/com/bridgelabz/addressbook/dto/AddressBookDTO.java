package com.bridgelabz.addressbook.dto;


public class AddressBookDTO {
    private String name;
    private String phone;

    public AddressBookDTO() {
    }

    public AddressBookDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}