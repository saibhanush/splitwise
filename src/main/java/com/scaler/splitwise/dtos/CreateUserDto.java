package com.scaler.splitwise.dtos;

import com.scaler.splitwise.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateUserDto {
    private String name ;

    private String phoneNumber;

    private String hashedPassword;

    public User user(String hashedPassword){
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setHashedPassword(hashedPassword);
        return user;
    }


}
