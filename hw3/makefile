all : compile run clean

compile:
	javac Main.java

run : 
	java Main

doc:
	javadoc -protected -splitindex -use -author -version -d ./javadoc *.java 

clean:
	rm *.class

cleandoc:
	rm -r ./javadoc

help:
	@echo "Available targets:"
	@echo "  all       - compile run clean"
	@echo "  compile   - Compile Java code"
	@echo "  run       - Run Java code"
	@echo "  doc       - Generate JavaDoc documentation"
	@echo "  clean     - Clean up compiled files"
	@echo "  cleandoc  - Clean up JavaDoc documentation"
	@echo "  help      - Display this help message"
