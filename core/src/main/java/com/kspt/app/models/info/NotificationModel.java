package com.kspt.app.models.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class NotificationModel {
    private Long id;
    private Long id_from;
    private Long id_to;
    private String status;
    private String theme;
    private String text;
}
