package com.rocketseat.planner.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = ActivityTimeValidator.class)
public @interface ActivityDate {
    String message() default "Date must be between the start and end of the trip";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
