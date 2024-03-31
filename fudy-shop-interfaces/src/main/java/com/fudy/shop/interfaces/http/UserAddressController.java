package com.fudy.shop.interfaces.http;

import com.fudy.shop.application.UserAddressManager;
import com.fudy.shop.application.UserManager;
import com.fudy.shop.application.dto.SimpleUserDTO;
import com.fudy.shop.application.dto.UserAddressDTO;
import com.fudy.shop.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
public class UserAddressController {
    @Autowired
    private UserManager userManager;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserAddressManager addressManager;

    @GetMapping("/api/users/addresses")
    Result<List<UserAddressDTO>> findUserAddressList() {
        try {
            //获取登录的用户信息
            SimpleUserDTO user = userManager.getUser(httpSession);
            //获取收货地址信息
            List<UserAddressDTO> data = addressManager.findUserAddressList(user.getId());
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getClass().getName(), e.getMessage());
            return Result.fail(e.getClass().getName(), e.getMessage());
        }
    }
}
