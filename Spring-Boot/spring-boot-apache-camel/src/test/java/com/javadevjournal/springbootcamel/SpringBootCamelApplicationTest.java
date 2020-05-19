package com.javadevjournal.springbootcamel;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootCamelApplicationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private CamelContext camelContext;

  @Test
  public void should_returnDiscounts() {
    NotifyBuilder notify = new NotifyBuilder(camelContext)
        .fromRoute("make-discount")
        .whenDone(1)
        .and()
        .fromRoute("list-discounted-products")
        .whenDone(1)
        .create();
    assertThat(notify.matches(8, TimeUnit.SECONDS)).isTrue();

    ResponseEntity<Discount> response = restTemplate
        .getForEntity("/javadevjournal/products/discounts/1", Discount.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    Discount discount = response.getBody();
    assertThat(discount).isNotNull();
    assertThat(discount.getId()).isEqualTo(1);
    assertThat(discount.getAmount()).isBetween(1, 100);
  }

  @Test
  public void should_returnProducts() {
    ResponseEntity<List<Product>> response = restTemplate.exchange("/javadevjournal/products",
        HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
        });

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    List<Product> books = response.getBody();

    assertThat(books).hasSize(3);
    assertThat(books).element(0)
        .hasFieldOrPropertyWithValue("name", "Book")
        .hasFieldOrPropertyWithValue("price", 25);
    assertThat(books).element(1)
        .hasFieldOrPropertyWithValue("name", "Watch")
        .hasFieldOrPropertyWithValue("price", 100);
    assertThat(books).element(2)
        .hasFieldOrPropertyWithValue("name", "Shoes")
        .hasFieldOrPropertyWithValue("price", 40);
  }
}
