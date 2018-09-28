package com.petearthur.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {
    private final List<AddressEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public AddressBook(List<AddressEntry> entries) {
        this.entries = entries;
    }

    public List<AddressEntry> getEntries() {
        return entries;
    }

    public Optional<AddressEntry> getEntryByName(String name) {
        return entries.stream().filter(e -> e.getName().equals(name)).findFirst();
    }
}
