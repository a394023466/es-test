package com.ct.bsd.test;

import java.io.Serializable;

/**
 * 类的注释
 *
 * @Package com.ct.bsd.test
 * @ClassName CommenEntity
 * @Description
 * @Author liyuzhi
 * @Date 2019-03-12 17:12
 */

public interface CommenEntity<ID> extends Serializable {


    void setId(ID id);

    ID getId();


}
