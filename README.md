# Spring Boot GraalVM native demo

This project demonstrates the startup speed and memory efficiency of running Spring Boot applications as GraalVM native executables. Tested on macOS Catalina (10.15.5).

## Compile and run on your machine

Prerequisites:
- Java 11 (11.0.7)
- GraalVM CE 20.1.0
- GraalVM Native Image 20.1.0

To easily manage multiple Java and GraalVM installations, install prerequisites using [SDKMAN!](https://sdkman.io/) or with [Homebrew](https://brew.sh/index_nl) and [jEnv](https://www.jenv.be/).

Run the shell script to compile the native executable:  
`./compile-native-executable.sh books nl.robinlaugs.books.Main 0.0.1-SNAPSHOT`

Run the native executable:  
`./target/native-executable/books`

### Speed comparison

To compare the startup speed and memory usage, you can also run the traditional JAR that is a side product of the shell script:   
`java -jar ./target/books-0.0.1-SNAPSHOT.jar --server.port=8081`

## Compile and run in Docker

Build and package the Docker image with the native executable:  
`docker build . --tag=books-native -f Dockerfile_native`

Run the Docker image with the native executable:  
`docker run --name books-native -p 8080:8080 books-native`

### Speed comparison

To compare the startup speed and memory usage, a traditional Dockerfile for running the application is a JAR is added.

Build and package the Docker image with the traditional JAR:  
`docker build . --tag=books-traditional -f Dockerfile_traditional`

Run the Docker image with the native executable:  
`docker run --name books-traditional -p 8081:8081 books-traditional`  
(uses different server port, so can be used at the same time)

Use `docker stats` command to compare memory usage.

