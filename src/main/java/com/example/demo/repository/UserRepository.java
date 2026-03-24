package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // JPQL
    @Modifying
    @Query("UPDATE User u SET u.passwordHash = :newPasswordHash WHERE u.id = :id")
    User updatePasswordHashById(@Param("id") int id, @Param("newPasswordHash") String newPasswordHash);

    // SQL
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET password_hash = :newPasswordHash WHERE login = :login", nativeQuery = true)
    User updatePasswordHashByLogin(@Param("login") String login, @Param("newPasswordHash") String newPasswordHash);

    User findById(int id);
    User findByLogin(String login);
}
