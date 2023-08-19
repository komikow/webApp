package by.komikow.service.serviceInterface;

import by.komikow.entity.Basket;

import java.util.List;
import java.util.Map;

public interface BasketService {
    public void createBasket(Map<Integer, Integer> shopMap, int customerId);
    public List<Basket> readBasket();
    public void updateIdCustomerOfBasket(int id, int newCustomer);
    public void deleteBasket(int basketId);
}
