package br.com.gustavoakira.ms.user.application.service;

import br.com.gustavoakira.ms.user.application.domain.PageInformation;
import br.com.gustavoakira.ms.user.application.domain.User;
import br.com.gustavoakira.ms.user.application.port.UserRepositoryPort;
import br.com.gustavoakira.ms.user.application.port.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserServicePort {

    @Autowired
    private UserRepositoryPort port;

    @Override
    public User insert(User user) {
        return port.insert(user);
    }

    @Override
    public User update(UUID id, User user) {
        return port.update(id,user);
    }

    @Override
    public User getUser(UUID id) {
        return port.getUser(id);
    }

    @Override
    public Page<User> getUsers(PageInformation information) {
        return port.getUsers(information);
    }

    @Override
    public void removeUser(UUID id) {
        port.removeUser(id);
    }
}
