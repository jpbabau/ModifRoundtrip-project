package xtext.ui;

import modif.AttributeModification;
import modif.ChangeBounds;
import modif.ClassModification;
import modif.ReferenceModification;

import org.eclipse.xtext.impl.TerminalRuleImpl;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;


public class XModifHighlightingSemanticCalculator implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(final XtextResource resource, IHighlightedPositionAcceptor acceptor) { 
		if (resource == null || resource.getParseResult() == null ) { return; }

		INode root = resource.getParseResult().getRootNode();

		BidiTreeIterator<INode> it = root.getAsTreeIterable().iterator();
		while( it.hasNext() ){
			INode node = it.next();

			// ClassModification
			if(node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof ClassModification) {
				boolean removeClass = ((ClassModification)node.getSemanticElement()).isRemove();
				String classOldName = ((ClassModification)node.getSemanticElement()).getOldName();
				String classNewName = ((ClassModification)node.getSemanticElement()).getNewName();
				String text = node.getText();
				if(!removeClass) {				
					if(classOldName.equals(classNewName)) {
						if(text.contains("{")) {
						acceptor.addPosition(node.getOffset()+classOldName.length(), text.indexOf('{')-classOldName.length()-3, XModifHighlightingConfiguration.COMMENT_ID);
						}else {
							acceptor.addPosition(node.getOffset()+classOldName.length(), 2 + 2 + classNewName.length(), XModifHighlightingConfiguration.COMMENT_ID);
						}
					}
					BidiTreeIterator<INode> it2 = node.getAsTreeIterable().iterator();
					while(it2.hasNext() ){
						INode node2 = it2.next();

						// ReferenceModification
						if(node2 instanceof CompositeNodeWithSemanticElement && node2.getSemanticElement() instanceof ReferenceModification) {
							boolean remove = ((ReferenceModification)node2.getSemanticElement()).isRemove();
							if(!remove){
								String refOldName = ((ReferenceModification)node2.getSemanticElement()).getOldName();
								String refNewName = ((ReferenceModification)node2.getSemanticElement()).getNewName();
								ChangeBounds changeBounds = ((ReferenceModification)node2.getSemanticElement()).getChangeBounds();
								int oldLowerBound = changeBounds.getOldLower();
								int newLowerBound = changeBounds.getNewLower();
								int oldUpperBound = changeBounds.getOldUpper();
								int newUpperBound = changeBounds.getNewUpper();

								if(refOldName.equals(refNewName)){
									acceptor.addPosition(node2.getOffset()+ 3 + refOldName.length() + 2, 
											3 + refNewName.length(), XModifHighlightingConfiguration.COMMENT_ID);
									if(oldLowerBound == newLowerBound) {
										if(oldUpperBound == newUpperBound) {
											// 3 -> ref + 2 -> 2 empty spaces
											acceptor.addPosition(node2.getOffset() + 3 + 1 + refOldName.length() + 1 + 2 + 1 + refNewName.length() + 1 + 6 + 1 + 5 + 1, 
																2 + 1 + 5, XModifHighlightingConfiguration.COMMENT_ID);
										}
									}
								}
							}

							// AttributeModification
						}else if(node2 instanceof CompositeNodeWithSemanticElement && node2.getSemanticElement() instanceof AttributeModification) {
							boolean removeAttribute = ((AttributeModification)node2.getSemanticElement()).isRemove();
							String attOldName = ((AttributeModification)node2.getSemanticElement()).getOldName();
							String attNewName = ((AttributeModification)node2.getSemanticElement()).getNewName();
							ChangeBounds changeBounds = ((AttributeModification)node2.getSemanticElement()).getChangeBounds();
							int oldLowerBound = changeBounds.getOldLower();
							int newLowerBound = changeBounds.getNewLower();
							int oldUpperBound = changeBounds.getOldUpper();
							int newUpperBound = changeBounds.getNewUpper();

							if(!removeAttribute){
								if(!attOldName.equals("UUID")) {
									if(attOldName.equals(attNewName)){
										if(oldLowerBound == newLowerBound) {
											if(oldUpperBound == newUpperBound) {
												acceptor.addPosition(node2.getOffset(), node2.getLength(), XModifHighlightingConfiguration.COMMENT_ID);
											}
										}
									}
								}
							}
						}
					}
				}else {
					// remove class
					acceptor.addPosition(node.getOffset()+classOldName.length()+7, text.length()-7, XModifHighlightingConfiguration.COMMENT_ID);
				}

			}/*else if(node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof ReferenceModification){
				boolean remove = ((ReferenceModification)node.getSemanticElement()).isRemove();
				if(remove) {
					//acceptor.addPosition(node.getOffset(), node.getLength(), XModifHighlightingConfiguration.COMMENT_ID);
				}else if(!remove){
					String refOldName = ((ReferenceModification)node.getSemanticElement()).getOldName();
					String refNewName = ((ReferenceModification)node.getSemanticElement()).getNewName();
					String nodeText = node.getText();
					if(refOldName.equals(refNewName)) {
						acceptor.addPosition(node.getOffset(), node.getLength(), XModifHighlightingConfiguration.COMMENT_ID);
					}
				}
			}else if(node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof AttributeModification) {
				boolean remove = ((AttributeModification)node.getSemanticElement()).isRemove();
				if(!remove) {
					String attOldName = ((AttributeModification)node.getSemanticElement()).getOldName();
					String attNewName = ((AttributeModification)node.getSemanticElement()).getNewName();
					String nodeText = node.getText();
					if(attOldName.equals(attNewName)) {
						acceptor.addPosition(node.getOffset(), node.getLength(), XModifHighlightingConfiguration.COMMENT_ID);
					}
				}
			}*/
		}

		/*for (INode node : root.getAsTreeIterable()){
			EObject grammarElement = node.getGrammarElement();
			if(grammarElement instanceof RuleCall) {
				RuleCall rc = (RuleCall)grammarElement;
				AbstractRule r = rc.getRule();
				EObject c = grammarElement.eContainer();
				if(r.getName().equals("ReferenceModification")) {
					System.out.println(" -- "+ r.toString());
					System.out.println(" -- "+ r.getName()+ "   "+r.eClass().getName());

					for(EStructuralFeature f : r.eClass().getEAllStructuralFeatures()) {
						System.out.println("   \\ "+ f.getName());
					}

					//System.out.println(r.eClass().eGet(r.eClass().getEStructuralFeature("remove")));
					//if(r.getName().equals("ID") && c instanceof Assignment && ((Assignment)c).getFeature().equals("name")){

					INode p = node.getParent();
					if(p != null && p.getGrammarElement() instanceof RuleCall){
						rc = (RuleCall)p.getGrammarElement();
						AbstractRule rr = rc.getRule();
						if(rr.getName().equals("Method")){
							acceptor.addPosition(node.getOffset(), node.getLength(), XModifHighlightingConfiguration.KEYWORD_ID);
						}else {
							System.out.println("comment");
							acceptor.addPosition(node.getOffset(), node.getLength(), XModifHighlightingConfiguration.COMMENT_ID);
						}
					}else {
						System.out.println(" NOT  RuleCall");
					}
				}else if (r.getName().equals("AttributeModification")) {
					System.out.println(" ++ "+ r.getName());
				}
			}
		}*/

		/*	INode root = resource.getParseResult().getRootNode();
		  for (INode node : root.getAsTreeIterable()) {
		    if (node.getGrammarElement() instanceof CrossReference) {
		      acceptor.addPosition(node.getOffset(), node.getLength(), 
		    		  XModifHighlightingConfiguration.COMMENT_ID);
		    }else {
		    	acceptor.addPosition(node.getOffset(), node.getLength(), 
			    		  XModifHighlightingConfiguration.KEYWORD_ID);
		    }
		  }*/



		/*Iterator<INode> allNodes = resource.getParseResult().getRootNode().getAsTreeIterable().iterator(); 
		/while(allNodes.hasNext()) { 
			INode node = allNodes.next(); 

			System.out.println("node : "+node +"   "+node.getGrammarElement()+ "  " +node.getGrammarElement().eClass());

			if (node.getGrammarElement() instanceof Keyword) { 
				System.out.println("KEYWORD_ID");
				highlightNode(node, XModifHighlightingConfiguration.KEYWORD_ID, acceptor); 
			}else if(node.getGrammarElement() instanceof ReferenceModification){
				System.out.println("REFERENCE");
				System.out.println("Offset : "+node.getOffset());
				System.out.println("size : "+node.getLength());
				acceptor.addPosition(node.getOffset(), node.getLength(), XModifHighlightingConfiguration.KEYWORD_ID);
			}
			else if(node.getGrammarElement() instanceof ClassModification){
				System.out.println("Class");
				System.out.println("Offset : "+node.getOffset());
				System.out.println("size : "+node.getLength());
				acceptor.addPosition(node.getOffset(), node.getLength(), XModifHighlightingConfiguration.KEYWORD_ID);
			}
		} */

		/*Iterator<EObject> iter = EcoreUtil.getAllContents(resource, true);
		while(iter.hasNext()) {
			EObject current = iter.next();
			System.out.println("current :" + current +"    "+current.eClass());
			if(current instanceof StructuralFeatureModification) {
				System.out.println("is a StructuralFeature");
				StructuralFeatureModification refNode = (StructuralFeatureModification)current;
				acceptor.addPosition(refNode.getOffset(), refNode.getLength(), XModifHighlightingConfiguration.KEYWORD_ID);
			}
		}*/

	} 

	void setStyles( IHighlightedPositionAcceptor acceptor, BidiIterator<INode> it, String...styles )
	{
		for( String s : styles )
		{
			if( ! it.hasNext() ) return;
			INode n = skipWhiteSpace( acceptor, it );
			if( n != null && s != null ) acceptor.addPosition( n.getOffset(), n.getLength(), s );
		}
	}

	INode skipWhiteSpace( IHighlightedPositionAcceptor acceptor, BidiIterator<INode> it )
	{
		INode n = null;
		while ( it.hasNext() && ( n = it.next() ).getClass() == HiddenLeafNode.class )
			processHiddenNode( acceptor, (HiddenLeafNode)n );
		return n;
	}

	void processHiddenNode( IHighlightedPositionAcceptor acceptor, HiddenLeafNode node )
	{
		if( node.getGrammarElement() instanceof TerminalRuleImpl )
		{
			TerminalRuleImpl ge = (TerminalRuleImpl) node.getGrammarElement();
			if( ge.getName().equalsIgnoreCase( "GUESS_COMMENT" ) ) {
				acceptor.addPosition( node.getOffset(), node.getLength(), XModifHighlightingConfiguration.COMMENT_ID);
			}
		}
	}


	/*private void highlightNode(INode node, String id, IHighlightedPositionAcceptor acceptor) { 
		if (node == null) 
			return; 
		if (node instanceof ILeafNode) { 
			acceptor.addPosition(node.getOffset(), node.getLength(), id); 
		} else { 
			for(ILeafNode leaf: node.getLeafNodes()) { 
				if (!leaf.isHidden()) { 
					acceptor.addPosition(leaf.getOffset(), leaf.getLength(), id); 
				} 
			} 
		} 
	}*/
}
