FROM jboss/wildfly:18.0.0.Final

ADD ./target/helloworld-cicd*.war /opt/jboss/wildfly/standalone/deployments/helloworld-cicd.war

#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-Djboss.http.port=$PORT"]
CMD /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -Djboss.http.port=$PORT