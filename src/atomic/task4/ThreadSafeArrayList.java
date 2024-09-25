package atomic.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ThreadSafeArrayList<E> {
    private final List<E> arrayList = Collections.synchronizedList(new ArrayList<>());

    public void addElement(E element) {
        synchronized (arrayList) {
            arrayList.add(element);
            System.out.println("Added: " + element);
        }
    }

    public void readElements() {
        synchronized (arrayList) {
            System.out.println(arrayList);
        }
    }

    public void update(int index, E newElement) {
        synchronized (arrayList) {
            Objects.checkIndex(index, arrayList.size());
            E oldElement = arrayList.get(index);
            arrayList.set(index, newElement);
            System.out.println("Changed from: " + oldElement + " -> " + newElement);
        }
    }

    public void deleteElement(int index) {
        synchronized (arrayList) {
            Objects.checkIndex(index, arrayList.size());
            E remove = arrayList.remove(index);
            System.out.println("Removed element: " + remove);
        }
    }

    public static void main(String[] args) {
        ThreadSafeArrayList<String> arrayList = new ThreadSafeArrayList<>();

        Thread thread1 = new Thread(() -> {
            arrayList.addElement("Germany");
            arrayList.addElement("Italy");
            arrayList.readElements();
        });

        Thread thread2 = new Thread(() -> {
            arrayList.addElement("France");
            arrayList.update(1, "Luxembourg");
            arrayList.readElements();
        });

        Thread thread3 = new Thread(() -> {
            arrayList.deleteElement(0);
            arrayList.readElements();
        });

        Thread thread4 = new Thread(() -> {
            arrayList.addElement("Spain");
            arrayList.addElement("Norway");
            arrayList.addElement("Poland");
            arrayList.addElement("Russia");
            arrayList.deleteElement(0);
            arrayList.deleteElement(0);
            arrayList.deleteElement(0);
            arrayList.readElements();
        });


        try {
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();

            thread4.start();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
