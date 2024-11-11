# Chapter 6: Getting to Know the Spring Framework

This repository contains the code from the book for Chapter 6, Getting to Know the Spring Framework. See the [main book page)[https://github.com/realworldjava) for the list of all chapter specific repositories.

# How this repository is organized

In this repository, the code is in 10 branches corresponding to different parts of the chapter.

 Branch Name  | Corresponding Section |
| ------------- | ------------- |
|xml-config|Using XML Configuration Files|
|configuration-class|Using Java Configuration Classes|
|component-scan|Using Component Scanning|
|profiles|Customizing Spring Applications with Properties|
|spring-boot|Using IntelliJ Initializr Integration|
|actuator|Inspecting your Application with Actuator|
|spring-boot-security-basics|Understanding Spring Security Processing
|main|Unused (was for creating other branches)|

# How to run the examples in this chapter

If you want to use an IDE, import the repository as a Maven project so you have the proper  dependencies.

If you want to use the command line, cd to the directory for that example and run the following:
```
mvn verify
```

When running the app, also run:
```
java - jar target/mtgcalc- 0.0.1- SNAPSHOT.jar
```

# Accessing URLs

In this chapter, most of the URLs are GET operations, which means you can simply paste them into your web browser. For the POST example, you can use your choice of curl or Postman. 

## Curl

Linux and Mac come with curl out of the box. For Windows users, curl is included with git bash (from chapter 3). As an example, the POST command from the book is:


```
curl -X POST -H "Content-Type:application/json" -d @request.json http://localhost:8081/mtg/payment
```


## Postman

Postman is a popular tool for making RESTFul HTTP API calls and useful when you want a UI. 

You can download a free version of Postman from [their website](https://www.postman.com/downloads/).

# Clickable Links from the Further References Section

* [Roy Fielding’s original dissertation on REST](http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
* [Initializr](https://start.spring.io)
* [Spring Framework Documentation](https://docs.spring.io/spring-framework/reference/index.html)
* [Base 64 encoder](https://www.base64encode.org)
