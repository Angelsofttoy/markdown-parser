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
    public void imageURLTest() throws IOException{
        Path fileName = Path.of("/Users/angel/Documents/GitHub/markdown-parser/tester1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of(),links);
    }

    @Test
    public void paragraphTest() throws IOException{
        Path fileName = Path.of("/Users/angel/Documents/GitHub/markdown-parser/tester2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
	    assertEquals(List.of("https://something.com","some-page.html"),links);
    }

    @Test
    public void 


   
}
