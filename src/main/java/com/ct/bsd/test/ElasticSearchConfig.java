package com.ct.bsd.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 类的注释
 *
 * @Package com.ct.bsd.common.es
 * @ClassName ElasticSearchConfig
 * @Description
 * @Author liyuzhi
 * @Date 2019-02-13 16:03
 */
@Configuration
//@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class ElasticSearchConfig {

    @Value("${elasticsearch.cluster.name}")
    private String cluserName;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.host}")
    private String host;

    @Bean
    public EsClientPool esClientPool() {
        return new EsClientPool(poolFactory());
    }

    @Bean
    public EsClientPoolObjectFactory poolFactory() {
        EsClientPoolObjectFactory poolFactory = new EsClientPoolObjectFactory();
        poolFactory.setCluserName(cluserName);
        poolFactory.setHost(host);
        poolFactory.setPort(port);
        return poolFactory;
    }

}
