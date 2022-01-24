package application.dao;

import application.model.PhoneNumber;
import java.util.List;
import java.util.Optional;

public interface PhoneNumberDao {
    Long add(PhoneNumber phoneNumber);

    List<String> getPhoneNumbersByClientId(Long clientId);

    boolean delete(long id);

    Optional<Long> getClientIdByMainPhone(String mainPhoneNumber);

    boolean checkIfExists(String phoneNumber);
}
