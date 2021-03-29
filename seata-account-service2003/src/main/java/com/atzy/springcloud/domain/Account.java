package com.atzy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private long id;
    private long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
