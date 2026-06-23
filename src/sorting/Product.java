package sorting;

public class Product {
    int id ;
    String name;
    double price;
    long eks;

    public Product(int id , String name, double price , long eks){
        this.id = id;
        this.name = name;
        this.price = price;
        this.eks = eks ;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", eks=" + eks +
                '}';
    }
}
