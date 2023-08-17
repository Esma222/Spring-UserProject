package com.esmabeydili.backend2.service;

import com.esmabeydili.backend2.dto.UserCreateDTO;
import com.esmabeydili.backend2.dto.UserUpdateDTO;
import com.esmabeydili.backend2.dto.UserViewDTO;
import com.esmabeydili.backend2.exception.NotFoundException;
import com.esmabeydili.backend2.model.User;
import com.esmabeydili.backend2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {
       final User user= userRepository.findById(id).orElseThrow(() -> new NotFoundException("not found exception!"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {

        //databaseden tüm kullanıcıları al
        //steram aracını kullanarak
        // map ile streamden gelen her kullanıcıyı of methoduyla UserViewDTO nesnesine çevir
        // collect ve Collectors.toList ile UserViewDTO nesnelerinin tamamını bir listeye at
        // ve o listeyi döndür
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save
                (new User(userCreateDTO.getUserName(),userCreateDTO.getFirstName(),userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user= userRepository.findById(id).orElseThrow(() -> new NotFoundException("not found exception!"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setSecondName(userUpdateDTO.getLastName());

        final User updatedUser= userRepository.save(user);
        return UserViewDTO.of(updatedUser);
    }

    @Override
    public UserViewDTO deleteUser(Long id) {
        final User user= userRepository.findById(id).orElseThrow(() -> new NotFoundException("not found exception!"));
         userRepository.deleteById(user.getId());
         return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> slice(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
    }


}
