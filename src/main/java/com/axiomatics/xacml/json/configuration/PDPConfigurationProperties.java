package com.axiomatics.xacml.json.configuration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public final class PDPConfigurationProperties {

    /**
     * The host URL of the PDP
     *
     * It can be an https connection too
     */
    private String pdpHost;

    /**
     * Used to determine if credentials should added to requests to PDP.
     */
    private String authenticationEnabled;

    /**
     * Username of a PEP user
     *
     * Will be used to authenticate requests to PDP, if authentication is enabled
     */
    private String pepUser;

    /**
     * Username of a PEP password
     *
     * Will be used to authenticate requests to PDP, if authentication is enabled
     */
    private String pepPassword;

}
