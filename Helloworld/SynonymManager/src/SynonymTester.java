import edu.smu.tspell.wordnet.Synset;

/** Author(s)/Contributor(s): Fausto Tommasi
 *  Date: 2/21/2016
 *  Purpose: Test validity of SynonymManager classes
 */
public class SynonymTester {
	public static void main(String[] args){
		String key = "wordnet.database.dir";
		String value = "/home/design/Documents/WordNet-3.0/dict/"; 
		System.setProperty(key, value);//initialize the Synset database
		//TODO(TEAM): write tests for synonym Manager classes
		SynonymGetter s= new SynonymGetter();
		Synset[] mine = s.getSynonym("food");
		for(int i=0; i<mine.length; i++){
			System.out.println(mine[i].toString());
			
		}
	}

}