package application.model.mapper;

import application.model.PersonalInfo;
import application.model.dto.GetAndUpdateClientResponseDto;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.inject.Singleton;

@Singleton
@Default
public class ResponseDtoMapper {
    public GetAndUpdateClientResponseDto toUpdateClientResponseDto(PersonalInfo personalInfo,
                                                                   List<String> phoneNumbers) {
        GetAndUpdateClientResponseDto getAndUpdateClientResponseDto
                = new GetAndUpdateClientResponseDto();
        getAndUpdateClientResponseDto
                .setDateOfBirth(String.valueOf(personalInfo.getDateOfBirth()));
        getAndUpdateClientResponseDto.setFullName(personalInfo.getFullName());
        getAndUpdateClientResponseDto.setPassport(personalInfo.getPassport());
        getAndUpdateClientResponseDto.setPhoneNumbers(phoneNumbers);
        return getAndUpdateClientResponseDto;
    }
}
