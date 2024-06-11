# Use Bouncy Castle as the provider for the Java Cryptography Extension (JCE) API and Java Secure Socket Extension (JSSE) API.
- By default, Java uses its own implementation of the JCE and JSSE APIs. However, you can use the Bouncy Castle provider as an alternative. This provider is a popular choice for developers who want to use strong encryption algorithms that are not included in the default Java implementation. In this tutorial, we'll show you how to use Bouncy Castle as the provider for the JCE and JSSE APIs in your Java applications.
# Maven dependency
- To use Bouncy Castle in your Java project, you need to add the following Maven dependency to your project's pom.xml file:
```xml

<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bctls-jdk18on</artifactId>
    <version>1.78.1</version>
</dependency>
<dependency>
<groupId>org.bouncycastle</groupId>
<artifactId>bcprov-jdk18on</artifactId>
<version>1.78.1</version>
</dependency>
```
# Using Bouncy Castle as the JCE & JSSE provider
```java
        //Add BouncyCastle as a Security Provider
        Security.insertProviderAt(new org.bouncycastle.jce.provider.BouncyCastleProvider(), 1);
        Security.insertProviderAt(new org.bouncycastle.jsse.provider.BouncyCastleJsseProvider(), 2);
```
- Read a secure webpage using TLS
```java
 // BouncyCastle is used to establish a TLS connection with the web server
            URL url = new URL("https://www.google.com");
            URLConnection urlConnection = url.openConnection();
```
# TLS Debugging
- To enable debugging for the TLS connection, you can set the following system properties:
```java
System.setProperty("javax.net.debug", "all"); //Unfortunately, this does not work with BouncyCastle
```
- or pass the following VM arguments to your Java application:
```shell
-Djavax.net.debug=all
```

