package application.dao;

import application.model.PersonalInfo;
import java.util.Optional;

public interface PersonalInfoDao {
    Long add(PersonalInfo personalInfo);

    Optional<PersonalInfo> getByClientId(Long clientId);

    void update(PersonalInfo newPersonalInfo);

    boolean delete(long id);
}
