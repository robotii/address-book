package com.petearthur.addressbook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AddressEntryReader {
    public static AddressEntry entryFromLine(String line) {
        String[] values = Arrays.stream(line.split(","))
            .map(String::trim)
            .toArray(String[]::new);

        if(values.length != 3) {
            throw new RuntimeException("Expected Entry length of 3, got " + values.length);
        }
        return new AddressEntry(values[0], Gender.valueOf(values[1]), convertToInstant(values[2]));
    }

    private static LocalDate convertToInstant(String date) {
        String[] values = date.split("/");
        if(values.length != 3) {
            throw new RuntimeException("Incorrectly formatted date");
        }

        // Add on the century (assuming that all dates are 20th Century)
        values[2] = "19" + values[2];
        date = Arrays.stream(values).collect(Collectors.joining("/"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date,formatter);
    }
}
