package Entity;

import Exceptional.OrderAlreadyFulfilled;
import Exceptional.OrderNotFound;

import java.util.List;
import java.util.Map;

public interface OnlineShoppingInterface {
    boolean addOrder(Order order);
    boolean cancelOrder(long orderId) throws OrderNotFound;
    boolean cancelItem(long orderId, long itemId) throws OrderNotFound;
    boolean fulfillOrder(long orderId) throws OrderAlreadyFulfilled;
    Map<Integer, Integer> getStockDetails();
    List<Order> listOrderByPrice(String status);
}
