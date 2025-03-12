package com.parcel.tracking.validator;

import com.parcel.tracking.validator.impl.RFC3339Validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RFC3339Validator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface RFC3339Timestamp {
    String message() default "Invalid RFC 3339 timestamp format. Expected format: yyyy-MM-dd'T'HH:mm:ssXXX";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
