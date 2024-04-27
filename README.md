# TABLE OF CONTENTS

- [1. Introduction](#1-introduction)
- [2. Creational Design Patterns](#2-creational-design-patterns)
   * [2.1  Builder](#21-builder)
   * [2.2  Simple Factory](#22-simple-factory)
   * [2.3  Factory Method](#23-factory-method)
   * [2.4  Abstract Factory](#24-abstrsct-factory)

# 1. Introduction<a name="1-introduction"></a>

This repository presents a concise guide to design patterns, offering solutions to frequent software design challenges. It enables developers to adopt common terms and strategies for clearer communication and teamwork.

# 2. Creational Design Patterns<a name="2-creational-design-patterns"></a>

## 2.1  Builder<a name="21-builder"></a>

Builder pattern provides a flexible and fluent approach to constructing complex objects. Instead of using numerous constructors, the pattern uses a separate Builder class that constructs the final object step by step. This Builder class encapsulates the construction logic and allows for better control over the construction process. For a sample code implementation, please click [here](src/main/java/com/pattern/builder).

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

## 2.2  Simple Factory<a name="22-simple-factory"></a>
Simple Factory pattern simplifies the process of creating objects, particularly when the creation logic involves some complexity. Instead of calling a constructor directly, this pattern uses a separate Factory class to handle the instantiation of objects. For a sample code implementation, please click [here](src/main/java/com/pattern/simplefactory).

### 2.2.1  When to Use
- To dynamically create the exact type of object needed at runtime, based on incoming parameters, promoting polymorphism by having the code interact with a base class or an interface while the factory returns specific concrete objects.
- To encapsulate object creation, thereby enhancing code flexibility and maintainability by isolating the construction process.

### 2.2.2  Real-Life Examples

**[BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html)**
```java
@Component
public class BeanRetriever {

  private final ApplicationContext context;

  public BeanRetriever(ApplicationContext context) {
    this.context = context;
  }

  public MyBean getBeans() {
    // ApplicationContext extends BeanFactory
   return context.getBean(MyBean.class);
	
  }
}
```

**[NumberFormat](https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html)**
```java
// Get the NumberFormat instance for the default locale
NumberFormat format = NumberFormat.getInstance();

// Get the NumberFormat instance for a specific locale
NumberFormat formatInFrance = NumberFormat.getInstance(Locale.UK);

// Get a NumberFormat instance for percentage formatting
NumberFormat percentFormat = NumberFormat.getPercentInstance();
```

## 2.3  Factory Method<a name="23-factory-method"></a>
Factory Method pattern provides an interface for creating objects in a superclass, allowing subclasses to determine which classes to instantiate based on their own specific logic. For a sample code implementation, please click [here](src/main/java/com/pattern/factorymethod).

### 2.3.1  When to Use
- Use the Factory Method pattern in addition to the basic Factory pattern when subclass creation requires additional logic not covered by a simple factory.

### 2.3.2  Real-Life Examples
**[Persistence](https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Persistence.html)**
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
EntityManager em = emf.createEntityManager();
```

## 2.4  Abstract Factory<a name="24-abstrsct-factory"></a>
Abstract Factory pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes. For a sample code implementation, please click [here](src/main/java/com/pattern/abstractfactory).

### 2.4.1  When to Use
- When multiple related products need to be created that are intended to work together, ensuring they are styled consistently according to the system's specifications.
- To enhance flexibility by separating the object creation into classes that implement factory interfaces, allowing these classes to be developed and modified without impacting the application that uses them.
