assert = $(if $2,$(if $1,,$(error $2)))

JUnit.ver  = 1.5.2
JUnit.jar  = junit-platform-console-standalone-$(JUnit.ver).jar
Maven.http = http://central.maven.org/maven2/org/junit/platform/junit-platform-console-standalone
JUnit.mvn  = $(Maven.http)/$(JUnit.ver)/$(JUnit.jar)

all: check-variable test

check-variable:
	$(call assert,$(JAVA_HOME),JAVA_HOME is not defined)

dirs:
	-mkdir -p target
	-mkdir -p lib

compile-java: dirs
	$(JAVA_HOME)/bin/javac -d target/classes src/*/*.java

junit-download:
	curl -s -z lib/$(JUnit.jar) \
          -o lib/$(JUnit.jar) \
          $(JUnit.mvn)

compile-test: compile-java junit-download
	$(JAVA_HOME)/bin/javac -d target/test-classes \
          -cp lib/$(JUnit.jar):target/classes \
          src/test/java/sample/*.java

test: compile-test
	$(JAVA_HOME)/bin/java -jar lib/$(JUnit.jar) \
           --class-path target/classes:target/test-classes \
           --scan-class-path

clean:
	-rm -rf lib
	-rm -rf target