package application.dao.impl;

import application.dao.PhoneNumberDao;
import application.exception.DataProcessingException;
import application.model.PhoneNumber;
import application.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.inject.Default;

@Default
public class PhoneNumberDaoImpl implements PhoneNumberDao {
    @Override
    public Long add(PhoneNumber phoneNumber) {
        String addPhoneNumberRequest = "INSERT INTO phone_numbers "
                + "(client_id, phone_number, phone_number_type_id, created)"
                + " VALUES (?, ?, ?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement addPhoneNumberStatement =
                        connection.prepareStatement(addPhoneNumberRequest,
                             Statement.RETURN_GENERATED_KEYS)) {
            addPhoneNumberStatement.setLong(1, phoneNumber.getClientId());
            addPhoneNumberStatement.setString(2, phoneNumber.getPhoneNumber());
            addPhoneNumberStatement.setLong(3, phoneNumber.getTypeId());
            addPhoneNumberStatement.setTimestamp(4,
                    Timestamp.valueOf(phoneNumber.getCreated()));
            addPhoneNumberStatement.executeUpdate();
            ResultSet generatedKeys = addPhoneNumberStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                phoneNumber.setId(generatedKeys.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Cant add " + phoneNumber + " to DB", e);
        }
        return phoneNumber.getId();
    }

    @Override
    public List<String> getPhoneNumbersByClientId(Long clientId) {
        String getPhoneNumbersRequest = "SELECT phone_number FROM phone_numbers "
                + "WHERE client_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getPhoneNumbersStatement
                        = connection.prepareStatement(getPhoneNumbersRequest)) {
            getPhoneNumbersStatement.setLong(1, clientId);
            ResultSet resultSet = getPhoneNumbersStatement.executeQuery();
            List<String> list = parsePhoneNumbers(resultSet);
            return list;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldnt get phone numbers for client №"
                    + clientId, throwable);
        }
    }

    @Override
    public boolean delete(long id) {
        String deletePhoneNumbersRequest = "UPDATE phone_numbers SET is_deleted "
                + "= TRUE, deleted = ? WHERE client_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deletePhoneNumbersStatement
                        = connection.prepareStatement(deletePhoneNumbersRequest)) {
            deletePhoneNumbersStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            deletePhoneNumbersStatement.setLong(2, id);
            return deletePhoneNumbersStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldnt delete phone numbers for client №"
                    + id, throwable);
        }
    }

    @Override
    public Optional<Long> getClientIdByMainPhone(String mainPhoneNumber) {
        String getClientIdByPhoneNumberRequest = "SELECT client_id FROM phone_numbers "
                + "WHERE phone_number = ? AND phone_number_type_id = 1;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getClientIdByPhoneNumberStatement
                        = connection.prepareStatement(getClientIdByPhoneNumberRequest)) {
            getClientIdByPhoneNumberStatement.setString(1, mainPhoneNumber);
            ResultSet resultSet = getClientIdByPhoneNumberStatement.executeQuery();
            Long clientId = null;
            if (resultSet.next()) {
                clientId = resultSet.getObject("client_id", Long.class);
            }
            return Optional.ofNullable(clientId);
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldnt get client ID for phone number "
                    + mainPhoneNumber, throwable);
        }
    }

    @Override
    public boolean checkIfExists(String phoneNumber) {
        String checkIfNumberExistsRequest = "SELECT client_id FROM phone_numbers "
                + "WHERE phone_number = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement checkIfNumberExistsStatement
                        = connection.prepareStatement(checkIfNumberExistsRequest)) {
            checkIfNumberExistsStatement.setString(1, phoneNumber);
            ResultSet resultSet = checkIfNumberExistsStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Phone number already exists "
                    + phoneNumber, throwable);
        }
    }

    private List<String> parsePhoneNumbers(ResultSet resultSet) throws SQLException {
        List<String> phoneNumbers = new ArrayList<>();
        while (resultSet.next()) {
            phoneNumbers.add(resultSet.getString("phone_number"));
        }
        return phoneNumbers;
    }
}
