FROM jboss/wildfly:18.0.0.Final

ENV PORT 8080

ENV JBOSS_HOME /opt/jboss/wildfly
ENV POSTGRESQL_VERSION 42.2.8

ENV DB_HOST db
ENV DB_PORT 5432
ENV DB_DATASOURCE_NAME helloworld-cicd
ENV DB_DATASOURCE_JNDI_NAME helloworld-cicdDS
ENV DB_NAME helloworld-cicd-db
ENV DB_USER cicd
ENV DB_PASS pwd0123456789

# Install postgres drivers and datasource
RUN /bin/sh -c '$JBOSS_HOME/bin/standalone.sh &' && \
  sleep 10 && \
  cd /tmp && \
  curl --location --output postgresql-${POSTGRESQL_VERSION}.jar --url http://search.maven.org/remotecontent?filepath=org/postgresql/postgresql/${POSTGRESQL_VERSION}/postgresql-${POSTGRESQL_VERSION}.jar && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command="deploy /tmp/postgresql-${POSTGRESQL_VERSION}.jar" && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command="xa-data-source add --name=helloworld-cicd --jndi-name=java:/jdbc/datasources/helloworld-cicdDS --user-name=${DB_USER} --password=${DB_PASS} --driver-name=postgresql-42.2.8.jar --xa-datasource-class=org.postgresql.xa.PGXADataSource --xa-datasource-properties=ServerName=${DB_HOST},PortNumber=${DB_PORT},DatabaseName=${DB_NAME} --valid-connection-checker-class-name=org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker --exception-sorter-class-name=org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter" && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command=:shutdown && \
  rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/ $JBOSS_HOME/standalone/log/* && \
  rm /tmp/postgresql-42*.jar && \
  rm -rf /tmp/postgresql-*.jar

ADD ./target/helloworld-cicd*.war /opt/jboss/wildfly/standalone/deployments/helloworld-cicd.war

CMD /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -Djboss.http.port=$PORT