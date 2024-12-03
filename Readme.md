## SpringBoot 語法學習日誌

1. 簡介: 這只是是用來了解 spring boot 與 java 語法的練習的範例程式

2. mvn 指令

   + mvn clean: 清理項目，刪除 target 目錄及其內容。

   + mvn compile: 編譯源代碼，將 src/main/java 目錄中的 Java 文件編譯成 .class 文件

   + mvn install: 將編譯並打包的 artifact 安裝到本地 Maven 倉庫，讓其他項目可以使用。

   + mvn dependency:tree  :顯示當前項目的所有依賴樹，方便查看依賴項目及其版本。

3. 目前學習到的地方: APIgateway(org.springframework, lombok), orm(hibernate.orm, JPA, jakarta), grpc(grpc-protobuf)

4. Reference

   1. https://medium.com/@heather_programming/spring-security-%E5%B8%B3%E8%99%9F%E5%AF%86%E7%A2%BC%E9%A9%97%E8%AD%89-98a4bfd03abe

   2. https://www.baeldung.com/grpc-introduction