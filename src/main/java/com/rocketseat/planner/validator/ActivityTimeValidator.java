package com.rocketseat.planner.validator;

import com.rocketseat.planner.activity.Activity;
import com.rocketseat.planner.trip.Trip;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ActivityTimeValidator implements ConstraintValidator<ActivityDate, Activity> {
    @Override
    public boolean isValid(Activity activity, ConstraintValidatorContext context) {
        Trip trip = activity.getTrip();
        if (activity.getOccursAt() != null) {
            return activity.getOccursAt().isAfter(trip.getStartsAt()) && activity.getOccursAt().isBefore(trip.getEndsAt());
        }
        return true;
    }
}
