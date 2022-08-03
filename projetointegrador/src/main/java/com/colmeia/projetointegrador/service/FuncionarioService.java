package com.colmeia.projetointegrador.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colmeia.projetointegrador.dto.FuncionarioDTO;
import com.colmeia.projetointegrador.entity.Funcionario;
import com.colmeia.projetointegrador.exception.ResourceNotFoundException;
import com.colmeia.projetointegrador.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;
}