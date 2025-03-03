package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {
    private List<AddressBookEntry> contacts = new ArrayList<>();

    public List<AddressBookDTO> getAllContacts() {
        return contacts.stream()
                .map(contact -> new AddressBookDTO(contact.getName(), contact.getPhone()))
                .collect(Collectors.toList());
    }

    public AddressBookDTO getContactById(int id) {
        if (id >= 0 && id < contacts.size()) {
            AddressBookEntry contact = contacts.get(id);
            return new AddressBookDTO(contact.getName(), contact.getPhone());
        }
        return null;
    }

    public void createContact(AddressBookDTO contactDTO) {
        contacts.add(new AddressBookEntry(contactDTO.getName(), contactDTO.getPhone()));
    }

    public boolean updateContact(int id, AddressBookDTO updatedContactDTO) {
        if (id >= 0 && id < contacts.size()) {
            AddressBookEntry contact = contacts.get(id);
            contact.setName(updatedContactDTO.getName());
            contact.setPhone(updatedContactDTO.getPhone());
            return true;
        }
        return false;
    }

    public boolean deleteContact(int id) {
        if (id >= 0 && id < contacts.size()) {
            contacts.remove(id);
            return true;
        }
        return false;
    }
}