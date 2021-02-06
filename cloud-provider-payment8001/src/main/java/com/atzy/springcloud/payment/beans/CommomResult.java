package com.atzy.springcloud.payment.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommomResult<T> implements Serializable {
    Integer code;
    String message;
    T data;
}
