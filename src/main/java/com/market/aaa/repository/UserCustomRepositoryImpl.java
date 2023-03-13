package com.market.aaa.repository;

import com.market.aaa.entity.QUser;
import com.market.aaa.entity.User;
import com.market.aaa.payload.request.SmUserDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.market.aaa.entity.QUser.user;


@Repository
@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public User findByUserId(String userId) {
        return queryFactory.selectFrom(user)
                .where(user.userId.eq(userId))
                .fetchOne();
    }

    @Override
    public Boolean failCountReset(SmUserDto userDto) {
        return queryFactory.update(user)
                .set(user.loginFailCount, 0)
                .where(user.userId.eq(userDto.getUserId()))
                .execute() > 0;
    }
}
