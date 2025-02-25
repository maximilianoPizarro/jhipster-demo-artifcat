package com.mycompany.myapp.web.rest.vm;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * View Model object for storing a user's credentials.
 */
@RegisterForReflection
public class LoginVM {

    @NotNull
    @Size(min = 1, max = 50)
    public String username;

    @NotNull
    @Size(min = 4, max = 100)
    public String password;

    public Boolean rememberMe;

    @Override
    public String toString() {
        return "LoginVM{" + "username='" + username + '\'' + ", rememberMe=" + rememberMe + '}';
    }
}
