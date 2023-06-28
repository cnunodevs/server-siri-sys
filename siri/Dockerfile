FROM openjdk:17-jdk-slim
WORKDIR /home/app
COPY target/siri-0.0.1-SNAPSHOT.jar siri-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","siri-0.0.1-SNAPSHOT.jar" ]
