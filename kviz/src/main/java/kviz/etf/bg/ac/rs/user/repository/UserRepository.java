package kviz.etf.bg.ac.rs.user.repository;

import kviz.etf.bg.ac.rs.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT ue FROM UserEntity ue WHERE ue.username = ?1 and ue.password = ?2")
    UserEntity authenticateUser(@Param("username") String username, @Param("password") String password);

    @Query("SELECT ue FROM UserEntity ue WHERE ue.userid = ?1")
    UserEntity getUserById(@Param("userId") Integer userId);

    @Query("SELECT ue FROM UserEntity ue WHERE ue.username = ?1")
    UserEntity getUserByUsername(@Param("username") String username);
}
