```
INSERT OVERWRITE TABLE `${target.table}` PARTITION (partition_date='${now.date}')
SELECT
    shop_id
    ,new_distribute_label
    ,stay_value_potential_label
FROM
(
    SELECT 
        case when '$now.day'=1 and '$now.month' in (3,6,9,12) then t1.shop_id
            when '$now.day'=1 then t2.shop_id
            else t3.shop_id end as shop_id
        ,null as new_distribute_label
        ,case when '$now.day'=1 and '$now.month' in (3,6,9,12) then t1.stay_value_potential_label
            when '$now.day'=1 then t2.stay_value_potential_label
            else t3.stay_value_potential_label end as stay_value_potential_label
            
        ## 分三种情况
        ## 情况一 分区时间是 3、6、9、12月  的1号
        ## 情况二 分区时间是 其余月的1号
        ## 情况三 非1号
    FROM
    (
       SELECT 
            shop_id
    		,case when v_label=1 and p_label=1 then 1
        		when v_label=1 and p_label=2 then 2
            	when v_label=2 and p_label=1 then 3
                when v_label=2 and p_label=2 then 4
            	else  null end as stay_value_potential_label
        FROM
        (
            select shop_id
                    ,case when value_rank <= 0.4*city_shop_num then 1
                            else 2 end as v_label
                    ,case when potential_rank <= 0.4*city_shop_num then 1
                            else 2 end as p_label
            from mart_ado.dm_aurora_beauty_shop_classify_rank
            where partition_date = '$now.month_begin_date.date' ##  当月2号执行形成的门店分数表 即分区时间是当月1号
        )
    )t1 ## 3,6,9,12 形成1号分区
    full outer join 
    (
       
       SELECT 
            if(a.shop_id is not null,a.shop_id,b.shop_id) as shop_id
            ,if(a.shop_id is not null,a.stay_value_potential_label,b.stay_value_potential_label) as stay_value_potential_label
            ## 门店id若在a表有，去表a
            ## 表a没有，再去表b
            
       FROM
       (
            select shop_id
                   ,stay_value_potential_label 
            from mart_ado.dm_aurora_beauty_shop_classify_result
            where partition_date = '$now.delta(months = 1).month_begin_date.date'  ## 找本张表在上月的1号分区的结果
       )a 
       full outer join 
       (
            SELECT 
                shop_id
                ,case when v_label=1 and p_label=1 then 1
                when v_label=1 and p_label=2 then 2
                when v_label=2 and p_label=1 then 3
                when v_label=2 and p_label=2 then 4
                else  null end as stay_value_potential_label
            FROM
            (
                select shop_id
                    ,case when value_rank <= 0.4*city_shop_num then 1
                            else 2 end as v_label
                    ,case when potential_rank <= 0.4*city_shop_num then 1
                            else 2 end as p_label
                from mart_ado.dm_aurora_beauty_shop_classify_rank
                where partition_date = '$now.month_begin_date.date' ## 当月2号执行形成的门店分数表 即分区时间是当月1号 形成本月的标签
            )
       )b on a.shop_id = b.shop_id
    
    )t2 on t1.shop_id =t2.shop_id
    full outer join
    (
        select shop_id
               ,stay_value_potential_label 
        from mart_ado.dm_aurora_beauty_shop_classify_result
        where partition_date = '$now.month_begin_date.date'  ## 取本张表 当月1号分区
    )t3 on t1.shop_id = t3.shop_id
)    
where shop_id is not null

;
```

