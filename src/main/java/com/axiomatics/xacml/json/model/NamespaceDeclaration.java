package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Data
public class NamespaceDeclaration {

    @ApiModelProperty(
        example = "md"
    )
    @Getter(onMethod_ = {@JsonProperty("Prefix")})
    String prefix;

    @ApiModelProperty(
        example = "urn:example:med:schemas:record",
        required = true
    )
    @Getter(onMethod_ = {@JsonProperty("Namespace")})
    String namespace;

    public NamespaceDeclaration(String namespace) {
        this.namespace = namespace;
    }

    public NamespaceDeclaration(String namespace, String prefix) {
        this.namespace = namespace;
        this.prefix = prefix;
    }

}
