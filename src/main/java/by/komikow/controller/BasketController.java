package by.komikow.controller;

import by.komikow.entity.Basket;
import by.komikow.service.serviceImplementation.BasketServiceImpl;
import by.komikow.service.serviceInterface.BasketService;

import java.util.List;
import java.util.Map;

public class BasketController {
    private BasketService basketService = new BasketServiceImpl();

    public void createBasket(Map<Integer, Integer> shopMap, int customerId) {
        basketService.createBasket(shopMap, customerId);
    }
    public List<Basket> readBasket() {
        return basketService.readBasket();
    }

    public void updateIdCustomerOfBasket(int id, int newCustomer) {
        basketService.updateIdCustomerOfBasket(id, newCustomer);
    }

    public void deleteBasket(int basketId) {
        basketService.deleteBasket(basketId);
    }
}
