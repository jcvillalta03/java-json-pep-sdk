package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StatusCode {
    @JsonProperty("Value")
    String value;

    @Getter(onMethod_ = {@JsonProperty("StatusCode")})
    StatusCode statusCode;

}
