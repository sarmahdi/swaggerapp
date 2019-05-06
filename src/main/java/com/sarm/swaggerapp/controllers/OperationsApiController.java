package com.sarm.swaggerapp.controllers;

import com.sarm.swaggerapp.delegate.OperationsApiDelegate;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

@Controller
public class OperationsApiController implements OperationsApi {

    private final OperationsApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public OperationsApiController(OperationsApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public OperationsApiDelegate getDelegate() {
        return delegate;
    }
}
