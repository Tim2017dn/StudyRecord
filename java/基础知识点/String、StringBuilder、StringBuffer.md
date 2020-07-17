# String、StringBuilder、StringBuffer

https://segmentfault.com/a/1190000021908557

https://www.jianshu.com/p/2cf1f60b0d9a



## 区别

### 1 

 String 发生更改，地址会变

StringBuilder、StringBuffer



```java
String string = "初始值";
StringBuffer stringBuffer = new StringBuffer("初始值");
StringBuilder stringBuilder = new StringBuilder("初始值");
System.out.println("string:"+string.hashCode());
System.out.println("stringBuffer:"+stringBuffer.hashCode());
System.out.println("stringBuilder:"+stringBuilder.hashCode());
string = string+"更新了";
stringBuffer = stringBuffer.append("更新了");
stringBuilder = stringBuilder.append("更新了");
System.out.println("***********************************");
System.out.println("string:"+string.hashCode());
System.out.println("stringBuffer:"+stringBuffer.hashCode());
System.out.println("stringBuilder:"+stringBuilder.hashCode());
```

运行效果

```
string:20934318
stringBuffer:1580066828
stringBuilder:491044090
***********************************
string:910164828
stringBuffer:1580066828
stringBuilder:491044090
```

可以看到String 的地址确实发生改变了。



why？



### 2

String StirngBuilder 线程不安全 thread unsafe

StringBuffer thread safe



```java
public class Test {

  public static void main(String[] args) {
    StringBuilder builder = new StringBuilder();
    StringBuffer buffer = new StringBuffer();

    for (int i = 0; i < 10; i++) {
      new A(builder, buffer).start();
    }
  }
}

class A extends Thread {

  private StringBuilder builder;

  private StringBuffer buffer;

  A(StringBuilder builder, StringBuffer buffer) {
    this.buffer = buffer;
    this.builder = builder;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      builder.append("c");
      buffer.append("c");

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("[" + Thread.currentThread().getName() + "]builder:" + builder.length());
    System.out.println("[" + Thread.currentThread().getName() + "]buffer:" + buffer.length());
  }
}
```



Why?

```

```

