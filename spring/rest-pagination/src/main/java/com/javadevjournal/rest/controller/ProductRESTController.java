package com.javadevjournal.rest.controller;

import com.javadevjournal.rest.entity.ProductEntity;
import com.javadevjournal.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class ProductRESTController {

    @Autowired
    private ProductService productService;

    @Autowired private EntityLinks links;

    @GetMapping(value = "/products",produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResources<ProductEntity>> AllProducts(Pageable pageable, PagedResourcesAssembler assembler){
        Page<ProductEntity> products = productService.findAllProducts(pageable);
        PagedResources<ProductEntity> pr= assembler.toResource(products,linkTo(ProductRESTController.class).slash("/products").withSelfRel());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Link",createLinkHeader(pr));
        return new ResponseEntity<>(assembler.toResource(products,linkTo(ProductRESTController.class).slash("/products").withSelfRel()),responseHeaders,HttpStatus.OK);
    }

    private String createLinkHeader(PagedResources<ProductEntity> pr){
        final StringBuilder linkHeader = new StringBuilder();
        linkHeader.append(buildLinkHeader(  pr.getLinks("first").get(0).getHref(),"first"));
        linkHeader.append(", ");
        linkHeader.append(buildLinkHeader( pr.getLinks("next").get(0).getHref(),"next"));
        return linkHeader.toString();
    }

    public static String buildLinkHeader(final String uri, final String rel) {
        return "<" + uri + ">; rel=\"" + rel + "\"";
    }
}
