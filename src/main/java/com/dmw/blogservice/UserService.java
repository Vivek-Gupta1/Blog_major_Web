package com.dmw.blogservice;


import com.dmw.model.LoginForm;
import com.dmw.model.RegisterM;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean saveUser(RegisterM registerM) ;
    boolean login(LoginForm loginForm);
}
