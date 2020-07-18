package com.chernykh.sprint11.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecordParser {

    private RecordParser() {
    }

    private static String parseByRegex(String recordString, String regex) {
        String resultString = null;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(recordString);
        if (m.find())
        {
            resultString = m.group(0);
        }
        return resultString;
    }

    public static String getFirstName(String recordString) {
        return parseByRegex(recordString, "(?<=First name: ).*(?=, Last name:)");
    }

    public static String getLastName(String recordString) {
        return parseByRegex(recordString, "(?<=Last name: ).*(?=, Address:)");
    }

    public static String getAddress(String recordString) {
        return parseByRegex(recordString, "(?<=Address: ).*");
    }
}
