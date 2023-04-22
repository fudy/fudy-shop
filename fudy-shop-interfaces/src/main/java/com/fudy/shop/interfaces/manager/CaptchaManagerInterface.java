package com.fudy.shop.interfaces.manager;


import com.fudy.shop.interfaces.dto.CaptchaDTO;

import javax.validation.Valid;

public interface CaptchaManagerInterface {
    void send(@Valid CaptchaDTO dto) throws Exception;
}
