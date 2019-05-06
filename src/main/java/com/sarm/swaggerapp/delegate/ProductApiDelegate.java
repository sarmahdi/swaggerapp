package com.sarm.swaggerapp.delegate;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sarm.swaggerapp.controllers.responses.ApiResponseMessage;
import com.sarm.swaggerapp.controllers.responses.ProductResponse;
import com.sarm.swaggerapp.controllers.ProductApi;
import com.sarm.swaggerapp.controllers.ProductApiController;
import com.sarm.swaggerapp.controllers.responses.InlineResponse200;
import com.sarm.swaggerapp.domain.Product;
import com.sarm.swaggerapp.controllers.requests.ProductAddRequest;
import com.sarm.swaggerapp.controllers.responses.ProductNotFoundError;
import com.sarm.swaggerapp.controllers.requests.ProductUpdateRequest;
import com.sarm.swaggerapp.controllers.responses.ProductValidationError;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ProductApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

public interface ProductApiDelegate {

    Logger log = LoggerFactory.getLogger(ProductApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    /**
     * @see ProductApi#productIdGet
     */
    default ResponseEntity<? extends ProductResponse>  productIdGet( String  id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"createdAt\" : \"2017-10-13T01:50:58.735Z\",  \"id\" : 42.0,  \"text\" : \"Uulwi ifis halahs gag erh'ongg w'ssh.\",  \"isCompleted\" : false}", Product.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see ProductApi#productIdPatch
     */
    default ResponseEntity<? extends ProductResponse> productIdPatch(String  id,
                                                                     ProductUpdateRequest  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"createdAt\" : \"2017-10-13T01:50:58.735Z\",  \"id\" : 42.0,  \"text\" : \"Uulwi ifis halahs gag erh'ongg w'ssh.\",  \"isCompleted\" : false}", Product.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see ProductApi#productListGet
     */
    default ResponseEntity<? extends ApiResponseMessage>  productListGet(Optional<BigDecimal>  startindex,
                                                                         Optional<BigDecimal>  pagelength) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"PaginationResponse\" : \"\"}", InlineResponse200.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see ProductApi#productPost
     */
    default ResponseEntity<? extends ProductResponse>  productPost( ProductAddRequest  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"createdAt\" : \"2017-10-13T01:50:58.735Z\",  \"id\" : 42.0,  \"text\" : \"Uulwi ifis halahs gag erh'ongg w'ssh.\",  \"isCompleted\" : false}", Product.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    void setRequest(HttpServletRequest request);

    /**
     * Creates a NoteFoundError Response
     * @param id
     * @return
     * @throws IOException
     */
    default  ResponseEntity<ProductNotFoundError> createNotFoundError(Long id) throws IOException {

        String s = null;
        try {
            s = getObjectMapper().get().writeValueAsString(new ProductNotFoundError("NotFoundError",id));
        }
        catch (JsonProcessingException e) {
            log.error(" JsonProcessingException : Couldn't Process Json for content type ", e);
        }
        return new ResponseEntity<ProductNotFoundError>(getObjectMapper().get().readValue(s,ProductNotFoundError.class),HttpStatus.NOT_FOUND);

    }

    /**
     * Creates a ValidationError response
     * @param param
     * @param location
     * @param msg
     * @param value
     * @return
     * @throws IOException
     */
    default ResponseEntity<ProductValidationError> createValidationError(String param, String location, String msg, String value) throws IOException {
        String s = null;
        try {
            s = getObjectMapper().get().writeValueAsString(new  ProductValidationError(location,param,msg,value, "Validation Error"));
        }
        catch (JsonProcessingException e) {
            log.error(" JsonProcessingException : Couldn't Process Json for content type ", e);
        }
        return new ResponseEntity<ProductValidationError>(getObjectMapper().get().readValue(s,ProductValidationError.class),HttpStatus.BAD_REQUEST);

    }

}
