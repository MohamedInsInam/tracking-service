package com.parcel.tracking.service;

import com.parcel.tracking.request.TrackingRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicLong;
import java.security.MessageDigest;

@Service
public class TrackingService {

    private static final AtomicLong counter = new AtomicLong();

    public String generateTrackingNumber(TrackingRequest request) {

        // Unique counter in base 36 (alphanumeric)
        String uniquePart = Long.toString(counter.incrementAndGet(), 36).toUpperCase();

        // Construct the tracking number
        String trackingNumber = (request.getOrigin_country_id() + request.getDestination_country_id() + request.getCustomer_id() + formatWeight(request.getWeight()) + shortHash(request.getCreated_at()) + uniquePart)
                .replaceAll("[^A-Z0-9]", ""); // Ensure only alphanumeric characters

        // Return full tracking number or trim to 16 characters if needed
        return trackingNumber.length() > 16 ? trackingNumber.substring(0, 16) : trackingNumber;
    }

    private String formatWeight(BigDecimal weight) {
        return (weight != null) ? String.format("%02d", weight.intValue() % 100) : "00";
    }

    private String shortHash(String input) {
        if (input == null || input.isEmpty()) {
            return "XX";
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return String.format("%02X", hash[0]); // Use the first byte of SHA-256 hash
        } catch (NoSuchAlgorithmException e) {
            return "XX";
        }
    }
}