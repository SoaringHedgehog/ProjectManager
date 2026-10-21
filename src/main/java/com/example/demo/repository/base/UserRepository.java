package com.example.demo.repository.base;

import com.example.demo.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    // JPQL
    @Modifying
    @Query("UPDATE UserEntity u SET u.passwordHash = :newPasswordHash WHERE u.id = :id")
    UserEntity updatePasswordHashById(@Param("id") int id, @Param("newPasswordHash") String newPasswordHash);

    // SQL
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET password_hash = :newPasswordHash WHERE login = :login", nativeQuery = true)
    UserEntity updatePasswordHashByLogin(@Param("login") String login, @Param("newPasswordHash") String newPasswordHash);

    UserEntity findById(int id);
    UserEntity findByLogin(String login);
}
