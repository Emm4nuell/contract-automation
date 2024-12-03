package br.com.contract_automation.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    ADMINISTRADOR(1, "ADMINISTRADOR"),
    GERENTE(1, "GERENTE"),
    ESTOQUISTA(1, "ESTOQUISTA"),
    VENDEDOR(1, "VENDEDOR");

    private int id;
    private String role;

    public static String roles(String value){
        if(value == null || value.isEmpty()){
            return VENDEDOR.getRole();
        }
        for (RoleEnum r : RoleEnum.values()) {
            if (r.getRole().equalsIgnoreCase(value)){
                return r.getRole();
            }
        }
        return VENDEDOR.getRole();
    }
}
