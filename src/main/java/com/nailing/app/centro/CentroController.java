/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nailing.app.centro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jaime
 */

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/centros")
public class CentroController {
    
    @Autowired
    private CentroService centroService;
    
    @GetMapping()
    public ResponseEntity<List<Centro>> findAll(){
	List<Centro> centros = centroService.findAll();
	return new ResponseEntity<List<Centro>>(centros, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCentro(@PathVariable Long id) {
	centroService.delete(id);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Centro> findById(@PathVariable Long id){
	return new ResponseEntity<Centro>(centroService.findById(id).get(), HttpStatus.OK);
    }
    
}
