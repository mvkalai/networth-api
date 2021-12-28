package com.networth.api.enums;

public enum EStatusCode {

    RECORD_ADDED_SUCCESSFULLY("Record added successfully"),
    RECORD_UPDATED_SUCCESSFULLY("Record updated successfully"),
    RECORD_CLONED_SUCCESSFULLY("Record cloned sucessfully"),
    RECORD_DELETED_SUCCESSFULLY("Record deleted sucessfully"),
    RECORDS_DELETED_SUCCESSFULLY("Records deleted sucessfully"),
    SUCCESS("Success"),
    NOT_STARTED("Report not started"),
    COMPLETED("Report Completed"),
    IN_PROGRESS("Report in progress"),

    // FAILURE
    ERROR_ON_ADD("Exception occured while adding record: "),
    ERROR_ON_UPDATE("Exception occured while updating: "),
    ERROR_ON_DELETE("Exception occurred while deleting"),
    INTERNAL_SERVER_ERROR("UNABLE_TO_PROCESS_REQUEST"),
    RECORD_NOT_FOUND("Exception occured while fetching data"),
    ERROR_ON_GET("Exception occured while getting data"),
    ERROR_ON_LOGIN("Your username and password is invalid");

    String message;

    private EStatusCode(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

