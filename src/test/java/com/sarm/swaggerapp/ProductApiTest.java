package com.sarm.swaggerapp;

import com.sarm.swaggerapp.controllers.ProductApiController;
import com.sarm.swaggerapp.controllers.requests.ProductAddRequest;
import com.sarm.swaggerapp.controllers.requests.ProductUpdateRequest;
import com.sarm.swaggerapp.controllers.responses.ProductNotFoundError;
import com.sarm.swaggerapp.controllers.responses.ProductResponse;
import com.sarm.swaggerapp.controllers.responses.ProductValidationError;
import com.sarm.swaggerapp.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class ProductApiTest {


    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    ProductApiController productApiController;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void productIdGet() {
    }

    @Test
    public void productIdPatch() {
    }

    @Test
    public void productListGet() {
    }

    @Test
    public void productPost() {
    }


    /**
     * tests a POST request then does a GET for the id 1 and then updates the id 1
     */
    @Test
    public void testProduct(){

        ProductAddRequest productAddRequest = new ProductAddRequest();
        productAddRequest.setText("MyproductPost");
        ResponseEntity<? extends ProductResponse> responseEntityPost = productApiController.productPost(productAddRequest,httpRequest);
        assertThat(responseEntityPost.getBody(), instanceOf(Product.class)  );
        assertEquals(responseEntityPost.getStatusCode(), HttpStatus.OK);

        ResponseEntity<? extends ProductResponse> responseEntityGet = productApiController.productIdGet("1",httpRequest);
        assertThat(responseEntityGet.getBody(), instanceOf(Product.class)  );
        assertEquals(((Product)responseEntityGet.getBody()).getText().trim(),"MyproductPost");
        assertEquals(responseEntityGet.getStatusCode(), HttpStatus.OK);


        ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
        productUpdateRequest.setIsCompleted(true);
        ResponseEntity<? extends ProductResponse> responseEntityPatch = productApiController.productIdPatch("1",productUpdateRequest,httpRequest);
        assertThat(responseEntityGet.getBody(), instanceOf(Product.class)  );
        assertEquals(((Product)responseEntityPatch.getBody()).getText().trim(),"MyproductPost");
        assertEquals(((Product)responseEntityPatch.getBody()).isIsCompleted(),true);
        assertEquals(responseEntityPatch.getStatusCode(), HttpStatus.OK);

    }

    /**
     * tests a NotFoundError Response
     */
    @Test
    public void testTodoNotFoundError(){
        ResponseEntity<? extends ProductResponse> responseEntityGet = productApiController.productIdGet("1",httpRequest);
        assertThat(responseEntityGet.getBody(), instanceOf(ProductNotFoundError.class)  );
        assertEquals(responseEntityGet.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    /**
     * Tests a Validation Error Response
     */
    @Test
    public void testTodoNotValid(){
        ResponseEntity<? extends ProductResponse> responseEntityGet = productApiController.productIdGet("1e",httpRequest);
        assertThat(responseEntityGet.getBody(), instanceOf(ProductValidationError.class)  );
        assertEquals(responseEntityGet.getStatusCode(), HttpStatus.BAD_REQUEST);


        ProductAddRequest toDoItemAddRequest = new ProductAddRequest();
        toDoItemAddRequest.setText("    ");
        ResponseEntity<? extends ProductResponse> responseEntityPost = productApiController.productPost(toDoItemAddRequest,httpRequest);
        assertThat(responseEntityPost.getBody(), instanceOf(ProductValidationError.class)  );
        assertEquals(((ProductValidationError)responseEntityPost.getBody()).getDetails().get(0).getParam(),"text");
        assertEquals(responseEntityPost.getStatusCode(), HttpStatus.BAD_REQUEST);

    }
}