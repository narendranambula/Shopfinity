package com.narendra.ecomproj;

import com.narendra.ecomproj.controller.ProductController;
import com.narendra.ecomproj.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.file.Files;
import java.util.Date;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner preloadData(ProductController productService) {
        return args -> {
            List<ProductSeed> products = List.of(
                    new ProductSeed("iPhone 14 Pro", "Flagship Apple smartphone", 139999, "mobile", "Apple", 25, "1.1.jpg"),
                    new ProductSeed("Samsung Galaxy S23", "Latest Samsung flagship", 84999, "mobile", "Samsung", 30, "1.2.jpeg"),
                    new ProductSeed("OnePlus 11", "High-performance Android phone", 69999, "mobile", "OnePlus", 40, "1.3.jpg"),
                    new ProductSeed("Google Pixel 7", "Clean Android experience", 62999, "mobile", "Google", 35, "1.4.jpeg"),
                    new ProductSeed("Realme GT Neo 3", "Affordable flagship phone", 37999, "mobile", "Realme", 45, "1.5.jpeg"),
                    new ProductSeed("Motorola Edge 30", "Sleek design, great performance", 29999, "mobile", "Motorola", 50, "1.6.jpeg"),

                    new ProductSeed("MacBook Pro M2", "Apple's powerful laptop", 199999, "laptop", "Apple", 10, "2.1.jpeg"),
                    new ProductSeed("HP Spectre x360", "Premium 2-in-1 laptop", 124999, "laptop", "HP", 15, "2.2.jpeg"),
                    new ProductSeed("Lenovo ThinkPad X1", "Business-class ultrabook", 135000, "laptop", "Lenovo", 12, "2.3.jpeg"),
                    new ProductSeed("Asus ROG Zephyrus", "Gaming powerhouse laptop", 155000, "laptop", "Asus", 8, "2.4.jpeg"),
                    new ProductSeed("Dell Inspiron 15", "Everyday use laptop", 57999, "laptop", "Dell", 20, "2.5.jpeg"),
                    new ProductSeed("Acer Aspire 7", "Budget gaming laptop", 49999, "laptop", "Acer", 25, "2.6.jpeg"),

                    new ProductSeed("Sony Bravia 55", "4K Smart LED TV", 84999, "electronics", "Sony", 18, "3.1.jpeg"),
                    new ProductSeed("Philips Air Fryer", "Healthy cooking solution", 10999, "electronics", "Philips", 30, "3.2.jpeg"),
                    new ProductSeed("Mi Smart LED Bulb", "Smart light with Alexa support", 999, "electronics", "Xiaomi", 100, "3.3.jpeg"),
                    new ProductSeed("Canon DSLR 1500D", "Beginner DSLR camera", 32999, "electronics", "Canon", 10, "3.4.jpeg"),
                    new ProductSeed("JBL Bluetooth Speaker", "Portable wireless speaker", 3999, "electronics", "JBL", 60, "3.5.jpg"),
                    new ProductSeed("Samsung Microwave Oven", "Convection microwave", 8999, "electronics", "Samsung", 20, "3.6.jpeg"),

                    new ProductSeed("Lego Technic Car", "Mechanical car-building toy", 7499, "toys", "LEGO", 40, "4.1.jpeg"),
                    new ProductSeed("Hot Wheels Track Set", "Race track with loops", 2599, "toys", "Hot Wheels", 50, "4.2.jpeg"),
                    new ProductSeed("Barbie Dreamhouse", "Luxury house for Barbie", 9999, "toys", "Barbie", 20, "4.3.jpeg"),
                    new ProductSeed("Rubik’s Cube", "3x3 puzzle cube", 299, "toys", "Rubik", 150, "4.4.jpeg"),

                    new ProductSeed("Men’s Formal Shirt", "Cotton white office wear", 1299, "fashion", "Peter England", 70, "5.1.jpeg"),
                    new ProductSeed("Women’s Ethnic Dress", "Traditional festive wear", 2499, "fashion", "Biba", 50, "5.2.jpeg"),
                    new ProductSeed("Sports Shoes", "Running shoes for men", 2199, "fashion", "Nike", 60, "5.3.jpeg"),
                    new ProductSeed("Winter Jacket", "Warm puffer jacket", 3599, "fashion", "Decathlon", 40, "5.4.jpeg"),
                    new ProductSeed("Denim Jeans", "Slim fit stretchable jeans", 1999, "fashion", "Levi's", 65, "5.5.jpg"),
                    new ProductSeed("Casual T-Shirt", "Cotton round neck t-shirt", 799, "fashion", "Roadster", 100, "5.6.jpg"),
                    new ProductSeed("Leather Belt", "Brown genuine leather belt", 999, "fashion", "Woodland", 80, "5.7.jpeg"),
                    new ProductSeed("Sunglasses", "UV protected stylish sunglasses", 1499, "fashion", "Ray-Ban", 45, "5.8.jpg"),
                    new ProductSeed("Kurta Set", "Men’s festive kurta with churidar", 1899, "fashion", "Manyavar", 55, "5.9.jpg"),
                    new ProductSeed("Women's Handbag", "Trendy leather handbag", 2799, "fashion", "Caprese", 50, "5.10.jpg"),
                    new ProductSeed("Ankle Boots", "Black leather ankle boots", 3299, "fashion", "Hush Puppies", 30, "5.11.jpg"),
                    new ProductSeed("Sports Watch", "Digital waterproof watch", 1599, "fashion", "Casio", 70, "5.12.jpg"),
                    new ProductSeed("Women's Heels", "Stylish party wear heels", 2399, "fashion", "Catwalk", 40, "5.13.jpg"),
                    new ProductSeed("Sweatshirt", "Winter fleece sweatshirt", 1499, "fashion", "Puma", 60, "5.14.jpg"),
                    new ProductSeed("Women's Jeggings", "Comfortable cotton jeggings", 999, "fashion", "ONLY", 75, "5.15.jpeg"),
                    new ProductSeed("Men’s Suit", "Two-piece formal suit", 4999, "fashion", "Raymond", 20, "5.16.jpg"),
                    new ProductSeed("Men’s Cap", "Adjustable casual baseball cap", 599, "fashion", "Nike", 90, "5.17.jpg"),
                    new ProductSeed("Wrist Bracelet", "Leather strap bracelet for men", 699, "fashion", "Fossil", 40, "5.18.jpg"),
                    new ProductSeed("Women’s Scarf", "Printed silk scarf", 899, "fashion", "Zara", 65, "5.19.jpg"),
                    new ProductSeed("Men’s Wallet", "Classic bifold wallet", 899, "fashion", "Wildhorn", 100, "5.20.jpg"),
                    new ProductSeed("Women’s Flats", "Casual slip-on sandals", 1099, "fashion", "Metro", 50, "5.21.jpg"),
                    new ProductSeed("Track Pants", "Men’s sports track pants", 1299, "fashion", "Adidas", 60, "5.22.jpg"),
                    new ProductSeed("Denim Jacket", "Unisex rugged denim jacket", 2599, "fashion", "Flying Machine", 35, "5.23.jpg"),
                    new ProductSeed("Party Gown", "Evening wear long gown", 3899, "fashion", "Global Desi", 25, "5.24.jpg"),


                    new ProductSeed("Sony WH-1000XM5", "Wireless noise-canceling headphone", 29999, "headphone", "Sony", 25, "6.1.jpeg"),
                    new ProductSeed("Boat Rockerz 550", "Affordable over-ear headphones", 1999, "headphone", "Boat", 80, "6.2.jpeg"),
                    new ProductSeed("Apple AirPods Pro", "Wireless earbuds with ANC", 24999, "headphone", "Apple", 35, "6.3.jpeg"),
                    new ProductSeed("JBL Tune 760NC", "Bluetooth headphone with ANC", 6499, "headphone", "JBL", 45, "6.4.jpeg")
            );

            for (ProductSeed seed : products) {
                Product product = new Product();
                product.setName(seed.name);
                product.setDescription(seed.description);
                product.setPrice(seed.price);
                product.setCategory(seed.category);
                product.setBrand(seed.brand);
                product.setReleasedate(new Date());
                product.setProductavailable(true);
                product.setStockquantity(seed.stock);

                // Load image
                ClassPathResource imgFile = new ClassPathResource("static/images/" + seed.imageFileName);
                MultipartFile image = new MockMultipartFile(
                        imgFile.getFilename(),
                        imgFile.getFilename(),
                        Files.probeContentType(imgFile.getFile().toPath()),
                        Files.readAllBytes(imgFile.getFile().toPath())
                );

                productService.addProduct(product, image);
            }
        };
    }

    // Helper class to store product seed data
    record ProductSeed(String name, String description, int price, String category, String brand, int stock, String imageFileName) {}
}
