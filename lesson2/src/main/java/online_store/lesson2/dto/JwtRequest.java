package online_store.lesson2.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}