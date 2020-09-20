package io.github.sbcloudrace.sbauth.login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SB-USER", path = "/sb-user")
public interface SbUserServiceProxy {

    @RequestMapping(value = "/sbusers/search/findByEmail", method = RequestMethod.GET)
    SbUser getUserByEmail(@RequestParam("email") String email);
}
