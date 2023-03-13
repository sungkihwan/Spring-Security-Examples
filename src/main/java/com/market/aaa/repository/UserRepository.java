package com.market.aaa.repository;

import com.market.aaa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String userId);

    boolean existsByUserId(String userId);

    Optional<User> findByRefreshToken(String refreshToken);

    @Modifying
    @Query("UPDATE User u SET u.refreshToken = :refreshToken WHERE u.userId = :userId")
    void updateRefreshToken(@Param("userId") String userId, @Param("refreshToken") String refreshToken);

    @Modifying
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    // 해당 메서드는 새로운 트랜잭션에서 실행되므로, 해당 트랜잭션에서 변경된 내용은 상위 트랜잭션의 롤백 대상이 아니게 되는 옵션
    @Query("UPDATE User u SET u.loginFailCount = u.loginFailCount +1 WHERE u.userId = :userId")
    void updateLoginFailCount(@Param("userId") String userId);
}
