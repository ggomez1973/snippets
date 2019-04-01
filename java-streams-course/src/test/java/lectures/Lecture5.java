package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {
  final Predicate<Car> carPredicate = car -> car.getPrice() < 10000;
  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    cars.stream().filter(carPredicate).collect(Collectors.toList()).forEach(System.out::println);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> dtos = people.stream().map(person -> {
      PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
      return dto;
    }).collect(Collectors.toList());

    // .map(PersonDTO::map)
    dtos.forEach(System.out::println);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    double average = cars.stream().mapToDouble(value -> {
      return value.getPrice();
    }).average().orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {

  }
}



