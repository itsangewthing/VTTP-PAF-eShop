package vttp2022.paf.assessment.eshop.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.services.WarehouseService;

@RestController
public class DispatchRESTController {
    @Autowired
    private WarehouseService wService;

     // A. SEARCHING GAMES BY NAME
     @GetMapping(path = "/disptach/{order_id}") // check if URL is working first
     public ResponseEntity<String> getAllOrders(@RequestParam(value ="limit", required = false, defaultValue = "25") Integer limit, @RequestParam(value ="offset", required = false, defaultValue = "0")  Integer offset){
    
 
         List<Order> ordList = wService.getOrdersByLimitOffset(limit, offset);
    

   
     // A. getting TIMESTAMP
 
         Date timestamp = new Date(); 
 
         //first return nothing
        // use return ResponseEntity.ok().build(); to check for error
        // third, after searching, it will return the list of games as requested
      
     
 
     // JSON ARRAY BUILDER <--- for GAMES: [<ARRAY OF GAMES]
      JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
     // FOR LOOP - TO LOOP THROUGH LIST OF GAMES
      for (Order o: ordList){
         // turn every game into a JSON o. 
         arrBuilder.add(o.toJSON());
      }
      // create array builder for the array of games
      JsonArray oArr = arrBuilder.build();
 
      // build JSON Object builder <-- for all the objects ------> everything in {    }
             // create JsonObjectBuilder
      JsonObjectBuilder job = Json.createObjectBuilder();
      // add the objects into the object builder
         job.add("orderId", orderId); 
         job.add("name", name);
         job.add("address", address);
         job.add("emailt", email);
         job.add("timestamp", timestamp.toString());
 
         // build object
         JsonObject finalObject = job.build();
 
         return ResponseEntity
             .status(HttpStatus.OK)
             .body(finalObject.toString());
     }
}
