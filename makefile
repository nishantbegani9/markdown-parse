MarkdownParseNew.class : MarkdownParseNew.java 
	javac MarkdownParseNew.java 

MarkdownParseTestNew.class : MarkdownParseTestNew.java 
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTestNew.java

test : MarkdownParseTestNew.class MarkdownParseNew.class 
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTestNew