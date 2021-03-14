package Service;

import Entity.*;
import Exceptional.OrderAlreadyFulfilled;
import Exceptional.OrderNotFound;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OnlineShoppingSystem implements OnlineShoppingInterface {
    List<Order> orderList = new ArrayList<>();
    List<Supplier> supplierList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        for(Order order : orderList)
            this.orderList.add(setAmountForOrder(order));

    }

    public List<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(List<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

    @Override
    public boolean addOrder(Order order) {
        List<Order> orders =  orderList.stream().filter(i -> i.getOrderId() == order.getOrderId()).collect(Collectors.toList());
        if(!orders.isEmpty())
            return false;
        Order order1 = setAmountForOrder(order);
        order1.setOrderStatus("In-Progress");
        orderList.add(order1);
        return true;
    }

    @Override
    public boolean cancelOrder(long orderId) throws OrderNotFound {
        List<Order> orders =  orderList.stream().filter(i -> i.getOrderId() == orderId).collect(Collectors.toList());
        if( orders.isEmpty() )
            throw new OrderNotFound("Given order Id is not available !");
        Order order = orders.get(0);
        if(order.getOrderStatus().equalsIgnoreCase("FulFilled"))
            return false;
        orderList.remove(orders.get(0));
        return true;
    }

    @Override
    public boolean cancelItem(long orderId, long itemId) throws OrderNotFound {
        List<Order> orders =  orderList.stream().filter(i -> i.getOrderId() == orderId).collect(Collectors.toList());
        if( orders.isEmpty() )
            throw new OrderNotFound("Given order Id is not available !");
        Order order = orders.get(0);
        List<Item> items = orders.get(0).getItemList().stream().filter(i -> i.getItemId() == itemId).collect(Collectors.toList());
        if(items.isEmpty())
            return false;
        Item item = items.get(0);
        order.getItemList().remove(item);
        order = setAmountForOrder(order);
        return true;
    }

    @Override
    public boolean fulfillOrder(long orderId) throws OrderAlreadyFulfilled {
        List<Order> orders =  orderList.stream().filter(i -> i.getOrderId() == orderId).collect(Collectors.toList());
        if( orders.isEmpty() )
            return false;
        Order order = orders.get(0);
        if( order.getOrderStatus().equalsIgnoreCase("FulFilled") )
            throw new OrderAlreadyFulfilled("Given order Id is Already Ful Filled !");


        order.setOrderStatus("Fulfilled");

        return true;

    }

    @Override
    public Map<Integer, Integer> getStockDetails() {
        return null;
    }

    @Override
    public List<Order> listOrderByPrice(String status) {
        List<Order> orders = orderList.stream().filter(i -> i.getOrderStatus().equalsIgnoreCase(status)).collect(Collectors.toList());
        orders.sort((h1, h2) -> ( (int)h2.getAmountAfterDiscount() ) - ( ( (int)h1.getAmountAfterDiscount() )));

        return orders;
    }

    private Order setAmountForOrder(Order order){

        order.setOrderAmount( order.getItemList().stream().mapToDouble(i -> i.getPrice()).sum());
        if( order.getCustomer() instanceof  Privilege)
            order.setAmountAfterDiscount(order.getOrderAmount() - order.getOrderAmount() * ((Privilege) order.getCustomer()).getDiscountPercent() / 100);
        else{
            if ( order.getOrderAmount() >= 1000 && order.getOrderAmount() <= 2000)
                ((ValueAdd) order.getCustomer()).setBonusPoint(((ValueAdd) order.getCustomer()).getBonusPoint()+50);
            else if(order.getOrderAmount() > 2000 && order.getOrderAmount() <= 5000)
                ((ValueAdd) order.getCustomer()).setBonusPoint(((ValueAdd) order.getCustomer()).getBonusPoint()+100);
            else if(order.getOrderAmount() > 5000 && order.getOrderAmount() <= 10000)
                ((ValueAdd) order.getCustomer()).setBonusPoint(((ValueAdd) order.getCustomer()).getBonusPoint()+200);
            else
                ((ValueAdd) order.getCustomer()).setBonusPoint(((ValueAdd) order.getCustomer()).getBonusPoint()+300);

            long discountAmount = (long)order.getOrderAmount() * 10 / 100;

            if( discountAmount <= ((ValueAdd)order.getCustomer()).getBonusPoint() ){
                order.setAmountAfterDiscount( order.getOrderAmount() - discountAmount );
                ((ValueAdd) order.getCustomer()).setBonusPoint(((ValueAdd) order.getCustomer()).getBonusPoint() - discountAmount);
            }
            else
                order.setAmountAfterDiscount( order.getOrderAmount() );
        }
        return order;
    }
    public void disp(){
        orderList.stream().forEach(System.out::println);
    }
}
