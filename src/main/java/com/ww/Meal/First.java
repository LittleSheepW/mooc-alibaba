package com.ww.Meal;

/**
 * @author: Sun
 * @create: 2019-11-28 18:46
 * @version: v1.0
 */
public class First {

    /**
     * IDEA插件：
     * (1)Alibaba Java Coding Guidelines：安装该插件后，代码超过80行、手动创建线程池等，这些和《阿里巴巴编码手册》中的规约不符时，
     * IDEA中会给出警告提示。它会帮助你检查出很多隐患，督促你写更规范的代码。
     *
     * (2)jclasslib bytecode viewer：可视化的字节码查看插件。
     * 使用方法:
     * 1.在IDEA打开想研究的类;
     * 2.编译该类或者直接编译整个项目(如果想研究的类在jar包中，此步可略过);
     * 3.打开“view”菜单，选择“Show Bytecode With jclasslib"选项;
     * 4.选择上述菜单项后IDEA中会弹出jclasslib工具窗口。
     * 这个插件的强大之处在于:
     * 1.不需要敲命令，简单直接，在右侧方便和源代码进行对比学习;
     * 2.字节码命令支持超链接，点击其中的虚拟机指令即可跳转到jvms相关章节，超级方便。
     * // TODO: 2019-11-28 Maven项目编译单个类之后使用该插件：Error reading class file class file not found
     *
     * (3)Codota：
     * 该插件的强大之处在于:
     * 1.支持智能代码自动提示，该功能可以增强IDEA的代码提示功能;
     * 2.支持JDK和知名第三方库的函数的使用方法搜索，可以看到其他知名开源项目对该函数的用法。当我们第一次使用某个类 ，对某个函数不够熟悉时，
     * 可以通过该插件搜索相关用法，快速模仿学习。
     * 使用方法:
     * 1、快捷提示
     * 2、在类、方法(快捷提示)上使用control+shift+o就会搜索相应代码
     * 3、control+shift+o弹出搜索框
     *
     * (4)Auto filling Java call arguments：开发中，我们通常会调用其它已经编写好的函数，调用后需要填充参数，但是绝大多数情况下，
     * 传入的变量名称和该函数的参数名一致，当参数较多时，手动单个填充参数非常浪费时间。该插件就可以帮你解决这个问题。
     * 使用方法：
     * 安装完该插件以后，调用一个函数，使用Alt+Enter组合键，调出“Auto fill call parameters"自动使用该函数定义的参数名填充。
     *
     * (5)GenerateO20(未安装)、GenerateAllSetter：自动调用所有Setter函数(可填充默认值)
     * 使用方法：
     * 1、我们定义好从A类转换到B类的函数转换函数后，使用这两个插件可以自动调用Getter和Setter函数实行自动转换。 public static UserDTO convertToDTO(UserDO source) {
     *     Alt+Enter 点击Generate setter getter converter
     * }
     * 2、我们创建一个对象后，想依次调用Setter函数对属性赋值，如果属性较多很容易遗漏或者重复。
     * OrderDo orderDo = new OrderDo();    在对象名称处 Alt+Enter 点击Generate All setter no default value
     *
     * (6)Rainbow Brackets
     * 由于很多人没有养成好的编码风格，没有随手format代码的习惯，甚至有些同事会写代码超过几百行，阅读起来将非常痛苦。
     * 痛苦的原因之一就是找到上下文，由于括号太多，不确定当前代码行是否属于某个代码块，此时这个插件就会帮上大忙。
     * 使用方法：
     * (1)写代码就可以看到相对应的括号
     * (2)代码块中command + 双手单击触摸板可以标识处当前代码块范围
     *
     * (7)Maven Helper
     * 现在Java项目通常会使用maven或者gradle构建，对于maven项目来说，jar包冲突非常常见。那么如何更容易地杳看和解决Jar包冲突呢?
     * 安装该插件，安装后IDEA中打开pom.xml文件时，就会多出一个“DependencyAnalyzer”选项卡。点击进入之后在点击Conflicts就可以看到有冲突的Jar包。
     *
     * (8)FindBugs
     * 程序员总是想尽可能地避免写BUG，FindBugs 作为静态代码检查插件，可以检查你代码中的隐患，并给出原因。
     *
     * (9)SequenceDiagram
     * SequenceDiagram可以根据代码调用链路自动生成时序图，超级赞，超级推荐!这对研究源码，梳理工作中的业务代码有极大的帮助，堪称神器。
     * 安装完成后，在某个类的某个函数中，右键--> Sequence Diagaram即可调出。
     * // TODO: 2019-11-28 生成时序图时很卡
     *
     * (10) Stack trace to UML：支持根据JVM异常堆栈画UML时序图和通信图。
     * 打开 方式Analyze > Open Stack trace to UML plugin + Generate UML diagrams from stacktrace from debug
     * // TODO: 2019-11-28 未实际使用过
     *
     * (11)Java Stream Debugger
     * Stream非常好用，可以灵活对数据进行操作，但是对很多刚接触的人来说，不好理解。那么Java Stream Debugger这款神器的IDEA就可以帮到你。
     * 它可以将Stream的操作步骤可视化，非常有助于我们的学习。
     * // TODO: 2019-11-28 该版本IDEA好像不兼容安装此插件
     *
     *
     * 反编译软件：
     * ①在线反编译网站：http://www.decompiler.com/
     * ②离线Java反编译工具：JD-GUI(使用过)、Luyten(未使用过)
     *
     * 图形界面反编译虽然更直观，但是如果我们想反编译Linux服务器上的类文件可咋办呢?
     * 我们可以通过Jad、CFR、Procyon、 ernflower、 JD等 反编译工具。另外知名的阿里开源Java诊断工具arthas也支持jad命令，
     * 可以将JVM中实际运行的class文件的字节码反编译成Java代码，便于理解业务和排查问题。   // TODO: 2019-11-28 未实际使用过
     * 举一个真实发生过的典型的场景:
     * 有一次代码发布上线，但是从功能表现看线上仍然是“旧代码”，但是从发布的git 提交版
     * 本来看是最新版。此时就可以使用Jad反编译该类，来核查该问题。
     *
     * 实际开发中需要用到反编译的典型场景有:
     * (1)自己或者二方. 上传的包含新的接口jar包到maven仓库，下载下来查看jar包检查新的接口是否包含在新的jar包中;
     * (2)需要临时查看某个Jar包的源码，不想加到本地仓库中;
     * (3)拿不到源码，又想了解其源码究竟是怎么写的;
     * (4)线上代码表现和自己的源码不一致，怀疑线上代码不对，可以反编译去核对。
     *
     * 反汇编软件：
     * ①jclasslib(IDEA中也有相应的插件)
     *
     *
     * UML画图工具：
     * visual-paradigm：该画图工具不仅支持软件本地画图，还支持在线画图，支持最新的语法，并且有丰富的参考示例。
     * PlantUML：强烈推荐，理由是其他大多数作图软件都采用拖拽式，对于有些强迫症的人会浪费很多时间进行对齐等操作。
     * 该软件还提供了IDEA插件，在IDEA中创建plantUML的图形支持实时预览。
     * 其它UML画图工具：
     * 可以使用processon来作图，优势是在线存储。windows系统用户可以使用visio，功能强大，画的图也很美观。
     *
     */

}
