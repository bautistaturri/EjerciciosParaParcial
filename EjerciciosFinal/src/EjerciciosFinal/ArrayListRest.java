package EjerciciosFinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class ArrayListRest<E> extends ArrayList<E> {
    private Predicate<E> condition;

    public ArrayListRest(Predicate<E> condition) {
        super();
        this.condition = condition;
    }

    public ArrayListRest(Collection<? extends E> c, Predicate<E> condition) {
        super(c);
        this.condition = condition;
    }

    @Override
    public boolean add(E e) {
        if (condition.test(e)) {
            return super.add(e);
        } else {
            return false;
        }
    }

    @Override
    public void add(int index, E element) {
        if (condition.test(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (condition.test(e)) {
                modified |= super.add(e);
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (condition.test(e)) {
                super.add(index++, e);
                modified = true;
            }
        }
        return modified;
    }

    public static void main(String[] args) {
        // Ejemplo de uso con una condición simple (números mayores que cero)
        Predicate<Integer> condition = num -> num > 0;
        ArrayListRest<Integer> numbers = new ArrayListRest<>(condition);

        numbers.add(5);   // Añadir número válido
        numbers.add(-2);  // No se añadirá, no cumple con la condición
        System.out.println(numbers);

        ArrayList<Integer> moreNumbers = new ArrayList<>();
        moreNumbers.add(10);
        moreNumbers.add(-3);
        moreNumbers.add(7);
        numbers.addAll(moreNumbers);  // Solo el 10 y el 7 se añadirán
        System.out.println(numbers);
    }
}