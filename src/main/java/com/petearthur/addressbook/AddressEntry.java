package com.petearthur.addressbook;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AddressEntry {

    private final String name;
    private final Gender gender;
    private final LocalDate birthday;

    public AddressEntry(String name, Gender gender, LocalDate birthday) {

        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public long daysOlderThan(AddressEntry other) {
        return ChronoUnit.DAYS.between(birthday, other.getBirthday());
    }

    @Override
    public String toString() {
        return "AddressEntry { name: " + name
            + ", gender: " + gender.name()
            + ", birthday: " + birthday + "}";
    }
}
