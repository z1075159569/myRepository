package com.itmuch.cloud.FeignInterface;

import com.itmuch.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservcie-provider-user",url="http://localhost:8000/",
                fallbackFactory = UserFeignClient.FeignClientFallBackFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @Component
    class FeignClientFallBackFactory implements FallbackFactory<UserFeignClient> {

        private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallBackFactory.class);

        @Override
        public UserFeignClient create(Throwable cause) {
            return new UserFeignClient() {
                @Override
                public User findById(Long id) {
                    FeignClientFallBackFactory.LOGGER.info("fallback;reason was:",cause);
                    User user = new User();
                    user.setId(-1L);
                    user.setUsername("默认用户");
                    return user;
                }
            };
        }
    }
}
