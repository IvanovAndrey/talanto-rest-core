package com.kspt.app.models.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class RequestModel {
    private Long id;
    private String daysArr;
}
