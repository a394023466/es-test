package com.ct.bsd.test;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.elasticsearch.client.transport.TransportClient;

import java.io.Serializable;

/**
 * 类的注释
 *
 * @Package com.ct.bsd.common.es
 * @ClassName EsClientPool
 * @Description 获取ES连接的入口，该类就是一个对象池
 * @Author liyuzhi
 * @Date 2019-02-13 16:42
 */

public class EsClientPool extends GenericObjectPool<TransportClient>  implements Serializable {


    public EsClientPool(PooledObjectFactory<TransportClient> factory) {
        super(factory);
    }

    @Override
    public TransportClient borrowObject() throws Exception {
        return super.borrowObject();
    }

}
