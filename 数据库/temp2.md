![image-20200817172125581](/Users/dn/Library/Application Support/typora-user-images/image-20200817172125581.png)



````
for(ShopBadReview badReview:reviews){
                ReminderTemplateParamInfo templateParamInfo = new ReminderTemplateParamInfo();
                // 设置 接收人
                Set<String> receiverIds = shopModel.getAccountAllSaleOfShopId(Integer.parseInt(badReview.getShopId().toString()));
                if(receiverIds.isEmpty()){
                    continue;
                }
                templateParamInfo.setReceiverIds(Lists.newArrayList(receiverIds));
               //设置链接
                templateParamInfo.setPcLink((Environment.isOnlineEnv() ? Link.PC_AURORA_SHOP_DETAIL_ON_LINE : Link.PC_AURORA_SHOP_DETAIL_OFF_LINE) + badReview.getShopId());
                // 设置参数
                Map<String, Object> templateParam = Maps.newHashMap();
                templateParam.put("shopName","xxxxx");
                templateParam.put("reviewAddDate",badReview.getReviewAddDate());
                templateParam.put("platformName","dp".equals(badReview.getPlatform())?"点评":"美团");
                templateParam.put("num",badReview.getNum());

                templateParamInfo.setTemplateParameter(templateParam);
                templateParamInfos.add(templateParamInfo);


````

