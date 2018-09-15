package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public enum PDPDecision {

    @JsonProperty("Permit")
    PERMIT(0),
    @JsonProperty("Deny")
    DENY(1),
    @JsonProperty("Indeterminate")
    INDETERMINATE(2),
    @JsonProperty("NotApplicable")
    NOT_APPLICABLE(3);

    int ordinal;
    String decision;

    PDPDecision(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }

}
