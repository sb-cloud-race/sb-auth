package io.github.sbcloudrace.sbauth.login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SB-SESSION", path = "/sb-session")
public interface SbSessionServiceProxy {

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    String createTemporarySession(@PathVariable("userId") long userId);

}
