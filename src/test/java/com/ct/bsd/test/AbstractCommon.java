package com.ct.bsd.test;

import java.io.Serializable;

/**
 * 类的注释
 *
 * @Package com.ct.bsd.test
 * @ClassName AbstractCommon
 * @Description
 * @Author liyuzhi
 * @Date 2019-03-12 16:50
 */

public abstract class AbstractCommon<E extends CommenEntity, ID extends String> {

    abstract ID start(E entity);

    public ID invoker(E entity) {

        return start(entity);
    }
}
