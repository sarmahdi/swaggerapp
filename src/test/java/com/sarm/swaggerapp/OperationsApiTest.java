package com.sarm.swaggerapp;

import com.sarm.swaggerapp.controllers.OperationsApiController;
import com.sarm.swaggerapp.controllers.responses.ApiResponseMessage;
import com.sarm.swaggerapp.delegate.OperationsApiDelegate;
import com.sarm.swaggerapp.controllers.responses.BalanceTestResult;
import com.sarm.swaggerapp.controllers.responses.ProductValidationError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
//@Transactional
@SpringBootTest
public class OperationsApiTest {

    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    OperationsApiController operationsApiController;

    @Autowired
    OperationsApiDelegate operationsApiDelegate;


    /**
     * tests the validateBrackets task
     */
    @Test
    public void testOperations(){

        ResponseEntity<? extends ApiResponseMessage> responseEntity = operationsApiController.operationsValidateBracketsGet("({[]})",httpRequest );
        assertThat(responseEntity.getBody(), instanceOf(BalanceTestResult.class)  );
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }




    @Test
    public void operationsValidateBracketsGet1(){

        ResponseEntity<? extends ApiResponseMessage> responseEntity = operationsApiController.operationsValidateBracketsGet("123werwer",httpRequest );
        assertThat(responseEntity.getBody(), instanceOf(ProductValidationError.class)  );
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void operationsValidateBracketsGet2(){

        ResponseEntity<? extends ApiResponseMessage> responseEntity = operationsApiController.operationsValidateBracketsGet("{[}]",httpRequest );
        assertThat(responseEntity.getBody(), instanceOf(ProductValidationError.class)  );
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void operationsValidateBracketsGet3(){

        ResponseEntity<? extends ApiResponseMessage> responseEntity = operationsApiController.operationsValidateBracketsGet("[{)]",httpRequest );
        assertThat(responseEntity.getBody(), instanceOf(ProductValidationError.class)  );
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }




    @Before
    public void setUp() throws Exception {
        operationsApiDelegate.setRequest(httpRequest);
        org.mockito.Mockito.when(httpRequest.getHeader("Accept")).thenReturn("application/json");
        operationsApiController = new OperationsApiController(operationsApiDelegate);
    }

    @After
    public void tearDown() throws Exception {
    }
}