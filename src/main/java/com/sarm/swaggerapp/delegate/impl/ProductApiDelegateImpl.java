package com.sarm.swaggerapp.delegate.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.sarm.swaggerapp.controllers.requests.ProductAddRequest;
import com.sarm.swaggerapp.controllers.responses.ApiResponseMessage;
import com.sarm.swaggerapp.delegate.ProductApiDelegate;
import com.sarm.swaggerapp.domain.Product;
import com.sarm.swaggerapp.controllers.requests.ProductUpdateRequest;
import com.sarm.swaggerapp.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Service
public class ProductApiDelegateImpl implements ProductApiDelegate {

    HttpServletRequest request = null;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.of(new ObjectMapper());
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.of(request);
    }

    /**
     *  Facilitates a GET request
     *  It can throw a validation error if the id is non numeric
     *  or it can throw a notFoundError if the id is not used in the database and has no record for that id
     * @param strId
     * @return
     */
   @Override
    public ResponseEntity<? extends ApiResponseMessage> productIdGet(String  strId) {
        Long id = null;
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            //            removing to be able to access through a browser easily
//            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    boolean isNumeric = strId.chars().allMatch( Character::isDigit );
                    if (! isNumeric || strId.isEmpty()){
                        return  createValidationError("id","params","id is either empty or is not a number so cannot retrieve a product item ",strId);
                    }else{
                        id = Long.valueOf(strId);
                    }


                    Optional<Product> toDo = productRepository.findById(id);
                    if(toDo.isPresent()){
                        return  new ResponseEntity<>(getObjectMapper().get().readValue("{  \"createdAt\" : \" "+toDo.map(Product::getCreatedAt).orElse("NA") + "\",  \"id\" : "+ toDo.map(Product::getId).map(String::valueOf).orElse( "0" )+",  \"text\" : \" "+ toDo.map(Product::getText).orElse("NA")+"\",  \"isCompleted\" : "+toDo.map(Product::isIsCompleted).orElse(false)+"}", Product.class), HttpStatus.OK);

                    }else{
                    return createNotFoundError(id);
                    }
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }catch (Exception ex){
                    log.error("Exception: "+ ex.getMessage());
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);

                }
//            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     *
     * @param startindex
     * @param pagelength
     * @return
     */
    @Override
    public ResponseEntity<? extends ApiResponseMessage> productListGet(Optional<String> startindex, Optional<String> pagelength) {
        Long pl = null;
        if (startindex.isPresent()){

        }else{
            if(pagelength.isPresent()){
                    String pageLegthStr= pagelength.get();
                if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
                    //            removing to be able to access through a browser easily
//            if (getAcceptHeader().get().contains("application/json")) {
                    try {
                        boolean isNumeric = pageLegthStr.chars().allMatch( Character::isDigit );
                        if (! isNumeric || pageLegthStr.isEmpty()){
                            return  createValidationError("id","params","id is either empty or is not a number so cannot retrieve a product item ",strId);
                        }else{
                            pl = Long.valueOf(pageLegthStr);
                        }

                        Pageable sortedByName =
                                PageRequest.of(0, 3);
                        Optional<Product> toDo = productRepository.findAll(new  );
                        if(toDo.isPresent()){
                            return  new ResponseEntity<>(getObjectMapper().get().readValue("{  \"createdAt\" : \" "+toDo.map(Product::getCreatedAt).orElse("NA") + "\",  \"id\" : "+ toDo.map(Product::getId).map(String::valueOf).orElse( "0" )+",  \"text\" : \" "+ toDo.map(Product::getText).orElse("NA")+"\",  \"isCompleted\" : "+toDo.map(Product::isIsCompleted).orElse(false)+"}", Product.class), HttpStatus.OK);

                        }else{
                            return createNotFoundError(id);
                        }
                    } catch (IOException e) {
                        log.error("Couldn't serialize response for content type application/json", e);
                        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                    }catch (Exception ex){
                        log.error("Exception: "+ ex.getMessage());
                        return new ResponseEntity<>(HttpStatus.FORBIDDEN);

                    }
//            }
                } else {
                    log.warn("ObjectMapper or HttpServletRequest not configured in default ProductApi interface so no example is generated");
                }
            }

        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    /**
     * Facilitates the Patch request
     * Handles partial updates.
     * checks if the id supplied is a valid long Id
     * Checks if the id does exist in the system
     *
     * @see ProductApi#productIdPatch
     * @return
     */
    @Override
    public ResponseEntity<? extends ApiResponseMessage> productIdPatch(String  strId,
                                                                       ProductUpdateRequest body) {
        Long id = null;
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    boolean isNumeric = strId.chars().allMatch( Character::isDigit );
                    if (! isNumeric || strId.isEmpty()){
                        return   createValidationError("id","params","id is either empty or is not a number so cannot retrieve a product item ",strId);
                    }else{
                        id = Long.valueOf(strId);
                    }

                    // retrieve the item by Id
                    Optional<Product> toDo = productRepository.findById(id);
                    // check if the item is even present
                    if (toDo.isPresent()){
                        // do partial Update, let not the Null value override the original value
                        toDo.get().isCompleted( body.isIsCompleted()!=null ? body.isIsCompleted() : toDo.get().isIsCompleted());

                        if (body.getText()==(null) || body.getText().contentEquals("") || body.getText().isEmpty() || body.getText().trim().isEmpty() || !StringUtils.hasText(body.getText())){
                            toDo.get().setText( toDo.get().getText() );

                        }else {
                            toDo.get().setText( body.getText() );
                        }
                        productRepository.saveAndFlush(toDo.get());
                        return  new ResponseEntity<>(getObjectMapper().get().readValue("{  \"createdAt\" : \" "+toDo.map(Product::getCreatedAt).orElse("NA") + "\",  \"id\" : "+ toDo.map(Product::getId).map(String::valueOf).orElse( "0" )+",  \"text\" : \" "+ toDo.map(Product::getText).orElse("NA")+"\",  \"isCompleted\" : "+toDo.map(Product::isIsCompleted).orElse(false)+"}", Product.class), HttpStatus.OK);

                    }else{
                        return createNotFoundError(id);

                    }
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }



    /**
     * facilitates a POST request
     * Checks is the body is empty or just spaces before adding or raises a Validation error
     * @see ProductApi#productPost
     * @return
     */
    @Override
    public ResponseEntity<? extends ApiResponseMessage> productPost(ProductAddRequest body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {

                    if (body.getText()==(null) || body.getText().contentEquals("") || body.getText().isEmpty() || body.getText().trim().isEmpty() || !StringUtils.hasText(body.getText())){
                           return createValidationError("text","params","text is null or empty, cannot create a product item with 0 characters, must have 1 non space character at least ",body.getText());

                    }else{
                        Product toDo = new Product();
                        toDo.setText(body.getText());
                        toDo.isCompleted(false);
                        toDo.setCreatedAt(new Date().toString());
                        Product toDoSaved  = productRepository.save(toDo);
                        return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"createdAt\" : \" "+ toDoSaved.getCreatedAt()+" \",  \"id\" : " +toDoSaved.getId()+ ",  \"text\" : \"  "+toDoSaved.getText()+"\",  \"isCompleted\" : false}", Product.class), HttpStatus.OK);

                    }

                   } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


    @Override
    public  void setRequest(HttpServletRequest request){
        this.request = request;
    }

}
