package com.school.kotlin.utils.security;

import com.school.kotlin.utils.Constants;

/**
 * Created by android on 22/12/17.
 */

public class ApiFailureTypes {
    public String getFailureMessage(Throwable error) {

        String message;
        if (error == null) {
            message = Constants.FAILURE_TIME_OUT_ERROR;

        } else if (error.getLocalizedMessage() == null) {
            message = Constants.FAILURE_TIME_OUT_ERROR;

        } else if (error.getLocalizedMessage().toUpperCase().contains("ETIMEDOUT")) {
            message = Constants.FAILURE_INTERNET_CONNECTION;

        } else if (error.getLocalizedMessage().toUpperCase().contains("ECONNRESET")) {
            message = Constants.FAILURE_INTERNET_CONNECTION;
        } else if (error.getLocalizedMessage().toUpperCase().contains("FAILED TO CONNECT TO")) {
            message = Constants.FAILURE_SERVER_NOT_RESPONDING;
        } else if (error.getLocalizedMessage().isEmpty()) {
            message = Constants.FAILURE_SERVER_NOT_RESPONDING;
        } else {
                           message = Constants.FAILURE_SOMETHING_WENT_WRONG;

        }

        return message;

    }
}