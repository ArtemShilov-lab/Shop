
package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTest {

    @Test
    void shouldRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();

        Product phone = new Product(1, "iPhone", 100000);
        Product laptop = new Product(2, "MacBook", 150000);
        Product tablet = new Product(3, "iPad", 80000);

        repository.add(phone);
        repository.add(laptop);
        repository.add(tablet);

        repository.removeById(2);

        Product[] expected = {phone, tablet};

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldThrowNotFoundExceptionWhenRemovingMissingProduct() {
        ShopRepository repository = new ShopRepository();

        repository.add(new Product(1, "iPhone", 100000));
        repository.add(new Product(2, "MacBook", 150000));

        assertThrows(
                NotFoundException.class,
                () -> repository.removeById(5)
        );
    }
}
