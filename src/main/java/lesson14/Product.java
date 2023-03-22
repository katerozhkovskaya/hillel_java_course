package lesson14;

        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.ToString;

        import java.time.LocalDate;
        import java.util.*;
        import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private String category;
    private double price;
    private boolean discount;
    private LocalDate dateAdded;

    public static List<Product> getExpensiveBooks(List<Product> products, double price) {
        return products.stream()
                .filter(product -> product.getCategory().equals("Book"))
                .filter(product -> product.getPrice() > price)
                .toList();
    }

    public static List<Product> getBooksWithDiscount(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equals("Book"))
                .filter(Product::isDiscount)
                .map(product -> new Product(product.getCategory(), product.getPrice() * 0.9, false, product.getDateAdded()))
                .toList();
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("No Book products found"));
    }

    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();
    }

    public static double calculateCost(List<Product> products) {
        LocalDate currentYear = LocalDate.now().withDayOfYear(1);
        return products.stream()
                .filter(p -> p.getCategory().equals("Book"))
                .filter(p -> p.getPrice() <= 75.0)
                .filter(p -> p.getDateAdded().isAfter(currentYear))
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Book", 10.0, false, LocalDate.now().minusDays(60)),
                new Product("Book", 20.0, true, LocalDate.now().minusDays(50)),
                new Product("Book", 30.0, false, LocalDate.now().minusDays(40)),
                new Product("Toy", 40.0, false, LocalDate.now().minusDays(30)),
                new Product("Toy", 50.0, false, LocalDate.now().minusDays(20)),
                new Product("Food", 60.0, true, LocalDate.now().minusDays(10)),
                new Product("Book", 10.0, false, LocalDate.now().minusYears(2)),
                new Product("Book", 10.0, false, LocalDate.now().minusYears(1)));

        Map<String, List<Product>> categorizedProduct = groupProductsByType(products);
        System.out.println(categorizedProduct.toString());
    }
}
