### 完成度：
* 功能全部完成，但存在bug

__Details:__
- EducationController.java:20，Bug，给不存在的用户添加 education 也能成功，并且查找的时候也找不到


### 知识点：
* 使用了Lombok
* Spring Boot MVC Annotations基本使用正确，但ResponseEntity需要加深理解

__Details:__
- UserController.java:22，ResponseEntity可以省略掉
- EducationController.java:21 违反Restful实践，Post接口应返回创建成功的对象
- User.java:17 小细节需要注意，value=16，意味着可以取值16，但题目要求的是age>16
- UserService.java:12 存储相关的细节，可以抽取到repository层做
- GlobalExceptionHandler.java:16 不需要再包一层ResponseEntity，且status code重复设置了

### 工程实践：
* 结构划分合理
* 需要提高Java的通用API的使用
* 小步提交，做的不够小步，尝试进行tasking后，在进行开发，每一个task完成，提交一次

__Details:__
- UserService.java:23 可以试试Objects.isNull()，可读性更高
- UserService.java:16 可以试试Long.valueOf() 
- UserService.java:17 线程不安全，这种内存中自增可以试试AtomicInteger




