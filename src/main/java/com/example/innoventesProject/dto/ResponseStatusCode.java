package com.example.innoventesProject.dto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ResponseStatusCode {

	SUCCESS(20000, "SUCCESS"),
	FAIL(20001, "FAIL"),

	UNKNOWN_ERROR_OCCURRED(20002, "UNKNOWN_ERROR_OCCURRED"),

	INVALID_REQUEST_PARAMETER(20003, "INVALID_REQUEST_PARAMETER"),

	INTERNAL_SERVER_ERROR(10005, "INTERNAL_SERVER_ERROR"),


	//Auth Service Status code
	USER_EXISTS_FOR_AUTH(60000,"USER_EXISTS_FOR_AUTH"),
	USER_DOES_NOT_EXISTS_FOR_AUTH(60001,"USER_DOES_NOT_EXISTS_FOR_AUTH"),
	USER_PASSWORD_UPDATED(60002,"USER_PASSWORD_UPDATED"),
	NO_MATCHING_OTP_RECORDS_FOUND(89899, "NO_MATCHING_OTP_RECORDS_FOUND"),
	OLD_PASSWORD_MATCHES_WITH_NEW_PASSWORD(60003,"OLD_PASSWORD_MATCHES_WITH_NEW_PASSWORD");

	private final Integer code;
	private final String reasonPhrase;

	private static final Map<Integer, ResponseStatusCode> RESPONSE_STATUS_CODE_MAP = Arrays
			.stream(com.example.innoventesProject.dto.ResponseStatusCode.values())
			.collect(Collectors.toMap(com.example.innoventesProject.dto.ResponseStatusCode::getCode, Function.identity()));

	private ResponseStatusCode(Integer code, String reasonPhrase) {
		this.code = code;
		this.reasonPhrase = reasonPhrase;
	}

	public static com.example.innoventesProject.dto.ResponseStatusCode valueOf(int value) {
		if (RESPONSE_STATUS_CODE_MAP.containsKey(value)) {
			return RESPONSE_STATUS_CODE_MAP.get(value);
		}
		throw new IllegalArgumentException("No matching constant for [" + value + "]");
	}


	public Integer getCode() {
		return code;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

}
