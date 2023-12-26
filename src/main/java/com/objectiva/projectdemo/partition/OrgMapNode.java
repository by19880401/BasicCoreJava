package com.objectiva.projectdemo.partition;

import java.time.LocalDate;

public class OrgMapNode {
    private Long nodeId;

    private LocalDate expirationDate = LocalDate.now();

    public OrgMapNode(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "OrgMapNode{" +
                "nodeId=" + nodeId +
                '}';
    }
}
