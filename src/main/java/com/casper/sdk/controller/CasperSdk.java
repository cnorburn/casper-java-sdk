package com.casper.sdk.controller;

import com.casper.sdk.service.MetricsService;
import org.apache.commons.codec.DecoderException;
import com.casper.sdk.Properties;
import com.casper.sdk.service.HashService;
import com.casper.sdk.service.QueryService;

import java.security.NoSuchAlgorithmException;

/**
 * Entry point into the SDK
 * Exposes all permissible methods
 */
public class CasperSdk {

    private final QueryService queryService;
    private final MetricsService metricsService;

    public CasperSdk(final String url, final String port) {
        Properties.properties.put("node-url", url);
        Properties.properties.put("node-port", port);
        this.queryService = new QueryService();
        this.metricsService = new MetricsService();
    }

    public String getAccountInfo(final String accountKey) throws Throwable {
        return queryService.getAccountInfo(accountKey);
    }

    public String getAccountBalance(final String accountKey) throws Throwable {
        return queryService.getAccountBalance(accountKey);
    }

    public String getAccountMainPurseURef(final String accountKey) throws Throwable {
        return queryService.getAccountMainPurseURef(accountKey);
    }

    public String getStateRootHash() throws Throwable {
        return queryService.getStateRootHash();
    }

    public String getAccountHash(final String accountKey) throws DecoderException, NoSuchAlgorithmException {
        return HashService.getAccountHash(accountKey);
    }

    public String getAuctionInfo() throws Throwable {
        return queryService.getAuctionInfo();
    }

    public String getNodeStatus() throws Throwable {
        return queryService.getNodeStatus();
    }

    public String getNodePeers() throws Throwable {
        return queryService.getNodePeers();
    }

    public String getBlock() throws Throwable {
        return queryService.getBlock();
    }

    public String getBlockTransfers() throws Throwable {
        return queryService.getBlockTransfers();
    }

    public String getDeployInfo(final String deployHash) throws Throwable {
        return queryService.getDeployInfo(deployHash);
    }

    public String getEraInfoBySwitchBlock() throws Throwable {
        return queryService.getEraInfoBySwitchBlock();
    }

    public String getRpcSchema() throws Throwable {
        return queryService.getRpcSchema();
    }

    public String getNodeMetrics() throws Throwable {
        return metricsService.getMetrics();
    }
}
