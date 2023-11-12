package com.fudy.shop.domain.captcha;

public enum CaptchaType {
    FORGET_PASSWORD("captcha-forget-password"),
    MOCK("captcha-mock"),
    USER_LOGIN("captcha-user-login"),
    USER_REGISTRY("captcha-user-registry");
    private String value;

    CaptchaType(String value) {
        this.value = value;
    }

    public static CaptchaType of(String type) {
        for (CaptchaType ct : CaptchaType.values()) {
            if (ct.value.equals(type)) {
                return ct;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
