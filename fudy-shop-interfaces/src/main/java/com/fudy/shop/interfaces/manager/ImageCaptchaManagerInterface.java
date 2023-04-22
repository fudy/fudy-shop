package com.fudy.shop.interfaces.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ImageCaptchaManagerInterface {
    void outputImageCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
