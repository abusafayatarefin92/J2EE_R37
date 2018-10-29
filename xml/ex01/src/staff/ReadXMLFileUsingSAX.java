package staff;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFileUsingSAX {
    
    public static void main(String argv[]) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean bfname = false;
                boolean bsalary = false;
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                    
                    if (qName.equalsIgnoreCase("FULLNAME")) {
                        bfname = true;
                    }
                    
                    if (qName.equalsIgnoreCase("SALARY")) {
                        bsalary = true;
                    }
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }
                
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bfname) {
                        System.out.println("Full Name: " + new String(ch, start, length));
                        bfname = false;
                    }
                    
                    if (bsalary) {
                        System.out.println("Salary: " + new String(ch, start, length));
                        bsalary = false;
                    }
                }
            };
            
            saxParser.parse("D:\\git\\J2EE_R37\\xml\\ex01\\src\\staff/Staff.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
