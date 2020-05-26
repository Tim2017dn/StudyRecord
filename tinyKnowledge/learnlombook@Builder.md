

学习 lombok 的 @builder 标签

User.java

```
import lombok.Builder;
import lombok.ToString;


@Builder
@ToString
public class User {

    private Integer id;
    private String name;
    private String address;

}
```

testUser.java

```
public class testUser {

    public static void main(String[] args) {
        User u= User.builder()
                .id(1)
                .name("mike")
                .address("nanjing")
                .build();
        System.out.println(u);
    }

}
```



https://github.com/Tim2017dn/StudyRecord/blob/master/pictures/%E6%88%AA%E5%B1%8F2020-05-26%E4%B8%8B%E5%8D%883.40.18.png

https://github.com/Tim2017dn/StudyRecord/blob/master/pictures/%E6%88%AA%E5%B1%8F2020-05-26%E4%B8%8B%E5%8D%883.45.50.png