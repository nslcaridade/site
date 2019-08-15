package br.com.caridade.service;

import br.com.caridade.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}