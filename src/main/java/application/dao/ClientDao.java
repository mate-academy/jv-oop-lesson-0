package application.dao;

import application.model.Client;
import java.util.Optional;

public interface ClientDao {
    Long add(Client client);

    Optional<Client> getById(long id);

    boolean delete(long id);
}
