package com.example.innoventesProject.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "address_details")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;



    @Column(name = "addrLine_One")
    @NotEmpty(message = "field should not be empty")
    @Length(min = 5)
    private String addrLineOne;

    @Column(name = "city")
    @NotEmpty(message = "field should not be empty")
    private String city;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddrLineOne() {
        return addrLineOne;
    }

    public void setAddrLineOne(String addrLineOne) {
        this.addrLineOne = addrLineOne;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addrLineOne='" + addrLineOne + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
