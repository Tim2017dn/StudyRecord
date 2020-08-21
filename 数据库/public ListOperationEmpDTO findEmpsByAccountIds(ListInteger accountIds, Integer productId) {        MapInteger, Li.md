```java
public List<OperationEmpDTO> findEmpsByAccountIds(List<Integer> accountIds, Integer productId) {
        Map<Integer, List<AccountAssignment>> accountAssignmentMap = accountAssignmentModel.batchQueryAssignmentsByAccounts(accountIds);
        if (MapUtils.isEmpty(accountAssignmentMap) || !accountAssignmentMap.containsKey(accountIds)) {
            return Collections.emptyList();
        }

        List<AccountAssignment> accountAssignments = accountAssignmentMap.get(accountId);
        if (CollectionUtils.isEmpty(accountAssignments)) {
            return Collections.emptyList();
        }

        List<Integer> territories = accountAssignments.stream().map(AccountAssignment::getTerritoryId).distinct().collect(Collectors.toList());
        Map<Integer, List<Integer>> territoryProductMap = territoryModel.batchQueryProductIdsByTerritoryIds(territories);

        Set<String> empIds = Sets.newHashSet();
        for (AccountAssignment accountAssignment : accountAssignments) {
            List<Integer> productIds = territoryProductMap.getOrDefault(accountAssignment.getTerritoryId(), Lists.newArrayList());
            if (productId == null || productIds.contains(productId)) {
                empIds.add(accountAssignment.getEmpId());
            }
        }

        return empService.batchQueryEmpByEmpIds(Lists.newArrayList(empIds));
    }
```

