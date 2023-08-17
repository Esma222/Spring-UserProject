package com.esmabeydili.backend2.dto;

import com.esmabeydili.backend2.validator.UniqueUserName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class UserCreateDTO {


    @NotNull(message = "{backend2.constraints.username.NotNull.message}")
    @Size(min = 2,max = 32,message = "{backend2.constraints.username.Size.message}")
    @UniqueUserName
    private String userName;

    @NotNull(message = "{backend2.constraints.firstname.NotNull.message}")
    @Size(min = 2,max = 32,message = "{backend2.constraints.firstname.Size.message}")
    private String firstName;
    @NotNull(message = "{backend2.constraints.lastname.NotNull.message}")
    @Size(min = 3,max = 16,message = "{backend2.constraints.lastname.Size.message}")
    private String  lastName;
}
