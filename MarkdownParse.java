//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class 	
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int exclaimMark;
        int openBracket;
        int closeBracket;
        int openParen;
        int closeParen;
        int urlDot;
        while(currentIndex < markdown.length()) {

            exclaimMark = markdown.indexOf("!", currentIndex);

            openBracket = markdown.indexOf("[", currentIndex); 
            if(exclaimMark == openBracket -1 && exclaimMark != -1){
                System.out.println("Invalid link format exclaimMark");
                break;
            }

            if(openBracket == -1){
                System.out.println("Error: Invalid link format! openBracket");
                break;
            }

            closeBracket = markdown.indexOf("]", openBracket);
            if(closeBracket == -1){
                System.out.println("Error: Invalid link format! closeBracket");
                break;
            }

            urlDot = markdown.indexOf(".", openBracket);

            openParen = markdown.indexOf("(", closeBracket);
            if(openParen == -1 || openParen!= closeBracket + 1){
                System.out.println("Error: Invalid link format openParen!");
                break;
            }

            closeParen = markdown.indexOf(")", openParen); 

            if(!(openParen < urlDot) && !(urlDot < closeParen) || urlDot == -1){
                System.out.println("Error: Invalid link format urlDot!");
                break;
            }
            if(closeParen == -1){
                System.out.println("Error: Invalid link format closeParen!");
                break;
            }

            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            System.out.println(currentIndex);
            System.out.println(markdown.length());
            
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
