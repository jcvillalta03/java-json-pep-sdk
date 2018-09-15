package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public class ObligationOrAdvice {

    @Getter(onMethod_ = {@JsonProperty("Id")})
    String id;

    @Getter(onMethod_ = {@JsonProperty("AttributeAssignment")})
    List<AttributeAssignment> attributeAssignments;
}
