package com.market.aaa.controller;

import com.market.aaa.entity.User;
import com.market.aaa.payload.request.SmUserDto;
import com.market.aaa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public User findUserByUserId(@PathVariable String userId) {
        return userService.findMemberByUserId(userId);
    }

    @GetMapping("/exists/{userId}")
    public Boolean existsByUserId(@PathVariable String userId) {
        return userService.existsByUserId(userId);
    }

    @PostMapping("/failCountReset")
    public Boolean failCountReset(@RequestBody SmUserDto userDto) {
        return userService.failCountReset(userDto);
    }
}
