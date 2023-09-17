package com.fudy.shop.domain.user.session;

import com.fudy.shop.domain.user.*;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserSession {
    private UserName userName;
    private UserId userId;
    private PhoneNumber phone;
    private NickName nickName;

    public UserSession(@NonNull User user) {
        this.userName = user.getUserName();
        this.userId = new UserId(user.getId());
        this.phone = user.getPhone();
        this.nickName = user.getNickName();
    }

    public UserSession() {
    }

    public Long getUserId() {
        return null == userId ? null : userId.getValue();
    }

    public String getUserName() {
        return null == userName ? null : userName.getValue();
    }

    public String getPhone() {
        return null == phone ? null : phone.getValue();
    }

    public String getNickName() {
        return null == nickName ? null : nickName.getNickName();
    }

}
