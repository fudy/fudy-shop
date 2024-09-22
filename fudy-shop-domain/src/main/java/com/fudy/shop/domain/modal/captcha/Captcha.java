package com.fudy.shop.domain.modal.captcha;

import com.fudy.shop.domain.util.RandomUtil;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;

public class Captcha implements Serializable {

    /** 验证码长度 */
    public static final int LENGTH = 4;
    /** 图片宽度 */
    public static final int WIDTH = 120;
    /** 图片长度 */
    public static final int HEIGHT = 40;
    private static final long serialVersionUID = 2353133740612279598L;

    @Getter @Setter
    private final String code;

    public Captcha(String code) {
        this.code = code;
    }

    public BufferedImage getImageCaptcha() {
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
