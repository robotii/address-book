package com.petearthur.addressbook;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {

    @Test
    void daysOlderThan() {
        AddressEntry pete = new AddressEntry("Pete", Gender.Male, Instant.parse("1980-02-03T00:00:00.00Z"));
        AddressEntry bob = new AddressEntry("Bob", Gender.Male, Instant.parse("1980-02-01T10:00:00.00Z"));

        assertEquals(2, bob.daysOlderThan(pete));
        assertEquals(-2, pete.daysOlderThan(bob));
    }
}
