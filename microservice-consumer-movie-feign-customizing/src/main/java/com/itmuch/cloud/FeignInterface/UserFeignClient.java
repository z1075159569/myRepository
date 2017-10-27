package com.itmuch.cloud.FeignInterface;

import com.itmuch.cloud.config.FeignConfiguration;
import com.itmuch.cloud.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    User findById(@PathVariable("id") Long id);

    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
