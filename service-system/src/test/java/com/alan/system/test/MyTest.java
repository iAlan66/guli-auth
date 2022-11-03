package com.alan.system.test;

import com.alan.common.result.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/29 1:11
 */
@SpringBootTest
public class MyTest {

    @Test
    public void mytest() {
        Result<Object> ok = Result.ok();
        System.out.println(ok);
    }
}
