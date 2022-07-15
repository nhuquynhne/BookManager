package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.NXBEntity;
import com.example.service.INXBService;

@RestController
@RequestMapping("/nxb")
public class NXBController {
	@Autowired
	private INXBService inxbService;
	
	//Test
		@GetMapping("/")
		public String test() {
			return "helloNXB";
		}
		
		//API add nxb
		@PostMapping("/")
		public NXBEntity addNXB(@RequestBody NXBEntity nxb) {
			return inxbService.addNXB(nxb);
		}
		
		//API update nxb
		@PutMapping("/{id}")
		public NXBEntity updateNXB(@PathVariable("id") String id, @RequestBody NXBEntity nxb) {
			return inxbService.updateNXB(id, nxb);
		}
		
		//API delete author
		@DeleteMapping("/{id}")
		public boolean delNXB(@PathVariable("id") String id) {
			return inxbService.delNXB(id);
		}
}
