package com.luisgomezcaballero.dockerdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luisgomezcaballero.dockerdemo.model.MyEntity;
import com.luisgomezcaballero.dockerdemo.service.MyService;

@RestController
@RequestMapping("/dockerdemo")
public class MainController {

	@Autowired
	MyService myService;

	@RequestMapping(value = "/myentity/", method = RequestMethod.GET)
	public ResponseEntity<List<MyEntity>> readAllEntities() {
		return new ResponseEntity<List<MyEntity>>(myService.readAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/myentity/{id}", method = RequestMethod.GET)
	public ResponseEntity<MyEntity> readEntityById(@PathVariable("id") long id) {
		MyEntity myEntityResult = myService.readById(id);
		return new ResponseEntity<MyEntity>(myEntityResult, HttpStatus.OK);
	}

	@RequestMapping(value = "/myentity/", method = RequestMethod.POST)
	public ResponseEntity<MyEntity> createEntity(@RequestBody MyEntity myEntity) {
		myService.create(myEntity);
		return new ResponseEntity<MyEntity>(myEntity, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/myentity/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MyEntity> updateEntity(@PathVariable("id") long id, @RequestBody MyEntity myEntity) {
		myService.update(id, myEntity);
		return new ResponseEntity<MyEntity>(myEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/myentity/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MyEntity> deleteEntityById(@PathVariable("id") long id) {
		myService.deleteById(id);
		return new ResponseEntity<MyEntity>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/myentity/", method = RequestMethod.DELETE)
	public ResponseEntity<MyEntity> deleteAllEntities() {
		myService.deleteAll();
		return new ResponseEntity<MyEntity>(HttpStatus.NO_CONTENT);

	}
}
