
package com.joy.kafka.json.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Street1",
    "Street2",
    "City",
    "State",
    "PinCode",
    "Country"
})
public class Address {

    @JsonProperty("Street1")
    private String street1;
    @JsonProperty("Street2")
    private String street2;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private Integer state;
    @JsonProperty("PinCode")
    private String pinCode;
    @JsonProperty("Country")
    private String country;

    @JsonProperty("Street1")
    public String getStreet1() {
        return street1;
    }

    @JsonProperty("Street1")
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public Address withStreet1(String street1) {
        this.street1 = street1;
        return this;
    }

    @JsonProperty("Street2")
    public String getStreet2() {
        return street2;
    }

    @JsonProperty("Street2")
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public Address withStreet2(String street2) {
        this.street2 = street2;
        return this;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("State")
    public Integer getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(Integer state) {
        this.state = state;
    }

    public Address withState(Integer state) {
        this.state = state;
        return this;
    }

    @JsonProperty("PinCode")
    public String getPinCode() {
        return pinCode;
    }

    @JsonProperty("PinCode")
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Address withPinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    public Address withCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("street1", street1).append("street2", street2).append("city", city).append("state", state).append("pinCode", pinCode).append("country", country).toString();
    }

}
