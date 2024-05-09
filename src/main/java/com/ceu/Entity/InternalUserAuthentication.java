package com.ceu.Entity;

import com.ceu.model.EmailVerifyStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "internal-user-authentication")
@Getter
@Setter
public class InternalUserAuthentication extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String loginName;
    private String hashedPassword;
    private String passwordSalt;
    private String emailAddress;
    private String confirmationToken;
    private LocalDateTime tokenGenerationTime;
    @Enumerated(EnumType.STRING)
    private EmailVerifyStatus emailVerifyStatus;
    private String passwordRecoveryToken;
    private LocalDateTime recoveryTokenTime;
    private boolean isPremiumAccount;
    @OneToOne(mappedBy = "internalUserAuthentication")
    private User user;

}
