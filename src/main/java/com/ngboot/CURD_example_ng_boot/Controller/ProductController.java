package com.ngboot.CURD_example_ng_boot.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ngboot.CURD_example_ng_boot.model.Product;
import com.ngboot.CURD_example_ng_boot.repository.ProductRepository;

@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ArrayList<Product> getProducts() {
		return (ArrayList<Product>) productRepository.findAll();
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ResponseEntity<?> setProduct(@RequestBody Product product) {
		System.out.println("upp");
		boolean exist = false;
		System.out.println(product.toString());
		if (productRepository.equals(product)) {
			exist = true;
		} else if (exist == false) {
			productRepository.save(product);

		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/findproduct/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Product findProductById(@PathVariable int id) {
		return productRepository.findByproductId(id);

	}

	@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.GET)
	public Product deleteProductById(@PathVariable int id) {
		Product product = productRepository.findByproductId(id);
		productRepository.delete(id);
		return product;

	}

	@RequestMapping(value = "/bulkupload", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void bulkUpload(@RequestBody ArrayList<Product> products) {
		Iterable<Product> iProducts = products;
		productRepository.save(iProducts);
	}

}
