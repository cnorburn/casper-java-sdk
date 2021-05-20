package com.casper.sdk.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Domain type: header information associated with a deploy.
 */
public class DeployHeader {
    /** Public key of account dispatching deploy to a node. */
    private final PublicKey account;
    /** Timestamp at point of deploy creation as an ISO8601 date time with timezone */
    private final String timestamp;
    /** Time interval after which the deploy will no longer be considered for processing by a node. eg 3m */
    private final String ttl;
    /** Hash of deploy payload. */
    private final Digest bodyHash;
    /** Set of deploys that must be executed prior to this one. */
    private final List<Digest> dependencies;
    /** Name of target chain to which deploy will be dispatched. */
    private final String chainName;

    @JsonCreator
    public DeployHeader(@JsonProperty("account") final PublicKey account,
                        @JsonProperty("timestamp") final String timestamp,
                        @JsonProperty("ttl") final String ttl,
                        @JsonProperty("body_hash") final Digest bodyHash,
                        @JsonProperty("dependencies") final List<Digest> dependencies,
                        @JsonProperty("chain_name") final String chainName) {
        this.account = account;
        this.timestamp = timestamp;
        this.ttl = ttl;
        this.bodyHash = bodyHash;
        this.dependencies = dependencies;
        this.chainName = chainName;
    }

    public PublicKey getAccount() {
        return account;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTtl() {
        return ttl;
    }

    public Digest getBodyHash() {
        return bodyHash;
    }

    public List<Digest> getDependencies() {
        return dependencies;
    }

    public String getChainName() {
        return chainName;
    }
}