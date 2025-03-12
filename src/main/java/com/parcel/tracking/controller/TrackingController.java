package com.parcel.tracking.controller;

import com.parcel.tracking.request.TrackingRequest;
import com.parcel.tracking.response.TrackingResponse;
import com.parcel.tracking.service.TrackingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

@RestController
class TrackingController {

    @Autowired
    private TrackingService trackingService;

    private static final ConcurrentHashMap<String, Boolean> trackingNumbers = new ConcurrentHashMap<>();

    @GetMapping("/next-tracking-number")
    public TrackingResponse getNextTrackingNumber(@Valid @RequestBody TrackingRequest request) {
        String trackingNumber;
        do {
            trackingNumber = trackingService.generateTrackingNumber(request);
        } while (trackingNumbers.putIfAbsent(trackingNumber, true) != null);
        return new TrackingResponse(trackingNumber, DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
    }

}
