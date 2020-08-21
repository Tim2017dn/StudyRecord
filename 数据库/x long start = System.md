```


long start = System.currentTimeMillis();
long stop = System.currentTimeMillis();
System.out.println(stop-start+" ms");


"打点处1"

"打点处3"

"打点处3"









long start = System.currentTimeMillis();
long stop = System.currentTimeMillis();
System.out.println(stop-start+" ms");

```



````
List<Integer> shopIds = reviews.stream().map(r -> r.getShopId()).collect(Collectors.toList());

                    Map<String, Set<String>> shopEmpMap = shopAMModel.batchGetAMEmpIdsByShopids(shopIds);

                    List<ReminderTemplateParamInfo> templateParamBatch = Lists.newArrayList();

                    for (ShopBadReview badReview : reviews) {

                        ReminderTemplateParamInfo templateParamInfo = new ReminderTemplateParamInfo();
                        // 设置 接收人
                        Set<String> receiverIdsSet = Sets.newHashSet();
                        Set<String> receiverAMs = shopEmpMap.get(String.valueOf(badReview.getShopId()));
                        if (receiverAMs != null && !receiverAMs.isEmpty()) {
                            receiverIdsSet.addAll(receiverAMs);
                        }

                        Map<String, OperationEmpDTO> salesMap = shopRelationProcessor.getTgSales(0, badReview.getShopId());
                        if (salesMap != null && !salesMap.isEmpty()) {
                            Set<String> sales = salesMap.entrySet().stream().filter(s -> s != null && s.getValue() != null).map(s -> s.getValue().getEmpId()).collect(Collectors.toSet());
                            if (sales != null && !sales.isEmpty()) {
                                receiverIdsSet.addAll(sales);
                            }
                        }
                        if (receiverIdsSet.isEmpty()) {
                            continue;
                        }
                        List receiverIdsList = Lists.newArrayList(receiverIdsSet);
                        templateParamInfo.setReceiverIds(receiverIdsList);
                        //设置链接
                        templateParamInfo.setPcLink((Environment.isOnlineEnv() ? Link.PC_AURORA_SHOP_DETAIL_ON_LINE : Link.PC_AURORA_SHOP_DETAIL_OFF_LINE) + badReview.getShopId());
                        // 设置参数
                        Map<String, Object> templateParam = Maps.newHashMap();
                        templateParam.put("shopName", badReview.getShopName());
                        templateParam.put("reviewAddDate", DateUtil.formatDate(badReview.getReviewAddDate()));
                        templateParam.put("platformName", "dp".equals(badReview.getPlatform()) ? "点评" : "美团");
                        templateParam.put("num", badReview.getNum());

                        templateParamInfo.setTemplateParameter(templateParam);
                        templateParamBatch.add(templateParamInfo);

                    }


                    return templateParamBatch;
````

