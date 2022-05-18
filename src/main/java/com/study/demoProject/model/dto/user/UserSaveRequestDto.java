package com.study.demoProject.model.dto.user;

import com.study.demoProject.config.value.Address;
import com.study.demoProject.domain.user.Role;
import com.study.demoProject.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String username;
    private String password;
    private String name;
    private String nickname;
    private String birth;
    private String phone;
    private String email;
    private Address address;


    private Role role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .nickname(nickname)
                .birth(birth)
                .phone(phone)
                .email(email)
                .address(address)
                .role(Role.USER)
                .build();
    }
}
