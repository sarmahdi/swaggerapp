package com.sarm.swaggerapp.controllers.responses;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T10:53:59.975Z")

public class InlineResponse200 extends ApiResponseMessage implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("PaginationResponse")
  private PaginationResponse paginationResponse = null;

  public InlineResponse200 paginationResponse(PaginationResponse paginationResponse) {
    this.paginationResponse = paginationResponse;
    return this;
  }

  /**
   * Get paginationResponse
   * @return paginationResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PaginationResponse getPaginationResponse() {
    return paginationResponse;
  }

  public void setPaginationResponse(PaginationResponse paginationResponse) {
    this.paginationResponse = paginationResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.paginationResponse, inlineResponse200.paginationResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paginationResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    paginationResponse: ").append(toIndentedString(paginationResponse)).append("\n");
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

