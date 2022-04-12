package org.paumard.solutions.devnexus.record;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class A_SimpleRecord {

    /**
     * The content of this class has just been added to make the code
     * compile. All this content should be removed when you make this class a record.
     */
    record Population(int amount) implements Comparable<Population> {
        Population {
            if (amount < 0) {
                throw new IllegalArgumentException("A population cannot be negative");
            }
        }

        Population() {
            this(0);
        }

        @Override
        public int compareTo(Population other) {
            return Integer.compare(this.amount, other.amount);
        }
    }

    /**
     * Make the Population class a Record. Remove the amount()
     * method from it.
     */
    @Test
    public void a_record01() {

        Population population = new Population(10);

        assertThat(population.amount()).isEqualTo(10);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Replace the existing Population class with a record.
    // </editor-fold>


    /**
     * Create an empty constructor in the Population record, that
     * creates a population instance with 0 people.
     */
    @Test
    public void a_record02() {

        Population population = new Population();

        assertThat(population.amount()).isEqualTo(0);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You can add any constructor to a record, as long as it calls
    // its canonical constructor.
    // </editor-fold>


    /**
     * A population instance should not carry any negative number.
     * Add a validation rule to enforce that.
     */
    @Test
    public void a_record03() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Population(-10));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You can add this validation rule either in the canonical constructor or
    // the compact constructor.
    // </editor-fold>


    /**
     * We need to be able to sort Population instances in the
     * ascending order. Make your Population record implement the
     * <code>Comparable&lt;Population></code> to make this test pass.
     */
    @Test
    public void a_record04() {

        Population p1 = new Population(90);
        Population p2 = new Population(10);
        Population p3 = new Population(60);
        Population p4 = new Population(30);
        Population p5 = new Population(50);

        List<Population> populations = Arrays.asList(p1, p2, p3, p4, p5);
        populations.sort(Comparator.naturalOrder());

        assertThat(populations).containsExactly(p2, p4, p5, p3, p1);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You should compare integers using the <code>Integer.compare()</code> method.
    // </editor-fold>
}
