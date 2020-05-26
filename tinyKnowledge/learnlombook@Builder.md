

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



 

![截屏2020-05-26下午3.45.50](/Users/dn/Documents/personRecord/学习笔记/gitResource/StudyRecord/pictures/截屏2020-05-26下午3.45.50.png)

![截屏2020-05-26下午3.40.18](/Users/dn/Documents/personRecord/学习笔记/gitResource/StudyRecord/pictures/截屏2020-05-26下午3.40.18.png)