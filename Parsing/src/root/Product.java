package root;

class Product {

    private String price, name, productLink, imageLink;

    Product(String price, String name, String productLink, String pictureLink) {
        this.price = price;
        this.name = name;
        this.productLink = productLink;
        this.imageLink = pictureLink;
    }

    String getPrice() {
        return price;
    }

    String getName() {
        return name;
    }

    String getProductLink() {
        return productLink;
    }

    String getImageLink() {
        return imageLink;
    }
}
