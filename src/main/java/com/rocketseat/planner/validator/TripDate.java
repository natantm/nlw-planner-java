package com.rocketseat.planner.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Constraint(validatedBy = TripDateTimeValidator.class)
public @interface TripDate {
    String message() default "Invalid trip date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
