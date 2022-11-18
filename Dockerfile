FROM openjdk:19
LABEL maintainer="possibly Ramon@eBay"
ADD target/eBayLatest-0.0.1-SNAPSHOT.jar sprinboot-dockerized-item-demo.jar
ENTRYPOINT ["java", "-jar", "sprinboot-dockerized-item-demo.jar"]