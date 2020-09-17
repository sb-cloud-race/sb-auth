package io.github.sbcloudrace.sbauth.login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sb-session", url = "localhost:8001", path = "/sb-session")
public interface SbSessionServiceProxy {

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    String createTemporarySession(@PathVariable("userId") long userId);

}
