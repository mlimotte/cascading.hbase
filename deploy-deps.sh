#! /bin/sh
#
# Deploy all HBase dependencies which are not available via the official
# maven repository at http://repo1.maven.org.
#
#

# The maven repository to deploy to.
#

REPOSITORY_URL=file:///$HOME/.m2/repository

if [ -z $HBASE_HOME ]; then
	echo "Error: HBASE_HOME is not set." 2>&1
	exit 1
fi

HBASE_LIBDIR=$HBASE_HOME/lib

# HBase
mvn deploy:deploy-file -Dfile=$HBASE_HOME/hbase-0.20.2.jar \
	-DpomFile=./hbase-0.20.2.pom -Durl=$REPOSITORY_URL

# AgileJSON
mvn deploy:deploy-file -DgroupId=org.clojars.ndimiduk -DartifactId=AgileJSON \
    -Dversion=2009-03-30 -Dpackaging=jar -Durl=$REPOSITORY_URL \
    -Dfile=$HBASE_LIBDIR/AgileJSON-2009-03-30.jar

# commons cli
#mvn deploy:deploy-file -DgroupId=org.clojars.ndimiduk \
#    -DartifactId=commons-cli -Dversion=2.0-SNAPSHOT -Dpackaging=jar \
#    -Durl=$REPOSITORY_URL -Dfile=$HBASE_LIBDIR/commons-cli-2.0-SNAPSHOT.jar
mvn deploy:deploy-file -DgroupId=org.clojars.ndimiduk \
    -DartifactId=commons-cli -Dversion=2.0 -Dpackaging=jar \
    -Durl=$REPOSITORY_URL -Dfile=$HBASE_LIBDIR/commons-cli-2.0-SNAPSHOT.jar

# commons el from jetty
mvn deploy:deploy-file -DgroupId=org.clojars.ndimiduk \
    -DartifactId=commons-el-from-jetty -Dversion=5.1.4 -Dpackaging=jar \
    -Durl=$REPOSITORY_URL -Dfile=$HBASE_LIBDIR/commons-el-from-jetty-5.1.4.jar

# thrift
mvn deploy:deploy-file -DgroupId=org.clojars.ndimiduk -DartifactId=thrift \
	-Dversion=r771587 -Dpackaging=jar -Durl=$REPOSITORY_URL \
	-Dfile=$HBASE_LIBDIR/libthrift-r771587.jar

# zookeeper
mvn deploy:deploy-file -DgroupId=org.clojars.ndimiduk -DartifactId=zookeeper \
	-Dversion=3.2.1 -Dpackaging=jar -Durl=$REPOSITORY_URL \
	-Dfile=$HBASE_LIBDIR/zookeeper-3.2.1.jar

# EOF
