package com.qaschool.validators;

public class PostValidator {

    public static final String POST_VALID = "POST_VALID";
    public static final String ERROR_EMPTY = "ERROR_EMPTY";
    public static final String ERROR_TOO_LONG = "ERROR_TOO_LONG";
    public static final String ERROR_FORBIDDEN = "ERROR_FORBIDDEN";

    public String getPostStatus(String postBody) {

        //Dacă postBody este null sau postBody.isEmpty()
        if (postBody == null || postBody.isEmpty()) {
            return "ERROR_EMPTY";
        }

        // Dacă postBody.length() > 250
        if (postBody.length() > 250) {
            return "ERROR_TOO_LONG";
        }

        // Dacă postBody conține cuvântul "politică"
        if (postBody.contains("politică")) {
            return "ERROR_FORBIDDEN";
        }

        // În toate celelalte cazuri
        return "POST_VALID";
    }
}