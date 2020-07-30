# linux 命令



# 查看进程

## ps



```
ps -A //显示所有的进程信息

ps -u root //显示root 进程用户信息

ps -ef //显示所有命令，连带命令行
```



```
ps -ef | grep ngnix //查询和ngnix相关的进程信息

```



# 查看端口号

## lsof

```
lsof -i:8080
```



netstat -tunlp

```
netstat -tunlp | grep 
```

- -t (tcp) 仅显示tcp相关选项
- -u (udp)仅显示udp相关选项
- -n 拒绝显示别名，能显示数字的全部转化为数字
- -l 仅列出在Listen(监听)的服务状态
- -p 显示建立相关链接的程序名

 