package com.rocketseat.planner.validator;

import com.rocketseat.planner.trip.Trip;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class TripDateTimeValidator implements ConstraintValidator<TripDate, Trip> {
    @Override
    public boolean isValid(Trip trip, ConstraintValidatorContext context) {
        if (trip.getStartsAt() != null && trip.getEndsAt() != null) {
            return trip.getEndsAt().isAfter(trip.getStartsAt());
        }
        return true; // Allow null values for now (optional)
    }
}
