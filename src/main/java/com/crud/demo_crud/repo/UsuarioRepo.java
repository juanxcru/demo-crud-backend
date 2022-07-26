/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.demo_crud.repo;
import com.crud.demo_crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Juan Cruz
 */
@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> { // Integer. no int. le pasamos la clase (tipo) de la tabla y el tipo del id (no primitivo)
    
    //Jparepository nos da los metodos heredados de pagingandsorting y crud (repo)
    
}
