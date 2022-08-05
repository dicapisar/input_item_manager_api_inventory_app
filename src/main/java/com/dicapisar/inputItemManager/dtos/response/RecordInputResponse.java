package com.dicapisar.inputItemManager.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordInputResponse {
    private Long id;
    private boolean isActive;
    private String status;
    private String reason;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private Long creator;
}
