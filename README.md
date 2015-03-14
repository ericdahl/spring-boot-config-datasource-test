# spring-boot-config-datasource-test

Example showing an issue when using ```@RefreshScope``` and conditional bean definition using spring-boot. It is a basic app which does nothing except create a custom H2 ```DataSource``` that has ```@RefreshScope``` on it.

# Quick Start
### Clone repo
```$ git clone git@github.com:ericdahl/spring-boot-config-datasource-test.git```
### Run
```
$ mvn spring-boot:run
...
Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'customDataSource': Requested bean is currently in creation: Is there an unresolvable circular reference?
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:258)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:194)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.findAutowireCandidates(DefaultListableBeanFactory.java:1127)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1051)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:949)
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:533)
	... 49 more
```

Note: Using spring-cloud-config-client version 1.0.0.RC3 does not have this issue.
