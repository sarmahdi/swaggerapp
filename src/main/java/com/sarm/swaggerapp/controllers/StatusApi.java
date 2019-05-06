/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.4).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.sarm.swaggerapp.controllers;

import com.sarm.swaggerapp.delegate.StatusApiDelegate;
import com.sarm.swaggerapp.controllers.responses.StatusResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

@Api(value = "status", description = "the status API")
public interface StatusApi {

    StatusApiDelegate getDelegate();

    @ApiOperation(value = "Return system's status", nickname = "statusGet", notes = "", response = StatusResponse.class, tags={ "misc", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StatusResponse.class) })
    @RequestMapping(value = "/status",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<StatusResponse> statusGet() {
        return getDelegate().statusGet();
    }

}