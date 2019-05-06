package com.ct.bsd.test;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * 类的注释
 *
 * @Package com.ct.bsd.common.es
 * @ClassName EsClientPoolObjectFactory
 * @Description
 * @Author liyuzhi
 * @Date 2019-02-13 16:46
 */

public class EsClientPoolObjectFactory extends BasePooledObjectFactory<TransportClient> implements Serializable {

    private String cluserName;

    private int port;

    private String host;

    /**
     * @return org.elasticsearch.client.transport.TransportClient
     * @description 该方法是实现了BasePooledObjectFactory抽象类的实现方法，用于创建与ES的连接对象，该ES的连接对象是需要放在对象池里的
     * @methodName create
     * @Param:
     * @author liyuzhi
     * @createTime 2019-02-13 16:52
     * @version v1.0
     */
    @Override
    public TransportClient create() throws Exception {
        Settings settings = Settings.builder()
                .put("cluster.name", cluserName)
                .put("client.transport.sniff", true)
                .build();
        InetSocketTransportAddress master = new InetSocketTransportAddress(InetAddress.getByName(host)
                , port);

        return new PreBuiltTransportClient(settings).addTransportAddress(master);
    }

    /**
     * @return org.apache.commons.pool2.PooledObject<org.elasticsearch.client.transport.TransportClient>
     * @description 该方法用于将工厂创建出来的ES连接对象放入对象池里
     * @methodName wrap
     * @Param: obj：ES连接对象
     * @author liyuzhi
     * @createTime 2019-02-13 16:57
     * @version v1.0
     */
    @Override
    public PooledObject<TransportClient> wrap(TransportClient obj) {
        return new DefaultPooledObject<>(obj);
    }

    void setCluserName(String cluserName) {
        this.cluserName = cluserName;
    }

    void setPort(int port) {
        this.port = port;
    }

    void setHost(String host) {
        this.host = host;
    }
}
