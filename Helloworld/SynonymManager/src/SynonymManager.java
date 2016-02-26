import java.util.ArrayList;

/** Author(s)/Contributor(s): Fausto Tommasi
 *  Date: 2/21/2016
 *  Purpose: Create the interface which the first version of the synonmym generator will use
 */

public interface SynonymManager {
	public ArrayList<ArrayList<String>> getSynonym(String target);

}