JVM内存结构：

> 1、堆内存

>> 年轻代；
>>> Eden空间（80%）；

>>> From Survivor空间（10%）；

>>> To Survivor空间（10%）；

>> 老年代；

> 2、方法区（别名 Non-Heap）：存储类信息、常量、静态变量等数据，是线程共享的区域；

> 3、栈  

>> Java虚拟机栈；

>> 本地方法栈：主要用于方法的执行。


参考链接：
http://www.cnblogs.com/ityouknow/p/5610232.html