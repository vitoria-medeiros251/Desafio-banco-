package com.picpaysimplificado.service;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.UserDto;
import com.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void ValidateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("usuario do tipo lojista nao esta autorizado a realizar transação");

        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("usuario nao tem saldo suficiente");
        }
    }
    public User findUserById(long id) {
        return this.repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario nao encontrado"));

    }

    public User createUser(UserDto data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;

    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }


    public void saveUser(User user){
        this.repository.save(user);

    }

}




