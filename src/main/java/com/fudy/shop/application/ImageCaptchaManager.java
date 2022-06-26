package com.fudy.shop.application;

import com.fudy.shop.infrastructure.common.RandomUtil;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Validated
@Service
public class ImageCaptchaManager {
    /** 验证码长度 */
    public static final int LENGTH = 4;
    /** 图片宽度 */
    public static final int WIDTH = 120;
    /** 图片长度 */
    public static final int HEIGHT = 40;
    public static final String IMAGE_CAPTCHA_CODE = "image_captcha_code";

    public void outputImageCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = RandomUtil.randomStr(LENGTH);
        request.getSession().setAttribute(IMAGE_CAPTCHA_CODE, code);
        BufferedImage image = getImageCaptcha(code);
        ImageIO.write(image, "JPEG", response.getOutputStream());
        ServletOutputStream os = response.getOutputStream();
        os.flush();
        os.close();
    }

    public boolean isValid(HttpSession session, String code) {
        return StringUtils.equals((String)session.getAttribute(IMAGE_CAPTCHA_CODE), code);
    }

    private BufferedImage getImageCaptcha(String code) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        //设置区块颜色
        g.setColor(Color.WHITE);
        //填充图形边框（会用到上面设置的颜色）
        g.fillRect(0,0,WIDTH, HEIGHT);
        //设置字体颜色
        g.setColor(Color.RED);
        //设置字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        //旋转
        Random random = new Random();
        g.rotate(Math.toRadians(random.nextInt(-30,30)), WIDTH/2, HEIGHT/2);
        //绘制字符串
        g.drawString(code, 30, 25);
        //生成干扰线
        int maxSize = random.nextInt(5, 10);
        for (int i=0; i< maxSize; i++) {
            int startX = random.nextInt(WIDTH);
            int startY = random.nextInt(HEIGHT);
            int endX = startX + random.nextInt(-50,50);
            int endY = startY + random.nextInt(-20,20);
            g.drawLine(startX, startY, endX, endY);
        }
        //释放graphics资源
        g.dispose();
        return image;
    }

}
