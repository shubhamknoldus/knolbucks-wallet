package com.knoldus.knolbucks;

public class Persons {
    int personID;
    String lastName,FirstName,Address,City;

    public int getPersonID() {
        return this.personID;
    }

    public void setPersonID(final int personID) {
        this.personID = personID;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(final String firstName) {
        this.FirstName = firstName;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(final String address) {
        this.Address = address;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(final String city) {
        this.City = city;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "personID=" + personID +
                ", lastName='" + lastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
