package com.esmabeydili.backend2.dto;

import com.esmabeydili.backend2.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class UserViewDTO implements Serializable {

     private static final long serialVersionUID= 1L;
     private final String firstname;
     private final String lastname;

    private UserViewDTO(String firstname, String lastname) {//initialize
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public static UserViewDTO of(User user){//bu method constructor private olduğu için oluşturuldu
        return new UserViewDTO(user.getFirstName(),user.getSecondName());
    }
}
