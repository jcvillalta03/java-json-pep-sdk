package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonRootName(value = "Request")
@ApiModel("The Request Body for PDP Authorize Requests")
public class Request {

    @ApiModelProperty(example = "false", notes = "Optional, default value is false")
    @Getter(onMethod_ = {@JsonProperty("ReturnPolicyIdList")})
    Boolean returnPolicyIdList;

    @ApiModelProperty(example = "false", notes = "Optional, default value is false")
    @Getter(onMethod_ = {@JsonProperty("CombinedDecision")})
    Boolean combinedDecision;

    @ApiModelProperty(notes = "Mandatory if the XACML request contains XPath expressions; otherwise, optional.")
    @Getter(onMethod_ = {@JsonProperty("XPathVersion")})
    String xPathVersion;

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("Category")})
    List<Category> categories = new ArrayList<>();

    @ApiModelProperty(value = "Collection of resource-related attributes", notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("Resource")})
    List<Category> resourceCategories = new ArrayList<>();

    @ApiModelProperty(value = "Collection of action-related attributes", notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("Action")})
    List<Category> actionCategories = new ArrayList<>();

    @ApiModelProperty(value = "Collection of environment-related attributes", notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("Environment")})
    List<Category> environmentCategories = new ArrayList<>();

    @ApiModelProperty(value = "Collection of access-related attributes", notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("AccessSubject")})
    List<Category> accessSubjectCategories = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("RecipientSubject")})
    List<Category> RecipientSubject = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("IntermediarySubject")})
    List<Category> IntermediarySubject = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("CodeBase")})
    List<Category> CodeBase = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("RequestingMachine")})
    List<Category> RequestingMachine = new ArrayList<>();

    @ApiModelProperty(notes = "Optional")
    @Getter(onMethod_ = {@JsonProperty("MultiRequests")})
    com.axiomatics.xacml.json.model.MultiRequests MultiRequests;

    public boolean addResourceCategory(Category category) {
        return resourceCategories.add(category);
    }

    public boolean addActionCategory(Category category) {
        return actionCategories.add(category);
    }

    public boolean addEnvironmentCategory(Category category) {
        return environmentCategories.add(category);
    }

    public boolean addAccessSubjectCategory(Category category) {
        return accessSubjectCategories.add(category);
    }
}
