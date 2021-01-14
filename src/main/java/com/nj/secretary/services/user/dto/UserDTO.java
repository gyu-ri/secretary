package com.nj.secretary.services.user.dto;

import com.nj.secretary.services.user.domain.User;
import lombok.Data;

import java.io.Serializable;

public class UserDTO {

    @Data
    // @Builder
    public static class signUpDTO implements Serializable { //Serializable 하나의 객체로 보낼 수 있게 해주므로 더 효율적
        private String userName;
        private String userId;
        private String password;
        private String nickname;
        private String email;
    }

}
