package com.ct.bsd.test;

import io.netty.util.internal.ObjectUtil;
import org.springframework.util.ObjectUtils;

import java.util.Objects;
import java.util.Optional;

/**
 * 类的注释
 *
 * @Package com.ct.bsd.test
 * @ClassName CommonTest
 * @Description
 * @Author liyuzhi
 * @Date 2019-03-12 16:57
 */

public class CommonTest extends AbstractCommon<CommonTestEntity, String> {


    @Override
    String start(CommonTestEntity entity) {
        if (Objects.nonNull(entity)) {
            return "";
        }
        return "";
    }
}
