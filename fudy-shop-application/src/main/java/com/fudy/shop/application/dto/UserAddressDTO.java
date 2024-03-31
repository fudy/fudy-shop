package com.fudy.shop.application.dto;

import lombok.Data;

@Data
public class UserAddressDTO {
    /** 用户 */
    private Long userId;
    /** 收货人*/
    private String receiver;
    /** 手机号 */
    private String phone;
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
    /** 是否是默认地址 */
    private boolean defaultAddress;
}
