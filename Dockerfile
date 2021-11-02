FROM adoptopenjdk/openjdk11:alpine
VOLUME /tmp
ARG JAR_FILE=target/seguradora-gold-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
CMD java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080

# docker build -t seguradora-gold-server .
# docker run -p 8080:8080 seguradora-gold-server