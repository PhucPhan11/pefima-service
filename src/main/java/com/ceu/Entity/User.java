package com.ceu.Entity;

import com.ceu.model.Gender;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "user-account")
@Getter
@Setter
public class User extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "internal-user-authentication-id", referencedColumnName = "id")
    private InternalUserAuthentication internalUserAuthentication;
}
