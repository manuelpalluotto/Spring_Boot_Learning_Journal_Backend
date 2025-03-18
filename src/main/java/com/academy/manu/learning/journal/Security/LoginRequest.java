package com.academy.manu.learning.journal.Security;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoginRequest {
    private String username;
    private String password;
}

