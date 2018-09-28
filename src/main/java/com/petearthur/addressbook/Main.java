package com.petearthur.addressbook;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        AddressBookReader reader = new AddressBookReader(new File("data/AddressBook"));
        AddressBook addressBook = reader.toAddressBook();

        // Get the number of males in the addressbook
        System.out.println("Number of Males present in AddressBook = "
            + addressBook.countByGender(Gender.Male));

        // Get the oldest member
        System.out.println("Locating oldest member...");
        AddressEntry oldestMember = addressBook.getOldestMember()
            .orElseThrow(() -> new RuntimeException("Unable to locate oldest member"));
        System.out.println(oldestMember.toString());

        // Calculate how many days older Bill is comparted to Paul
        System.out.println("How many days older is Bill than Paul?");

        AddressEntry bill = addressBook
            .getEntryByName("Bill McKnight")
            .orElseThrow(() -> new RuntimeException("Unable to locate Bill in the addressbook"));

        AddressEntry paul = addressBook
            .getEntryByName("Paul Robinson")
            .orElseThrow(() -> new RuntimeException("Unable to locate Paul in the addressbook"));

        System.out.println(bill.daysOlderThan(paul));
    }
}
