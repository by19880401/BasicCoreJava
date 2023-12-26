package com.objectiva.projectdemo.innerclass;

import cn.hutool.log.StaticLog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GLResolverServiceImpl {

    private class AssignedJobWithDate {
        private Long assignedJobId;
        private LocalDate expiryDate;

        public AssignedJobWithDate(Long assignedJobId, LocalDate expiryDate) {
            this.assignedJobId = assignedJobId;
            this.expiryDate = expiryDate;
        }

        public Long getAssignedJobId() {
            return assignedJobId;
        }

        public void setAssignedJobId(Long assignedJobId) {
            this.assignedJobId = assignedJobId;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
        }

        @Override
        public String toString() {
            return "AssignedJobWithDate{" +
                    "assignedJobId=" + assignedJobId +
                    ", expiryDate=" + expiryDate +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<AssignedJobWithDate> assignedJobWithDates = new GLResolverServiceImpl().initList();
//        List<Long> jobIds = assignedJobWithDates.stream().map(assignedJobWithDate -> assignedJobWithDate.assignedJobId).distinct().collect(Collectors.toList());
        List<Long> jobIds = assignedJobWithDates.stream().map(assignedJobWithDate -> assignedJobWithDate.getAssignedJobId()).distinct().collect(Collectors.toList());
        StaticLog.info("jobIds: {}", jobIds);

        for (AssignedJobWithDate assignJobIdAndDate : assignedJobWithDates) {
            Long jobId = assignJobIdAndDate.getAssignedJobId();
            LocalDate expiryDate = assignJobIdAndDate.getExpiryDate();
            StaticLog.info("{},{}", jobId, expiryDate);
        }
    }


    private List<AssignedJobWithDate> initList() {
        List<AssignedJobWithDate> list = new ArrayList<>();
        list.add(new AssignedJobWithDate(10L, LocalDate.now()));
        list.add(new AssignedJobWithDate(20L, LocalDate.now()));
        list.add(new AssignedJobWithDate(20L, LocalDate.now()));
        list.add(new AssignedJobWithDate(30L, LocalDate.now()));
        return list;
    }


}
