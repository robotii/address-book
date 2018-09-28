package com.petearthur.addressbook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public class AddressEntryReader {
    public static AddressEntry entryFromLine(String line) {
        try {
            String[] values = Arrays.stream(line.split(",")).map(String::trim).toArray(String[]::new);

            if(values.length != 3) {
                throw new RuntimeException("Entry is invalid");
            }

            return new AddressEntry(values[0], values[1], convertToInstant(values[2]));
        } catch(ParseException e) {
            throw new RuntimeException("Unable to parse date", e);
        }
    }

    private static Instant convertToInstant(String date) throws ParseException {
        String[] values = date.split("/");
        if(values.length != 3) {
            throw new RuntimeException("Incorrectly formatted date");
        }
        values[2] = "19" + values[2];
        date = Arrays.stream(values).collect(Collectors.joining("/"));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date parsedDate = formatter.parse(date);
        return parsedDate.toInstant();
    }
}
