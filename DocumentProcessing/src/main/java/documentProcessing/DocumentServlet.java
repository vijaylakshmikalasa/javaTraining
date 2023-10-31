package documentProcessing;
 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/DocumentServlet")
public class DocumentServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paragraph = request.getParameter("paragraph");
		String path = "C:\\Users\\Vijaylakshmi Kalasa\\TextProcessingDocument";
		long timestamp = System.currentTimeMillis();
		String filename = path + "processed_paragraph_" + timestamp + ".txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write(paragraph);
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		Map<String, Integer> wordCountMap = calculateWordCount(paragraph);
 
		int count = wordCountMap.size();
		request.setAttribute("totalWordCount", count);
		request.setAttribute("paragraph", paragraph);
		request.setAttribute("wordCountMap", wordCountMap);
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}
 
	public Map<String, Integer> calculateWordCount(String paragraph) {
		HashSet<String> commonWords = new HashSet<>();
 
		commonWords.add("is");
		commonWords.add("i");
		commonWords.add("as");
		commonWords.add("if");
		commonWords.add("and");
		commonWords.add("the");
		commonWords.add("on");
		commonWords.add("into");
		commonWords.add("does");
		commonWords.add("to");
		commonWords.add("for");
		commonWords.add("of");
		commonWords.add(",");
		commonWords.add("in");
		commonWords.add("an");
		commonWords.add("this");
		commonWords.add("hi");
		commonWords.add("here");
		commonWords.add("with");
		commonWords.add("am");
		commonWords.add("a");
		commonWords.add("it");
		commonWords.add("but");
		commonWords.add("not");
		commonWords.add("only");
		commonWords.add("also");
		commonWords.add("then");
		commonWords.add("how");
		commonWords.add("are");
		commonWords.add("you");
		commonWords.add("why");
		// Add your common words here
 
		String[] words = paragraph.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].replaceAll("[^a-zA-Z]", "");
		}
 
		Map<String, Integer> wordCountMap = new HashMap<>();
		for (String word : words) {
			word = word.toLowerCase();
			if (!commonWords.contains(word)) {
				wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
			}
		}
 
		return wordCountMap;
	}
}