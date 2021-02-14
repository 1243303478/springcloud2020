package com.atzy.springcloud.payment.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    Integer code;
    String message;
    T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
