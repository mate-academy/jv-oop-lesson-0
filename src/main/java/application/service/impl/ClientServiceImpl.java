package application.service.impl;

import application.dao.ClientDao;
import application.dao.PersonalInfoDao;
import application.dao.PhoneNumberDao;
import application.model.Client;
import application.model.PersonalInfo;
import application.model.PhoneNumber;
import application.model.dto.AddClientDto;
import application.model.dto.GetAndUpdateClientRequestDto;
import application.model.dto.GetAndUpdateClientResponseDto;
import application.model.mapper.ResponseDtoMapper;
import application.service.ClientService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Default
public class ClientServiceImpl implements ClientService {
    @Inject
    private ClientDao clientDao;
    @Inject
    private PersonalInfoDao personalInfoDao;
    @Inject
    private PhoneNumberDao phoneNumberDao;
    @Inject
    private ResponseDtoMapper responseDtoMapper;

    @Override
    public Long add(AddClientDto addClientDto) {
        if (getByPhoneAndName(addClientDto.getFullName(),
                addClientDto.getMainPhoneNumber()).isPresent()) {
            return getByPhoneAndName(addClientDto.getFullName(),
                    addClientDto.getMainPhoneNumber()).get().getId();
        }
        Client client = new Client();
        Long id = clientDao.add(client);
        PersonalInfo personalInfo = new PersonalInfo(id, addClientDto.getFullName());
        personalInfoDao.add(personalInfo);
        PhoneNumber phoneNumber = new PhoneNumber(id, addClientDto.getMainPhoneNumber(), 1L);
        phoneNumberDao.add(phoneNumber);
        return id;
    }

    @Override
    public Object update(
            GetAndUpdateClientRequestDto getAndUpdateClientRequestDto) {
        PersonalInfo personalInfo = personalInfoDao
                .getByClientId(getAndUpdateClientRequestDto.getClientId()).get();
        List<String> phoneNumbers = phoneNumberDao
                .getPhoneNumbersByClientId(getAndUpdateClientRequestDto.getClientId());
        if (personalInfo.getFullName().equals(getAndUpdateClientRequestDto.getFullName())
                && personalInfo.getPassport().equals(getAndUpdateClientRequestDto.getPassport())
                && personalInfo.getDateOfBirth()
                .equals(LocalDate.parse(getAndUpdateClientRequestDto.getDateOfBirth()))
                && phoneNumbers.contains(getAndUpdateClientRequestDto
                .getAdditionalPhoneNumber())) {
            return getAndUpdateClientRequestDto;
        } else {
            PersonalInfo newPersonalInfo =
                    new PersonalInfo(getAndUpdateClientRequestDto.getClientId(),
                    getAndUpdateClientRequestDto.getFullName(),
                    getAndUpdateClientRequestDto.getPassport(),
                    LocalDate.parse(getAndUpdateClientRequestDto.getDateOfBirth()));
            personalInfoDao.update(newPersonalInfo);
            PhoneNumber phoneNumber = new PhoneNumber(getAndUpdateClientRequestDto.getClientId(),
                    getAndUpdateClientRequestDto.getAdditionalPhoneNumber(), 2L);
            phoneNumberDao.add(phoneNumber);
            phoneNumbers = phoneNumberDao
                    .getPhoneNumbersByClientId(getAndUpdateClientRequestDto.getClientId());
            return responseDtoMapper.toUpdateClientResponseDto(newPersonalInfo, phoneNumbers);
        }
    }

    @Override
    public Optional<GetAndUpdateClientResponseDto> getById(long id) {
        if (clientDao.getById(id).isEmpty()) {
            return Optional.empty();
        }
        PersonalInfo personalInfo = personalInfoDao.getByClientId(id).get();
        List<String> phoneNumbers = phoneNumberDao.getPhoneNumbersByClientId(id);
        return Optional.of(responseDtoMapper.toUpdateClientResponseDto(personalInfo, phoneNumbers));
    }

    @Override
    public Long delete(long id) {
        if (clientDao.getById(id).isEmpty()) {
            return null;
        }
        personalInfoDao.delete(id);
        phoneNumberDao.delete(id);
        clientDao.delete(id);
        return id;
    }

    private Optional<Client> getByPhoneAndName(String fullName, String mainPhoneNumber) {
        if (phoneNumberDao.getClientIdByMainPhone(mainPhoneNumber).isEmpty()) {
            return Optional.empty();
        }
        return clientDao.getById(phoneNumberDao.getClientIdByMainPhone(mainPhoneNumber).get());
    }
}
