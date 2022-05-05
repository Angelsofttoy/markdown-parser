import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest extends MarkdownParse {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    } 


    @Test
    public void paragraphTest() throws IOException{
        Path fileName = Path.of("./tester2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of("https://something.com","some-page.html"),links);
    }

    @Test
    public void onlyBracketTest() throws IOException{
        Path fileName = Path.of("./tester3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of(),links);
    }

    @Test
    public void onlyTextAfterBracketTest() throws IOException{
        Path fileName = Path.of("./tester4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of(),links);
    }

    @Test
    public void linesBetweenBracketandParen() throws IOException{
        Path fileName = Path.of("./tester5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of(),links);
    }

    @Test
    public void imageURLTest() throws IOException{
        Path fileName = Path.of("./tester6.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
        System.out.println("lo=ve");
	    assertEquals(List.of(),links);
    }

    @Test
    public void halfBracketParen() throws IOException{
        Path fileName = Path.of("./tester7.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of(),links);
    }

    @Test
    public void invalidUrlInParen() throws IOException{
        Path fileName = Path.of("./tester8.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of(),links);
    }
    /*@Test
    public void severalspacesinfrontandbehindlink() throws IOException{
        Path fileName = Path.of("./tester9.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of("   hjfsajkfs.com    "),links);
    }*/






   
}
