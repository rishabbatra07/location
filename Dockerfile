FROM --platform=linux/x86_64 openjdk:17-alpine
EXPOSE 8888
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=/build/libs/location-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
RUN echo ${JAR_FILE}
ENTRYPOINT ["java","-jar","/app.jar"]