package com.javadevjournal.data;

import org.springframework.hateoas.ResourceSupport;

public class ProductReviews extends ResourceSupport {

    private String code;
    private String productCode;
    private double score;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
