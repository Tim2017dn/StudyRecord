



# Springboot 整合 mybatis



项目结构

```
-src
	-main
		-java
			-com.dn.learnredis
				-controller
				-mapper
				-pojo
					-user.java
				-service
				LearnredisApplication.java (主类)
		-resource
	-test
```





### 第一步

pom.xml添加依赖 

```
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
```



### 第二步 

配置连接

resource里的application.properties 添加如下内容

```java
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/ssm?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=12341234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

```



### 简单测试1

数据库准备一张user的表

```java
@SpringBootTest
class LeanredisApplicationTests {  
		@Test
    public void test1() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from user");
        
       while(resultSet.next()){
           System.out.println(resultSet.getString("name"));
       }

    }
}
```



### 第三步

pojo 类

```java
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    Integer id;
    String name;
    Integer pass;

    public User(){};

    public User(Integer id,String name,Integer pass){
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

}
```



mapper类 UserMapper.java

注意要加@mapper

```java
@Mapper
public interface UserMapper {


    @Select("select * from user where name = #{name}")
     User finByName(String name);

    boolean insertOneUser(User u);

}
```



service类 UserService.java

```java
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public User find(String name){
        User user = userMapper.finByName(name);
        return user;
    }

    public boolean insert(String name,Integer pass){
        User u = User.builder().build();
        u.setName(name);
        u.setPass(pass);
        boolean b = userMapper.insertOneUser(u);
        return b;
    }


}
```



注意这里可以在 主类上添加对mapper的扫描

```java
@SpringBootApplication
@MapperScan("com.dn.learnredis.mapper")
public class LeanredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeanredisApplication.class, args);
    }

}

```



还可以怎么配置了？





### 简单测试2

```java
	@Test
    public void test2(){

        boolean bool = userService.insert("zhang", 1234);
        System.out.println(bool);
    }
```





### 第四步

更多的是需要谢xml，毕竟注释还是有限

在resource下建立mapper包，再在这个下面放xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.dn.leanredis.mapper.UserMapper">

    <insert id="insertOneUser" parameterType="com.dn.leanredis.pojo.User" useGeneratedKeys="true">
        insert into user (`name`,pass)
        values (#{name},#{pass})
    </insert>
</mapper>
```



 注意再在 application.properties 配置

```
mybatis.mapper-locations=classpath:mapper/*.xml
```



## end

