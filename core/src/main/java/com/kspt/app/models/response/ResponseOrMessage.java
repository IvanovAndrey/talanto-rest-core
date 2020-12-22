package com.kspt.app.models.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ResponseOrMessage <T> extends ApiResult {
    T body;

    public ResponseOrMessage(T body) {
        this.body = body;
    }

    public ResponseOrMessage(String error){
        this.message = error;
    }
}
