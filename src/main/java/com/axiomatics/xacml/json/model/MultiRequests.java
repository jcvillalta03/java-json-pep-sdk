package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MultiRequests {

    @ApiModelProperty(
        example = "[{\"ReferenceId\":[\"foo1\",\"bar1\"]}]",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("RequestReference")})
    final List<RequestReference> requestReferences = new ArrayList<>();

    public boolean addRequestReferenceWithIds(List<String> referenceIds) {
        return requestReferences.add(new RequestReference(referenceIds));
    }

    public boolean addRequestReference(RequestReference requestReference) {
        return requestReferences.add(requestReference);
    }

}
