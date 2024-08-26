package ru.lainer.springcore.ioc_container.annotation_based.qualifier;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Magnet {

  @Autowired
  private Store<String> s1; // qualifier = String , здесь внедрится: bean = stringStore

  @Autowired
  private Store<Integer> s2; // qualifier = Integer, здесь внедрится: bean = integerStore

  @Autowired
  private List<Store<Double>> s3Double; //qualifier = Double, здесь внедрится все bean-ы doubleStore

  @Autowired
  //qualifier = Double, здесь внедрится все bean-ы doubleStore
  private Map<String,Store<Double>> mapDouble;

  @Autowired
  private Store<Double>[] arrayDouble; //qualifier = Double, здесь внедрится все bean-ы doubleStore

  public void print() {
    System.out.println("Magnet -> print()");
    s1.info("Hello");
    s2.info(13);
  }

  public void printDouble() {
    System.out.println("Magnet -> printDouble()");
    for (Store<Double> store : s3Double) {
      store.info(19.3);
    }
  }

  public void printMapDouble() {
    System.out.println("Magnet -> printMapDouble()");
    for (Map.Entry<String, Store<Double>> entry : mapDouble.entrySet()) {
      System.out.print("Key = " + entry.getKey() + " ");
      entry.getValue().info(3.3);
      System.out.println("-----");
    }
  }

  public void printArrayDouble() {
    System.out.println("Magnet -> printArrayDouble()");
    for (Store<Double> store : arrayDouble) {
      store.info(13.3);
      System.out.println("+++++");
    }
  }
}
