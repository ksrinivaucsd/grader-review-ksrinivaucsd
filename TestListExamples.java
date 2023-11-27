import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeRightEndRightEmpty() {
    List<String> left = Arrays.asList("a");
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a");
    assertEquals(expected, merged);
  }

    @Test(timeout = 500)
  public void testMergeLefttEndRightEmpty() {
    List<String> left = Arrays.asList("a");
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(right, left);
    List<String> expected = Arrays.asList("a");
    assertEquals(expected, merged);
  }

    @Test(timeout = 500)
  public void testMergeBothEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }

    @Test(timeout = 500)
  public void testFilterBasic() {
    List<String> left = Arrays.asList("moon", "sun", "earth");
    List<String> filtered = ListExamples.filter(left, new IsMoon());
    List<String> expected = Arrays.asList("moon");
    assertEquals(expected, filtered);
  }

    @Test(timeout = 500)
  public void testFilterNoneFiltered() {
    List<String> left = Arrays.asList( "sun", "earth");
    List<String> filtered = ListExamples.filter(left, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

    @Test(timeout = 500)
  public void testFilterEmptyList() {
    List<String> left = Arrays.asList();
    List<String> filtered = ListExamples.filter(left, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }
}

