package com.atzy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {

    private long id;
    private long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}
