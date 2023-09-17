package com.fudy.shop.application;

import com.fudy.shop.domain.captcha.Captcha;
import com.fudy.shop.domain.util.RandomUtil;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Validated
@Service
public class ImageCaptchaManager  {
    /** 验证码长度 */
    public static final int LENGTH = 4;
    public static final String IMAGE_CAPTCHA_CODE = "image_captcha_code";

    public void outputImageCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Captcha captcha = new Captcha(RandomUtil.randomStr(LENGTH));
        request.getSession().setAttribute(IMAGE_CAPTCHA_CODE, captcha.getCode());
        BufferedImage image = captcha.getImageCaptcha();
        ImageIO.write(image, "JPEG", response.getOutputStream());
        ServletOutputStream os = response.getOutputStream();
        os.flush();
        os.close();
    }

    public boolean isValid(HttpSession session, String code) {
        return StringUtils.equals((String)session.getAttribute(IMAGE_CAPTCHA_CODE), code);
    }

    public void clearImageCaptcha(HttpSession httpSession) {
        httpSession.removeAttribute(IMAGE_CAPTCHA_CODE);
    }
}
