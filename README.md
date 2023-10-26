# 基于supOS APP JAR开发的脚手架
本工程已经封装了AK/SK、REST接口例子、OpenAPI调用例子等功能，可以在这基础上是实现一些APP的较复杂逻辑或接口开发。

## 主要技术
Springboot、Maven

## 版本支持
* 支持supOS版本：V3.0.0

## 本地开发细节
* 建议使用idea进行开发，使用git进行项目代码管理，在初始化项目代码时注意提示
* 本项目需要使用maven进行外部库引用管理
* 由于防火墙问题，请将 src/main/resources/settings.xml 作为maven setting文件

## 目录说明
```
app-jar-demo-tower
│ 
├─src/main/java
│    ├─com.supos.app    
│    │       ├─aksk                         通过AK/SK签名发送HTTP请求调用OpenAPI功能封装
│    │       ├─config                       仅supOS-V2.7及之前版本支持的客户端模式（V3.0不用关注）
|    |       ├─config                       配置文件读取 
|    |       ├─controller                   控制层（主要暴露接口给APP前端调用）
|    |       ├─dto                          dto
|    |       ├─pojo                         pojo
|    |       ├─supopenapi                   OpenAPI调用接口实现
|    |       ├─util                         工具类
|    |       ├─impl                         implement
|    |       └─AppJarDemoTowerApplication   启动类
│    │ 
│─src/main/resources 
│    ├─application.yml        配置文件
│ 
```