# eBay Take Home

Spring Demo App

FEATURES COMPLETED:

1. Implemented interfaces to allow open and closed principle for 'should validate' and 'validation'
2. The 'default' methods can also be extended or alternatively new method can implement the two interfaces above
3. Cached was implemented using a map data structure and annotated as @component
4. I assume that following format for item specifics String comma delimited and futher delimited with a colon between the key and value
   "Model:Civic,Brand:Honda,Color:Blue"
5. LOGGING:
   'CALL NORMALIZE' is logged for each call to the 'external api'. 
6. UnitTests to follow. 

"Future" features:

1. Add mocking and test at the controller level
2. Run the ExternalAPI in a thread to overcome latency.
3. Refactor existing basic caching mechanism to implement LRU caching with max size for scalability
   and to avoid memory issue. Evict least recently used once we reach the max size. Need to back the 
   cached hashMap with a double linkedlist. Least recently used should be add to the front of the list and most recent one either remove and/or only added to the end of list


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



