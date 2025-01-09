package com.example.MaiLinhGroup.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class AuthResponse {
    private String userId;
    private String token;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // Định dạng ngày tháng
    private LocalDateTime createdDate;

}
