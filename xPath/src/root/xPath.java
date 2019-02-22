package root;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xPath {

    private XPath xPath;
    private Document doc;
    private NodeList nodeList;

    private String answer;

    public xPath() throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            throw new Exception("Can't create DocumentBuilder");
        }

        String XML_URI = "https://auto.ru/kazan/cars/all/?sort=fresh_relevance_1-desc&output_type=list&page=1";
        try {
            doc = builder.parse(XML_URI);
        } catch (IOException ex) {
            throw new Exception("Can't get XML by URL " + XML_URI);
        } catch (SAXException ex) {
            throw new Exception("Can't read downloaded XML.");
        }

        XPathFactory xPathfactory = XPathFactory.newInstance();
        xPath = xPathfactory.newXPath();
    }

    private void getNodeList(String expression) throws Exception {
        XPathExpression xPathExpression;
        try {
            xPathExpression = xPath.compile(expression);
        } catch (XPathExpressionException ex) {
            throw new Exception("Can't parse xPath expression " + expression);
        }

        try {
            nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException ex) {
            throw new Exception("Can't evaluate expression");
        }
    }

    private void getAnswerByType(Node node, int i) {
        switch (node.getNodeType()) {
            case Node.ELEMENT_NODE:
                answer += "There is number " + (i + 1) + " \"" + node.getNodeName() + "\" node with the following content:\n" + node.getTextContent() + "\n\n";
                break;
            case Node.ATTRIBUTE_NODE:
                answer += "There is number " + (i + 1) + " \"" + node.getNodeName() + "\" attribute with the following value:" + " \"" + node.getNodeValue() + "\"\n\n";
                break;
            case Node.TEXT_NODE:
                answer += "There is number " + (i + 1) + " \"" + node.getParentNode().getNodeName() + "\" text content with the following value:" + " \"" + node.getTextContent() + "\"\n\n";
                break;
            default:
                throw new IllegalStateException("Unexpected Node type" + node.getNodeType());
        }
    }

    private void setAnswer() {
        answer = "";
        for (int i = 0; i < nodeList.getLength(); i++)
            getAnswerByType(nodeList.item(i), i);
    }

    public String getResult(String expression) throws Exception {
        getNodeList(expression);
        setAnswer();
        return answer;
    }
}
