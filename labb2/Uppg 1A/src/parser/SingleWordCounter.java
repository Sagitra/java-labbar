package parser;
public class SingleWordCounter implements TextProcessor {
	private final String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}


	//Ska inte vara == på en sring. En string kräver .equals istället förutsatt
	// Att vi vill kolla så att objekten innehåller samma sak och 
	// inte är exakt samma objekt
	public void process(String w) {
		if (w.equals(this.word)) {
			n++;
		}

	}

	public String report() {
		return word + ": " + n;
	}

}
