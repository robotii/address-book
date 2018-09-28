package com.petearthur.addressbook;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressEntryTest {

    @Test
    void daysOlderThan() {
        AddressEntry pete = new AddressEntry("Pete", Gender.Male, LocalDate.parse("1980-02-03"));
        AddressEntry bob = new AddressEntry("Bob", Gender.Male, LocalDate.parse("1980-02-01"));

        assertEquals(2, bob.daysOlderThan(pete));
        assertEquals(-2, pete.daysOlderThan(bob));
    }
}
