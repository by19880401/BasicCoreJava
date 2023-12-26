package com.objectiva.staticmethod;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;

public class StaticMethodExecuteOrder {
    private static final ForkJoinPool totalizerPool = makeTotalizerPool();
    private static final ForkJoinPool tenantImplTotalizerPool = makeTenantImplTotalizerPool();

    public static void main(String[] args) throws IOException {

        /**
         * There is two cases:
         * one: tenantId = 1, result: no
         * two: tenantId = 9, result: yes
         */

        long tenantId1 = 1L;
        final ForkJoinPool totalizerPool = makeTotalizerPoolLogic(tenantId1);
        StaticLog.info("totalizerPool:{}", totalizerPool);


        long tenantId2 = 9L;
        final ForkJoinPool implTotalizerPool = makeTotalizerPoolLogic(tenantId2);
        StaticLog.info("implTotalizerPool:{}", implTotalizerPool.getPoolSize());
    }

    private static ForkJoinPool makeTotalizerPoolLogic(Long tenantId) throws IOException {
        List<TenantObj> tenants = getAllTenants();
        Optional<TenantObj> tenantObj = tenants.stream().filter((tenant -> tenantId == tenant.getId() && StringUtils.equals(UsageStateEnum.IN_IMPLEMENTATION.getValue(), tenant.getState()))).findFirst();
        if (tenantObj.isPresent()) {
            StaticLog.info("yes, a new pool is active, size: {}", tenantImplTotalizerPool.getParallelism());
            return tenantImplTotalizerPool;
        }
        StaticLog.info("No, use the old pool, size: {}", totalizerPool.getParallelism());
        return totalizerPool;
    }

    private static ForkJoinPool makeTotalizerPool() {
        return new ForkJoinPool(16);
    }

    private static ForkJoinPool makeTenantImplTotalizerPool() {
        return new ForkJoinPool(4);
    }

    private static List<TenantObj> getAllTenants() {
        List<TenantObj> resultList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            TenantObj tenantObj = new TenantObj();
            tenantObj.setId(i);
            tenantObj.setState(UsageStateEnum.IN_PRODUCTION.getValue());
            resultList.add(tenantObj);
        }
        TenantObj tenantObj = new TenantObj();
        tenantObj.setId(9);
        tenantObj.setState(UsageStateEnum.IN_IMPLEMENTATION.getValue());
        resultList.add(tenantObj);
        return resultList;
    }
}
