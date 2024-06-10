# TABLE OF CONTENTS

- [1. Introduction](#1-introduction)
- [2. Creational Design Patterns](#2-creational-design-patterns)
   * [2.1  Builder](#21-builder)
   * [2.2  Simple Factory](#22-simple-factory)
   * [2.3  Factory Method](#23-factory-method)
   * [2.4  Abstract Factory](#24-abstrsct-factory)
   * [2.5  Prototype](#25-prototype)
   * [2.6  Singleton](#26-singleton)
   * [2.7  Object Pool](#27-object-pool)
- [3. Structural Design Patterns](#3-structural-design-patterns)   
   * [3.1  Adapter](#31-adapter)
   * [3.2  Bridge](#32-bridge)
   * [3.3  Decorator](#33-decorator)
   * [3.4  Composite](#34-composite)
   * [3.5  Facade](#35-facade)
   * [3.6  Flyweight](#36-flyweight)
   * [3.7  Proxy](#37-proxy)
- [4. Behavioral Design Patterns](#4-behavioral-design-patterns)   
   * 4.1  Chain of Responsibility
   * 4.2  Command
   * 4.3  Interpreter
   * 4.4  Mediator
   * 4.5  Iterator
   * 4.6  Memento
   * 4.7  Observer
   * 4.8  State
   * 4.9  Strategy
   * 4.10  Template Method
   * 4.11  Visitor   
   
# 1. Introduction<a name="1-introduction"></a>

This repository presents a concise guide to design patterns, offering solutions to frequent software design challenges. It enables developers to adopt common terms and strategies for clearer communication and teamwork. Please note that this project is ongoing, and more design patterns will be added periodically.

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
- Use the Factory Method pattern in addition to the Simple Factory pattern when subclass creation requires additional logic not covered by a simple factory.

### 2.3.2  Real-Life Examples
**[Persistence](https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Persistence.html)**
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
EntityManager em = emf.createEntityManager();
```

## 2.4  Abstract Factory<a name="24-abstrsct-factory"></a>
Abstract Factory pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes. For a sample code implementation, please click [here](src/main/java/com/pattern/abstractfactory).

### 2.4.1  When to Use
- In addition to the Simple Factory pattern, use the Abstract Factory when multiple related objects are intended to work together seamlessly across the application and their creation needs to be standardized.

## 2.5  Prototype<a name="25-prototype"></a>
The Prototype pattern provides a mechanism to clone an existing object rather than creating a new instance from scratch, allowing modifications to the cloned object as needed. For a sample code implementation, please click [here](src/main/java/com/pattern/prototype).

### 2.5.1  When to Use
- When creating an object is resource-intensive or complicated, and a similar object already exists.
- When the system needs to be independent of how its objects are created

### 2.5.2  Real-Life Examples
**[Object.clone()](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)**

**Remark:** Modern Java practices favor the use of copy constructors or factory methods over `clone()`, as they provide greater visibility and control over the copying process of objects.

## 2.6  Singleton<a name="26-singleton"></a>
The Singleton pattern ensures that only one instance of a class exists and provides a global access point to that instance. It can be implemented using eager loading, where the instance is created when the class is loaded, or lazy loading, which creates the instance on its first use. Eager loading is generally preferred unless the instance is costly to create. For a sample code implementation, please click [here](src/main/java/com/pattern/singleton).

### 2.6.1  When to Use
- When the application requires exactly one instance of a class to coordinate actions across the system.
- When managing access to a resource that is shared throughout an application, such as a configuration settings object.

### 2.6.2  Real-Life Examples
**Beans in Spring are treated as singletons by default, unless a different scope is explicitly specified.**

## 2.7  Object Pool<a name="27-object-pool"></a>
The Object Pool pattern pre-creates and stores a set of reusable objects in a "pool". These objects should have a method to "reset" their state, allowing them to be reused efficiently. The Object Pool manages the creation, usage, and validation of these objects, and it also handles their release or destruction in a concurrent environment. For a sample code implementation, please click [here](src/main/java/com/pattern/objectpool).

### 2.7.1  When to Use
- When creating new objects is resource-intensive and significantly impacts performance.
- When a fixed number of objects in the pool can satisfy the application's demands, minimizing the overhead of creating and destroying objects frequently.

### 2.7.2  Real-Life Examples
**Database Connection Pool**

# 3. Structural Design Patterns<a name="3-structural-design-patterns"></a>

## 3.1  Adapter<a name="31-adapter"></a>
The Adapter pattern allows objects with incompatible interfaces to work together by wrapping one of the incompatible objects with an adapter. This adapter translates (or "adapts") its interface to the format expected by the client. This pattern is often implemented using composition, where the adapter contains an instance of the class it adapts. For a sample code implementation, please click [here](src/main/java/com/pattern/adapter).

### 3.1.1  When to Use
-  When you want to use existing classes that provide the functionality you need but have interfaces that are incompatible with the rest of your application.

### 3.1.2  Real-Life Examples
**Conversion between [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html) and [Reader](https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html)**
```java
InputStream is = new FileInputStream("input.txt");
Reader reader = new InputStreamReader(is);
```

**[JpaRepository](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)**
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Define query methods here
}
```

## 3.2  Bridge<a name="32-bridge"></a>
The Bridge pattern decouples an abstraction from its implementation, allowing them to vary independently. It bridges them together through composition. For a sample code implementation, please click [here](src/main/java/com/pattern/bridge).

### 3.2.1  When to Use
- When the application requires platform independence and implementations might vary significantly across platforms.
- When both the abstraction and its implementation need to be extended frequently without affecting each other.
- When multiple abstractions should share an implementation, which can be dynamically switched at runtime.
- When there is a need to switch implementations at runtime without altering the client code.

### 3.2.2  Real-Life Examples
**Logger API**<br>
The abstraction is the Logger interface or abstract class that defines logging methods such as `logInfo` and `logError`. Different implementations can include `ConsoleLogger`, `FileLogger`, and `DatabaseLogger`, each providing a specific logging mechanism. The Bridge pattern is used here as the client code interacts with the Logger abstraction, allowing the actual logging mechanism (console, file, database) to vary independently. This decoupling facilitates the use of different logging methods without modifying the core logging logic.

**JDBC API**<br> 
The abstraction is represented by the JDBC API itself, including interfaces such as `java.sql.Connection` and `java.sql.Statement`. Various database drivers, such as those for `MySQL`, `PostgreSQL`, and `Oracle`, serve as the concrete implementations. The Bridge pattern allows the client code to interact with a standard API while the underlying database implementation can change independently. The JDBC driver manager acts as the bridge, enabling seamless database operations regardless of the specific database being used.

## 3.3  Decorator<a name="33-decorator"></a>
The Decorator pattern allows for the dynamic addition of behaviours to individual objects without affecting the behaviour of other objects from the same class. By using the same interface, decorators provide a flexible alternative to subclassing for extending functionality.

### 3.3.1  When to Use
- When you need to add responsibilities to individual objects dynamically and transparently, without affecting other objects.
- When you want to add behavior to an object, either statically or dynamically, without altering its structure.

### 3.3.2  Real-Life Examples
**[BufferedOutputStream](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/BufferedOutputStream.html)**
```java
OutputStream fileOutputStream = new FileOutputStream("output.txt");
OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
```

## 3.4  Composite<a name="34-composite"></a>
The Composite pattern allows you to compose objects into tree structures, enabling clients to treat individual objects and compositions of objects in the same way.

### 3.4.1  When to Use
- When you need to represent hierarchical structures of objects.
- When you want clients to be able to ignore the difference between compositions of objects and individual objects.

### 3.4.2  Real-Life Examples


## 3.5  Facade<a name="35-facade"></a>
The Facade pattern provides a simplified interface to a complex subsystem. It hides the complexities of the subsystem and makes it easier to use by providing a single simple interface.

### 3.5.1  When to Use
- When you want to provide a simple interface to a complex subsystem.
- When there are many interdependent classes or interfaces in a subsystem and you want to reduce the dependency of external code on this subsystem.

### 3.5.2  Real-Life Examples
**[URL](https://docs.oracle.com/en/java/javase/17/docs//api/java.base/java/net/URL.html)**<br>
Users can create a `URL` object and open a connection to it with just a few lines of code, abstracting away the complexities of different network protocols. Internally, `URL` delegates the actual work of connecting and data transfer to various protocol handlers, which the user does not need to interact with directly.

## 3.6  Flyweight<a name="36-flyweight"></a>
The Flyweight pattern minimizes memory usage by sharing as much data as possible with other similar objects.

### 3.6.1  When to Use
- When an application uses a large number of objects that can cause high memory consumption.
- When most of the object state can be made extrinsic, meaning it can be passed in from the outside rather than stored internally.
- When the objects are immutable and can be shared safely across different contexts.

### 3.6.2  Real-Life Examples
**[String.intern()](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#intern())**

## 3.7  Proxy<a name="37-proxy"></a>
The Proxy pattern provides a placeholder for another object to control access to it. Proxies can be used to add an additional layer of control to an object, handling tasks such as lazy initialization, access control, logging, and more. There are three types of proxies:<br>

- Protection Proxy: Controls access to an object based on permissions.
- Remote Proxy: Provides a local representative for an object located on a remote server.
- Virtual Proxy: Controls access to a resource that is expensive to create by initializing it only when needed.

### 3.7.1  When to Use
- When you need to control access to an object, such as controlling permissions or managing resource-intensive operations.
- When you want to add functionality to an object transparently, without modifying the actual object.
- When you need to manage the lifecycle of a resource or object, like lazy loading or caching.

### 3.7.2  Real-Life Examples
**Lazy Loading in Hibernate**<br>
Hibernate uses proxies to implement lazy loading of entities. When an entity is requested, a proxy object is returned instead of the actual entity, and the database query to load the entity data is only executed when the proxy is first accessed.

**Aspect-Oriented Programming (AOP) in Spring Framework**<br>
Spring AOP uses proxies to add additional behavior to objects. For example, proxies can manage transactions or caching. The proxy intercepts method calls and applies cross-cutting concerns like logging, security, or transaction management before delegating to the actual method.

# 4. Behavioral Design Patterns<a name="4-behavioral-design-patterns"></a>
