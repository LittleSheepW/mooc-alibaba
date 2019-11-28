# mooc-alibaba

####学习阿里巴巴编码规约手册详解

> - 02、Integer缓存问题分析  `IntegerCacheProblemAnalysis02`，包装类型中缓存相关知识，Integer.chche缓存范围-128-127是JLS中要求
的，缓存经常使用到的对象，可以减少内存并且可以提高访问速度。  
> - 03、Java序列化引发的血案  `JavaSerializable03`，Json反序列化Map时如果原始值小于Int最大值，反序列化后原本为Long类型的字段，
会变为Integer 类型，使用readObject()方法对对象中不可序列化的属性进行序列化。  
> - 04、学习浅拷贝和深拷贝的正确姿势 `JavaClone04`    
**浅拷贝之后一般情况下**：  
①x.clone() != x的结果为true  
②x.clone().getClass() == x.getClass()的结果为true  
③x.clone().equals(x)的结果也是true  
**深拷贝的方式有4种**：  
①重写clone()方法，手动将类中所有引用类型的数据重新生成新的对象  
②使用JDK序列化方式实现  
③使用commons-lang3中SerializationUtils.clone()方法  
④使用Gson库进行Json序列化实现  
> - 05、分层领域模型使用解读 `HierarchicalDomainModel05`  
> - 06、Java属性映射的正确姿势 `AttributeMapping06`  
> - 07、过期类、属性、接口的正确处理姿势 `Deprecated07`    
> - 08、空指针引发的血案 `BloodyCaseCausedByNullpointer08`    
> - 09、当switch遇到空指针 `SwitchMeetNullpointer09`  
switch语句必须满足以下条件，否则会出现编译错误:  
1、与switch语句关联的每个case都必须和switch的表达式的类型一致;  
2、如果switch表达式是枚举类型 case常量也必须是枚举类型;   
3、不允许同一个switch的两个case常量的值相同;  
4、和switch语句关联的常量不能为null ;  
5、一个switch语句最多有-个default标签。  
> - 10、枚举类的正确学习方式 `EnumerationClassCorrectLearningPosture10`  
> - 11、ArrayList的SubList和Arrays的asList学习 `ArrayListSubListAndArraysAsList11`  
> - 12、添加注释的正确姿势 `AddTheCorrectPostureForTheAnnotation12`  
> - 13、你真的了解可变参数吗 `DoYouReallyUnderstandVariadicParameters13`  
> **为了兼容Java SE 5.0之前的版本，方法签名的选择分为3个阶段：**  
> - 第一阶段:不让自动装箱和拆箱，也不能使用可变参数的情况下选择重载。如果无法选择合适地方法，则进入第二阶段。由于不允许自动拆箱、拆箱和可变参数，
这一条保证了Java SE 5.0之前的函数调用的合法性。如果在第一阶段可变参数生效，如果在一个已经声明了m(Object) 函数的类中声明m(Obejct..obj)函数，
会导致即使有更适合的表达式(如m(null))也不会选择 m(Object) 。  
> - 第二阶段:允许自动装箱和拆箱，但是仍然排除变长参数的重载。如果仍然无法选择合适的方法，则进入第三阶段。这是为了保证，如果定义了定长参数的函数情况下，不会选择变长参数。
> - 第三阶段:允许自动装箱、拆箱和变长参数的重载。  
> - 14、集合去重的正确姿势 `SetTheCorrectPostureForDeduplication14`  
> (1)HashSet元素唯一-性是通过HashMap 的key唯一-性来实现的;  
(2)性能的差距是元素查找函数的时间复杂度不同导致的;  
(3)元素较少时两者耗时差距很小，随着元素的增多耗时差距越来越大。   
> - 15、学习线程池的正确姿势 `LearningTheCorrectPostureOfTheThreadPool15`    
`ThreadPoolExecutor.execute() 分为3个处理步骤：`  
1、如果线程池中小于corePoolSize 个执行的线程，则新建线程将当前任务作为第一个任务来执行;  
2、如果任务成功入队，我们仍然需要double- -check判断是否需要往线程池中新增线程(因为上次检查后可能有一个已经存在的线程挂了)或者进入这段函数时线程池关闭了;  
3、如果不能入队，则创建一个新线程。如果失败，我们就知道线程池已经被关闭或已经饱和就需要调用拒绝策略来拒绝当前任务。  