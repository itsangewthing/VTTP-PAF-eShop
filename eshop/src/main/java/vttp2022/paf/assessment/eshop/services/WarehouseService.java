package vttp2022.paf.assessment.eshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.models.OrderStatus;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;

@Service
public class WarehouseService {

	@Autowired
	private OrderRepository oRepo;
	private CustomerRepository cRepo;
	
	// You cannot change the method's signature
	// You may add one or more checked exceptions
	public OrderStatus dispatch(Order order) {
		return null;
		
		// TODO: Task 4

	}

    public Customer getCustomerName(String name) {
        return cRepo.findCustomerByName(name);
    }


	public List<LineItem> getCustomerOrder(String name){
		Optional<List<LineItem>> orderListOps = oRepo.getOrdersFromRepo(name); 
		return orderListOps.get();
	}

    public Object findCustomerByName(String name) {
        return null;
    }
}
