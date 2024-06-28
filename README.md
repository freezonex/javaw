# 基于supOS APP JAR开发的脚手架
本工程已经封装了AK/SK、REST接口例子、OpenAPI调用例子等功能，可以在这基础上是实现一些APP的较复杂逻辑或接口开发。

## 主要技术
Springboot、Maven

## 版本支持
* 支持supOS版本：V3.0.0

## 一定要看！！！！
* 建议使用idea进行开发，使用git进行项目代码管理，在初始化项目代码时注意提示
* 本项目需要使用maven进行外部库引用管理
* 由于防火墙问题，请将 src/main/resources/settings.xml 作为maven setting文件
* 按照步骤安装本地sdk 最新的jar src/main/resources里 请下载好后进行本地替换  在 https://devc-cloud.supos.com/document?groupId=doc_group_id_007&devcContentId=DOC_CONTENT_1642640641949&version=no_version&id=808
* 要下载IntelliJ IDEA Ultimate
* 开发过程中与supos关联的接口 全部使用sdk中的方法，不需要自己重复劳动
* 环境变量一定要使用配置项! https://devc-cloud.supos.com/document?groupId=doc_group_id_007&devcContentId=DOC_CONTENT_1643093045458&version=no_version&id=838
* resources.templates 目录下package为关键字，不可用来命名

## 暴力指引（其他懒得看就只看这个）
* 要下载IntelliJ IDEA Ultimate 激活码在key中
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

