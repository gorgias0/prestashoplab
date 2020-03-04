package testdata;

import java.time.LocalDateTime;

public class TestPerson {
    private boolean random = false;
    private String gender = "male";
    private String firstName = "Nisse";
    private String lastName = "Nyqvist";
    private String email = "nisse5@test.com";
    private String guestEmail = "nisse_guest2@test.com";
    private String password = "Nisse12345";
    private String birtDate = "01/01/1970";

    private String address = "Nyponstigen 4";
    private String zipcode = "12345";
    private String city = "Stockholm";
    private String country = "France";

    public String generatedEmail() {
        return LocalDateTime.now().hashCode() + "@test.com";
    }

    public TestPerson(){}

    public TestPerson(boolean random){
        this.random = true;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getEmail() {
        if (random) {
            return generatedEmail();
        } else {
            return email;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(String birtDate) {
        this.birtDate = birtDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
