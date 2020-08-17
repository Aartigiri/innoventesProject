package com.example.innoventesProject.dto;


public enum ResponseConstants {


    BAD_REQUEST(200, "BAD_REQUEST"),
    BAD_CREDENTIALS(201, "BAD_CREDENTIALS"),
    REFRESH_TOKEN_EXPIRED(202, "REFRESH_TOKEN_EXPIRED"),
    ACCESS_TOKEN_EXPIRED(203, "ACCESS_TOKEN_EXPIRED"),
    INVALID_ACCESS_TOKEN(204, "INVALID_ACCESS_TOKEN"),
    UNAUTHORIZED_REQUEST(205, "UNAUTHORIZED_REQUEST"),
    INVALID_REFRESH_TOKEN(206, "INVALID_REFRESH_TOKEN");

    private final int code;

    private final String desc;

    ResponseConstants(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

}