package br.com.contract_automation.entity;

import br.com.contract_automation.enuns.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "cpf")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Name nao pode ser nulo")
    private String name;
    @NotNull(message = "Email nao pode ser nulo")
    @Email(message = "Email invalido")
    private String email;
    @NotNull(message = "Cpf nao pode ser nulo")
    @CPF(message = "Cpf invalido")
    private String cpf;
    @NotBlank(message = "Password nao pode ser nulo")
    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles = new HashSet<>();
}
