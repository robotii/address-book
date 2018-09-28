package com.petearthur.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressBookTest {

    private AddressBook addressBook;
    private final AddressEntry pete = new AddressEntry("Pete", Gender.Male, LocalDate.parse("1980-02-02"));
    private final AddressEntry bob = new AddressEntry("Bob", Gender.Male, LocalDate.parse("1980-02-01"));
    private final AddressEntry anita = new AddressEntry("Anita", Gender.Female, LocalDate.parse("1970-03-03"));

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
        addressBook.add(pete);
        addressBook.add(bob);
        addressBook.add(anita);
    }

    @Test
    void getOldestMember() {
        AddressEntry oldestMember = addressBook.getOldestMember()
            .orElseThrow(() -> new RuntimeException("There is no oldest member"));
        assertEquals(anita, oldestMember);
    }

    @Test
    void countByGender() {
        assertEquals(1, addressBook.countByGender(Gender.Female));
        assertEquals(2, addressBook.countByGender(Gender.Male));
    }

    @Test
    void getEntryByName() {
        AddressEntry anita = addressBook.getEntryByName("Anita")
            .orElseThrow(() -> new RuntimeException("Nobody called Anita is present"));
        assertEquals("Anita", anita.getName());
    }
}