package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * The Request Body for PDP Authorize Requests
 *
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@ApiModel("The Request Body for PDP Authorize Requests")
public class Request {

    /**
     * This attribute is used to request that the PDP return a list of all fully applicable policies and policy sets which were used in the decision
     * as a part of the decision response.
     *
     * Defaults to false if not specified
     */
    @ApiModelProperty(example = "false", notes = "This attribute is used to request that the PDP return a list of all fully applicable policies and " +
        "policy sets which were used in the decision as a part of the decision response. Defaults to false if not specified")
    @Getter(onMethod_ = {@JsonProperty("ReturnPolicyIdList")})
    boolean returnPolicyIdList = false;

    /**
     * This attribute is used to request that the PDP combines multiple decisions into a single decision.
     *
     * Defaults to false if not specified
     */
    @ApiModelProperty(example = "false", notes = "This attribute is used to request that the PDP combines multiple decisions into a single decision." +
        "Defaults to false if not specified")
    @Getter(onMethod_ = {@JsonProperty("CombinedDecision")})
    boolean combinedDecision = false;

    /**
     * The xpath version
     */
    @ApiModelProperty(notes = "The xpath version. Mandatory if the XACML request contains XPath expressions; otherwise, optional.")
    @Getter(onMethod_ = {@JsonProperty("XPathVersion")})
    String xPathVersion;

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("Category")})
    List<Category> customCategories = new ArrayList<>();

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
    List<Category> recipientSubjectCategories = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("IntermediarySubject")})
    List<Category> intermediarySubjectCategories = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("CodeBase")})
    List<Category> codeBaseCategories = new ArrayList<>();

    @ApiModelProperty(notes = "Optional, but see section 4.2.2.2.")
    @Getter(onMethod_ = {@JsonProperty("RequestingMachine")})
    List<Category> requestingMachineCategories = new ArrayList<>();

    /**
     * Lists multiple request contexts by references to the Category members. Optional
     */
    @ApiModelProperty(notes = "Lists multiple request contexts by references to the Category members. Optional")
    @Getter(onMethod_ = {@JsonProperty("MultiRequests")})
    MultiRequests multiRequests;

    public boolean addCustomCategory(Category category) {
        return customCategories.add(category);
    }

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

    public boolean addRecipientSubjectCategories(Category category) {
        return recipientSubjectCategories.add(category);
    }

    public boolean addIntermediarySubjectCategories(Category category) {
        return intermediarySubjectCategories.add(category);
    }

    public boolean addCodeBaseCategories(Category category) {
        return codeBaseCategories.add(category);
    }

    public boolean addRequestingMachineCategories(Category category) {
        return requestingMachineCategories.add(category);
    }
}
