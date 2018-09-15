package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * Encapsulates the authorization decision produced by the PDP
 *
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Data
@ApiModel("The Response Body Wrapper")
public class Response {

    @ApiModelProperty(value = "A sequence of one or more results, with one Result element per requested resource.")
    @Getter(onMethod_ = {@JsonProperty("Response")})
    List<Result> results;

}
