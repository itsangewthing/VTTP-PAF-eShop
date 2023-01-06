package vttp2022.paf.assessment.eshop.respositories;


public class Queries {
     
    public static final String SQL_SEARCH_CUSTOMER_BY_NAME = "select name, address, email";

    public static final String SQL_SEARCH_ALL_ORDERS_BY_NAME = "select name, address, email, orderId, deliveryId, status, orderDate";

}