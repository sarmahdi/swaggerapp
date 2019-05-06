package com.sarm.swaggerapp.controllers.responses;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PaginationResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T13:00:22.888Z")

public class PaginationResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("totalrecords")
  private BigDecimal totalrecords = null;

  @JsonProperty("displayrecords")
  private BigDecimal displayrecords = null;

  public PaginationResponse totalrecords(BigDecimal totalrecords) {
    this.totalrecords = totalrecords;
    return this;
  }

  /**
   * Get totalrecords
   * @return totalrecords
  **/
  @JsonSerialize(using = ToStringSerializer.class)
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTotalrecords() {
    return totalrecords;
  }

  public void setTotalrecords(BigDecimal totalrecords) {
    this.totalrecords = totalrecords;
  }

  public PaginationResponse displayrecords(BigDecimal displayrecords) {
    this.displayrecords = displayrecords;
    return this;
  }

  /**
   * Get displayrecords
   * @return displayrecords
  **/
  @JsonSerialize(using = ToStringSerializer.class)
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getDisplayrecords() {
    return displayrecords;
  }

  public void setDisplayrecords(BigDecimal displayrecords) {
    this.displayrecords = displayrecords;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationResponse paginationResponse = (PaginationResponse) o;
    return Objects.equals(this.totalrecords, paginationResponse.totalrecords) &&
        Objects.equals(this.displayrecords, paginationResponse.displayrecords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalrecords, displayrecords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationResponse {\n");
    
    sb.append("    totalrecords: ").append(toIndentedString(totalrecords)).append("\n");
    sb.append("    displayrecords: ").append(toIndentedString(displayrecords)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

