package com.scaler.splitwise.controllers;

import com.scaler.splitwise.dtos.CreateUserDto;
import com.scaler.splitwise.dtos.GetUserDto;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService service;
    @PostMapping("/user")
    public GetUserDto createUSer(@RequestBody CreateUserDto request){
        validate(request);
        User user =service.createUser(request);
        return toResponse(user);
    }

    private void validate(CreateUserDto request) {
        if (request.getHashedPassword()==null){
            throw new RuntimeException("Password not present");
        }
    }
    @GetMapping("/user/{id}")
    public GetUserDto getUser(@PathVariable Long id) {
        return toResponse(service.getUser(id));
    }

    @GetMapping("/users")
    public List<GetUserDto> getUsers() {
        return service.getUsers().stream().map(GetUserDto::from).collect(Collectors.toList());
    }

    private GetUserDto toResponse(User user) {
        if (user == null) {
            return null;
        }

        return GetUserDto.from(user);
    }
}
