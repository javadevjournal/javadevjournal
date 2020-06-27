package com.javadevjournal.springbootcamel;

import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

  private final DiscountRepository discounts;
  private final ProductService productService;

  private final Random random = new Random();

  @Autowired
  public DiscountService(DiscountRepository discounts,
      ProductService productService) {
    this.discounts = discounts;
    this.productService = productService;
  }

  public Discount makeDiscount() {
    // create a discount
    Discount discount = new Discount();
    int discountRate = this.random.nextInt(100);
    discount.setAmount(discountRate);

    // select random product
    int productId = this.random.nextInt(3) + 1;
    Product product = productService.findById(productId);

    // set discount to product and save
    int discountedPrice = product.getPrice() - (discountRate * product.getPrice() / 100);
    product.setDiscounted(discountedPrice);
    productService.save(product);

    discount.setProduct(product);
    return discount;
  }

  public Discount findDiscount(Integer id) {
    Optional<Discount> discount = discounts.findById(id);
    if (!discount.isPresent()) {
      throw new IllegalStateException("Discount could not found for given id:" + id);
    }
    return discount.get();
  }
}
