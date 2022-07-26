/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.demo_crud.controller;

import com.crud.demo_crud.except.ResourceNotFoundException;
import com.crud.demo_crud.model.Usuario;
import com.crud.demo_crud.repo.UsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Cruz
 */
@CrossOrigin(origins = "http://localhost:3000") // lo cruzazmos con donde este el frontend
@RestController
@RequestMapping("/api/v0.1/") //del servidor
public class UsuarioController {
    
    @Autowired
    private UsuarioRepo usuarioRepo; 
    
    //todos los usuarios
    
    @GetMapping ("/usuarios") // para levantar desde el front
    public List<Usuario> getUsers(){
    
        return usuarioRepo.findAll(); // metodo del jparepository
    
    }
    
    //crear usuario
    
    @PostMapping("/usuarios") // para recibir y clavar en el back
    public Usuario createUser(@RequestBody Usuario user ){
        return usuarioRepo.save(user); // metodo del repository.crud
    
    }
    
    //buscar por id
    @GetMapping ("/usuarios/{id}") // para levantar desde el front
    public ResponseEntity<Usuario> getUserById(@PathVariable Integer id){
    
        Usuario usuario = usuarioRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe "+ id));
        return ResponseEntity.ok(usuario); 
    
    }
    
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUser( @PathVariable Integer id, @RequestBody Usuario userIn){
        
        Usuario usuarioBuff = usuarioRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe "+ id));
        
        usuarioBuff.setNombre(userIn.getNombre());
        usuarioBuff.setApellido(userIn.getApellido());
        usuarioBuff.setEmail(userIn.getEmail());
        usuarioBuff.setEdad(userIn.getEdad());
        
        
        return (ResponseEntity.ok(usuarioRepo.save(usuarioBuff)));
        
    }
    
    
    
}
