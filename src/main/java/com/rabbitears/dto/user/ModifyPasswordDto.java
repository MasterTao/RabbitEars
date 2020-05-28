package com.rabbitears.dto.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ModifyPasswordDto {
    private String oldPassword;
    private String newPassword;
}
