package xtext.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class XModifHighlightingConfiguration implements IHighlightingConfiguration{

	/** 
	 * the ID of keywords highlighting configuration 
	 */ 
	public static final String DEFAULT_ID = "default"; 
	public static final String PACKAGE_ID = "package"; 
	public static final String CLASS_ID = "class"; 
	public static final String REFERENCE_ID = "ReferenceModification"; 
	public static final String ATTRIBUTE_ID = "AttributeModification"; 
	public static final String KEYWORD_ID = "keyword"; 
	public static final String COMMENT_ID = "comment"; 

	public static final String[] ALL_STRINGS = { PACKAGE_ID , CLASS_ID , REFERENCE_ID , ATTRIBUTE_ID };


	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		//acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default",defaultTextStyle()); 
		/*addType(acceptor, PACKAGE_ID, 255, 0, 0, 1);
		addType(acceptor, CLASS_ID, 0, 255, 0, 2);
		addType(acceptor, REFERENCE_ID, 0, 0, 255, 3);
		addType(acceptor, ATTRIBUTE_ID, 255, 255, 0, 4);
		addType(acceptor, KEYWORD_ID, 0, 255, 255, 5);
		addType(acceptor, COMMENT_ID, 255, 0, 0, 6);*/

		//acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keywordTextStyle()); 
		//acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle()); 
		//acceptor.acceptDefaultHighlighting(REFERENCE_ID, "reference", referenceTextStyle()); 

	}

	public void addType(IHighlightingConfigurationAcceptor acceptor, String s, int r, int g, int b, int style )
	{
		TextStyle textStyle = new TextStyle();
		textStyle.setBackgroundColor(new RGB(255, 0, 255));
		textStyle.setColor(new RGB(r, g, b));
		textStyle.setStyle(style);
		acceptor.acceptDefaultHighlighting(s, s, textStyle);
	}

	/** 
	 * Create the TextStyle for keywords 
	 * @return the style for keywords 
	 */ 
	public TextStyle keywordTextStyle() { 
		TextStyle textStyle = new TextStyle(); 
		textStyle.setColor(new RGB(255, 0, 0)); 
		textStyle.setBackgroundColor(new RGB(0, 255, 0));
		textStyle.setStyle(SWT.ITALIC); 
		return textStyle; 
	} 

	public TextStyle classTextStyle() { 
		System.out.println("class style");
		TextStyle textStyle = new TextStyle(); 
		//textStyle.setBackgroundColor(new RGB(0, 0, 255)); 
		textStyle.setColor(new RGB(255, 0, 0)); 
		return textStyle; 
	} 

	protected TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}

}
