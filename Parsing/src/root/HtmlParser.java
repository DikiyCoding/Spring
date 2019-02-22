package root;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class HtmlParser {

    private HtmlCleaner cleaner;
    private List<TagNode> pageList;
    private List<Product> productList;
    private String mainLink, pageLink, productTag, nameTag, priceTag, productLinkTag, imageLinkTag;

    HtmlParser() {
        mainLink = "https://hobbygames.ru/";
        pageLink = mainLink + "catalog-all?page="; //162 страницы
        productTag = "//div[@class='col-lg-4 col-md-6 col-sm-6 col-xs-12']";
        nameTag = "//a[@class='name']/text()";
        priceTag = "//span[@class='price']/text()";
        productLinkTag = "//a[@class='name']/@href/text()";
        imageLinkTag = "//img/@src/text()";
        cleaner = new HtmlCleaner();
        pageList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    List<Product> parse() throws IOException, XPatherException {
        getPages();
        getProductsInfo();
        return productList;
    }

    private void getPages() throws IOException {
        String pageLink;
        URL pageURL;
        for (int i = 1; i < 4; i++) {
            pageLink = this.pageLink + i;
            pageURL = new URL(pageLink);
            pageList.add(cleaner.clean(pageURL));
        }
    }

    private void getProductsInfo() throws XPatherException {
        TagNode productNode;
        for (TagNode page : pageList) {
            for(Object productObject : page.evaluateXPath(productTag)) {
                productNode = (TagNode) productObject;
                formProducts(productNode.evaluateXPath(priceTag),
                             productNode.evaluateXPath(nameTag),
                             productNode.evaluateXPath(productLinkTag),
                             productNode.evaluateXPath(imageLinkTag));
            }
        }
    }

    private void formProducts(Object[] prices, Object[] names, Object[] pageLinks, Object[] imageLinks) {
        for (int i = 0; i < names.length; i++)
            System.out.println("Product's name: " + names[i].toString().trim() + "\n" +
                               "Product's price: " + prices[i].toString().trim().replaceAll("&nbsp;", "") + "\n" +
                               "Product's page link: " + pageLinks[i].toString() + "\n" +
                               "Product's image link: " + imageLinks[i].toString() + "\n");
    }
}
