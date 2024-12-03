package br.com.contract_automation.dto;

public record UserRequest(
        String name,
        String email,
        String cpf,
        String password) {
}
