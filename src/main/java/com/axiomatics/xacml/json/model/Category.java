package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Category {

    @ApiModelProperty(
        value = "A string containing a XACML category URI or the shorthand notation defined in section 4.2.2.1. " +
            "Mandatory for a Category object in the \"Category\" member array; otherwise, optional. ",
        example = "urn:oasis:names:tc:xacml:2.0:subject:role"
    )
    @Getter(onMethod_ = {@JsonProperty("CategoryId")})
    String categoryId;

    @ApiModelProperty(
        value = "",
        example = ""
    )
    @Getter(onMethod_ = {@JsonProperty("Id")})
    String id;

    @ApiModelProperty(
        value = "There are two possible ways to represent the XML content of a XACML request in the JSON representation: XML escaping or Base64 " +
            "encoding. The request parser must determine whether XML escaping or Base 64 encoding is used. There are no members in the JSON request " +
            "to indicate which is used.\n" +
            "In both cases, any XML content sent in a JSON request MUST include all namespace definitions needed to parse that content.\n" +
            "\n" +
            "The value of the \"Content\" member is a string which MUST contain an XML payload per the XACML specification.\n" +
            "XML content must be escaped before being inserted into the JSON request. JSON dictates double quotes (\") be escaped using a backslash " +
            "(\\). This profile therefore follows this behavior.\n" +
            "In addition, since the XML content could itself contain backslashes and possibly the sequence \\\", it is important to also " +
            "escape backslashes.\n" +
            "\n" +
            "In the case of Base64 encoding, the XML content shall be converted to its Base64 representation as per [BASE64].",
        example = "<?xml version=\"1.0\"?><catalog><book id=\"bk101\"><author>Gambardella, Matthew</author><title>XML Developer's Guide</title><genre>" +
            "Computer</genre><price>44.95</price><publish_date>2000-10-01</publish_date><description>An in-depth look at creating applications with " +
            "XML.</description></book></catalog>"
    )
    @Getter(onMethod_ = {@JsonProperty("Content")})
    String content;

    @ApiModelProperty(
        value = "",
        example = ""
    )
    @Getter(onMethod_ = {@JsonProperty("Attribute")})
    final List<Attribute> attributes = new ArrayList<>();

    public boolean addAttribute(Attribute attribute) {
        return attributes.add(attribute);
    }

    public boolean addAttribute(String attributeId, Object value) {
        return attributes.add(new Attribute(attributeId, value));
    }

    public boolean addAttribute(String attributeId, Object value, String dataType) {
        return attributes.add(new Attribute(attributeId, value, dataType));
    }


}
