# LoaderIO Jenkins Plugin



## Debugging a Plugin

Load by maven:

    export MAVEN_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=n"
    mvn hpi:run

If you open http://localhost:8080/ in your browser, you should see the Jenkins page running in Jetty. The MAVEN_OPTS portion launches this whole thing with the debugger port 8000, so you should be able to start a debug session to this port from your IDE.

For cleanup:

    mvn clean install

Done.