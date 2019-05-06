package com.sarm.swaggerapp.controllers.requests;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * ProductUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

public class ProductUpdateRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("text")
  private String text = null;

  @JsonProperty("isCompleted")
  private Boolean isCompleted = null;

  public ProductUpdateRequest text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
  **/
  @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.", value = "")

@Size(min=1,max=50) 
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public ProductUpdateRequest isCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
    return this;
  }

  /**
   * Get isCompleted
   * @return isCompleted
  **/
  @ApiModelProperty(example = "true", value = "")


  public Boolean isIsCompleted() {
    return isCompleted;
  }

  public void setIsCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductUpdateRequest productUpdateRequest = (ProductUpdateRequest) o;
    return Objects.equals(this.text, productUpdateRequest.text) &&
        Objects.equals(this.isCompleted, productUpdateRequest.isCompleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, isCompleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductUpdateRequest {\n");
    
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    isCompleted: ").append(toIndentedString(isCompleted)).append("\n");
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

