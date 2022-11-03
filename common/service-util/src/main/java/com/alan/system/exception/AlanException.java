package com.alan.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.RuntimeErrorException;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/11/1 21:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlanException extends RuntimeException {

    private Integer code;
    private String msg;
}
