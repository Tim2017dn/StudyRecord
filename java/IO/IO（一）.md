# IO（一）

https://www.zhihu.com/question/67535292/answer/1248887503



# 字节流 

byte stream

以字节的形式传输。



## InputStream 输入流

主要

```java
// 读数据
abstract int read();

// 将读到的数据存储到 byte[] b,再将实际读到的yte的个数作为integer返回
int read(byte[] b)

// 
int read(byte[] b,int off,int len)
-- off array b的开始写的位置
-- len 读的最大数量

```

```java
int available()
Returns an estimate of the number of bytes that can be read (or skipped over) from this input stream without blocking by the next invocation of a method for this input stream.

void close()
Closes this input stream and releases any system resources associated with the stream.

long skip()
Skips over and discards n bytes of data from this input stream.
```



## OutputStream 输出流

```java
//
abstract void write(int b)

//将byte[] b 写入输出流
void write(byte[] b)

//将byte[] b从off位置开始，写入长度len的数据
void write(byte[] b,int off,int len)

```

```java
void flush()

void close()
```





# 字符流

char stream

## Reader 

```java
// 读一个字符
int read()

// 将读到数据放到char[] cbuf
int read(char[] cbuf)

//将读到的数据 放到cbuf的 off
abstract int read(char[] cbuf,int off,int len)
```



## writer

```java
void write(char[] cbuf)

abstract void write(char cbuf,int off,int len)

void write(int c)

void write(String str)

void write(String str,int off,int len)
```

