package org.qinjie.controller;

import org.qinjie.entity.ResultCode;
import org.qinjie.entity.ResultVO;
import org.qinjie.entity.User;
import org.qinjie.exception.ApiException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author jieqin
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResultVO<String> login(@RequestBody @Valid User user){
        try {
            User user1 = null;
            user1.getUserName();
        }catch (Exception e){
            throw new ApiException(ResultCode.USERNAME_PASSWORD_ERROR,user.toString());
        }
        return new ResultVO<>(ResultCode.SUCCESS);
    }

}
