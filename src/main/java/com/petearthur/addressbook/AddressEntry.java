package com.petearthur.addressbook;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class AddressEntry {

    private final String name;
    private final Gender gender;
    private final Instant birthday;

    public AddressEntry(String name, Gender gender, Instant birthday) {

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

    public Instant getBirthday() {
        return birthday;
    }

    public long daysOlderThan(AddressEntry other) {
        return ChronoUnit.DAYS.between(birthday, other.getBirthday());
    }

    @Override
    public String toString() {
        return "AddressEntry { name: " + name
            + ", gender: " + gender.name()
            + ", birthday: " + birthday.atZone(ZoneId.of("Europe/London")) + "}";
    }
}
