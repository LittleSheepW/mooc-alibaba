# mooc-alibaba

#####学习阿里巴巴编码规约手册详解

> - 02、Integer缓存问题分析  `IntegerCacheProblemAnalysis02`，包装类型中缓存相关知识，Integer.chche缓存范围-128-127是JLS中要求
的，缓存经常使用到的对象，可以减少内存并且可以提高访问速度。  
> - 03、Java序列化引发的血案  `JavaSerializable03`，Json反序列化Map时如果原始值小于Int最大值，反序列化后原本为Long类型的字段，
会变为Integer 类型，使用readObject()方法对对象中不可序列化的属性进行序列化。  