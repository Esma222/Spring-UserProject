package com.esmabeydili.backend2.api;

import com.esmabeydili.backend2.dto.UserCreateDTO;
import com.esmabeydili.backend2.dto.UserUpdateDTO;
import com.esmabeydili.backend2.dto.UserViewDTO;
import com.esmabeydili.backend2.service.UserService;
import com.esmabeydili.backend2.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;

    @GetMapping("v1/user/{userId}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long userId){
       final UserViewDTO user= userService.getUserById(userId);
       return ResponseEntity.ok(user);
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        final List<UserViewDTO> users= userService.getUsers();
        return ResponseEntity.ok(users);
    }

    //sayfalama işlemini başka yöntemlerle de yapabiliyoruz fakat bu işlem bütün dataya değil
    // belirlenen sınırlara göre sorgu attığı için daha performanslı çalışıyor diyebiliriz
    @GetMapping("v1/user/slice")
    public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable){
        final List<UserViewDTO> users= userService.slice(pageable);
        return ResponseEntity.ok(users);
    }

    @PostMapping("v1/user")//controller ın entity üzerinden çalışmasını istemiyoruz yeni class oluşturduk
    public ResponseEntity<?> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User created."));
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") Long id,@RequestBody UserUpdateDTO userUpdateDTO){
       final UserViewDTO user= userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User deleted."));
    }


}