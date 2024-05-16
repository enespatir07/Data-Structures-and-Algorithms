all: compile run clean


compile:
	javac Main.java

run:
	java Main

doc:
	javadoc -protected -splitindex -use -author -version -d ./javadoc *.java 

clean:
	rm *.class 

cleandoc:
	rm -r ./javadoc