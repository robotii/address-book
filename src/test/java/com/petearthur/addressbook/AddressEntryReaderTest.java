package com.petearthur.addressbook;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntryReaderTest {

    @Test
    void entryFromLine() {
        AddressEntry result = AddressEntryReader.entryFromLine("bob, Male, 19/05/78");
        assertEquals("bob", result.getName());
        assertEquals(Gender.Male, result.getGender());
        assertEquals(Instant.parse("1978-05-18T23:00:00.00Z"), result.getBirthday());
    }
}