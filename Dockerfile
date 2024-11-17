FROM amazoncorretto:8

RUN ["mkdir" , "-p", "/home/app"]

WORKDIR /home/app

COPY ./target/docker-spring-demo-1.0-SNAPSHOT.jar /home/app

COPY ./application /home/app

RUN mv /home/app/application /home/app/application.yml


CMD ["nohup", "java", "-jar", "/home/app/docker-spring-demo-1.0-SNAPSHOT.jar"]