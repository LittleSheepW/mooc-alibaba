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
> - 加餐1 `Meal.First`  
Java反编译和反汇编的区别：
反编译是指:将class文件反编译成Java源码的过程。  
反汇编是指:将class文件反解析为更可读的虚拟机指令的过程。  
> - 16、虚拟机退出时机问题研究 `ResearchOnTheTimingOfVirtualMachineExit16`  
> - 17、如何解决条件语句的多嵌套问题 `HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17`  
> - 18、一些异常处理建议 `SomeExceptionHandlingSuggestions18`  
> - 19、日志学习和使用的正确姿势 `LogLearningAndUsingTheCorrectPosture19`  
> - 常用的日志级别分为: ERROR、WARN、INFO、DEBUG、TRACE。  
ERROR日志的使用场景是:影响到程序正常运行或影响到当前请求正常运行的异常情况。比如打开配置失败、调用二方或者三方库抛出异常等。  
WARN日志的使用场景是:不应该出现，但是不影响程序正常运行，不影响请求正常执行的情况。如找不到某个配置但是使用了默认配置，比如某些业务异常。  
INFO日志的使用场景是:需要了解的普通信息，比如接口的参数和返回值，异步任务的执行时间和任务内容等。  
DEBUG日志的使用场景是:所有调试阶段想了解的信息。比如无法进行远程DEBUG时，添加DEBUG日志在待研究的函数的某些位置打印参数和中间数据等。  
TRACE日志的使用场景是:非常详细的系统运行信息，比如某个中间件读取配置，启动完成等。实际业务开发中TRACE级别的日志很少使用。  
> - 20、单元测试的知识储备 `KnowledgeReserveForUnitTesting20`  
`@RunWith` junit的注解，通过这个注解使用SpringRunner.class，能够将junit和spring进行集成。后续的spring相关注解才会起效。  
`@SpringBootTest` spring的注解，通过扫描应用程序中的配置来构建测试用的Spring上下文。  
`@AutoConfigureMockMvc`	spring的注解，能够自动配置MockMvc对象实例，用来在模拟测试环境中发送http请求。  
`@WebMvcTest` spring的注解，切片测试的一种。使之替换@SpringBootTest能将构建bean的范围限定于web层，但是web层的下层依赖bean，需要通过mock来模拟。也可以通过参数指定只实例化web层的某一个到多个controller。  
`@RestClientTest` spring的注解，切片测试的一种。如果应用程序作为客户端访问其他Rest服务，可以通过这个注解来测试客户端的功能。  
`@MybatisTest`	mybatis按照spring的习惯开发的注解，切片测试的一种。使之替换@SpringBootTest，能够将构建bean的返回限定于mybatis-mapper层。  
`@JdbcTest`	spring的注解，切片测试的一种。如果应用程序中使用Jdbc作为持久层（spring的JdbcTemplate），那么可以使用该注解代替@SpringBootTest，限定bean的构建范围。
`@DataJpaTest` spring的注解，切片测试的一种。如果使用Jpa作为持久层技术，可以使用这个注解。
`@DataRedisTest` spring的注解，切片测试的一种。  
> - 21、单元测试构造数据的正确姿势 `UnitTestConstructsTheCorrectPostureOfTheData21`  
> - 22、单元测试之单测举例 `SingleTestExampleOfUnitTest22`  
> - 23、Java学习宝典 `JavaStudyBook23`  
> - 24、代码调试的正确姿势 `CorrectPostureForCodeDebugging24`  
> - 25、阅读源码的正确姿势 `TheCorrectPostureToReadTheSourceCode25`  
> - 26、代码重构的正确姿势 `CorrectPostureForCodeRefactoring26`  
> - 27、Code Review的正确姿势 `CodeReviewCorrectPosture27`  