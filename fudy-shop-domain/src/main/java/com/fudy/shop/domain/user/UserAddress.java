package com.fudy.shop.domain.user;

import com.fudy.shop.domain.Entity;
import lombok.Data;

@Data
public class UserAddress extends Entity {
    /** 收货人*/
    private UserName receiver;
    /** 手机号 */
    private PhoneNumber phone;
    /** 省份 */
    private String province;
    /** 城市 */
    private String city;
    /** 区县 */
    private String district;
    /** 街道 */
    private String street;
    /** 地址 */
    private String address;
    /** 邮编 */
    private String zipCode;
    /** 是否是默认地址 */
    private boolean defaultAddress;
}
