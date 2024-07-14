package com.rocketseat.planner.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@Service
public class TripService {
    @Autowired
    private TripRepository repository;

    public Trip createTrip(TripRequestPayload tripRequestPayload){
        Trip newTrip = new Trip(tripRequestPayload);
        this.repository.save(newTrip);
        return newTrip;
    }

    public Optional<Trip> getTrip(UUID id){
        Optional<Trip> tripOptional = this.repository.findById(id);
//        if (tripOptional.isPresent()) {
//            return tripOptional.get();
//        } else {
//            throw new RuntimeException();
//        }
        return tripOptional;
    }

    public Trip updateTrip(UUID id,TripRequestPayload payload){
        Optional<Trip> trip = this.repository.findById(id);

        if(trip.isPresent()){
            Trip rawTrip = trip.get();
            rawTrip.setEndsAt(LocalDateTime.parse(payload.ends_at(), DateTimeFormatter.ISO_DATE_TIME));
            rawTrip.setStartsAt(LocalDateTime.parse(payload.starts_at(), DateTimeFormatter.ISO_DATE_TIME));
            rawTrip.setDestination(payload.destination());

            this.repository.save(rawTrip);

            return rawTrip;
        } else{
            throw new RuntimeException();
        }
    }
    public Trip confirmTrip(UUID id){
        Optional<Trip> trip = this.repository.findById(id);

        if(trip.isPresent()){
            Trip rawTrip = trip.get();
            rawTrip.setConfirmed(true);

            this.repository.save(rawTrip);

            return rawTrip;
        }else {
            throw new RuntimeException();
        }
    }
}
