#	SpringCloud 学习记录（一）提供者和消费者



## 介绍

微服务要求服务拆分成一个个小的服务模块

这样做的好处：

- 解耦合，
- 便于独立开发

- 便于部署上的自由选择，有的服务流量高，就可以多部署



## 特点

服务通过网络之间调用

## 实践

![image-20200726103154849](/Users/dn/Library/Application Support/typora-user-images/image-20200726103154849.png)



### 父工程

对包进行统一的管理

```java

 <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Greenwich.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.1.4.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>


            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>1.3.2</version>
            </dependency>

            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.47</version>
            </dependency>

            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>1.1.10</version>
            </dependency>


            <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.12</version>
                <scope>provided</scope>
            </dependency>


            <!-- https://mvnrepository.com/artifact/junit/junit -->
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.13</version>
            </dependency>

        </dependencies>
    </dependencyManagement>


    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```



#### api 项目

放入需要传输的对象，也就是实体类

记得实现Serializable 接口，否则无法序列化

```java

@Data
@NoArgsConstructor()
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;
    private String dept_name;
    private String db_source;

    public Dept(String dept_name) {
        this.dept_name = dept_name;
    }
}
```





#### provider

这边和之前区别不大，一样是写一个三层架构的项目，

稍微不一样：要求服务小一些



### consumer

作为调用方，这里需要做的事，就是去调用 provider 提供的服务，

##### 如何调用了？

controller

```java
@Controller
public class DeptConsumerController {

    @Autowired
    private RestTemplate template;


    private static final String PREFIX = "http://localhost:8001";

    @RequestMapping("/consume/get/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") Integer id){
        return template.getForObject(PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consume/add")
    @ResponseBody
    public Dept add( String dept_name){
        Dept dept = new Dept(dept_name);
        return template.postForObject(PREFIX+"/dept/add/",dept,Dept.class);
    }
}
```

Config

```java
@Configuration
public class ConfigBean {


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
```



通过一个 RestTemplate 的对象的相关方法，通过传输url，进行调用。



## need to know in the future

```
1、Template 是如何起作用的，为什么传输url就可以去调用

```



