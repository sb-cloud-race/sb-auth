package io.github.sbcloudrace.sbauth.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SbUser implements Serializable {

    private String email;

    private String password;

    private Long userId;
}
