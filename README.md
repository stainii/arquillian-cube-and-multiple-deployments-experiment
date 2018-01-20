Arquillian Cube + multiple deployments experiment
==============================================================================================

Goal
----
Make it possible to
1. hit "mvn clean install"
1. have a Docker container started up with an empty Wildlfly
1. deploy the latest version of all microservices
1. run Arquillian tests
1. destroy Docker container


Configuration on Mac
---------------------
You need a running instance of Docker.
On Mac, one extra complication pops up: Docker does not listen on a tcp connection.
In order to have this TCP accessibility:

1. stbrew install socat
1. stsocat TCP-LISTEN:2375,reuseaddr,fork UNIX-CONNECT:/var/run/docker.sock


Build
-----

In order to build and run the Arquillian tests, use
````
maven clean dependency:copy-dependencies install
````