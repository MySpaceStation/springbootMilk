package com.hc.core.config;

import com.hc.system.admin.service.impl.UserServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * author milk
 * createTime 2017/3/8.
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(UserServiceImpl.class);
    }
}
