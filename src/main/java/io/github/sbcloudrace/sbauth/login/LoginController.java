package io.github.sbcloudrace.sbauth.login;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
@AllArgsConstructor
public class LoginController {

    private final SbUserServiceProxy sbUserServiceProxy;

    private final SbSessionServiceProxy sbSessionServiceProxy;

    @RequestMapping(value = "gamelogin", method = RequestMethod.POST)
    @ResponseBody
    public String gameLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            SbUser userByEmail = sbUserServiceProxy.getUserByEmail(email);
            if (password.equals(userByEmail.getPassword())) {
                String temporarySession = sbSessionServiceProxy.createTemporarySession(userByEmail.getUserId());
                return temporarySession + " " + userByEmail.getUserId();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "0";
    }
}
