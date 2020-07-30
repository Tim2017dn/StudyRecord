





# I/O 



# 字节流

## InputStream

### API

```java
int read() //读取单个数据
int read(byte[] b) //将读取的数据写到byte[] 里
```







## FileInputStream







#### 单个字符读

```java
 InputStream is = new FileInputStream("E:\\ProjectWorkspace\\IDEAWorkspace\\算法4的学习\\src\\graphPackage\\tinyG.txt");

int temp;
while((temp=is.read())!=-1){
    System.out.print((char)temp+" ");
}

System.out.println((char)10+"1");
System.out.println("\n\r"+"1");

is.close();
 
```

#### 读字符数组

```java
InputStream is = new FileInputStream("E:\\ProjectWorkspace\\IDEAWorkspace\\算法4的学习\\src\\graphPackage\\tinyG.txt");
byte[] arr = new byte[20];

int len;
while((len=is.read(arr))!=-1){
System.out.print(new String(arr,0,len));
}

is.close();
```

*tip*

这里使用new String(arr,0,len) 从零开始输出len长度的

为什么会这样，

因为，每次应该读取到固定为20长度的字符

最后一次只能读取len长度的字符，len之后的数据，是上次的读取数据





# 字符流

# Reader

 ## FileReader







```java
FileReader fr = new FileReader("src/graphPackage/text.txt");

int len=0;
char[] ch=new char[5];
while((len=fr.read(ch))!=-1){
    System.out.println(new String(ch,0,len));
}

fr.close();
```

text.txt
```txt
你好aaaaa&*%^$
```





