package by.komikow.util;

import by.komikow.controller.*;

public class Main {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        ProductController productController = new ProductController();
        CustomerController customerController = new CustomerController();
        UnitController unitController = new UnitController();
        OrderController orderController = new OrderController();
        BasketController basketController = new BasketController();

//        System.out.println(orderController.findOrderByStatus(2));
//        productController.deleteProductById(9);
//        productController.updateQuantityOfProduct(5,10);
//        basketController.updateIdCustomerOfBasket(1,1);
//        System.out.println(basketController.readBasket());
//        basketController.deleteBasket(2);
//        System.out.println(orderController.readOrders());
//        LocalDate date = LocalDate.of(2023, 8, 2);
//        orderController.createOrder(date, 1, 1);

//        Map<Integer, Integer> shoppingMap = new HashMap<>();
//        shoppingMap.put(4, 1);
//        basketController.createBasket(shoppingMap, 1);
//        orderController.deleteOrderById(3);

//        unitController.createUnit("кг");
//        unitController.deleteUnitById(3);
//        LocalDate date = LocalDate.of(2023, 8, 2);
//        List<OrderResponse> orderByDate = orderController.findOrderByDate(date);
//        List<OrderResponse> orderResponses = orderController.findOrderByStatus(2);
//        for (OrderResponse orderResponse: orderByDate) {
//            System.out.println(orderResponse);
//        }
//        orderController.createOrder(date, 1, 6, 1, 3, 2);
//        productController.updatePriceOfProduct(1, BigDecimal.valueOf(19.4));
//        List<ProductResponse> productResponses = productController.readProducts();
//        for (ProductResponse productResponse: productResponses) {
//            System.out.println(productResponse);
//        }
//        productController.updateQuantityOfProduct(1, 17);
//        customerController.createCustomer("ООО \"Азбука кухни\"", "kitchen@gmail.com");
//        productController.createProduct("Масло моторное", "Mobil Super 3000 X1 5W-40 синтетическое 1л", BigDecimal.valueOf(43.9), 5, 2);

    }
}
