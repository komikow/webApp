package by.komikow.service.serviceImplementation;

import by.komikow.entity.Customer;
import by.komikow.repositorie.CustomerRepository;
import by.komikow.service.serviceInterface.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void createCustomer(String name, String email) {
        customerRepository.createCustomer(name, email);
    }

    @Override
    public List<Customer> readCustomers() {
        return customerRepository.readCustomers();
    }

    @Override
    public void updateEmailOfCustomer(int id, String newEmail) {
        customerRepository.updateEmailOfCustomer(id, newEmail);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }
}
