import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;

public class Parser {
    public static void main(String[] args) {
        parseFile("C:/Users/lunay/IdeaProjects/Exercises/exercise8/bookshelf.xml", FileType.XML);
        parseFile("C:/Users/lunay/IdeaProjects/Exercises/exercise8/bookshelf.json", FileType.JSON);
    }
    enum FileType {
        XML,
        JSON
    }
    public static String readFileContent(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString();
    }
    public static void parseFile(String filePath, FileType fileType) {
        try {

            System.out.println("Book Information: parse from "+filePath);
            System.out.println("-".repeat(200));
            System.out.printf("| %-80s | %-15s | %-15s | %-80s |\n", "Title", "Published Year", "Num of Pages", "Authors");
            System.out.println("-".repeat(200));

            if (fileType == FileType.XML) {
                File file = new File(filePath);
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                NodeList bookList = document.getElementsByTagName("Book");

                for (int i = 0; i < bookList.getLength(); i++) {
                    Node bookNode = bookList.item(i);
                    if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element bookElement = (Element) bookNode;
                        String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                        int publishedYear = Integer.parseInt(bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                        int numberOfPages = Integer.parseInt(bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent());
                        NodeList authorList = bookElement.getElementsByTagName("author");
                        StringBuilder authors = new StringBuilder();
                        for (int j = 0; j < authorList.getLength(); j++) {
                            Element authorElement = (Element) authorList.item(j);
                            authors.append(authorElement.getTextContent());
                            if (j != authorList.getLength() - 1) {
                                authors.append(", ");
                            }
                        }
                        System.out.printf("| %-80s | %-15d | %-15d | %-80s |\n", title, publishedYear, numberOfPages, authors);
                    }
                }
                System.out.println("-".repeat(100));
            } else if (fileType == FileType.JSON) {
                String content = readFileContent(filePath);
                JSONObject bookshelfObject = new JSONObject(content);
                JSONArray booksArray = bookshelfObject.getJSONArray("books");

                for (int i = 0; i < booksArray.length(); i++) {
                    JSONObject book = booksArray.getJSONObject(i);
                    String title = book.getString("title");
                    int publishedYear = book.getInt("publishedYear");
                    int numberOfPages = book.getInt("numberOfPages");
                    JSONArray authorsArray = book.getJSONArray("authors");
                    StringBuilder authors = new StringBuilder();
                    for (int j = 0; j < authorsArray.length(); j++) {
                        authors.append(authorsArray.getString(j));
                        if (j != authorsArray.length() - 1) {
                            authors.append(", ");
                        }
                    }
                    System.out.printf("| %-80s | %-15d | %-15d | %-80s |\n", title, publishedYear, numberOfPages, authors);
                }
                System.out.println("-".repeat(100));
            } else {
                System.out.println("Unsupported file type.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
