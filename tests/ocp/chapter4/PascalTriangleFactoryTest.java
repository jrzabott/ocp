package ocp.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class PascalTriangleFactoryTest {


    Logger logger = Logger.getLogger(PascalTriangleFactoryTest.class.getName());
    private PascalTriangleFactory factory;

    @BeforeEach
    void setUp() {
        this.factory = new PascalTriangleFactory();
    }

    @Test
    void whenCreatingATriangleWithNegativeLength_thenExceptionIsThrown() {
        final String message = Assertions.assertThrows(IllegalArgumentException.class, () -> factory.produceTriangle(-1)).getMessage();
        assertThat(message, is(equalTo(PascalTriangleFactory.LENGTH_MUST_BE_POSITIVE)));
    }

    @Test
    void whenCreatingATriangleWith0Length_thenTriangleIsEmpty() {
        factory.produceTriangle(0);
        final Optional<List<List<Integer>>> triangle = factory.getTriangle();
        assertThat(triangle.isPresent(), is(equalTo(false)));
    }

    @Test
    void whenCreatingATriangleWithLength1_thenATriangleWithOneRow() {
        factory.produceTriangle(1);
        final Optional<List<List<Integer>>> triangle = factory.getTriangle();
        assertThat(triangle.isPresent(), is(equalTo(true)));
        assertThat(triangle.get().size(), is(equalTo(1)));
        assertThat(triangle.get().get(0).size(), is(equalTo(1)));
        assertThat(triangle.get().get(0).get(0), is(equalTo(1)));
    }

    @Test
    void whenCreatingATriangleWithLength2_thenATriangleWithTwoRows() {
        factory.produceTriangle(2);
        final Optional<List<List<Integer>>> triangle = factory.getTriangle();
        assertThat(triangle.isPresent(), is(equalTo(true)));
        assertThat(triangle.get().size(), is(equalTo(2)));

        assertThat(triangle.get().get(0).size(), is(equalTo(1)));
        assertThat(triangle.get().get(0).get(0), is(equalTo(1)));

        assertThat(triangle.get().get(1).size(), is(equalTo(2)));
        assertThat(triangle.get().get(1).get(0), is(equalTo(1)));
        assertThat(triangle.get().get(1).get(1), is(equalTo(1)));
    }

    @Test
    void whenCreatingATriangleWithLength5_thenATriangleWithFiveRows() {
        factory.produceTriangle(5);
        final Optional<List<List<Integer>>> triangle = factory.getTriangle();
        assertThat(triangle.isPresent(), is(equalTo(true)));
        assertThat(triangle.get().size(), is(equalTo(5)));

        assertThat(triangle.get().get(0).size(), is(equalTo(1)));
        assertThat(triangle.get().get(0), contains(1));

        assertThat(triangle.get().get(1).size(), is(equalTo(2)));
        assertThat(triangle.get().get(1), contains(1, 1));

        assertThat(triangle.get().get(2).size(), is(equalTo(3)));
        assertThat(triangle.get().get(2), contains(1, 2, 1));

        assertThat(triangle.get().get(3).size(), is(equalTo(4)));
        assertThat(triangle.get().get(3), contains(1, 3, 3, 1));

        assertThat(triangle.get().get(4).size(), is(equalTo(5)));
        assertThat(triangle.get().get(4), contains(1, 4, 6, 4, 1));
    }

    @Test
    void whenCreatingATriangleWithLength10_thenATriangleWithTenRows() {
        factory.produceTriangle(10);
        final Optional<List<List<Integer>>> triangle = factory.getTriangle();
        assertThat(triangle.isPresent(), is(equalTo(true)));
        assertThat(triangle.get().size(), is(equalTo(10)));

        assertThat(triangle.get().get(0).size(), is(equalTo(1)));
        assertThat(triangle.get().get(0), contains(1));

        assertThat(triangle.get().get(1).size(), is(equalTo(2)));
        assertThat(triangle.get().get(1), contains(1, 1));

        assertThat(triangle.get().get(2).size(), is(equalTo(3)));
        assertThat(triangle.get().get(2), contains(1, 2, 1));

        assertThat(triangle.get().get(3).size(), is(equalTo(4)));
        assertThat(triangle.get().get(3), contains(1, 3, 3, 1));

        assertThat(triangle.get().get(4).size(), is(equalTo(5)));
        assertThat(triangle.get().get(4), contains(1, 4, 6, 4, 1));

        assertThat(triangle.get().get(5).size(), is(equalTo(6)));
        assertThat(triangle.get().get(5), contains(1, 5, 10, 10, 5, 1));

        assertThat(triangle.get().get(6).size(), is(equalTo(7)));
        assertThat(triangle.get().get(6), contains(1, 6, 15, 20, 15, 6, 1));

        assertThat(triangle.get().get(7).size(), is(equalTo(8)));
        assertThat(triangle.get().get(7), contains(1, 7, 21, 35, 35, 21, 7, 1));

        assertThat(triangle.get().get(8).size(), is(equalTo(9)));
        assertThat(triangle.get().get(8), contains(1, 8, 28, 56, 70, 56, 28, 8, 1));
    }
}

