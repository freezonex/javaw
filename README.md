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

## 暴力指引（其他懒得看就只看这个）
* 下载 idea 社区版
* 在github中 复制本仓库 https 链接
* new project from version control， 贴入https 链接
* 由于防火墙问题，请将 src/main/resources/settings.xml 作为maven setting文件（位置在 setting-build-build tool-maven）
* 此时 应该会自动下载 pom文件中的外部库，等一会还是下载不下来重启 idea
* 没有报错了 就可以找main方法执行，开启 java 编程之旅
* 搞不定 喊 于文浩

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