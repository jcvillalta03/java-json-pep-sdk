package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * Container of lists of policy and policy set {@link IdReference}s  which have been applicable to a request
 *
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@ApiModel("Container of lists of policy and policy set IdReferences which have been applicable to a request")
@Data
public class PolicyIdentifierList {

    @ApiModelProperty(
        value = "List of policy id references of policies which have been applicable to the request"
    )
    @Getter(onMethod_ = {@JsonProperty("PolicyIdReference")})
    List<IdReference> policyIdReferences;

    @ApiModelProperty(
        value = "List of policy set id references of policies which have been applicable to the request"
    )
    @Getter(onMethod_ = {@JsonProperty("PolicySetIdReference")})
    List<IdReference> policySetIdReferences;

}
