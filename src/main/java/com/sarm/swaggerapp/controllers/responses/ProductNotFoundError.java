package com.sarm.swaggerapp.controllers.responses;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ProductNotFoundError
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

public class ProductNotFoundError  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("details")
  @Valid
  private List<ProductNotFoundErrorDetails> details = null;

  @JsonProperty("name")
  private String name = null;


  public ProductNotFoundError(String notFoundError, Long id) {
    details= new ArrayList<>();
    details.add(new ProductNotFoundErrorDetails(id));
    this.name= notFoundError;
  }


  public ProductNotFoundError details(List<ProductNotFoundErrorDetails> details) {
    this.details = details;
    return this;
  }

  public ProductNotFoundError addDetailsItem(ProductNotFoundErrorDetails detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * Get details
   * @return details
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductNotFoundErrorDetails> getDetails() {
    return details;
  }

  public void setDetails(List<ProductNotFoundErrorDetails> details) {
    this.details = details;
  }

  public ProductNotFoundError name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "NotFoundError", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductNotFoundError productNotFoundError = (ProductNotFoundError) o;
    return Objects.equals(this.details, productNotFoundError.details) &&
        Objects.equals(this.name, productNotFoundError.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(details, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductNotFoundError {\n");
    
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

