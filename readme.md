2018.11.1  commit

这是一个近乎完全解耦的android 组件化方案
本框架实现以下几点:
1.实现业务组件的完全解耦,注意是完全解耦,主app和每个组件的交互通过common组件->component-base进行注册和分发
2.通过gradle实现组件的单独编译,实现模块的敏捷开发
3.activity的跳转通过alibaba的ARouter通过common进行跳转
4.本框架实现fragment实现完全解耦,推荐使用frament,通过component-base的service注册及分发实现


基于当前版本:
本框架局限性:由于ARouter的单进程体制,暂不支持跨进程,但是可以开发者可以在component-base的基础上实现AIDLManager实现跨进程进程app开发

sure  会一步步完善以下几点

1.各组件之间res的定制化控制
2.基于component-base的注册分发机制,实现AIDLManager的跨进程
3.实现sp的跨进程读取,当然有机会可以基于ARouter自己实现跨进程的跳转的自定义navigate框架


2018.11.2 commit

提交阿里巴巴  ARouter拦截器
不同业务组件 设置ARouter然后进行拦截处理  宿主APP业务逻辑减少







博客地址:[简书](https://www.jianshu.com/p/b9766b1a9c31)
