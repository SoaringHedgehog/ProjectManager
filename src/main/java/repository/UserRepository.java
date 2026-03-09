package repository;

import entity.RoleType;
import entity.Session;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    void authorizeUser(String login, String passwordHash, Session session);
    void registerUser(int userId, String login, String passwordHash, RoleType role);
    void terminateSession(Session session);
    void updatePassword(String oldPasswordHash, String newPasswordHash, Session session);
    User findById(int userId);
    void printCurrentProfileInfo(Session session);
    int getRepositorySize();
}
