package ru.bikbaev.microservice_2.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bikbaev.microservice_2.model.Order;
import ru.bikbaev.microservice_2.service.PurchaseOrder;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class OrderController {
    private PurchaseOrder purchaseOrder ;

    public OrderController(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }


    @GetMapping("/")
    public String home(){
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String order(Model model) {
        List<Order> orders = purchaseOrder.creatPurchaseOrder();
        model.addAttribute("orders", orders);
        purchaseOrder.creat(orders);
        return "orders";
    }

    /**
     * Эндпойнт для скачивания файла Order.xls
     *
     * @return
     * @throws IOException
     */
    @GetMapping("/orders/download")
    public ResponseEntity<Resource> downloadOrder() throws IOException {
        String filePath = "/Users/arturbikbaev/Desktop/java/spring_hw_9/microservice_2/src/main/resources/static/document/order.xls";
        Path path = Paths.get(filePath);

        byte[] data = Files.readAllBytes(path);

        ByteArrayResource resource = new ByteArrayResource(data);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "order.xls");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(data.length)
                .body(resource);
    }

}
