package com.esmabeydili.backend2.service;

import com.esmabeydili.backend2.dto.UserCreateDTO;
import com.esmabeydili.backend2.dto.UserUpdateDTO;
import com.esmabeydili.backend2.dto.UserViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserViewDTO getUserById(Long id);

    List<UserViewDTO> getUsers();

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    UserViewDTO deleteUser(Long id);

    List<UserViewDTO> slice(Pageable pageable);
}
