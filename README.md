# Leetcode-Java

Programming and algorithm exercises using Java 8 in Leetcode.

- [Problem 344](src/com/moonspirit/leetcode/p344/Problem_344.java)

- [Problem 541](src/com/moonspirit/leetcode/p541/Problem_541.java)

- [Problem 557](src/com/moonspirit/leetcode/p557/Problem_557.java)

- [Problem 709](src/com/moonspirit/leetcode/p709/Problem_709.java) **【简单】** 字符串、编码

- [Problem 777](src/com/moonspirit/leetcode/p771/Problem_771.java) **【简单】** 字符串、搜索

- IoC, Inversion of Control

IoC 容器负责管理 Bean 及其依赖关系，这一过程是容器依赖描述（配置、注解等）自动进行的，而不需要显式的代码操作。也就是说，对象管理和控制权由对象使用者转变为 IoC 容器，即控制反转。控制反转的目的是实现 Bean 之间的解耦合。

- AOP, Aspect Oriented Programming

AOP 用于管理某个切面上对象之间的协作，常用于处理数据库事务、日志、安全、权限等。

> 这种在运行时，动态地将代码切入到类的指定方法、指定位置上的编程思想就是面向切面编程。面向对象的特点是继承、多态和封装。而封装就要求将功能分散到不同的对象中去，这在软件设计中往往称为职责分配。实际上也就是说，让不同的类设计不同的方法。这样代码就分散到一个个的类中去了。这样做的好处是降低了代码的复杂程度，使类可重用。但是人们也发现，在分散代码的同时，也增加了代码的重复性。比如说，我们在两个类中，可能都需要在每个方法中做日志。按面向对象的设计方法，我们就必须在两个类的方法中都加入日志的内容。也许他们是完全相同的，但就是因为面向对象的设计让类与类之间无法联系，而不能将这些重复的代码统一起来。也许有人会说，那好办啊，我们可以将这段代码写在一个独立的类独立的方法里，然后再在这两个类中调用。但是，这样一来，这两个类跟我们上面提到的独立的类就有耦合了，它的改变会影响这两个类。那么，有没有什么办法，能让我们在需要的时候，随意地加入代码呢？这种在运行时，动态地将代码切入到类的指定方法、指定位置上的编程思想就是面向切面的编程。
> 一般而言，我们将切入到指定类指定方法的代码片段称为切面，而切入到哪些类、哪些方法则叫切入点。有了面向切面编程，我们就可以把几个类共有的代码，抽取到一个切片中，等到需要时再切入对象中去，从而改变其原有的行为。这样看来，AOP 其实只是 OOP 的补充而已。OOP 从横向上区分出一个个的类来，而 AOP 则从纵向上向对象中加入特定的代码。有了 AOP，OOP 变得立体了。如果加上时间维度，AOP 使 OOP 由原来的二维变为三维了，由平面变成立体了。从技术上来说，AOP 基本上是通过代理机制实现的。
