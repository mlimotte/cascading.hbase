(defproject org.clojars.ndimiduk/cascading.hbase "0.1.2"
  :description "FIXME: write"
  :dependencies [[org.apache.hadoop/hadoop-core "0.20.2-dev"]
		 [org.clojars.ndimiduk/hbase "0.20.6"]
     [cascading/cascading-core "1.1.3"]]
  :dev-dependencies [[lein-javac "1.2.1-SNAPSHOT"]]
  :java-source-path "src/java"
  :javac-fork "true")
