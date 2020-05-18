package com.rabbitears.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RegisterDto {
    @JsonProperty("userName")
    private String name;
    private String password;
    private String confirmPassword;
}
