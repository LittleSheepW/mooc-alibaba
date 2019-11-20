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