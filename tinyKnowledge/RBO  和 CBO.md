# RBO  和 CBO



## rbo



oracle的15个等级

Path1: single row by rowid 

通过行id查询

path2: single row by cluster join

单行 聚簇索引

#### Path 3: Single Row by Hash Cluster Key with Unique or Primary Key

单行  hash簇索引 唯一键or主键



path4 single row by unique or primary key

单行 唯一键or主键



path5 clustered join

聚合索引的join



Path6 hash cluster join

```
SELECT * 
    FROM line_items 
    WHERE orderno = 65118968; 
```



Line_items表以hash cluster 存储，orderno 是主键



Path7 indexed cluster key



path8 composite key 组合key



path9 单列索引



Path10 bound range search on indexed columns



Path11 unbound range search on indexed columns



#### Path 12: Sort Merge Join



#### Path 13: MAX or MIN of Indexed Column



#### Path 14: ORDER BY on Indexed Column



#### Path 15: Full Table Scan

