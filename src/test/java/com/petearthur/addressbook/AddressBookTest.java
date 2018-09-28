package com.petearthur.addressbook;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressBookTest {

    private AddressBook addressBook;
    private AddressEntry pete = new AddressEntry("Pete", Gender.Male, Instant.parse("1980-02-02T00:00:00.00Z"));
    private AddressEntry bob = new AddressEntry("Bob", Gender.Male, Instant.parse("1980-02-01T00:00:00.00Z"));
    private AddressEntry anita = new AddressEntry("Anita", Gender.Female, Instant.parse("1970-03-03T00:00:00.00Z"));

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        addressBook = new AddressBook();
        addressBook.add(pete);
        addressBook.add(bob);
        addressBook.add(anita);
    }

    @org.junit.jupiter.api.Test
    void getOldestMember() {
        AddressEntry oldestMember = addressBook.getOldestMember()
            .orElseThrow(() -> new RuntimeException("There is no oldest member"));
        assertEquals(anita, oldestMember);
    }

    @org.junit.jupiter.api.Test
    void countByGender() {
        assertEquals(1, addressBook.countByGender(Gender.Female));
        assertEquals(2, addressBook.countByGender(Gender.Male));
    }

    @org.junit.jupiter.api.Test
    void getEntryByName() {
        AddressEntry anita = addressBook.getEntryByName("Anita")
            .orElseThrow(() -> new RuntimeException("Nobody called Anita is present"));
        assertEquals("Anita", anita.getName());
    }
}