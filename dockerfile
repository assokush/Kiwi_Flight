FROM maven:3.3-jdk-8-alpine
MAINTAINER coccus
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH
ENV SPRING_DATASOURCE_URL jdbc:jdbc:postgresql://PostgreSQL:5432/postgres
ENV SPRING_DATASOURCE_USERNAME postgres
ENV SPRING_DATASOURCE_PASSWORD postgres
CMD mvn  install -DskipTests -q
ADD target/*.jar app.jar
EXPOSE 8080 8080
ENTRYPOINT ["java","-jar","app.jar"]