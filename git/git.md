# git



https://www.cnblogs.com/qyf404/p/git_push_local_branch_to_remote.html



```
git checkout -b feature-branch origin/feature-branch    //检出远程的feature-branch分支到本地
```





```
git checkout -b feature-branch    //创建并切换到分支feature-branch  
git push origin feature-branch:feature-branch    //推送本地的feature-branch(冒号前面的)分支到远程origin的feature-branch(冒号后面的)分支(没有会自动创建)
```

