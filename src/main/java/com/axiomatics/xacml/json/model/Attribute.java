package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@ApiModel("A XACML attribute")
public class Attribute {

    public Attribute(String attributeId, Object value) {
        this.attributeId = attributeId;
        this.value = value;
    }

    public Attribute(String attributeId, Object value, String dataType) {
        this.attributeId = attributeId;
        this.value = value;
        this.dataType = dataType;
    }

    /**
     * The unique identifier of the {@link Attribute)
     */
    @ApiModelProperty(
        value = "A string containing a XACML attribute URI",
        example = "urn:oasis:names:tc:xacml:2.0:subject:role",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("AttributeId")})
    String attributeId;

    /**
     * The value of the {@link Attribute)
     */
    @ApiModelProperty(
        value = "An array of elements of the same type; either string, boolean, number (which maps to either a XACML integer or double as defined in " +
            "Supported Data Types) or object.",
        example = "acmeId-001",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("Value")})
    Object value;

    /**
     * The data-type of the {@link Attribute}
     * <p>
     * Can be omitted in the JSON representation, thus null in object
     * <p>
     * Its default value will be http://www.w3.org/2001/XMLSchema#string unless it can be safely assumed according to rules to the rules set in
     * 3.3.1 Supported Data Types. In the case of an array of values, inference works as described in section 3.3.2.
     */
    @ApiModelProperty(
        value = "A string containing a XACML data type URI or the shorthand notation defined in section 3.3.1.\n" +
            "The default value will be http://www.w3.org/2001/XMLSchema#string unless the data type can be safely assumed to be otherwise according " +
            "to the rules set in sections 3.3.1 and 3.3.2.",
        example = "http://www.w3.org/2001/XMLSchema#string"
    )
    @Getter(onMethod_ = {@JsonProperty("DataType")})
    String dataType;

    /**
     * The issuer of the {@link Attribute)
     */
    @ApiModelProperty()
    @Getter(onMethod_ = {@JsonProperty("Issuer")})
    String issuer;

    /**
     *
     */
    @ApiModelProperty()
    @Getter(onMethod_ = {@JsonProperty("IncludeInResult")})
    Boolean includeInResult;

}
