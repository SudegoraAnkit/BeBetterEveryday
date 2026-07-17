package com.nexcommerce.user_service.model.entity;

import com.nexcommerce.user_service.model.enums.Role;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users", indexes = {@Index(name = "idx_users_email", columnList = "email")})
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 255) // Spring auto-maps this to password_hash
    private String passwordHash;

    @Column(nullable = false, length = 50)  // Spring auto-maps to first_name
    private String firstName;

    @Column(nullable = false, length = 50)  // Spring auto-maps to last_name
    private String lastName;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles; // Contained as Enum values directly

    @CreatedDate
    @Column(nullable = false, updatable = false) // Spring auto-maps to created_at
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt; // Spring auto-maps to updated_at
}