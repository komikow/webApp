package by.komikow.service.serviceImplementation;

import by.komikow.entity.Basket;
import by.komikow.repositorie.BasketRepository;
import by.komikow.service.serviceInterface.BasketService;

import java.util.List;
import java.util.Map;

public class BasketServiceImpl implements BasketService {
    private BasketRepository basketRepository = new BasketRepository();

    @Override
    public void createBasket(Map<Integer, Integer> shopMap, int customerId) {
        basketRepository.createBasket(shopMap, customerId);
    }

    @Override
    public List<Basket> readBasket() {
        return basketRepository.readBasket();
    }

    @Override
    public void updateIdCustomerOfBasket(int id, int newCustomer) {
        basketRepository.updateIdCustomerOfBasket(id, newCustomer);
    }

    public void deleteBasket(int basketId) {
        basketRepository.deleteBasket(basketId);
    }

}
