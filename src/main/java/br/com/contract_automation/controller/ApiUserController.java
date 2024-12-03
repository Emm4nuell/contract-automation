package br.com.contract_automation.controller;

import br.com.contract_automation.dto.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user/")
public interface ApiUserController {

    @PostMapping("create")
    ResponseEntity<Void> create(@RequestBody @Valid UserRequest request);
}
