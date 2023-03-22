package lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class ProductTest {

    private final List<Product> products = Arrays.asList(
            new Product("Book", 10.0, false, LocalDate.now().minusDays(60)),
            new Product("Book", 20.0, true, LocalDate.now().minusDays(50)),
            new Product("Book", 30.0, false, LocalDate.now().minusDays(40)),
            new Product("Toy", 40.0, false, LocalDate.now().minusDays(30)),
            new Product("Toy", 50.0, false, LocalDate.now().minusDays(20)),
            new Product("Food", 60.0, true, LocalDate.now().minusDays(10)),
            new Product("Book", 10.0, false, LocalDate.now().minusYears(2)),
            new Product("Book", 10.0, false, LocalDate.now().minusYears(1)));

    @Test
    void testGetExpensiveBooks() {
        List<Product> expensiveBooks = Product.getExpensiveBooks(products, 25.0);
        Assertions.assertEquals(1, expensiveBooks.size());
        Assertions.assertEquals(products.get(2), expensiveBooks.get(0));
    }

    @Test
    void testGetBooksWithDiscount() {
        List<Product> booksWithDiscount = Product.getBooksWithDiscount(products);
        Assertions.assertEquals(1, booksWithDiscount.size());
        Assertions.assertEquals("Book", booksWithDiscount.get(0).getCategory());
        Assertions.assertEquals(18.0, booksWithDiscount.get(0).getPrice());
    }

    @Test
    void testGetCheapestBook() {
        Product cheapestBook = Product.getCheapestBook(products);
        Assertions.assertEquals(10.0, cheapestBook.getPrice());
    }

    @Test
    void testGetLastThreeAddedProducts() {
        List<Product> lastThreeAddedProducts = Product.getLastThreeAddedProducts(products);
        Assertions.assertEquals(3, lastThreeAddedProducts.size());
        Assertions.assertEquals(products.get(5), lastThreeAddedProducts.get(0));
        Assertions.assertEquals(products.get(4), lastThreeAddedProducts.get(1));
        Assertions.assertEquals(products.get(3), lastThreeAddedProducts.get(2));
    }

    @Test
    void testCalculateCost() {
        double cost = Product.calculateCost(products);
        Assertions.assertEquals(60.0, cost);
    }

    @Test
    void testGroupProductsByType() {
        Map<String, List<Product>> productsByType = Product.groupProductsByType(products);
        Assertions.assertEquals(3, productsByType.size());
        Assertions.assertEquals(5, productsByType.get("Book").size());
        Assertions.assertEquals(2, productsByType.get("Toy").size());
        Assertions.assertEquals(1, productsByType.get("Food").size());
    }
}
