package com.scaler.splitwise.dtos;

import com.scaler.splitwise.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetUserDto {
    private String name;
    private String phoneNumber;
    public static GetUserDto from(User user){
        return new GetUserDto(user.getName(),user.getPhoneNumber());

    }

}
