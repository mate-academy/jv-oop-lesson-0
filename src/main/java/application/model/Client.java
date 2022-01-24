package application.model;

import java.time.LocalDateTime;

public class Client {
    private Long id;
    private LocalDateTime created;
    private LocalDateTime deleted;

    public Client() {
        this.created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getDeleted() {
        return deleted;
    }

    public void setDeleted(LocalDateTime deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Client{"
                + "id=" + id
                + ", created=" + created
                + ", deleted=" + deleted
                + '}';
    }
}
