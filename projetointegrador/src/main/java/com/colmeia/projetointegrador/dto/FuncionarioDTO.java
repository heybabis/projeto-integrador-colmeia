package com.colmeia.projetointegrador.dto;

import java.io.Serializable;
import com.colmeia.projetointegrador.entity.Funcionario;

public class FuncionarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public Funcionario(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
