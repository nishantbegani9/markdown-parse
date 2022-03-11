CLASSPATH = lib/*:.
MarkdownParseNew.class : MarkdownParseNew.java 
	javac -cp $(CLASSPATH) MarkdownParseNew.java 

MarkdownParseTestNew.class : MarkdownParseTestNew.java 
	javac -cp $(CLASSPATH) MarkdownParseTestNew.java

test : MarkdownParseTestNew.class MarkdownParseNew.class 
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTestNew

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java 