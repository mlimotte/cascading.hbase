
Current Fork:
This fork includes an update for lein-javac 1.2.1, cascading 1.1.3, hbase 0.20.6.
Also added an HBaseScheme feature to support mapping of fields to arbitrary hbase family:columns.

Original Fork note:
This fork adds some simple leiningen interop stuff. Most of it centered around
dependency management and such. I'll eventually create the necessary pom files
and push all this stuff to clojars, but until then, you get a script.

installation

1. download hbase-0.20.6 release and extract it somewhere
2. run deploy-deps.sh to install jars into your local mvn repo
$ HBASE_HOME=/path/to/hbase sh deploy-deps.sh
3. install deps locally (assuming 3 worked): lein deps
4. compile and jar: lein javac ; lein jar
5. install to your local repo: lein install

using

If all that worked okay, you can now include cascading.hbase as a project dep

 :dependencies [[org.clojars.ndimiduk/cascading.hbase "0.0.1-dev"]]

Original readme follows
---

Welcome

 This is the Cascading.HBase module.

 It provides support for reading/writing data to/from an HBase
 cluster when bound to a Cascading data processing flow.

 Cascading is a feature rich API for defining and executing complex,
 scale-free, and fault tolerant data processing workflows on a Hadoop
 cluster. It can be found at the following location:

   http://www.cascading.org/

 HBase is the Hadoop database. Its an open-source, distributed,
 column-oriented store modeled after the Google paper on Bigtable.

   http://hadoop.apache.org/hbase/

Building

 This release requires at least Cascading 1.0.1. Hadoop 0.19.x,
 and the related HBase release.

 To build a jar,

 > ant -Dcascading.home=... -Dhadoop.home=... -Dhbase.home=... jar

 To test,

 > ant -Dcascading.home=... -Dhadoop.home=... -Dhbase.home=... test

where "..." is the install path of each of the dependencies.


Using

  The cascading-hbase.jar file should be added to the "lib"
  directory of your Hadoop application jar file along with all
  Cascading dependencies.

  See the HBaseTest unit test for sample code on using the HBase taps and
  schemes in your Cascading application.

License

  Copyright (c) 2009 Concurrent, Inc.

  This work has been released into the public domain
  by the copyright holder. This applies worldwide.

  In case this is not legally possible:
  The copyright holder grants any entity the right
  to use this work for any purpose, without any
  conditions, unless such conditions are required by law.
