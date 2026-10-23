package com.example.demo.repository;

import com.example.demo.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    // JPQL
    @Modifying
    @Query("UPDATE UserEntity u SET u.passwordHash = :newPasswordHash WHERE u.id = :id")
    int updatePasswordHashById(@Param("id") UUID id, @Param("newPasswordHash") String newPasswordHash);

    // SQL
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET password_hash = :newPasswordHash WHERE login = :login", nativeQuery = true)
    int updatePasswordHashByLogin(@Param("login") String login, @Param("newPasswordHash") String newPasswordHash);

    UserEntity findByLogin(String login);
}
