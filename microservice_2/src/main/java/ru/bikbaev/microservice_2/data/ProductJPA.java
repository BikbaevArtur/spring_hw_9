package ru.bikbaev.microservice_2.data;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.bikbaev.microservice_2.model.Product;

public interface ProductJPA extends JpaRepository<Product,Integer> {

}
