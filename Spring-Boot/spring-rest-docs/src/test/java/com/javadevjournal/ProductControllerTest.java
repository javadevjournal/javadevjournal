package com.javadevjournal;

import com.javadevjournal.controller.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import  org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnProductCode() throws Exception{
        this.mockMvc.perform(get("/products/2"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("WD SSD"))).andDo(document("product/get-product-by-id"));
    }

    @Test
    public void getProductById() throws Exception{
        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/products/{code}", 2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("WD SSD")))
                .andDo(document("product/get-product-by-id",pathParameters(parameterWithName("code").description("Product Unique Identifier"))));
    }

    @Test
    public void getProductByIdResponseFieldDocumentation() throws Exception{
        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/products/{code}", 2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("WD SSD")))
                .andDo(document("product/get-product-by-id",pathParameters(parameterWithName("code")
                        .description("Product Unique Identifier")),responseFields(
                                fieldWithPath("code").description("Product Unique Identifier"),
                                fieldWithPath("name").description("Name of the product"),
                                fieldWithPath("description").description("Product Description"),
                                fieldWithPath("price").description("Product Price"),fieldWithPath("stock").description("Product stock"))));
    }
}
