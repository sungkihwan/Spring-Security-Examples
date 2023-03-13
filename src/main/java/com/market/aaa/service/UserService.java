package com.market.aaa.service;

import com.market.aaa.entity.User;
import com.market.aaa.payload.request.SmUserDto;
import com.market.aaa.repository.UserCustomRepository;
import com.market.aaa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
//@Transactional(readOnly = true)
public class UserService {

    private final UserCustomRepository userCustomRepository;

    private final UserRepository userRepository;

    public User findMemberByUserId(String userId) {
        return userCustomRepository.findByUserId(userId);
    }

    public Boolean existsByUserId(String userId) {
        return userRepository.existsByUserId(userId);
    }

    @Transactional
    public Boolean failCountReset(SmUserDto userDto) {
        return userCustomRepository.failCountReset(userDto);
    }
}
