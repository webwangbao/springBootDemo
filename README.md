# springBootDemo
基于springboot环境搭建的开发工程demo  

程序中日志记录非常重要，日志记录主要的：日志输出注意事项：  

1）在任务执行之前和执行之后打印log，任务执行之前的log上带上当前任务的所有参数，任务执行结束的log尽量带上当前的处理结果；  

2）在关键函数入口处（即进入该函数的开始位置）和出口前打印log，入口处的log带上当前的参数，出口处的log尽量带上当前的处理结果；  

3）在错误和异常日志中带上错误和异常执行前的关键参数；在实际开发中经常会遇到各种条件判断，如果条件不满足，则返回错误，此时再返回之前尽量要输出一条log，并在该log上带上引起错误的参数，对于异常也是如此；   

4）在关键代码前加上log，log要带上当前的重点参数；例如，有一段代码是向另外一个模块发送消息，则在发送消息之前最好加上log，log中要带上向哪里发送什么；  

5）在有关键信息出现的地方加log，并在log中输出这些关键的信息；   

6）日志描述要简洁清晰；  

6、日志输出一定要分等级显示，例如debug，warn，error等；在log输出时要分级别显示：  

如果遇到程序无法继续执行的情况，log级别是error；   

如果程序虽然出错但是还依然可以继续运行，log级别是warn；  

如果关键信息的输出可以使用info或者debug；  

其他调试信息可以使用debug级别； 
