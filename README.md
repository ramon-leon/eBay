# eBay Take Home

Spring Demo App

INSTALLATION

System Requirements:

1. IDE (Intellij)
2. Github account
3. Install Docker desktop

TO RUN locally

1. You only need to start DemoApplication - right click DemoApplication under
   src/main/java/com/example/eBayLatest/EBayLatestApplication.java) and select Run


TO RUN as standalone docker container

1. Make sure Maven has download all the dependencies from the pom.xml file. It should be done automatically.
2. Build the .jar file (this jar referenced in the dockerFile)
   Run the maven 'package' command (.jar file will be in the target folder)
3. From terminal run the following docker commands:
   docker build -t  demo_ramon:latest .  (this build a docker image)
   docker images (you should now see the image that you tagged above)
4. Start the dock container
   docker run -p 8082:8080 demo_ramon:latest  (make sure the port 8082 is already in use
   (you can also use other available port numbers)
5. Note Tomcat and H2 in memory db should be started automatically


TO TEST APIs (use swagger UI)

1a. http://localhost:8080/swagger-ui.html#    (standalone locally)
1b. http://localhost:8081/swagger-ui.html#    (from docker container - only port number is different)


TEST FROM POSTMAN

http://localhost:8080/ItemsAPI/    (standalone locally)
http://localhost:8081/ItemsAPI/    (from docker container)

H2 db access:

http://localhost:8080/h2console    (from locally run only)

KNOWN ISSUES LIMITATIONS

1. ...
2. ...
3. 

