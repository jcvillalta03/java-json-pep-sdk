package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public class PolicyIdentifierList {

    @Getter(onMethod_ = {@JsonProperty("PolicyIdReference")})
    List<IdReference> policyIdReferences;

    @Getter(onMethod_ = {@JsonProperty("PolicySetIdReference")})
    List<IdReference> policySetIdReferences;
}
