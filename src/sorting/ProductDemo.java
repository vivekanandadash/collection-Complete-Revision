package sorting;

import java.util.ArrayList;
import java.util.List;

public class ProductDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(201, "Jeans pant" , 3999.00 , 5000) );
        products.add(new Product(202, "Cargo pant" , 1842 , 2451) );
        products.add(new Product(203, "Korean pant" , 2541 , 1458) );
        products.add(new Product(204, "Half pant" , 1052 , 9856) );

        products.sort(new ProductIdComparator());
        for (Product product : products){
            //Print the number
            System.out.println(product);
        }
    }
}
