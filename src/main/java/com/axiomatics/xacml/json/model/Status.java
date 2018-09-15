package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * The status of the authorization decision result.
 *
 * Indicates whether errors occurred during evaluation of the decision request, and optionally, information about those errors.  If the
 * Response> element contains <Result> elements whose <Status> elements are all identical, and the <Response> element is contained in a protocol
 * wrapper that can convey status information, then the common status information MAY be placed in the protocol wrapper and this <Status> element MAY
 * be omitted from all <Result> elements.
 *
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@ApiModel("The status of the authorization decision result")
@Data
public class Status {

    @ApiModelProperty(
        value = "Status code"
    )
    @Getter(onMethod_ = {@JsonProperty("StatusCode")})
    StatusCode statusCode;

    @ApiModelProperty(
        value = "A free-form description of the status code"
    )
    @Getter(onMethod_ = {@JsonProperty("StatusMessage")})
    String statusMessage;

    @ApiModelProperty(
        value = "Additional status information"
    )
    @Getter(onMethod_ = {@JsonProperty("StatusDetail")})
    List<JSONPObject> statusDetail;

}
