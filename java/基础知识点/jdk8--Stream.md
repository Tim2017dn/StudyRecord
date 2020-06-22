# Jdk8stream

-------



## 官方文档

> https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html



做一个小结 放在前面、

Filter  筛选符合要求的 返回的还是stream

Map 执行函数 返回的还是stream

count() 计数



collect(Collection.asList) 以list的形式返回



## 例子

```java
List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
System.out.println("列表: " +strings);

long count =  strings.stream().filter(s->s.isEmpty()).count();
System.out.println("空字符串数量为: " + count);

count = strings.stream().filter(string -> string.length() == 3).count();
System.out.println("字符串长度为 3 的数量为: " + count);

List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
System.out.println("筛选后的列表: " + filtered);

String mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
System.out.println("合并字符串: " + mergedString);

List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

List<Integer> squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
System.out.println("Squares List: " + squaresList);



List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
System.out.println("列表: " +integers);

IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();

System.out.println("列表中最大的数 : " + stats.getMax());
System.out.println("列表中最小的数 : " + stats.getMin());
System.out.println("所有数之和 : " + stats.getSum());
System.out.println("平均数 : " + stats.getAverage());


System.out.println("随机数: ");
Random random = new Random();
// 还需要学习sort
random.ints().limit(10).sorted().forEach(System.out::println);
//random.ints().limit(10).sorted().forEach(System.out::println);

```

运行结果

```
列表: [abc, , bc, efg, abcd, , jkl]
空字符串数量为: 2
字符串长度为 3 的数量为: 3
筛选后的列表: [abc, bc, efg, abcd, jkl]
合并字符串: abc, bc, efg, abcd, jkl
Squares List: [9, 4, 49, 25]
列表: [1, 2, 13, 4, 15, 6, 17, 8, 19]
列表中最大的数 : 19
列表中最小的数 : 1
所有数之和 : 85
平均数 : 9.444444444444445
随机数: 
-871372349
-854032437
-324625595
87773983
96237296
599185157
653136898
695082787
817053490
1677804157

Process finished with exit code 0

```



关于sort

```
        int[] numbers ={2,8,3,6,9,5,1,4};

        List<Integer> list = Arrays.asList(2,8,3,6,9,5,1,4);
        List<Integer> res = list.stream().filter(x -> x%2 == 0).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }).collect(Collectors.toList());
        System.out.println(res);

```

结果

```
[8, 6, 4, 2]

Process finished with exit code 0

```



