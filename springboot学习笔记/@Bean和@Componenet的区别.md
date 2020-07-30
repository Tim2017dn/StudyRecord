# @component 和 @bean的区别

https://blog.csdn.net/qq_38534144/article/details/82414201



@component 直接相当于配置好le

```java
@Component
public class Strudent{
		Integer sid
		String name;
		
}
```



@bean 相当于在xml里配置好bean，还需要结合@configruation

```java
@Configuration
public class config{
	
		@Bean
		public Student getStudent(){
				return new Student();
		}
}
```

