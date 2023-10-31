package documentProcessing.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
 
import java.util.Map;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
 
import documentProcessing.DocumentServlet;
 
public class DocumentServletTest {
	@ParameterizedTest
	@ValueSource(strings = {
			"The Men in Blue surpassed New Zealand to take over the second spot in terms of most matches won in the history of ODI World Cups. Only five-time champions Australia have won more matches than India in ODI World Cups ",
			"Following Australia and India, New Zealand has won 58 matches in the ODI World Cup, England has won 50, Pakistan has won 47, while South Africa and West Indies have come out on top 43 times each.",
			"All the best to indian cricket team" })
 
	public void testCalculateWordCount(String paragraph) {
		DocumentServlet servlet = new DocumentServlet();
		Map<String, Integer> wordCountMap = servlet.calculateWordCount(paragraph);
		switch (paragraph) {
		case "The Men in Blue surpassed New Zealand to take over the second spot in terms of most matches won in the history of ODI World Cups. Only five-time champions Australia have won more matches than India in ODI World Cups ":
			assertEquals(24, wordCountMap.size());
			break;
 
		case "Following Australia and India, New Zealand has won 58 matches in the ODI World Cup, England has won 50, Pakistan has won 47, while South Africa and West Indies have come out on top 43 times each.":
			assertEquals(25, wordCountMap.size());
			break;
		case "All the best to indian cricket team":
			assertEquals(5, wordCountMap.size());
			break;
			default:
				assertNotEquals(0, wordCountMap.size());
				break;
		}
 
	   
	}
 
	@Test
	public void testCalculateWordCount() {
		DocumentServlet servlet = new DocumentServlet();
		String paragraph = "This is a test. This is only a test.";
		Map<String, Integer> wordCountMap = servlet.calculateWordCount(paragraph);
 
		assertEquals(1, wordCountMap.size());
		assertEquals(2, (int) wordCountMap.get("test"));
 
	}
}
