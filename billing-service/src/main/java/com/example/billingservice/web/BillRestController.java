package com.example.billingservice.web;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.feign.CustomerServiceRestClient;
import com.example.billingservice.feign.InventoryServiceRestClient;
import com.example.billingservice.model.Customer;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerServiceRestClient customerServiceRestClient;
    private InventoryServiceRestClient inventoryServiceRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerServiceRestClient customerServiceRestClient, InventoryServiceRestClient inventoryServiceRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerServiceRestClient = customerServiceRestClient;
        this.inventoryServiceRestClient = inventoryServiceRestClient;
    }

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id)
    {
        Bill bill =billRepository.findById(id).get();
        Customer customer=customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi->
        {pi.setProduct(inventoryServiceRestClient.getProduct(pi.getProductId()));});
        return bill;
    }
}

