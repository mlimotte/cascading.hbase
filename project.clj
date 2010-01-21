(defproject org.clojars.ndimiduk/cascading.hbase "0.0.1-dev"
  :description "FIXME: write"
  :dependencies [[org.apache.hadoop/hadoop-core "0.20.2-dev"]
		 [org.clojars.ndimiduk/hbase "0.20.2"]
		 [cascading "1.0.17-SNAPSHOT"]]
  :dev-dependencies [[lein-javac "0.0.2-SNAPSHOT"]]
  :java-source-path "src/java"
  :javac-fork "true")
