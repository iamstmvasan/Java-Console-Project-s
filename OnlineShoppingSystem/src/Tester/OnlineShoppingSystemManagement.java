package Tester;

import Entity.*;
import Exceptional.OrderAlreadyFulfilled;
import Exceptional.OrderNotFound;
import Service.OnlineShoppingSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OnlineShoppingSystemManagement {
    public static void main(String[] args) {

        OnlineShoppingSystem shoppingSystem = new OnlineShoppingSystem();

        Customer c1 = new Privilege(
                "Thiru",
                new Date(1999, 01, 19),
                "Male",
                "101",
                "TNJ",
                "7200*****3",
                "s.t.********.com",
                20.0);

        Customer c2 = new Privilege(
                "Vijay",
                new Date(1998, 12, 9),
                "Male",
                "102",
                "PKT",
                "9003******",
                "Vijay********.com",
                15.0);

        Customer c3 = new Privilege(
                "Ragav",
                new Date(1999, 9, 20),
                "Male",
                "103",
                "AMPT",
                "9876*****3",
                "rags********.com",
                10.0);

        Customer c4 = new ValueAdd(
                "Viji",
                new Date(1978, 05, 22),
                "Female",
                "104",
                "TNJ",
                "9655*****3",
                "viji********.com",
                200);

        Customer c5 = new ValueAdd(
                "Saru",
                new Date(2001, 8, 31),
                "Female",
                "105",
                "TNJ",
                "9600*****3",
                "saru********.com",
                15000);

        Item i1 = new Item(501, "Mobile", 12999.0);
        Item i2 = new Item(502, "Laptop", 72999.0);
        Item i3 = new Item(503, "Watch", 1999.0);
        Item i4 = new Item(504, "Camera", 120999.0);
        Item i5 = new Item(505, "Shoe", 2999.0);
        Item i6 = new Item(506, "Bag", 999.0);
        Item i7 = new Item(507, "Cooling glass", 999.0);
        Item i8 = new Item(508, "Perfume", 499.0);
        Item i9 = new Item(509, "Charger", 699.0);
        Item i10 = new Item(510, "Power bank", 1999.0);
        Item i11 = new Item(511, "Hand bag", 2499.0);
        Item i12 = new Item(512, "Mixie", 5499.0);

        List<Item> itemList = new ArrayList<>();
        itemList.add(i1);
        itemList.add(i9);
        itemList.add(i10);

        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(i2);
        itemList1.add(i6);

        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(i4);
        itemList2.add(i8);

        List<Item> itemList3 = new ArrayList<>();
        itemList3.add(i3);
        itemList3.add(i5);
        itemList3.add(i7);

        List<Item> itemList4 = new ArrayList<>();
        itemList4.add(i11);
        itemList4.add(i12);


        Order order1 = new Order(11, new Date(2021, 1, 15), "available", c1, itemList );
        Order order2 = new Order(12, new Date(2021, 2, 16), "available", c3, itemList1 );
        Order order3 = new Order(13, new Date(2021, 2, 17), "fulfilled", c5, itemList2 );
        Order order4 = new Order(14, new Date(2021, 3, 18), "available", c2, itemList3 );
        Order order5 = new Order(15, new Date(2021, 4, 19), "available", c4, itemList4 );

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        shoppingSystem.setOrderList(orders);

        System.out.println("Order Added ? "+shoppingSystem.addOrder(order5));
        shoppingSystem.disp();
        System.out.println("--------------------------------------------------\n--------------------------------------------------");
        try {
            System.out.println("Order Cancel ? "+shoppingSystem.cancelOrder(12));
        }catch (OrderNotFound o){
            System.out.println("Order Cancel ? "+o);
        }
        shoppingSystem.disp();
        System.out.println("--------------------------------------------------\n--------------------------------------------------");
        try {
            System.out.println("Item Cancel ? "+shoppingSystem.cancelItem(11, 510 ));
        }catch (OrderNotFound o){
            System.out.println("Item Cancel ? "+o);
        }
        shoppingSystem.disp();
        System.out.println("--------------------------------------------------\n--------------------------------------------------");

        try{
            System.out.println("Order FulFilled ? "+shoppingSystem.fulfillOrder(11));
        }catch (OrderAlreadyFulfilled o){
            System.out.println("Order FulFilled ? "+o);
        }
        shoppingSystem.disp();
        System.out.println("--------------------------------------------------\n--------------------------------------------------");
        System.out.println(shoppingSystem.listOrderByPrice("fulfilled"));












    }
}
