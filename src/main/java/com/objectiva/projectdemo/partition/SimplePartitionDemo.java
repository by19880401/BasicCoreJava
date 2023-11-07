package com.objectiva.projectdemo.partition;

import cn.hutool.log.StaticLog;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimplePartitionDemo {

    private static final int batchSize = 5;

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    public static final String CONTENT = "%d_%s";
    public static final String DELIMITER = ",";

    public static void main(String[] args) {
        Collection<OrgMapNode> allAssignedJob = getCase4_1();
        StaticLog.info("Fetched Assigned Jobs Count: [{}].", allAssignedJob.size());
        Collection<List<OrgMapNode>> orgMapNodes = allAssignedJob.stream().collect(Collectors.groupingBy(OrgMapNode::getNodeId)).values();
        StaticLog.info("orgMapNodes: [{}]", orgMapNodes);

        //This is to split the data smaller than batch size
        List<List<OrgMapNode>> partition = partitionOrgMapNodes(batchSize, orgMapNodes);

        partition.forEach(batchNodes -> bindBatchTask(resolveAssignedJobs(batchNodes)));
    }

    private static List<List<OrgMapNode>> partitionOrgMapNodes(int batchSize, Collection<List<OrgMapNode>> orgMapNodes) {
        List<List<OrgMapNode>> partition = new ArrayList<>();
        partition.add(new ArrayList<>());
        for (List<OrgMapNode> v : orgMapNodes) {
            List<OrgMapNode> lastOrgMapNode = partition.get(partition.size() - 1);
            if (lastOrgMapNode.size() + v.size() >= batchSize) {
                List<OrgMapNode> newOrgMapNode = new ArrayList<>();
                partition.add(newOrgMapNode);
                lastOrgMapNode = newOrgMapNode;
            }
            lastOrgMapNode.addAll(v);
        }
        return partition;
    }

    private static List<String> resolveAssignedJobs(Collection<OrgMapNode> jobList) {
        if (jobList == null) {
            return Collections.emptyList();
        }
        return jobList.stream().map(node ->
                        String.format(CONTENT, node.getNodeId(), node.getExpirationDate().minusDays(1).format(DATE_FORMATTER)))
                .collect(Collectors.toList());
    }

    private static void bindBatchTask(List<String> batchNodes) {
        String context = batchNodes.stream().collect(Collectors.joining(DELIMITER));
        StaticLog.info("context: [{}]", context);
    }


    /**
     * 1,2,3
     *
     * @return as below:
     * context: [1_05-26-2022,2_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase1() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 1,1,2,2,3,3
     *
     * @return as below:
     * context: [1_05-26-2022,1_05-26-2022,2_05-26-2022,2_05-26-2022]
     * context: [3_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase2() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        return results;
    }


    /**
     * 1,1,1,2,3
     *
     * @return as below:
     * context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,2_05-26-2022]
     * context: [3_05-26-2022]
     */
    public static List<OrgMapNode> getCase3() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 1,1,1,1,2,3
     *
     * @return as below:
     * context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022]
     * context: [2_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase4() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 1,2,3,4,5
     *
     * @return as below:
     * context:  [1_05-26-2022,2_05-26-2022,3_05-26-2022,4_05-26-2022]
     * context: [5_05-26-2022]
     */
    public static List<OrgMapNode> getCase4_1() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(4L));
        results.add(new OrgMapNode(5L));
        return results;
    }

    /**
     * 1,1,1,1,1,1,2,3
     * @return as below:
     *  context: []
     *  context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022]
     *  context: [2_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase5() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 1,1,1,1,1,1,1,2,3
     * @return as below:
     *  context: []
     *  context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022]
     *  context: [2_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase6() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 1,1,1,1,1,1,1,1,1,1,1,1,2,3
     * @return as below:
     *  context: []
     *  context: context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022]
     *  context: [2_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase7() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 1,1,1,1,2,2,2,2,3,3,3,3
     * @return as below:
     *  context: context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022]
     *  context: context: [2_05-26-2022,2_05-26-2022,2_05-26-2022,2_05-26-2022]
     *  context: context: [3_05-26-2022,3_05-26-2022,3_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase8() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 1,1,1,1,1,2,2,2,2,2,3,3,3,3,3
     * @return as below:
     *  context: []
     *  context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022]
     *  context: [2_05-26-2022,2_05-26-2022,2_05-26-2022,2_05-26-2022,2_05-26-2022]
     *  context: [3_05-26-2022,3_05-26-2022,3_05-26-2022,3_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase9() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3
     * @return as below:
     *  context: []
     *  context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022]
     *  context: [2_05-26-2022,2_05-26-2022,2_05-26-2022,2_05-26-2022,2_05-26-2022,2_05-26-2022]
     *  context: [3_05-26-2022,3_05-26-2022,3_05-26-2022,3_05-26-2022,3_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase10() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        results.add(new OrgMapNode(3L));
        return results;
    }

    /**
     * 2,1,1,1,1,1,1,3
     * @return as below:
     *  context: context: [1_05-26-2022,1_05-26-2022,1_05-26-2022,1_05-26-2022]
     *  context: context: [2_05-26-2022,2_05-26-2022,2_05-26-2022,2_05-26-2022]
     *  context: context: [3_05-26-2022,3_05-26-2022,3_05-26-2022,3_05-26-2022]
     */
    public static List<OrgMapNode> getCase11() {
        List<OrgMapNode> results = new ArrayList<>();
        results.add(new OrgMapNode(2L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(1L));
        results.add(new OrgMapNode(3L));
        return results;
    }


}
