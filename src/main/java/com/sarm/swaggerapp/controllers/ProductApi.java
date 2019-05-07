/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.4).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.sarm.swaggerapp.controllers;

import java.math.BigDecimal;

import com.sarm.swaggerapp.controllers.responses.*;
import com.sarm.swaggerapp.delegate.ProductApiDelegate;
import com.sarm.swaggerapp.domain.Product;
import com.sarm.swaggerapp.controllers.requests.ProductAddRequest;
import com.sarm.swaggerapp.controllers.requests.ProductUpdateRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

@Api(value = "product", description = "the product API")
public interface ProductApi {

    ProductApiDelegate getDelegate();

    @ApiOperation(value = "Retrieve a specific product by id", nickname = "productIdGet", notes = "", response = Product.class, tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Product.class),
        @ApiResponse(code = 400, message = "Validation error", response = ProductValidationError.class),
        @ApiResponse(code = 404, message = "Not Found Error", response = ProductNotFoundError.class) })
    @RequestMapping(value = "/product/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<? extends ApiResponseMessage> productIdGet(@ApiParam(value = "id",required=true) @PathVariable("id") String id, HttpServletRequest request) {
        getDelegate().setRequest(request);
        return getDelegate().productIdGet(id);
    }


    @ApiOperation(value = "Modify an product entry", nickname = "productIdPatch", notes = "", response = Product.class, tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Product.class),
        @ApiResponse(code = 400, message = "Validation error", response = ProductValidationError.class),
        @ApiResponse(code = 404, message = "Not Found Error", response = ProductNotFoundError.class) })
    @RequestMapping(value = "/product/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    default ResponseEntity<? extends ApiResponseMessage> productIdPatch(@ApiParam(value = "id",required=true) @PathVariable("id") String id, @ApiParam(value = "" ,required=true )  @Valid @RequestBody ProductUpdateRequest body, HttpServletRequest request) {
        getDelegate().setRequest(request);
        return getDelegate().productIdPatch(id, body);
    }


    @ApiOperation(value = "Retrieve a list of products", nickname = "productListGet", notes = "", response = InlineResponse200.class, tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of customer orders", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "Validation error", response = ProductValidationError.class),
        @ApiResponse(code = 404, message = "Not Found Error", response = ProductNotFoundError.class) })
    @RequestMapping(value = "/product/list/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<? extends ApiResponseMessage> productListGet(@ApiParam(value = "Start index for paging") @Valid @RequestParam(value = "startindex", required = false) Optional<String> startindex, @ApiParam(value = "Number of records to return") @Valid @RequestParam(value = "pagelength", required = false) Optional<String> pagelength, HttpServletRequest request) {
        getDelegate().setRequest(request);
        return getDelegate().productListGet(startindex, pagelength);
    }


    @ApiOperation(value = "Create a product entry", nickname = "productPost", notes = "", response = Product.class, tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Product.class),
        @ApiResponse(code = 400, message = "Validation error", response = ProductValidationError.class) })
    @RequestMapping(value = "/product",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<? extends ApiResponseMessage> productPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ProductAddRequest body, HttpServletRequest request) {
        getDelegate().setRequest(request);
        return getDelegate().productPost(body);
    }

}
