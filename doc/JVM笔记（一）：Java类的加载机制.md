Java类的生命周期：

加载 ————> 连接（验证、准备、解析） ————> 初始化  ————> 使用 ————> 卸载。

说明：

1、加载

查找并加载类的二进制数据，即.class文件；

2、连接

验证————确保被加载类的正确性；
准备————为类的*静态变量*分配内存，并将其初始化为默认值；
解析————虚拟机将常量池中的符号引用替换为直接引用。

3、初始化

在Java中对类变量进行初始值设定有两种方式：

  > 声明类变量是指定初始值

  > 使用静态代码块为类变量指定初始值