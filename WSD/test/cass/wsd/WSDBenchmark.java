package cass.wsd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

import cass.languageTool.Language;
import cass.languageTool.LanguageTool;
import cass.testGenerator.TestData;
import cass.testGenerator.TestSentenceGenerator;

public class WSDBenchmark {
	
	public double benchmark(Algorithm algorithm) {
		int n = 0;
		double meanScore = 0;
		
		Iterator<TestData> tsg = new TestSentenceGenerator("semcor3.0");
		
		while(tsg.hasNext()) {
			n++;
			TestData ts = tsg.next();
			WSD wsd = new WSD(ts.getLeftContext(), ts.getTarget(), ts.getRightContext(), Language.EN);				
			LanguageTool lt = new LanguageTool(Language.EN);
			
			if (!lt.getSenses(ts.getTarget()).isEmpty()) {				
				List<ScoredSense> results = wsd.scoreSensesUsing(algorithm, 0);
				
				int numCorrectAnswers = ts.getSenses().size();
				//TODO(Chris): decide what to do with JAVA 8 Test code
//				double bestScore = IntStream.rangeClosed(1, numCorrectAnswers).mapToDouble(x -> ((double) 1)/x).sum();
//				// best score is based on harmonic series
//						
				double score = 0;
//				double score = IntStream.range(0, results.size())
//					.mapToObj(i -> new Pair<Integer, String>(i, results.get(i).getSense().getId()))
//					.filter(pair -> ts.getSenses().contains(pair.s))
//					.mapToDouble(pair -> ((double) 1)/(pair.t + 1))
//					.sum() / bestScore;
				
				List<String> resultIDs = new ArrayList<String>();
				for (ScoredSense result : results) {
					resultIDs.add(result.getSense().getId());
				}
				
				meanScore = (meanScore * n + score) / (n+1);
				
//				System.out.println();
//				System.out.println(ts.getLeftContext());
//				System.out.println(ts.getTarget());
//				System.out.println(ts.getRightContext());
//				System.out.println(resultIDs);
//				System.out.println(ts.getSenses());
//				System.out.println(score);
//				System.out.println();
				
				System.out.println(meanScore);
				
				n++;
			}
		}
		
		return meanScore;
	}
	
	class Pair<T,S> {
		public T t;
		public S s;
		
		public Pair(T t, S s) {
			this.t = t;
			this.s = s;
		}
		
		@Override
		public String toString() {
			return t.toString() + ", " + s.toString();
		}
	}
}
