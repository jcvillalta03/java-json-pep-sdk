package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * Conveys information about attributes required for policy evaluation that were missing from the request context.
 *
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Data
public class MissingAttributeDetail {

    @ApiModelProperty(
        value = "The identifier of the missing attribute",
        example = "urn:oasis:names:tc:xacml:2.0:subject:role",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("AttributeId")})
    String attributeId;

    @ApiModelProperty(
        value = "A string containing a XACML attribute URI",
        example = "urn:oasis:names:tc:xacml:2.0:subject:role",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("Value")})
    String value;

    @ApiModelProperty(
        value = "This attribute, if supplied, SHALL specify the required Issuer of the missing attribute",
        example = "urn:oasis:names:tc:xacml:2.0:subject:role",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("Issuer")})
    String issuer;

    @ApiModelProperty(
        value = "The data-type of the missing attribute",
        example = "urn:oasis:names:tc:xacml:2.0:subject:role",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("DataType")})
    String dataType;

    @ApiModelProperty(
        value = "The category identifier of the missing attribute",
        example = "urn:oasis:names:tc:xacml:2.0:subject:role",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("Category")})
    String category;

}
