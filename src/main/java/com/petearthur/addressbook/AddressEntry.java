package com.petearthur.addressbook;

import java.time.Instant;

public class AddressEntry {

    private final String name;
    private final String gender;
    private final Instant birthday;

    public AddressEntry(String name, String gender, Instant birthday) {

        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Instant getBirthday() {
        return birthday;
    }
}
