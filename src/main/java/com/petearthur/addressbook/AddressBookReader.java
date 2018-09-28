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


    public AddressBook getAddressBook() {
        try {
            if(file.exists() && !file.isDirectory()) {
                Scanner s = new Scanner(file);
                ArrayList<String> list = new ArrayList<>();
                while(s.hasNextLine()) {
                    list.add(s.nextLine());
                }
                s.close();

                return new AddressBook(list
                    .stream()
                    .map(AddressEntryReader::entryFromLine)
                    .collect(Collectors.toList()));
            } else {
                throw new RuntimeException("File does not exist or is directory");
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException("Not able to read file " + file.getAbsolutePath());
        }
    }
}
