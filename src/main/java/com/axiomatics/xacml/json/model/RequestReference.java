package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public class RequestReference {

    public RequestReference() {
        this.referenceIds = new ArrayList<>();
    }

    public RequestReference(List<String> referenceIds) {
        this.referenceIds = referenceIds;
    }

    @ApiModelProperty(
        value = "An array of one or more strings. Each string MUST be the value of a Category object’s \"Id\" member.",
        example = "[\"foo2\",\"bar1\"]",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("ReferenceId")})
    final List<String> referenceIds;

    public boolean addReferenceId(String referenceId) {
        return referenceIds.add(referenceId);
    }
}
