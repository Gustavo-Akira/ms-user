package br.com.gustavoakira.ms.user.adapters.outbound.persistence;

import br.com.gustavoakira.ms.user.adapters.outbound.persistence.entities.UserEntity;
import br.com.gustavoakira.ms.user.application.domain.PageInformation;
import br.com.gustavoakira.ms.user.application.domain.User;
import br.com.gustavoakira.ms.user.application.port.UserRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserRepository implements UserRepositoryPort {

    private final SpringDataUserRepository repository;

    private final ModelMapper mapper;

    public UserRepository(SpringDataUserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User insert(User user) {
        return mapper.map(repository.save(mapper.map(user, UserEntity.class)),User.class);
    }

    @Override
    public User update(UUID id, User user) {
        this.repository.findById(id).orElseThrow();
        user.setId(id);
        return mapper.map(this.repository.save(mapper.map(user,UserEntity.class)),User.class);
    }

    @Override
    public User getUser(UUID id) {
        return this.repository.findById(id).map(entity->{
            if(entity != null){
                return mapper.map(entity,User.class);
            }else{
                return  null;
            }
        }).get();
    }

    @Override
    public Page<User> getUsers(PageInformation information) {
        return repository.findAll(PageRequest.of(information.getActualPage(),information.getPageSize())).map(userEntity -> mapper.map(userEntity,User.class));
    }

    @Override
    public void removeUser(UUID id) {
        this.repository.findById(id).orElseThrow();
        this.repository.deleteById(id);
    }
}
