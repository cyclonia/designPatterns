package single.responsibilty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Journal {

	private final List<String> entries = new ArrayList<>();
	private static int count = 0;

	public void addEntry(String text) {

		entries.add("" + (++count) + ": " + text);
	}

	public void removeEntry(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}

}

class Persistence {
	public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
		if (overwrite || !new File(filename).exists()) {
			try (PrintStream out = new PrintStream(filename)) {
				out.println(journal.toString());
			}
		}
	}

	public void load(String filename) {

	}

	public void load(URL url) {

	}
}

class Demo {
	public static void main(String[] args) throws Exception {
		Journal j = new Journal();
		j.addEntry("I studies today");
		j.addEntry("I ate a bug");

		System.out.println(j);
		
		Persistence p = new Persistence();
		String filename = "/Users/sunil/Documents/mywork/designPatterns/journal.txt";
		p.saveToFile(j, filename, false);
	}
}
