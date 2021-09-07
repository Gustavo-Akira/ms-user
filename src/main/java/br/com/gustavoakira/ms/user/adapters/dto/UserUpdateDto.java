package br.com.gustavoakira.ms.user.adapters.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
public class UserUpdateDto {
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String name;
}
