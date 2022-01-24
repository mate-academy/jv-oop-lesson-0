package application.model.dto;

import java.util.List;

public class GetAndUpdateClientResponseDto {
    private String fullName;
    private String passport;
    private String dateOfBirth;
    private List<String> phoneNumbers;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "{"
                + "fullName='" + fullName + '\''
                + ", passport='" + passport + '\''
                + ", dateOfBirth='" + dateOfBirth + '\''
                + ", phoneNumbers=" + phoneNumbers
                + '}';
    }
}
