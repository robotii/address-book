package com.petearthur.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AddressBook {
    private final List<AddressEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public AddressBook(List<AddressEntry> entries) {
        this.entries = entries;
    }

    public void add(AddressEntry entry) {
        entries.add(entry);
    }

    public void remove(AddressEntry entry) {
        entries.remove(entry);
    }

    public Optional<AddressEntry> getOldestMember() {
        return entries
            .stream()
            .min(Comparator.comparing(AddressEntry::getBirthday));
    }

    public long countByGender(Gender gender) {
        return getByGender(gender).size();
    }

    private List<AddressEntry> getByGender(Gender gender) {
        return entries
            .stream()
            .filter(e -> e.getGender().equals(gender))
            .collect(Collectors.toList());
    }

    public Optional<AddressEntry> getEntryByName(String name) {
        return entries
            .stream()
            .filter(e -> e.getName().equals(name))
            .findFirst();
    }
}
