package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Values of the XACML xPathExpression data-type are represented as JSON objects
 */
@Data
public class XPathExpression {

    @ApiModelProperty(
        example = "urn:oasis:names:tc:xacml:3.0:attribute-category:resource",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("XPathCategory")})
    String xPathCategory;

    @ApiModelProperty(
        example = "[{\"Namespace\": \"urn:oasis:names:tc:xacml:3.0:core:schema:wd-17\"}]"
    )
    @Getter(onMethod_ = {@JsonProperty("Namespaces")})
    final List<NamespaceDeclaration> namespaceDeclarations = new ArrayList<>();

    @ApiModelProperty(
        example = "md:record/md:patient/md:patientDoB",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("XPath")})
    String xPath;

    public XPathExpression(String xPathCategory, String xPath) {
        this.xPathCategory = xPathCategory;
        this.xPath = xPath;
    }

    public boolean addNamespaceDeclaration(String namespace) {
        return namespaceDeclarations.add(new NamespaceDeclaration(namespace));
    }

    public boolean addNamespaceDeclaration(String namespace, String prefix) {
        return namespaceDeclarations.add(new NamespaceDeclaration(namespace, prefix));
    }
}
