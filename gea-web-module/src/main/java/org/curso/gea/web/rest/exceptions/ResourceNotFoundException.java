package org.curso.gea.web.rest.exceptions;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.io.Serial;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ResourceNotFoundException extends AbstractThrowableProblem {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final String RESOURCE_NOT_FOUNT_EX_KEY = "resource.not.found.ex";

    private final String entityName;
    private final String errorKey;

    public ResourceNotFoundException(String defaultMessage, String entityName) {
        this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, RESOURCE_NOT_FOUNT_EX_KEY);
    }

    public ResourceNotFoundException(URI type, String defaultMessage, String entityName, String errorKey) {
        super(type, defaultMessage, Status.NOT_FOUND, null, null, null, getAlertParameters(entityName, errorKey));
        this.entityName = entityName;
        this.errorKey = errorKey;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }

    private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message", "error." + errorKey);
        parameters.put("params", entityName);
        return parameters;
    }
}
