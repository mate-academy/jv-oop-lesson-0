package application.validation;

import application.dao.PhoneNumberDao;
import application.model.dto.AddClientDto;
import application.model.dto.GetAndUpdateClientRequestDto;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Default
public class Validator {
    private static final int YEAR_INDEX = 0;
    private static final int MONTH_INDEX = 1;
    private static final int DAY_INDEX = 2;
    private static final int FIRST_MONTH = 1;
    private static final int LAST_MONTH = 12;
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 31;
    private static final int STARTING_YEAR = 1900;
    private static final int CURRENT_YEAR = 2022;
    @Inject
    private PhoneNumberDao phoneNumberDao;

    public boolean validate(AddClientDto addClientDto) {
        return isFullName(addClientDto.getFullName())
                && isPhoneNumber(addClientDto.getMainPhoneNumber());
    }

    public boolean validate(GetAndUpdateClientRequestDto getAndUpdateClientRequestDto) {
        return isFullName(getAndUpdateClientRequestDto.getFullName())
                && isPassportId(getAndUpdateClientRequestDto.getPassport())
                && isDateOfBirth(getAndUpdateClientRequestDto.getDateOfBirth())
                && isPhoneNumber(getAndUpdateClientRequestDto.getAdditionalPhoneNumber());
    }

    private boolean isFullName(String fullName) {
        return fullName.matches("^[a-zA-Z -.']*$");
    }

    private boolean isPhoneNumber(String phoneNumber) {
        String[] split = phoneNumber.split("-");
        boolean areDigits = true;
        for (String string : split) {
            for (Character ch : string.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    areDigits = false;
                }
            }
        }
        return areDigits && split[0].length() == 3 && split[1].length() == 3
                && split[2].length() == 2 && split[3].length() == 2
                && !phoneNumberDao.checkIfExists(phoneNumber);
    }

    private boolean isPassportId(String passport) {
        boolean areDigits = true;
        for (Character ch : passport.toCharArray()) {
            if (!Character.isDigit(ch)) {
                areDigits = false;
            }
        }
        return areDigits;
    }

    private boolean isDateOfBirth(String dateOfBirth) {
        String[] split = dateOfBirth.split("-");
        return isYear(split[YEAR_INDEX])
                && isMonth(split[MONTH_INDEX])
                && isDay(split[DAY_INDEX]);
    }

    private boolean isYear(String yearOfBirth) {
        int year = Integer.parseInt(yearOfBirth);
        return year >= STARTING_YEAR && year <= CURRENT_YEAR;
    }

    private boolean isMonth(String monthOfBirth) {
        int month = Integer.parseInt(monthOfBirth);
        return month >= FIRST_MONTH && month <= LAST_MONTH;
    }

    private boolean isDay(String dayOfBirth) {
        int day = Integer.parseInt(dayOfBirth);
        return day >= FIRST_DAY && day <= LAST_DAY;
    }
}
