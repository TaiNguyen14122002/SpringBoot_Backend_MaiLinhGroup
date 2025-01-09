package com.example.MaiLinhGroup.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_SYS_LogMessage", schema = "dbo")
@Data
public class LogMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogId")
    private Long logId;

    @Column(name = "RecID")
    private String recID;

    @Column(name = "Log")
    private String log;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedDate")
    private LocalDateTime updatedDate;

    @Column(name = "UpdatedBy")
    private String updatedBy;
}
