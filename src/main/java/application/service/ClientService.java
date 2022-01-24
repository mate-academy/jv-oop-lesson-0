package application.service;

import application.model.dto.AddClientDto;
import application.model.dto.GetAndUpdateClientRequestDto;
import application.model.dto.GetAndUpdateClientResponseDto;
import java.util.Optional;

public interface ClientService {
    Long add(AddClientDto addClientDto);

    Object update(GetAndUpdateClientRequestDto getAndUpdateClientRequestDto);

    Optional<GetAndUpdateClientResponseDto> getById(long id);

    Long delete(long id);
}
