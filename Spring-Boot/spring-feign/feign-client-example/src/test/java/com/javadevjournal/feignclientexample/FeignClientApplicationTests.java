package com.javadevjournal.feignclientexample;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.javadevjournal.feignclientexample.errors.ProductNotFoundException;

@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
public class FeignClientApplicationTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProductServiceClient productServiceClient;


  @Test
  public void shouldReturnListOfProducts_whenFetchProductsCalled() throws Exception {

    List<Product> products = new ArrayList<Product>();
    products.add(new Product(1, "product-1", 12.0));
    products.add(new Product(2, "product-2", 22.0));
    given(productServiceClient.getAllProducts()).willReturn(products);
    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/fetchProducts");

    mvc.perform(builder).andExpect(status().isOk());
  }

  @Test
  public void shouldReturnProduct_whenvalidProductIdIsPassed() throws Exception {

    Product product = new Product(1, "product-1", 12.0);
    given(productServiceClient.getProduct(1)).willReturn(product);
    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/fetchProduct/" + 1);

    mvc.perform(builder).andExpect(status().isOk());
  }

  @Test
  public void shouldThrowException_whenInvalidProductIdPassed() throws Exception {

    given(productServiceClient.getProduct(2))
        .willThrow(new ProductNotFoundException("Id not found"));
    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/fetchProduct/" + 2);

    mvc.perform(builder).andExpect(status().isNotFound());
  }

}
