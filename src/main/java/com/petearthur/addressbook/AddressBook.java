package com.petearthur.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AddressBook {
    private final List<AddressEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public void add(AddressEntry entry) {
        entries.add(entry);
    }

    public void remove(AddressEntry entry) {
        entries.remove(entry);
    }

    public AddressBook(List<AddressEntry> entries) {
        this.entries = entries;
    }

    public Optional<AddressEntry> getOldestMember() {
        return entries
            .stream()
            .min(Comparator.comparing(AddressEntry::getBirthday));
    }

    public long countByGender(String gender) {
        return entries
            .stream()
            .filter(e -> e.getGender().equalsIgnoreCase(gender))
            .count();
    }

    public Optional<AddressEntry> getEntryByName(String name) {
        return entries.stream().filter(e -> e.getName().equals(name)).findFirst();
    }
}
