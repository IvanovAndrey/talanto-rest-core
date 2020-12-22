package com.kspt.app.models.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class ComplaintModel {
    private Long id;
    private Long id_incedent;
    private String theme;
    private String text;
    }

