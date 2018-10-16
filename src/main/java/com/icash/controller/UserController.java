package com.icash.controller;

import com.icash.controller.response.UserInfoResponse;
import com.icash.entity.User;
import com.icash.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected/api/v1/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserUtils userUtils;

    /**
     *
     * @return
     */
    @RequestMapping("/general-info")
    public ResponseEntity<?> getGeneralUserInfo(){
        User user = userUtils.currentUser();
        if(user == null){
            throw new RuntimeException("Can not get User from security context holder.");
        }
        return ResponseEntity.ok(this.wrapGeneralUserInfo(user));
    }

    private UserInfoResponse wrapGeneralUserInfo(User user) {
        UserInfoResponse userInfo = new UserInfoResponse();

        userInfo.setUsername(user.getUsername());
        userInfo.setiCoins(user.getCurrentICoins());
        userInfo.setAvatar(user.getAvatarImage());

        return userInfo;
    }
}
