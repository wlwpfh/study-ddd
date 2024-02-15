package com.ddd.studyddd.member.command.domain;

import org.springframework.security.core.parameters.P;

public class Member {
    private Password password;

    public void changePassword(String currentPassword, String newPassword){
        if(!password.match(currentPassword)){
            throw new PasswordNotMatchException();
        }
        this.password = new Password(newPassword);
    }
}
