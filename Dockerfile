FROM ubuntu:14.04

MAINTAINER Sridhar B <sridharb.in@gmail.com>

RUN apt-get update \
    && apt-get install -y wget \
    && rm -rf /var/lib/apt/lists/*

# Install JRE
ADD ibm-java*archive.bin /tmp/java.bin

RUN chmod +x /tmp/java.bin \
   && /tmp/java.bin -i silent -DUSER_INSTALL_DIR=/opt/ibm/java \
   && rm /tmp/java.bin

ENV JAVA_HOME /opt/ibm/java
ENV PATH $JAVA_HOME/jre/bin:$PATH

# Install Liberty
ADD wlp-*-runtime-8.5.5.*.jar /tmp/wlp-runtime.jar

RUN java -jar /tmp/wlp-runtime.jar --acceptLicense /opt/ibm \
    && rm /tmp/wlp-runtime.jar

ENV PATH /opt/ibm/wlp/bin:$PATH

# Set Path Shortcuts
ENV LOG_DIR /logs
ENV WLP_OUTPUT_DIR /opt/ibm/wlp/output
RUN mkdir /logs \
    && ln -s $WLP_OUTPUT_DIR/defaultServer /output \
    && ln -s /opt/ibm/wlp/usr/servers/defaultServer /config

# Configure WebSphere Liberty
RUN /opt/ibm/wlp/bin/server create \
    && rm -rf $WLP_OUTPUT_DIR/.classCache

COPY target/atomic-1.0-snapshot.war /opt/ibm/wlp/usr/servers/defaultServer/dropins/atomic-1.0-snapshot.war 

COPY server.xml /opt/ibm/wlp/usr/servers/defaultServer/

EXPOSE 9080 9443

CMD ["/opt/ibm/wlp/bin/server", "run", "defaultServer"]
