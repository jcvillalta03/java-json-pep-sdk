package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Status {

    @Getter(onMethod_ = {@JsonProperty("StatusMessage")})
    String statusMessage;

    @Getter(onMethod_ = {@JsonProperty("StatusDetail")})
    List<Map> statusDetail;

    @Getter(onMethod_ = {@JsonProperty("StatusCode")})
    StatusCode statusCode;

}
