package vttp2022.paf.assessment.eshop.respositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.models.OrderStatus;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class OrderRepository {
	// TODO: Task 3

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Object Order;

	public Optional<List<LineItem>> getOrdersFromRepo(String name){
		
		SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SEARCH_ALL_ORDERS_BY_NAME, Order);

		final List<LineItem> ordList = new LinkedList<>();

		while (rs.next()){
			ordList.add(Order.create(rs));
		}
		return Optional.of(ordList);
	}
}
