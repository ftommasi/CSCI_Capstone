/** Author(s)/Contributor(s): Fausto Tommasi
 *  Date: 2/21/2016
 *  Purpose: First implementation of SynonymManager that will use a Thesaurus
 */



import java.util.ArrayList;
import java.util.Arrays;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;


public class SynonymGetter implements SynonymManager{
	//private Synset[] mySyns;
	
	
	public SynonymGetter(){
		
	}
	
	@Override
	public ArrayList<ArrayList<String>> getSynonym(String target) {
		// TODO(Fausto): Implement and test against an open knowledge source 
		WordNetDatabase database = WordNetDatabase.getFileInstance();		
		Synset[] mySyns = database.getSynsets(target);
		//TODO(Fausto): get rid of overlapping words
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for(int i=0 ; i<mySyns.length;i++){
			String temp[] = mySyns[i].getWordForms();
			ArrayList<String> atemp = new ArrayList<String>(Arrays.asList(temp));
			result.add(i, atemp); 
		}
		return result;
	}

}