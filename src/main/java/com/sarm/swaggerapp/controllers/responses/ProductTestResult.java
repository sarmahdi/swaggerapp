package com.sarm.swaggerapp.controllers.responses;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sarm.swaggerapp.domain.Product;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ProductTestResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

public class ProductTestResult  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("input")
  private String input = null;

  @JsonProperty("result")
  private Product result = null;

  public ProductTestResult input(String input) {
    this.input = input;
    return this;
  }

  /**
   * Get input
   * @return input
  **/
  @ApiModelProperty(value = "")


  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public ProductTestResult result(Product result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Product getResult() {
    return result;
  }

  public void setResult(Product result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductTestResult productTestResult = (ProductTestResult) o;
    return Objects.equals(this.input, productTestResult.input) &&
        Objects.equals(this.result, productTestResult.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductTestResult {\n");
    
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

