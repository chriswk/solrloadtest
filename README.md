# Stress tester for two different ways of instantiating SolrServer


To launch, ./gradlew bootRun

This will start up a server on localhost:8080 which will respond to /singleton and /alwaysnew

  *  /singleton will use connection pooling from HttpSolrServer
  * /alwaysnew will use a new HttpSolrServer for every request