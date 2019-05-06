package com.sarm.swaggerapp.delegate;

import com.sarm.swaggerapp.controllers.OperationsApi;
import com.sarm.swaggerapp.controllers.OperationsApiController;
import com.sarm.swaggerapp.controllers.responses.BalanceTestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * A delegate to be called by the {@link OperationsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

public interface OperationsApiDelegate {

    Logger log = LoggerFactory.getLogger(OperationsApi.class);

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
     * @see OperationsApi#operationsValidateBracketsGet
     */
    default ResponseEntity<BalanceTestResult> operationsValidateBracketsGet( String  input) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"input\" : \"[(]\",  \"isBalanced\" : false}", BalanceTestResult.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OperationsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * validates the input string to have at least one paranthesis
     * @param input
     * @return
     */
    default Boolean validateInput(String input){
        if (input.contains("(") || input.contains(")") || input.contains("[") || input.contains("}")  || input.contains("{")  || input.contains("}")   )
        {
            return true;
        }else{
            return false;
        }
    }

    Boolean checkIfBracketsBalance(String input);

    void setRequest(HttpServletRequest request);

}
