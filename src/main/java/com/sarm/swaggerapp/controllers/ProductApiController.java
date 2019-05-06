package com.sarm.swaggerapp.controllers;

import com.sarm.swaggerapp.delegate.ProductApiDelegate;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

@Controller
public class ProductApiController implements ProductApi {

    private final ProductApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(ProductApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public ProductApiDelegate getDelegate() {
        return delegate;
    }
}
