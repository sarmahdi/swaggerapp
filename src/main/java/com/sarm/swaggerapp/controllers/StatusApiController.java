package com.sarm.swaggerapp.controllers;

import com.sarm.swaggerapp.delegate.StatusApiDelegate;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

@Controller
public class StatusApiController implements StatusApi {

    private final StatusApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public StatusApiController(StatusApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public StatusApiDelegate getDelegate() {
        return delegate;
    }


}
