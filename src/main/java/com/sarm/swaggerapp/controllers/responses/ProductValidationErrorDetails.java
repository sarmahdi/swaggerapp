package com.sarm.swaggerapp.controllers.responses;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;

/**
 * ProductValidationErrorDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

public class ProductValidationErrorDetails extends ProductResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("param")
  private String param = null;

  @JsonProperty("msg")
  private String msg = null;

  @JsonProperty("value")
  private String value = null;


  public ProductValidationErrorDetails(String location, String param, String msg, String value) {
    this.location=location;
    this.param= param;
    this.msg = msg;
    this.value= value;
  }


  public ProductValidationErrorDetails location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public ProductValidationErrorDetails param(String param) {
    this.param = param;
    return this;
  }

  /**
   * Get param
   * @return param
  **/
  @ApiModelProperty(value = "")


  public String getParam() {
    return param;
  }

  public void setParam(String param) {
    this.param = param;
  }

  public ProductValidationErrorDetails msg(String msg) {
    this.msg = msg;
    return this;
  }

  /**
   * Get msg
   * @return msg
  **/
  @ApiModelProperty(value = "")


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public ProductValidationErrorDetails value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductValidationErrorDetails productValidationErrorDetails = (ProductValidationErrorDetails) o;
    return Objects.equals(this.location, productValidationErrorDetails.location) &&
        Objects.equals(this.param, productValidationErrorDetails.param) &&
        Objects.equals(this.msg, productValidationErrorDetails.msg) &&
        Objects.equals(this.value, productValidationErrorDetails.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, param, msg, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductValidationErrorDetails {\n");
    
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    param: ").append(toIndentedString(param)).append("\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

