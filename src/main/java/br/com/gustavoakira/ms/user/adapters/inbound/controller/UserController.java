package br.com.gustavoakira.ms.user.adapters.inbound.controller;

import br.com.gustavoakira.ms.user.adapters.dto.UserDto;
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
    public Page<User> users(){
        return port.getUsers(new PageInformation(5,0));
    }

    @GetMapping("users/{page}")
    public Page<User> users(@PathVariable Integer page){
        return port.getUsers(new PageInformation(5,page));
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable UUID id){
        return port.getUser(id);
    }

    @PostMapping("user")
    public User saveUser(@RequestBody @Valid UserDto dto){
        return port.insert(mapper.map(dto,User.class));
    }

    @PutMapping("user/{id}")
    public User updateUser(@RequestBody @Valid UserUpdateDto dto, @PathVariable UUID id){
        return port.update(id, mapper.map(dto,User.class));
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable UUID id){
        port.removeUser(id);
        return ResponseEntity.ok().build();
    }

}
