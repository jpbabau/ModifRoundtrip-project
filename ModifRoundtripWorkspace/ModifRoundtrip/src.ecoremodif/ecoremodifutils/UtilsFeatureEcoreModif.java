/**
 *  a set of utility methods (find ) 
 *  to manipulate StructuralModif elements
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

package ecoremodifutils;

import java.util.List;

import ecoremodif.*;

public class UtilsFeatureEcoreModif {
	
	// find an EattributeModif by its old name in a list of EattributeModif 
	// returns it if found, null otherwise
	public EattributeModif findAttribute(EattributeModif eam, List<EattributeModif> listAttributeModif) {
	
		int positionStructuralFeature=0;	
		
		int i=0;
		while (i < listAttributeModif.size() && positionStructuralFeature == 0) {
			if (listAttributeModif.get(i).getModif().getOldName().equals(eam.getModif().getOldName())) {
				positionStructuralFeature =i+1;
			}
			i++;
		}
		if (positionStructuralFeature==0) {
			return null;	}
		else {
			return listAttributeModif.get(positionStructuralFeature-1);		}	
	}
	
	// find a EreferenceModif by its old name in a list of EreferenceModif 
	// returns it if found, null otherwise
	public EreferenceModif findReference(EreferenceModif erm, List<EreferenceModif> listReferenceModif) {
	
		int positionStructuralFeature=0;	
		
		int i=0;
		while (i < listReferenceModif.size() && positionStructuralFeature == 0) {
			if (listReferenceModif.get(i).getModif().getOldName().equals(erm.getModif().getOldName())) {
				positionStructuralFeature =i+1;
			}
			i++;
		}
		if (positionStructuralFeature==0) {
			return null;	}
		else {
			return listReferenceModif.get(positionStructuralFeature-1);		}	
	}
	
}
