package application.model;

import java.time.LocalDateTime;

public class PhoneNumber {
    private Long id;
    private Long clientId;
    private String phoneNumber;
    private Long typeId;
    private LocalDateTime created;
    private LocalDateTime deleted;

    public PhoneNumber(Long clientId, String phoneNumber, Long typeId) {
        this.clientId = clientId;
        this.phoneNumber = phoneNumber;
        this.typeId = typeId;
        this.created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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
        return "PhoneNumber{"
                + "id=" + id
                + ", clientId=" + clientId
                + ", phoneNumber='" + phoneNumber + '\''
                + ", typeId=" + typeId
                + ", created=" + created
                + ", deleted=" + deleted
                + '}';
    }
}
