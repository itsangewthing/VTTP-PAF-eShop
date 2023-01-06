package vttp2022.paf.assessment.eshop.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

// DO NOT CHANGE THIS CLASS
public class LineItem {

	private String item;
	private Integer quantity;

	public String getItem() { return this.item; }
	public void setItem(String item) { this.item = item; }

	public Integer getQuantity() { return this.quantity; }
	public void setQuantity(Integer quantity) { this.quantity = quantity; }

		public static LineItem create(SqlRowSet rs){
			LineItem li = new LineItem();
			li.setItem(rs.getString("item"));
			li.setQuantity(rs.getInt("quantity"));
			return li;
		}

}
