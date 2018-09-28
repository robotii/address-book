package com.petearthur.addressbook;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

    }

    private static Optional<AddressEntry> getOldestMember(AddressBook addressBook) {
        return addressBook
            .getEntries()
            .stream()
            .min(Comparator.comparing(AddressEntry::getBirthday));
    }

    private static long countMales(AddressBook addressBook) {
        return addressBook
            .getEntries()
            .stream()
            .filter(e -> e.getGender().equalsIgnoreCase("Male"))
            .count();
    }

    private static long daysOlder(AddressEntry first, AddressEntry second) {
        return ChronoUnit.DAYS.between(second.getBirthday(), first.getBirthday());
    }
}
