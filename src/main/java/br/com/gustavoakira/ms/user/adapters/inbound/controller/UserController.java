package br.com.gustavoakira.ms.user.adapters.inbound.controller;

import br.com.gustavoakira.ms.user.adapters.dto.UserDto;
import br.com.gustavoakira.ms.user.adapters.dto.UserReturn;
import br.com.gustavoakira.ms.user.adapters.dto.UserUpdateDto;
import br.com.gustavoakira.ms.user.application.domain.PageInformation;
import br.com.gustavoakira.ms.user.application.domain.User;
import br.com.gustavoakira.ms.user.application.port.UserServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserServicePort port;

    @Autowired
    public ModelMapper mapper;

    @GetMapping("users")
    public Page<UserReturn> users(){
        return port.getUsers(new PageInformation(5,0)).map(x->mapper.map(x,UserReturn.class));
    }

    @GetMapping("users/{page}")
    public Page<UserReturn> users(@PathVariable Integer page){
        return port.getUsers(new PageInformation(5,page)).map(x->mapper.map(x,UserReturn.class));
    }

    @GetMapping("user/{id}")
    public UserReturn getUser(@PathVariable UUID id){
        return mapper.map(port.getUser(id),UserReturn.class);
    }

    @PostMapping("user")
    public UserReturn saveUser(@RequestBody @Valid UserDto dto){
        return mapper.map(port.insert(mapper.map(dto,User.class)),UserReturn.class);
    }

    @PutMapping("user/{id}")
    public UserReturn updateUser(@RequestBody @Valid UserUpdateDto dto, @PathVariable UUID id){
        return mapper.map(port.update(id, mapper.map(dto,User.class)),UserReturn.class);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable UUID id){
        port.removeUser(id);
        return ResponseEntity.ok().build();
    }

}
