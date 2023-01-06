package vttp2022.paf.assessment.eshop.respositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class CustomerRepository {

	@Autowired
		private JdbcTemplate jdbcTemplate;

	// You cannot change the method's signature


public Customer findCustomerByName(String name){
		// TODO: Task 3 
	final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SEARCH_CUSTOMER_BY_NAME, name);
	final List<Customer> custList = new LinkedList<>();
	
	while (rs.next()){
		custList.add(Customer.create(rs));
	}

	if (name == null) {
		return null;
	} else{
		return Optional.empty().orElse(HttpStatus.NOT_FOUND("error:" + "Customer ${customer_name} not found"));
	}
}

}