package com.login.UserLogin.controller;

import com.login.UserLogin.repositories.RoleRepository;
import com.login.UserLogin.service.UserDetailsServiceImpl;
import com.login.UserLogin.service.request.CreateUserDTO;
import com.login.UserLogin.models.ERole;
import com.login.UserLogin.models.RoleEntity;
import com.login.UserLogin.models.UserEntity;
import com.login.UserLogin.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PrincipalController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public List<UserEntity> listUsers(){
        return userDetailsService.getAllUsers();
    }

    @GetMapping("/helloSecured")
    public String helloSecured(){
        return "Hello World Secured";
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){

        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }
    @GetMapping("/roles")
    public List<RoleEntity> getRoles() {
      return roleRepository.findAll();
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "User deleted with ID: "+(id);
    }
}
