package com.challenge.domus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.domus.beans.ResponseServices;
import com.challenge.domus.services.MoviesServices;

@RestController
@RequestMapping("/api/directors")
public class DomusController {

	@Autowired
	MoviesServices services;
	
	@GetMapping("/{threshold}")
	public ResponseEntity<ResponseServices> getDirectors(@PathVariable(name = "threshold") int threshold) {
		
		return ResponseEntity.ok().body(services.getDirectors(threshold));
		
		
	}

}
