package JavaCollectionsFramework;

import org.jetbrains.annotations.NotNull;

import java.util.TreeSet;

public class Book implements Comparable{
    String title;

    Book(String t) {
        title = t;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Book b = (Book) o;
        return title.compareTo(b.title);
    }


}

class TestTree {

    public static void main(String[] args) {
        new TestTree().fo();
    }

    private  void fo() {
        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново своё тело");
        Book b3 = new Book("В поисках Эмо");

        TreeSet<Book> treeSet = new TreeSet<Book>();
        treeSet.add(b1);
        treeSet.add(b2);
        treeSet.add(b3);
        System.out.println(treeSet);
    }
}
