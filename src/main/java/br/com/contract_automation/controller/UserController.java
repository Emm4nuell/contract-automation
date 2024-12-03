package br.com.contract_automation.controller;

import br.com.contract_automation.dto.UserRequest;
import br.com.contract_automation.entity.UserEntity;
import br.com.contract_automation.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserController implements ApiUserController{

    private final IUserService userService;
    private final ObjectMapper mapper;

    @Override
    public ResponseEntity<Void> create(UserRequest request) {

        var user = userService.create(mapper.convertValue(request, UserEntity.class));

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
