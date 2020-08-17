package com.example.innoventesProject.dto;

public class AddressDto {

private Long addressId;

    private String addrLineOne;

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
}
