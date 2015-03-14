# spring-boot-config-datasource-test

Example showing an issue when using ```@RefreshScope``` and conditional bean definition using spring-boot. It is a basic app which does nothing except create a custom H2 ```DataSource``` that has ```@RefreshScope``` on it.

# Quick Start
### Clone repo
```$ git clone git@github.com:ericdahl/spring-boot-config-datasource-test.git```
### Run
```
$ mvn spring-boot:run
...
### Check on DataSources
Open http://localhost:8080/health

There's two DataSources but there should just be one because the spring-boot provided one
should not be created.
