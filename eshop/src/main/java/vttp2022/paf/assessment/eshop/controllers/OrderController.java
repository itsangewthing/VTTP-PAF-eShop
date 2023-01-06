package vttp2022.paf.assessment.eshop.controllers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.pattern.FormatInfo;
import jakarta.json.JsonArrayBuilder;
import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.services.WarehouseService;

@Controller
@RequestMapping(path="")
public class OrderController {
	
	@Autowired
	private WarehouseService wService;


	//TODO: Task 3
	@GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
public Customer getCustomer(@PathVariable String name) {
   
	return ((Object) wService.findCustomerByName(name))
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Customer Not Found."));


		}

	@PostMapping("/{name}/save")
	public String saveCustomerOrder(@PathVariable ("name" String name, 
			Model model,@RequestBody MultiValueMap<String, String> form)){
			
				Optional<Customer> custOps = wService.findCustomerByName(name);
				Customer c = custOps.get();
			List<Order> ordList = new LinkedList<>();
			OptionalInt formSize = form.values().stream().filter(Objects::nonNull).mapToInt(List::size).findAny();

		Optional<Customer> custOps = wService.findCustomerByName(name);
		Customer c = custOps.get();

		List<Map<String, String>> result = new LinkedList<>();
		OptionalInt formSize = form.values().stream().filter(Objects::nonNull).mapToInt(List::size).findAny();
		formSize.ifPresent(size -> {
			for (int i = 0; i < size; i++){
				int index = i ; 
				Map<String, String> o  = new HashMap<>();
				form.entrySet()	.stream()
								.filter(entry -> entry.getValue())
								.forEach((entry -> order.put(entry.getKey(), entry.getValue().get(index))));
								result.add(o);
			}
			final ObjectMapper maps = new ObjectMapper();
			for(int i = 0; i < result.size(), i++){
				LineItem li = mapper.convertValue(result.get(i), OrderList.class);
				ordList.add(li);
			}
		});

		try{
			wService.upsertOrders(ordList, c.getName());
		} catch(Exception e){
			model.addAttribute("errorMessage", e.getMessage());
			return "error";
		}
		
		List<Order> orderListAfterUpsert = wService.getCustomerOrder(c.getName());
		c.setOrderList(orderListAfterUpsert);

		model.addAttribute("name",c);
	

	return "saved";
	


}
}
