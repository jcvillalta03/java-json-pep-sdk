package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public class IdReference {
    @Getter(onMethod_ = {@JsonProperty("Id")})
    String id;

    @Getter(onMethod_ = {@JsonProperty("Version")})
    String version;
}
