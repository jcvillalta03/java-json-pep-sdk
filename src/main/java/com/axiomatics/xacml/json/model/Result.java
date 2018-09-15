package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@ApiModel("The Response Body Wrapper")
public class Result {

    @Getter(onMethod_ = {@JsonProperty("Decision")})
    PDPDecision decision;

    @Getter(onMethod_ = {@JsonProperty("Status")})
    Status status;

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("Obligations")})
    List<ObligationOrAdvice> obligations = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("AssociatedAdvice")})
    List<ObligationOrAdvice> associatedAdvice = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("Category")})
    List<Category> categories;

    @ApiModelProperty(notes = "Optional")
    @Getter(onMethod_ = {@JsonProperty("PolicyIdentifierList")})
    PolicyIdentifierList policyIdentifierList;
}
