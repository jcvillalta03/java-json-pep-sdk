package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Request {
    private boolean returnPolicyIdList = false;
    private boolean combinedDecision = false;
    private String xPathVersion = "http://www.w3.org/TR/1999/REC-xpath-19991116";

    private Category[] categories;
    private MultiRequests multiRequests;

    public Request() {

    }

    @JsonProperty
    public boolean isReturnPolicyIdList() {
        return this.returnPolicyIdList;
    }

    public boolean isCombinedDecision() {
        return this.combinedDecision;
    }
}
