package application.controller;

import application.model.dto.AddClientDto;
import application.model.dto.GetAndUpdateClientRequestDto;
import application.model.dto.GetAndUpdateClientResponseDto;
import application.service.ClientService;
import application.validation.Validator;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.Logger;

@Path("clients")
public class ClientController {
    @Inject
    private Validator validator;
    @Inject
    private ClientService clientService;
    @Inject
    private Logger logger;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(AddClientDto addClientDto) {
        if (!validator.validate(addClientDto)) {
            logger.info("Failed to register a client with name " + addClientDto.getFullName()
                    + " and main phone number " + addClientDto.getMainPhoneNumber());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Long id = clientService.add(addClientDto);
        String message = "{\"Client's ID\": \"" + id + "\"}";
        logger.info("Client with name " + addClientDto.getFullName()
                + " and main phone number " + addClientDto.getMainPhoneNumber()
                + " was successfully registered. Client's ID: " + id);
        return Response.status(Response.Status.OK).entity(message).build();
    }

    @PATCH
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(GetAndUpdateClientRequestDto getAndUpdateClientRequestDto) {
        if (!validator.validate(getAndUpdateClientRequestDto)
                || clientService.getById(getAndUpdateClientRequestDto.getClientId()).isEmpty()) {
            logger.info("Failed to update a client with following fields: "
                    + getAndUpdateClientRequestDto);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Object response = clientService.update(getAndUpdateClientRequestDto);
        logger.info("Client was successfully updated. Updated info: " + response);
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id) {
        Optional<GetAndUpdateClientResponseDto> getAndUpdateClientResponseDto
                = clientService.getById(id);
        if (getAndUpdateClientResponseDto.isEmpty()) {
            logger.info("Unable to find a client №" + id);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        logger.info("Info about a client №" + id + " was successfully fetched from DB");
        return Response.status(Response.Status.OK)
                .entity(getAndUpdateClientResponseDto.get()).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        Long deletedClientId = clientService.delete(id);
        if (deletedClientId == null) {
            logger.info("Unable to delete a client №" + id);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        logger.info("Client №" + id + " was successfully deleted from DB");
        return Response.status(Response.Status.OK).build();
    }
}
