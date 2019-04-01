package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;
  final  Predicate<Integer> integerPredicate = integer -> integer < 10 && integer < 5;
  // no deterministico!! puede no retornar los mismo. Solo para performance en paralelo.
  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int any = Arrays.stream(numbers)
            .filter(integerPredicate)
            .findAny()
            .get();
    System.out.println(any);
  }

  // deterministico -> siempre da lo mismo
  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int any = Arrays.stream(numbers).
            filter(integer -> integer < 10)
            .findFirst()
            .get();
    System.out.println(any);
  }
}

