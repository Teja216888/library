FROM openjdk:17
EXPOSE 8080
ADD /build/libs/library-0.0.1-SNAPSHOT.jar library.jar
ENTRYPOINT ["java","-jar","library.jar"]