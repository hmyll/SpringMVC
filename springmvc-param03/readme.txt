1.springMVC注解式开发步骤
1)导入aop的jar包 (idea自动导入）
2)处理器类不需要再实现Controller接口，但是需要在处理器类上添加@controller注解
3)在处理器方法上添加@RequestNapping注解
4) springMvC配置文件上引入context约束
5) SpringMvc配置文件上注册组件扫描器

2.请求映射规则（了解熟悉）


3.处理器方法的参数
1)HttpservletRequest
2)HttpservletResponse
3)HttPsession
4)Model
5)Map<string,object
6)请求中所携带的参数

4.处理器方法的返回值
1)ModelAndview
若处理器对请求处理后，不仅要进行跳转，而且还在跳转过程中传递数据，此时使用ModelAndview较为方便。

2)string
(1）返回物理视图名
(2）返回逻辑视图名
(3）返回逻辑视图名(BeanName)

3)void
(1)需要跳转

(2)不需要跳转
Ajax
JS框架Query
SON,JavaScript object Notation ,J5对象标记。JSON对象使用{}包裹，内部数据使用键值对的形式表示，键值对以冒号分割。
一个JSON对象可以包括多个键值对，这多个键值对之间用逗号分割。例如:{name:"张三" ,age: 23}，为了增加可读性:
{
    name :"张三""，
    age: 23
}
    也可用3SON数组，数组的元素就是JSON对象。数组使用[]包裹数组元素，使用逗号分割数组元素，例如:[{...},{...}]
    也可以先定义空的"JON数组，逐个加入元素。向JSON数组中加入元素的方法是push()。

HttpMessageConvert,Http消息转换器，是适配器接口，这个适配器接口的实现类，即各种适配器对象是在NVC注解驱动被加载时，由系统自动创建的
其会创建7个适配器。其中就包含35ON和Java对象之间的转换适配器。但这个适配器类，不是SpringMvc框架自带的，而是由第三方提供。
JSON与Java对象间转换的工具类很多，例如:GSON、JACKSON、JSON-LIB等。我们这里用JACKSON，所以需要导入JACKsON的jar包。
引入第一个即可。jackson-databind

第一步:下载jQuery库文件，导入项目中
第二步:在index1.jsp页面上引入jQuery库文件
<script type="text/javascript" src=""{pagecontext.request.contextPath}/js/jquery. js"×</script>
第三步:写Ajax代码(发送客户端请求)，导入JACKSON的jar依赖
第四步:在springMVC配置文件中注册MC注解驱动
第五步:在用于接收Ajax请求所携带参数的处理器方法参数前加注解@RequestBody


4)object
注意事项;
处理器方法返回object对象，是作为数据出现的，不是作为视图出现的。返回object数据的应用场景是，服务端向Ajax请求作为响应。
将object数据传递给页面，需要HttpNessageconvert将其转换为SON，而这个转换器类对象是由ACKSON充当的。所以需要导入ACKSON的jar包，需要注册NvC注解驱动。
转换为SoM的处理器方法返回对象，是存放在响应体中的，所以需要处理器告诉系统，该返回值要存放到响应体中。怎么告知?在处理器方法前添加@ResponseBody注解。
(1)数值型对象

(2)string对象

(3)自定义类型对象

异常处理的三种方式:
(1）使用框架自带的异常解析器
(2）使用自定义的异常解析器
(3)使用异常处理器注解@ExceptionHandler
