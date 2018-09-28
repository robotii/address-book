package com.petearthur.addressbook;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressEntryReaderTest {

    @Test
    void entryFromLine() {
        AddressEntry result = AddressEntryReader.entryFromLine("bob, Male, 19/05/78");
        assertEquals("bob", result.getName());
        assertEquals(Gender.Male, result.getGender());
        assertEquals(LocalDate.parse("1978-05-19"), result.getBirthday());
    }
}