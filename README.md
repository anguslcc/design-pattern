# TABLE OF CONTENTS

- [1. Introduction](#1-introduction)
- [2. Creational Design Patterns](#2-creational-design-patterns)
   * [2.1  Builder](#21-builder)

# 1. Introduction<a name="1-introduction"></a>

This repository presents a concise guide to design patterns, offering solutions to frequent software design challenges. It enables developers to adopt common terms and strategies for clearer communication and teamwork.

# 2. Creational Design Patterns<a name="2-creational-design-patterns"></a>

## 2.1  Builder<a name="21-builder"></a>

Builder pattern provides a flexible and fluent approach to constructing complex objects. Instead of using numerous constructors, the pattern uses a separate Builder class that constructs the final object step by step. This Builder class encapsulates the construction logic and allows for better control over the construction process. For a sample code implementation, please click [here](src/com/pattern/builder).

### 2.1.1  When to Use
- To create complex objects with numerous optional parameters, minimizing the need for multiple constructors.
- When the object being created should be immutable once fully constructed, ensuring consistency and thread safety.

### 2.1.2  Real-Life Examples

**[HttpSecurity](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html)**
```java
http.csrf(AbstractHttpConfigurer::disable)
	.authorizeHttpRequests(authorization -> authorization.anyRequest().permitAll())
	.oauth2ResourceServer(oauth2 -> oauth2.jwt(
		jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)
	));
    
return http.build();
```

**[WebClient](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html)**
```java
return WebClient.builder()
		.baseUrl(microserviceConfigData.getBaseUrl())
		.filter(oauth2Filter)
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.build();
```
