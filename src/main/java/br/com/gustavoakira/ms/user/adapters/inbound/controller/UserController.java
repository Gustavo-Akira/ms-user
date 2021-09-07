package br.com.gustavoakira.ms.user.adapters.inbound.controller;

import br.com.gustavoakira.ms.user.application.port.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServicePort port;
}
