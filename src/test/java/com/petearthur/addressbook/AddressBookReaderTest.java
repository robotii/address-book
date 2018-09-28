package com.petearthur.addressbook;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookReaderTest {

    @Test
    void toAddressBook() {
        AddressBookReader reader = new AddressBookReader(new File("data/AddressBook"));
        AddressBook addressBook = reader.toAddressBook();

        assertNotNull(addressBook);

        reader = new AddressBookReader(new File("not-exists"));

        try {
            reader.toAddressBook();
            fail("This should have thrown an exception");
        } catch(Exception ignored) {
        }

        // Now try a directory
        reader = new AddressBookReader(new File("src"));

        try {
            reader.toAddressBook();
            fail("This should have thrown an exception");
        } catch(Exception ignored) {
        }
    }
}