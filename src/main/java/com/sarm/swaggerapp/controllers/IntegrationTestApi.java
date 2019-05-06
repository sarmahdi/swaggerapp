/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.4).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.sarm.swaggerapp.controllers;

import com.sarm.swaggerapp.delegate.IntegrationTestApiDelegate;
import com.sarm.swaggerapp.controllers.responses.IntegrationTestResult;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

@Api(value = "integrationTest", description = "the integrationTest API")
public interface IntegrationTestApi {

    IntegrationTestApiDelegate getDelegate();

    @ApiOperation(value = "Run integration tests against remote API", nickname = "integrationTestGet", notes = "", response = IntegrationTestResult.class, tags={ "test", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = IntegrationTestResult.class) })
    @RequestMapping(value = "/integrationTest",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<IntegrationTestResult> integrationTestGet(@NotNull @ApiParam(value = "base url of remote API to test", required = true) @Valid @RequestParam(value = "url", required = true) String url) {
        return getDelegate().integrationTestGet(url);
    }

}