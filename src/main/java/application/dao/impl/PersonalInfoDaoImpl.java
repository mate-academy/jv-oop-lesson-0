package application.dao.impl;

import application.dao.PersonalInfoDao;
import application.exception.DataProcessingException;
import application.model.PersonalInfo;
import application.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.enterprise.inject.Default;

@Default
public class PersonalInfoDaoImpl implements PersonalInfoDao {
    @Override
    public Long add(PersonalInfo personalInfo) {
        String addPersonalInfoRequest = "INSERT INTO personal_info "
                + "(client_id, full_name, created) "
                + "VALUES (?, ?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement addPersonalInfoStatement
                        = connection.prepareStatement(addPersonalInfoRequest,
                         Statement.RETURN_GENERATED_KEYS)) {
            addPersonalInfoStatement.setLong(1, personalInfo.getClientId());
            addPersonalInfoStatement.setString(2, personalInfo.getFullName());
            addPersonalInfoStatement.setTimestamp(3, Timestamp.valueOf(personalInfo.getCreated()));
            addPersonalInfoStatement.executeUpdate();
            ResultSet resultSet = addPersonalInfoStatement.getGeneratedKeys();
            if (resultSet.next()) {
                personalInfo.setId(resultSet.getObject(1, Long.class));
            }
            return personalInfo.getId();
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't add " + personalInfo + " to DB", throwable);
        }
    }

    @Override
    public Optional<PersonalInfo> getByClientId(Long clientId) {
        String getPersonalInfoRequest = "SELECT * FROM personal_info "
                + "WHERE client_id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getPersonalInfoStatement
                        = connection.prepareStatement(getPersonalInfoRequest)) {
            getPersonalInfoStatement.setLong(1, clientId);
            ResultSet resultSet = getPersonalInfoStatement.executeQuery();
            PersonalInfo personalInfo = null;
            if (resultSet.next()) {
                personalInfo = getPersonalInfo(resultSet);
            }
            return Optional.ofNullable(personalInfo);
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldnt get personal info for client №"
                    + clientId, throwable);
        }
    }

    @Override
    public void update(PersonalInfo newPersonalInfo) {
        String updatePersonalInfoRequest = "UPDATE personal_info SET full_name = ?, passport = ?,"
                + " date_of_birth = ? WHERE client_id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updatePersonalInfoStatement
                        = connection.prepareStatement(updatePersonalInfoRequest)) {
            updatePersonalInfoStatement.setString(1, newPersonalInfo.getFullName());
            updatePersonalInfoStatement.setString(2, newPersonalInfo.getPassport());
            updatePersonalInfoStatement.setDate(3,
                    Date.valueOf(newPersonalInfo.getDateOfBirth()));
            updatePersonalInfoStatement.setLong(4, newPersonalInfo.getClientId());
            updatePersonalInfoStatement.executeUpdate();
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't update personal info with values "
                    + newPersonalInfo, throwable);
        }
    }

    @Override
    public boolean delete(long id) {
        String deletePersonalInfoRequest = "UPDATE personal_info SET is_deleted "
                + "= TRUE, deleted = ? WHERE client_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deletePersonalInfoStatement
                        = connection.prepareStatement(deletePersonalInfoRequest)) {
            deletePersonalInfoStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            deletePersonalInfoStatement.setLong(2, id);
            return deletePersonalInfoStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldnt delete personal info for client №"
                    + id, throwable);
        }
    }

    private PersonalInfo getPersonalInfo(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        Long clientId = resultSet.getObject("client_id", Long.class);
        String fullName = resultSet.getString("full_name");
        String passport = resultSet.getString("passport");
        LocalDate dateOfBirth;
        if (resultSet.getDate("date_of_birth") != null) {
            dateOfBirth = resultSet.getDate("date_of_birth").toLocalDate();
        } else {
            dateOfBirth = null;
        }
        LocalDateTime created = resultSet.getTimestamp("created").toLocalDateTime();
        PersonalInfo personalInfo = new PersonalInfo(clientId, fullName, passport, dateOfBirth);
        personalInfo.setId(id);
        personalInfo.setCreated(created);
        return personalInfo;
    }
}
