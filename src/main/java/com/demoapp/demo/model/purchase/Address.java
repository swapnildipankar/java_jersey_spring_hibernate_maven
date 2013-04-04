package com.demoapp.demo.model.purchase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 3/21/13
 * Time: 8:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    @NotNull(groups=POST.class, message = "city: Missing Required Field")
    @NotBlank(groups=POST.class, message = "city: Cannot Be Blank")
    private String city;

    @NotNull(groups=POST.class, message = "country_code: Missing Required Field")
    @NotBlank(groups=POST.class, message = "country_code: Cannot Be Blank")
    @JsonProperty("country_code")
    private String countryCode;

    @NotNull(groups=POST.class, message = "first_name: Missing Required Field")
    @NotBlank(groups=POST.class, message = "first_name: Cannot Be Blank")
    @JsonProperty("first_name")
    private String firstName;

    @NotNull(groups=POST.class, message = "last_name: Missing Required Field")
    @NotBlank(groups=POST.class, message = "last_name: Cannot Be Blank")
    @JsonProperty("last_name")
    private String lastName;

    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("postal_code")
    private String postalCode;

    private String state;

    @JsonProperty("street_1")
    private String street1;

    @JsonProperty("street_2")
    private String street2;

    @JsonProperty("street_3")
    private String street3;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", street3='" + street3 + '\'' +
                '}';
    }
}
