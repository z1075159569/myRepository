package com.itmuch.cloud.FeignInterface;

import com.itmuch.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservcie-provider-user",url="http://localhost:8000/",
        fallback = UserFeignClient.FeignClientFallback.class )
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);


    @Component
    class FeignClientFallback implements UserFeignClient {

        @Override
        public User findById(Long id) {
           User user = new User();
           user.setId(-1L);
           user.setUsername("默认用户");
           return user;
        }
    }
}
