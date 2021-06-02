package com.cognizant.HotelService.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.HotelService.bean.MenuItem;
@RestController
public class CartController {
	
	 private static Map<Integer, MenuItem> cartItemList = new HashMap<>();
	 
	 @PostMapping("/cart/{id}")
     public ResponseEntity<Object> createProduct(@PathVariable("id") int id) {
		 MenuItem menuItem=MenuController.menuItemList.get(id);
		 cartItemList.put(menuItem.getId(), menuItem);
        return new ResponseEntity<>("Menu is added in cart successfully", HttpStatus.CREATED);
     }
     
	 @RequestMapping(value = "/cart")
     public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(cartItemList.values(), HttpStatus.OK);
     }  

}
