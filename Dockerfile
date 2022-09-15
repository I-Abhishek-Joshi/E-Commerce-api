#Define a base image for the application, here we using image with jre8 and alpineOS
FROM e-dpiac-docker-local.docker.lowes.com/irs-image-jre:13-alpine
#Change Working directory
WORKDIR /app
#By default process run as root user, change this to a least privileged user
RUN adduser --uid 10101 -S carbon
RUN chown -R 10101 /app/
USER 10101
#Mention which port the application listens
EXPOSE 8080
#Copy the application artifact
COPY target/*.jar app.jar
#Start java as a starting process with the application jar as a parameter
ENTRYPOINT ["java", "-jar", "/app/app.jar" ]