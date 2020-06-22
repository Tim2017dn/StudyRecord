# Arrays 相关知识点

## 方法 asList()

```
String str="aaaaa,bbbb,ccc,dd";
List<String> strings = Arrays.asList(str.split(","));
System.out.println(strings.toString());
```

结果

```
[aaaaa, bbbb, ccc, dd]
```

效果 数组 arr 转为 list

