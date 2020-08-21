```sql

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.dianping.midas.aurora.base.biz.dao.shop.ShopReviewMapper" >
    <resultMap id="BaseResultMap" type="com.dianping.midas.aurora.base.biz.entity.shop.ShopReview" >
        <id column="Id" property="id" jdbcType="BIGINT" />
        <result column="ShopId" property="shopId" jdbcType="BIGINT" />
        <result column="Platform" property="platform" jdbcType="VARCHAR" />
        <result column="ReviewId" property="reviewId" jdbcType="BIGINT" />
        <result column="ReviewAddDate" property="reviewAddDate" jdbcType="DATE" />
        <result column="ReviewAddTime" property="reviewAddTime" jdbcType="TIMESTAMP" />
        <result column="ReviewStar" property="reviewStar" jdbcType="INTEGER" />
        <result column="ReviewType" property="reviewType" jdbcType="VARCHAR" />
    </resultMap>
    <resultMap id="ResultMapWithBLOBs" type="com.dianping.midas.aurora.base.biz.entity.shop.ShopReview" extends="BaseResultMap" >
        <result column="ReviewContent" property="reviewContent" jdbcType="LONGVARCHAR" />
    </resultMap>
    <sql id="Base_Column_List" >
    Id, ShopId, Platform, ReviewId, ReviewAddDate, ReviewAddTime, ReviewStar, ReviewType
  </sql>
    <sql id="Blob_Column_List" >
    ReviewContent
  </sql>

    <select id = "selectByReviewAddDate" resultMap="BaseResultMap" parameterType="java.util.Date">
        select
        <include refid = "Base_Column_List" />
        from shop_review
    </select>

    <select id="selectReview" resultMap="BaseResultMap">
             select
            <include refid = "Base_Column_List" />
            from shop_review
    </select>

    <select id="batchSelectReview" resultMap="BaseResultMap">
        select
        <include refid = "Base_Column_List" />
        from shop_review
        order by Id
        limit #{offset},#{size}
    </select>

</mapper>

```



```
public interface ShopReviewMapper {

    List<ShopReview> selectByReviewAddDate(Date reviewAddDate);

    void selectReview(@Param("pageModel") PageModel pageModel);

    List<ShopReview> batchSelectReview(@Param("offset") Integer offset,@Param("size") Integer size);

}
```





reminderJob

```java
@Crane("aurora-base-service.craneTest")
    public void craneTest(){
        try{
            testCrane.test();
           // expireTicket.ticketExpireRemind();
        }catch(Exception e){
            log.error("craneTest error",e);
            throw e;
        }
    }
```





```java
package com.dianping.midas.aurora.base.biz.job.reminder;


import com.dianping.lion.Environment;

import com.dianping.midas.aurora.base.biz.constants.Link;
import com.dianping.midas.aurora.base.biz.dao.shop.ShopReviewMapper;
import com.dianping.midas.aurora.base.biz.entity.reminder.ReminderInstanceParam;
import com.dianping.midas.aurora.base.biz.entity.reminder.ReminderTemplateParamInfo;
import com.dianping.midas.aurora.base.biz.entity.shop.ShopReview;
import com.dianping.midas.aurora.base.biz.entity.visit.Visit;
import com.dianping.midas.aurora.base.biz.model.reminder.ReminderModel;
import com.dianping.midas.aurora.base.biz.utils.DateUtil;
import com.dianping.zebra.dao.plugin.page.PageModel;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Component
public class TestCrane {


    @Resource
    private ReminderModel reminderModel;

    @Autowired
    ShopReviewMapper shopReviewMapper;

    public static int BATCH_SIZE =3;

    private static final int BAD_REVIEW_TEMPLATE_CODE = 2046;

    public void test(){

        try{
            Date now = new Date();
            ReminderInstanceParam reminderInstanceParam = ReminderInstanceParam.builder()
                    .templateCode(BAD_REVIEW_TEMPLATE_CODE)
                    .remindTime(now)
                    .expiredTime(DateUtil.getDateEnd(now))
                    .deduplication(DateUtil.formatDot(now)+"-"+BAD_REVIEW_TEMPLATE_CODE)
                    .build();

            Map<String, Object> map = Maps.newHashMap();
            map.put("expiredTime", DateUtil.formatDot(now));

            Set<String> receiverIds = Sets.newHashSet();
          //  receiverIds.add("2550149");
            // 2176613,2440164,2266668
            receiverIds.add("2176613");
            receiverIds.add("2440164");
            receiverIds.add("2266668");

            PageModel pageModel = new PageModel(1,1);
            shopReviewMapper.selectReview(pageModel);
            int recordCount = pageModel.getRecordCount();
            System.out.println(recordCount);


            List<ShopReview> reviews = new ArrayList<>();
            for (int offset = 0; offset < recordCount; offset += BATCH_SIZE) {
                List<ShopReview> temp = shopReviewMapper.batchSelectReview(offset, BATCH_SIZE);
                reviews.addAll(temp);
            }


            List<ReminderTemplateParamInfo> templateParamInfos = Lists.newArrayList();

            ReminderTemplateParamInfo templateParamInfo = new ReminderTemplateParamInfo();
            templateParamInfo.setReceiverIds(Lists.newArrayList(receiverIds));
            Map<String,Object> templateParam = Maps.newHashMap(map);
            templateParam.put("shopName","xxx测试");
            //templateParam.
            templateParamInfo.setPcLink((Environment.isOnlineEnv() ? Link.PC_AURORA_SHOP_DETAIL_ON_LINE : Link.PC_AURORA_SHOP_DETAIL_OFF_LINE) + "101267921");
            templateParamInfo.setTemplateParameter(templateParam);
            templateParamInfos.add(templateParamInfo);

            reminderModel.createReminderInstance(reminderInstanceParam, templateParamInfos);


        }catch(Exception e){
            log.error("encounter a error ",e);
        }


    }

}

```





```
Set<String> receiverIds = shopModel.getAccountAllSaleOfShopId(dpShopId);
```



```java
public Set<String> getAccountAllSaleOfShopId(int dpShopId) {
        Set<String> receiverIds = Sets.newHashSet();
        List<AdAccountDTO> adAccountDTOS = allAccountInfoOfDpShop(String.valueOf(dpShopId));
        List<Integer> accountIds = adAccountDTOS.stream().map(AdAccountLiteDTO::getId).collect(Collectors.toList());
        accountIds.forEach(accountId -> {
            List<OperationEmpDTO> empDTOS = accountAssignmentService.findEmpsByAccountIdAndProductId(accountId, null);
            Set<String> emps = empDTOS.stream().map(OperationEmpDTO::getEmpId).collect(Collectors.toSet());
            receiverIds.addAll(emps);
        });
        return receiverIds;
    }
```

