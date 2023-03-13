package com.market.aaa.repository;

import com.market.aaa.entity.User;
import com.market.aaa.payload.request.SmUserDto;

public interface UserCustomRepository {
    User findByUserId(String userId);

    Boolean failCountReset(SmUserDto smUserDto);
}
