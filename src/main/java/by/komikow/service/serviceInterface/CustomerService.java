package by.komikow.service.serviceInterface;

import by.komikow.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void createCustomer(String name, String email);

    public List<Customer> readCustomers();

    public void updateEmailOfCustomer(int id, String newEmail);

    public void deleteCustomer(int id);
}
