package com.future.Collection;

import com.future.util.Generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * coffee generator
 *
 * @author liming
 * @date 2018-01-04 14:36
 */
public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{

    private Class[] types = {Coffee.Mocha.class, Coffee.Latte.class, Coffee.Cappuccino.class};

    private static final Random random = new Random(47);

    private int size;

    public CoffeeGenerator (int size){this.size = size;}
    @Override
    public Coffee next() {

        try {
            size++;
            return (Coffee) (types[random.nextInt(types.length)].newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            private int count = size;

            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Coffee next() {
                count--;
                return CoffeeGenerator.this.next();
            }
        };
    }

    class CoffeeIterator implements Iterator<Coffee> {

        private int count = size;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Coffee next() throws NoSuchElementException{
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator(5);
        for(int i = 0;i < 5; i++)
            System.out.println(coffeeGenerator.next());
        /*
         * for loop requires an iterable object,not a iterator object
         */
        for (Coffee c : coffeeGenerator)
            System.out.println(c);

        System.out.println("$");
        for (Iterator<Coffee> it = coffeeGenerator.iterator(); it.hasNext(); ) {
            Coffee c = it.next();
            System.out.println(c);
        }
        System.out.println("$");
    }

}

