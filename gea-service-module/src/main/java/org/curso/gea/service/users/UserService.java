package org.curso.gea.service.users;

import org.curso.gea.domain.users.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
}
