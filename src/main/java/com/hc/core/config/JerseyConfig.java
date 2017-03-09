package com.hc.core.config;

import com.hc.system.admin.service.IUserService;
import com.hc.system.admin.service.impl.UserServiceImpl;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * author milk
 * createTime 2017/3/8.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    @Value("${spring.jersey.application-path}")
    private String apiPath;

    public JerseyConfig() {
        registerEndpoints();
    }

    @PostConstruct
    public void init(){
        this.configureSwagger();
    }

    private void registerEndpoints() {
        register(IUserService.class);
    }

    private void configureSwagger() {
        // Available at localhost:port/swagger.json
         this.register(ApiListingResource.class);
         this.register(SwaggerSerializers.class);
         BeanConfig config = new BeanConfig();
         config.setConfigId("milk-webservice-1.0");
         config.setTitle("milk平台API");
         config.setVersion("1.0");
//         config.setContact("milk");
         config.setSchemes(new String[] { "http", "https" });
         config.setBasePath(this.apiPath);
         config.setResourcePackage("com.hc");
         config.setPrettyPrint(true);
         config.setScan(true);
    }
}
