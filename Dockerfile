FROM dockette/jdk8:latest
EXPOSE 8080
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]