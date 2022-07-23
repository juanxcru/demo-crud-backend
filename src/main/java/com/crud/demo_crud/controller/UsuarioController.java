/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.demo_crud.controller;

import com.crud.demo_crud.model.Usuario;
import com.crud.demo_crud.repo.UsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Cruz
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v0.1/")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepo usuarioRepo; 
    
    //todos los usuarios
    
    @GetMapping ("/usuarios")
    public List<Usuario> getAllUsers(){
    
        return usuarioRepo.findAll();
    
    }
    
    //crear usuario
    
    @PostMapping("/usuarios")
    public Usuario createUser(@RequestBody Usuario user ){
        return usuarioRepo.save(user);
    
    }
    
    
    
    
}
