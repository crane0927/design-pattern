package com.example.structural.proxy.cglib;

/**
 * CGLIB 动态代理客户端
 * 
 * 注意：在 Java 9+ 中运行 CGLIB 需要添加 JVM 参数：
 * --add-opens java.base/java.lang=ALL-UNNAMED
 * 
 * IDE 运行配置：
 * - IntelliJ IDEA: Run -> Edit Configurations -> VM options: --add-opens java.base/java.lang=ALL-UNNAMED
 * - Eclipse: Run -> Run Configurations -> Arguments -> VM arguments: --add-opens java.base/java.lang=ALL-UNNAMED
 * 
 * 命令行运行（使用 Maven + 环境变量）：
 * MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED" mvn exec:java -Dexec.mainClass="com.example.structural.proxy.cglib.Client"
 * 
 * 或者手动运行（需要指定完整的类路径）：
 * CLASSPATH="target/classes:$(mvn dependency:build-classpath -q -DincludeScope=compile -Dmdep.outputFile=/dev/stdout)"
 * java --add-opens java.base/java.lang=ALL-UNNAMED -cp "$CLASSPATH" com.example.structural.proxy.cglib.Client
 */
public class Client {

    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory();
        Station station = proxyFactory.getStation();
        station.sell();

    }

}
