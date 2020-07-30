

## 问题一

报错信息

```
CMakeFiles\memory.dir/objects.a(main.c.obj): In function `main':
E:/ProjectWorkspace/CLion-workspace/memory/main.c:37: undefined reference to `_imp____acrt_iob_func'
E:/ProjectWorkspace/CLion-workspace/memory/main.c:41: undefined reference to `_imp____acrt_iob_func'
collect2.exe: error: ld returned 1 exit status
mingw32-make.exe[3]: *** [CMakeFiles\memory.dir\build.make:85: memory.exe] Error 1
mingw32-make.exe[2]: *** [CMakeFiles\Makefile2:75: CMakeFiles/memory.dir/all] Error 2
mingw32-make.exe[1]: *** [CMakeFiles\Makefile2:82: CMakeFiles/memory.dir/rule] Error 2
mingw32-make.exe: *** [Makefile:117: memory] Error 2

```

问题代码

```
 fflush(stdout);
```

