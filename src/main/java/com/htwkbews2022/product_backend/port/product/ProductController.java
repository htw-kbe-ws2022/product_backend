package com.htwkbews2022.product_backend.port.product;


import com.htwkbews2022.product_backend.core.domain.model.Product;
import com.htwkbews2022.product_backend.core.interfaces.ProductInterface;
import com.htwkbews2022.product_backend.port.data.ProductDTO;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductInterface productRepo;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("")
    public List<Product> getAllProducts(){
        log.info("getAllProducts");
        return productRepo.getProducts();
    }

    @GetMapping("/{uuid}")
    public Product getProduct(@PathVariable(value = "uuid")UUID uuid){
        return productRepo.getProduct(uuid);
    }


    @PatchMapping("/patch")
    public ProductDTO patchProduct(@RequestBody ProductDTO productDTO) {
        Product product = ControlerHelper.translateDto(productDTO);
        val updatedProduct = productRepo.updateProduct(product);
        return ControlerHelper.buildDTOfromProduct((updatedProduct));
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDTO productDTO) {
        Product product = ControlerHelper.translateDto(productDTO);
        productRepo.createProduct(product);
    }

    @PatchMapping("/increment/{uuid}/{count}")
    public int incrementProduct(@PathVariable(value = "uuid") UUID uuid, @PathVariable(value = "count") int count) {
        return productRepo.incrementProduct(uuid, count);
    }

    @PatchMapping("/decrement/{uuid}/{count}")
    public int dercementProduct(@PathVariable(value = "uuid") UUID uuid, @PathParam(value = "count") int count) {
        return productRepo.decrementProduct(uuid, count);
    }

    @PatchMapping("/addToCard/{uuid}/{count}")
    public boolean addProductToCard(@PathVariable(value = "uuid") UUID uuid, @PathParam(value = "count") int count) {
        return productRepo.addToCard(uuid, count);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody ProductDTO productDTO) {
        Product product = ControlerHelper.translateDto(productDTO);
        productRepo.deleteProduct(product);
    }


}