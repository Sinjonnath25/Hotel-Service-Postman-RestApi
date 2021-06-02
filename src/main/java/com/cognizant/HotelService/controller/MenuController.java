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
public class MenuController {

   public static Map<Integer, MenuItem> menuItemList = new HashMap<>();
   static {
	   MenuItem p = new MenuItem();
	  p.setId(1);
      p.setName("Chicken Pizza");
      p.setPrice(250);
      menuItemList.put(p.getId(), p);
      MenuItem s = new MenuItem();
      s.setId(2);
      s.setName("Chicken Burger");
      s.setPrice(200);
      menuItemList.put(s.getId(), s);
   }
   
       @RequestMapping(value = "/menuitem")
      public ResponseEntity<Object> getProduct() {
         return new ResponseEntity<>(menuItemList.values(), HttpStatus.OK);
      }  
       
       @GetMapping("/menuitem/{id}")
       public ResponseEntity<Object> getById(@PathVariable("id") int id) {
    	   MenuItem p=menuItemList.get(id);
    	   return new ResponseEntity<Object>(p, HttpStatus.OK);
       }
       @RequestMapping(value = "/menuitem/{id}", method = RequestMethod.PUT)
       public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody MenuItem menuItem) { 
    	   menuItemList.remove(id);
    	   menuItem.setId(id);
    	   menuItemList.put(id, menuItem);
          return new ResponseEntity<>("Menu is updated successsfully", HttpStatus.OK); 
          }
       @PostMapping("/menuitem")
       public ResponseEntity<Object> createProduct(@RequestBody MenuItem menuItem) {
    	  menuItemList.put(menuItem.getId(), menuItem);
          return new ResponseEntity<>("Menu is added successfully", HttpStatus.CREATED);
       }
       
       @RequestMapping(value = "/menuitem/{id}", method = RequestMethod.DELETE)
       public ResponseEntity<Object> delete(@PathVariable("id") int id) 
       { 
    	   menuItemList.remove(id);
             return new ResponseEntity<>("Menu is deleted successsfully", HttpStatus.OK);  
        }
      
       
}


   