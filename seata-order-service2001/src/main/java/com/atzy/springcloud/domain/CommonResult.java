package com.atzy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String msg;
    private T Data;


    public CommonResult(Integer code ,String msg){
        this(code,msg,null);
    }
}
