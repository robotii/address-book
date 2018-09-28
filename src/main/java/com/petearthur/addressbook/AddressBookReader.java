package com.petearthur.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookReader {

    private final File file;

    public AddressBookReader(File file) {
        this.file = file;
    }

    public AddressBook toAddressBook() {
        try {
            if(file.exists() && !file.isDirectory()) {
                ArrayList<String> list = new ArrayList<>();
                try(Scanner s = new Scanner(file)) {
                    while(s.hasNextLine()) {
                        list.add(s.nextLine());
                    }
                }

                return new AddressBook(
                    list
                    .stream()
                    .map(AddressEntryReader::entryFromLine)
                    .collect(Collectors.toList()));

            } else {
                throw new RuntimeException("File does not exist or is directory: " + file.getAbsolutePath());
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException("Unable to read file: " + file.getAbsolutePath());
        }
    }
}
