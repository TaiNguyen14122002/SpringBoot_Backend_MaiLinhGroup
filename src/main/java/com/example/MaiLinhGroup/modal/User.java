package com.example.MaiLinhGroup.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_SYS_User", schema = "dbo")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecID")
    private Long recId;

    @Column(name = "UserID")
    @JsonProperty("userId")  // Đảm bảo rằng trường này được chuyển thành JSON
    private String userId;

    @Column(name = "Password")
    @JsonProperty("password")
    private String password;

    @Column(name = "IsActive")
    @JsonProperty("isActive")
    private Boolean isActive;

    @Column(name = "CreatedDate")
    @JsonProperty("createdDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // Định dạng ngày tháng
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy")
    @JsonProperty("createdBy")
    private String createdBy;

    @Column(name = "UpdatedDate")
    @JsonProperty("updatedDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // Định dạng ngày tháng
    private LocalDateTime updatedDate;

    @Column(name = "UpdatedBy")
    @JsonProperty("updatedBy")
    private String updatedBy;
}


