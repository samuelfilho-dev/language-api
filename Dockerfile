FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/language-api-0.0.1-SNAPSHOT.jar languageapi.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar languageapi.jar --spring.config.location=file:/etc/secrets/application.properties

