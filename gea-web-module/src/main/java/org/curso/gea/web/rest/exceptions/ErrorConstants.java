package org.curso.gea.web.rest.exceptions;

import java.net.URI;

public final class ErrorConstants {
    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    public static final String ERR_VALIDATION = "error.validation";
    public static final String PROBLEM_BASE_URL = "http://localhost:8081/problem";
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/constraint-violation");

    public static final String ID_NULL_BAD_REQUEST = "idnull";
    public static final String ID_INVALID_BAD_REQUEST = "idinvalid";
    public static final String ID_EXISTS_BAD_REQUEST = "idexists";

    private ErrorConstants() {}
}
