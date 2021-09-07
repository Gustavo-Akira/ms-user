package br.com.gustavoakira.ms.user.application.port;

import br.com.gustavoakira.ms.user.application.domain.PageInformation;
import br.com.gustavoakira.ms.user.application.domain.User;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserRepositoryPort {
    User insert(User user);
    User update(UUID id, User user);
    User getUser(UUID id);
    Page<User> getUsers(PageInformation information);
    void removeUser(UUID id);
}
