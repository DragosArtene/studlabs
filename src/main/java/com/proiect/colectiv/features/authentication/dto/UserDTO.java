package com.proiect.colectiv.features.authentication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    public String username;
    public String password;
    public String firstName;
    public String lastName;
    @Email
    public String email;
}
