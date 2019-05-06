package com.sarm.swaggerapp.controllers;

import com.sarm.swaggerapp.delegate.IntegrationTestApiDelegate;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

@Controller
public class IntegrationTestApiController implements IntegrationTestApi {

    private final IntegrationTestApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public IntegrationTestApiController(IntegrationTestApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public IntegrationTestApiDelegate getDelegate() {
        return delegate;
    }
}
