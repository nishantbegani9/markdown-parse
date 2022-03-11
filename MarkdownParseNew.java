// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkdownParseNew {
    public static ArrayList<String> getLinks(String markdown) {
        // ArrayList<String> toReturn = new ArrayList<>();
        // // find the next [, then find the ], then find the (, then take up to
        // // the next )
        // int currentIndex = 0;
        // while(currentIndex < markdown.length()) {

        //     //System.out.println(currentIndex); 
        //     int nextOpenBracket = markdown.indexOf("[", currentIndex);
        //     int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
        //     if (nextOpenBracket == -1) break; 
            
        //     String closeBracket = markdown.substring(nextCloseBracket+1, nextCloseBracket+2); 
        //     if (!closeBracket.equals("(")) break;
            
        //     int openParen = markdown.indexOf("(", nextCloseBracket);
        //     int closeParen = markdown.indexOf(")", openParen);
            
        //     System.out.println("nextCloseB: " + nextCloseBracket + "; nextOpenB: "+ nextOpenBracket + "; currentIdx" + currentIndex +"\n");
        //     if ( (nextOpenBracket ==0) || markdown.charAt(nextOpenBracket-1) != '!')
        //         toReturn.add(markdown.substring(openParen + 1, closeParen));
        //     currentIndex = closeParen + 1;
            
        // }
        // return toReturn;

        //ArrayList<String> toReturn = new ArrayList<>();

        Parser parser = Parser.builder().build();
        Node node = parser.parse(markdown);
        LinkCountVisitor visitor = new LinkCountVisitor();
        node.accept(visitor);
        return visitor.toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links); 
    }
}

class LinkCountVisitor extends AbstractVisitor {
    //int linkCount = 0;
    ArrayList<String> toReturn = new ArrayList<>();

    @Override
    public void visit(Link link) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        toReturn.add(link.getDestination()); 

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(link);
    }
}