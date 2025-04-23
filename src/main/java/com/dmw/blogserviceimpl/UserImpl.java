package com.dmw.blogserviceimpl;

import com.dmw.blogentity.UserTable;
import com.dmw.blogrepository.UserRepository;
import com.dmw.blogservice.UserService;
import com.dmw.model.LoginForm;
import com.dmw.model.RegisterM;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean saveUser(RegisterM registerM) {
        Optional<UserTable> userbyEmail = userRepository.findByEmail(registerM.getEmail().trim().toLowerCase());
        if (userbyEmail.isPresent()) {
            return false;
        }
        UserTable userTable = new UserTable();
        BeanUtils.copyProperties(userTable, registerM);
        userRepository.save(userTable);
        return true;
    }

    @Override
    public boolean login(LoginForm loginForm) {
        Optional<UserTable> byEmail = userRepository.findByEmail(loginForm.getEmail());
        return byEmail.isPresent() && byEmail.get().getPwd().equals(loginForm.getPwd());
    }
}