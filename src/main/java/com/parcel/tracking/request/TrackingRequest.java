package com.parcel.tracking.request;


import com.parcel.tracking.validator.RFC3339Timestamp;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;


public class TrackingRequest {

    @NotBlank(message = "Origin country ID cannot be blank")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Origin country ID must be in two uppercase letters")
    private String origin_country_id;

    @NotBlank(message = "Destination country ID cannot be blank")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Destination country ID must be in two uppercase letters")
    private String destination_country_id;

    @NotNull(message = "Weight cannot be null")
    @Digits(integer = 10, fraction = 3, message = "Weight must have up to 10 integer digits and 3 decimal places")
    private BigDecimal weight;

    @NotBlank(message = "Customer ID cannot be blank")
    private String customer_id;

    @NotBlank(message = "Customer name cannot be blank")
    private String customer_name;

    @NotBlank(message = "Created_at cannot be blank")
    @RFC3339Timestamp
    private String created_at;

    @NotBlank(message = "Customer slug cannot be blank")
    @Pattern(regexp = "^[a-z]+(?:-[a-z]+)*$", message = "Invalid slug format. Only lowercase letters and hyphens allowed (e.g., 'customer-name').")
    private String customer_slug;

    public String getOrigin_country_id() {
        return origin_country_id;
    }

    public void setOrigin_country_id(String origin_country_id) {
        this.origin_country_id = origin_country_id;
    }

    public String getDestination_country_id() {
        return destination_country_id;
    }

    public void setDestination_country_id(String destination_country_id) {
        this.destination_country_id = destination_country_id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCustomer_slug() {
        return customer_slug;
    }

    public void setCustomer_slug(String customer_slug) {
        this.customer_slug = customer_slug;
    }
}