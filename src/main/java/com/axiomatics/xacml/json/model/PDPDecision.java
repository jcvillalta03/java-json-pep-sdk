package com.axiomatics.xacml.json.model;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Getter
@ToString
public enum PDPDecision {

    PERMIT(0, "Permit"),
    DENY(1, "Deny"),
    INDETERMINATE(2, "Indeterminate"),
    NOT_APPLICABLE(3, "NotApplicable");

    int ordinal;
    String decision;

    PDPDecision(int ordinal, String decision) {
        this.ordinal = ordinal;
        this.decision = decision;
    }

}
