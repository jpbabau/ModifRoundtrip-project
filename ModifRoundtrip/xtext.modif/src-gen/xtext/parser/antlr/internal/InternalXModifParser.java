package xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import xtext.services.XModifGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXModifParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'removeAllAnnotations'", "'removeAllOperations'", "'removeAllEStringAttributes'", "'removeAllOpposites'", "'addAllOpposite'", "'addRootClass'", "'addNameClass'", "'root'", "'remove'", "'hide'", "'to'", "'Prefix'", "'URI'", "'removeEAnnotations'", "'package'", "'{'", "';'", "'}'", "'class'", "'dataType'", "'enumModification'", "'annotation'", "'('", "')'", "'detailsEntry'", "'flatten'", "'flattenAll'", "'changeAbstract'", "'oldInstanceType'", "'newInstanceType'", "'reify'", "'oldLiteral'", "'oldValue'", "'addAttribute'", "','", "'addReference'", "'bounds'", "'att'", "'changeType'", "'ref'", "'changeContainement'", "'removeOpposite'", "'addOpposite'", "'int'", "'string'", "'boolean'", "'char'", "'float'", "'addDerivedRef'", "':'", "'addDerivedAtt'", "'enumerate'", "'-'"
    };
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=4;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalXModifParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXModifParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXModifParser.tokenNames; }
    public String getGrammarFileName() { return "../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g"; }



     	private XModifGrammarAccess grammarAccess;
     	
        public InternalXModifParser(TokenStream input, XModifGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Modifications";	
       	}
       	
       	@Override
       	protected XModifGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModifications"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:67:1: entryRuleModifications returns [EObject current=null] : iv_ruleModifications= ruleModifications EOF ;
    public final EObject entryRuleModifications() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifications = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:68:2: (iv_ruleModifications= ruleModifications EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:69:2: iv_ruleModifications= ruleModifications EOF
            {
             newCompositeNode(grammarAccess.getModificationsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifications_in_entryRuleModifications75);
            iv_ruleModifications=ruleModifications();

            state._fsp--;

             current =iv_ruleModifications; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifications85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifications"


    // $ANTLR start "ruleModifications"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:76:1: ruleModifications returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* ) ) ) otherlv_10= 'root' ( (lv_rootPackageModification_11_0= rulePackageModification ) ) ) ;
    public final EObject ruleModifications() throws RecognitionException {
        EObject current = null;

        Token lv_removeAllAnnotations_1_0=null;
        Token lv_removeAllOperations_2_0=null;
        Token lv_removeAllEStringAttributes_3_0=null;
        Token lv_removeAllOpposites_4_0=null;
        Token lv_addAllOpposite_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_addRootClass_7_0 = null;

        EObject lv_addNameClass_9_0 = null;

        EObject lv_rootPackageModification_11_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:79:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* ) ) ) otherlv_10= 'root' ( (lv_rootPackageModification_11_0= rulePackageModification ) ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:80:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* ) ) ) otherlv_10= 'root' ( (lv_rootPackageModification_11_0= rulePackageModification ) ) )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:80:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* ) ) ) otherlv_10= 'root' ( (lv_rootPackageModification_11_0= rulePackageModification ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:80:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* ) ) ) otherlv_10= 'root' ( (lv_rootPackageModification_11_0= rulePackageModification ) )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:80:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:82:1: ( ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* ) )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:82:1: ( ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:83:2: ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:86:2: ( ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )* )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:87:3: ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )*
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:87:3: ( ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) ) )*
            loop1:
            do {
                int alt1=8;
                int LA1_0 = input.LA(1);

                if ( LA1_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 2) ) {
                    alt1=3;
                }
                else if ( LA1_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 3) ) {
                    alt1=4;
                }
                else if ( LA1_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 4) ) {
                    alt1=5;
                }
                else if ( LA1_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 5) ) {
                    alt1=6;
                }
                else if ( LA1_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 6) ) {
                    alt1=7;
                }


                switch (alt1) {
            	case 1 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:89:4: ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:89:4: ({...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:90:5: {...}? => ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:90:110: ( ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:91:6: ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:94:6: ({...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:94:7: {...}? => ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:94:16: ( (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:95:1: (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:95:1: (lv_removeAllAnnotations_1_0= 'removeAllAnnotations' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:96:3: lv_removeAllAnnotations_1_0= 'removeAllAnnotations'
            	    {
            	    lv_removeAllAnnotations_1_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModifications173); 

            	            newLeafNode(lv_removeAllAnnotations_1_0, grammarAccess.getModificationsAccess().getRemoveAllAnnotationsRemoveAllAnnotationsKeyword_0_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getModificationsRule());
            	    	        }
            	           		setWithLastConsumed(current, "removeAllAnnotations", true, "removeAllAnnotations");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:116:4: ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:116:4: ({...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:117:5: {...}? => ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:117:110: ( ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:118:6: ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:121:6: ({...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:121:7: {...}? => ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:121:16: ( (lv_removeAllOperations_2_0= 'removeAllOperations' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:122:1: (lv_removeAllOperations_2_0= 'removeAllOperations' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:122:1: (lv_removeAllOperations_2_0= 'removeAllOperations' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:123:3: lv_removeAllOperations_2_0= 'removeAllOperations'
            	    {
            	    lv_removeAllOperations_2_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModifications258); 

            	            newLeafNode(lv_removeAllOperations_2_0, grammarAccess.getModificationsAccess().getRemoveAllOperationsRemoveAllOperationsKeyword_0_1_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getModificationsRule());
            	    	        }
            	           		setWithLastConsumed(current, "removeAllOperations", true, "removeAllOperations");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:143:4: ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:143:4: ({...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:144:5: {...}? => ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:144:110: ( ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:145:6: ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:148:6: ({...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:148:7: {...}? => ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:148:16: ( (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:149:1: (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:149:1: (lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:150:3: lv_removeAllEStringAttributes_3_0= 'removeAllEStringAttributes'
            	    {
            	    lv_removeAllEStringAttributes_3_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModifications343); 

            	            newLeafNode(lv_removeAllEStringAttributes_3_0, grammarAccess.getModificationsAccess().getRemoveAllEStringAttributesRemoveAllEStringAttributesKeyword_0_2_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getModificationsRule());
            	    	        }
            	           		setWithLastConsumed(current, "removeAllEStringAttributes", true, "removeAllEStringAttributes");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:170:4: ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:170:4: ({...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:171:5: {...}? => ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:171:110: ( ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:172:6: ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:175:6: ({...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:175:7: {...}? => ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:175:16: ( (lv_removeAllOpposites_4_0= 'removeAllOpposites' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:176:1: (lv_removeAllOpposites_4_0= 'removeAllOpposites' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:176:1: (lv_removeAllOpposites_4_0= 'removeAllOpposites' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:177:3: lv_removeAllOpposites_4_0= 'removeAllOpposites'
            	    {
            	    lv_removeAllOpposites_4_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModifications428); 

            	            newLeafNode(lv_removeAllOpposites_4_0, grammarAccess.getModificationsAccess().getRemoveAllOppositesRemoveAllOppositesKeyword_0_3_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getModificationsRule());
            	    	        }
            	           		setWithLastConsumed(current, "removeAllOpposites", true, "removeAllOpposites");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:197:4: ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:197:4: ({...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:198:5: {...}? => ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 4)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:198:110: ( ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:199:6: ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 4);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:202:6: ({...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:202:7: {...}? => ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:202:16: ( (lv_addAllOpposite_5_0= 'addAllOpposite' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:203:1: (lv_addAllOpposite_5_0= 'addAllOpposite' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:203:1: (lv_addAllOpposite_5_0= 'addAllOpposite' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:204:3: lv_addAllOpposite_5_0= 'addAllOpposite'
            	    {
            	    lv_addAllOpposite_5_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModifications513); 

            	            newLeafNode(lv_addAllOpposite_5_0, grammarAccess.getModificationsAccess().getAddAllOppositeAddAllOppositeKeyword_0_4_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getModificationsRule());
            	    	        }
            	           		setWithLastConsumed(current, "addAllOpposite", true, "addAllOpposite");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:224:4: ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:224:4: ({...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:225:5: {...}? => ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 5)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:225:110: ( ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:226:6: ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 5);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:229:6: ({...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:229:7: {...}? => (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:229:16: (otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:229:18: otherlv_6= 'addRootClass' ( (lv_addRootClass_7_0= ruleAddRootClass ) )
            	    {
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModifications593); 

            	        	newLeafNode(otherlv_6, grammarAccess.getModificationsAccess().getAddRootClassKeyword_0_5_0());
            	        
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:233:1: ( (lv_addRootClass_7_0= ruleAddRootClass ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:234:1: (lv_addRootClass_7_0= ruleAddRootClass )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:234:1: (lv_addRootClass_7_0= ruleAddRootClass )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:235:3: lv_addRootClass_7_0= ruleAddRootClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModificationsAccess().getAddRootClassAddRootClassParserRuleCall_0_5_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAddRootClass_in_ruleModifications614);
            	    lv_addRootClass_7_0=ruleAddRootClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModificationsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"addRootClass",
            	            		lv_addRootClass_7_0, 
            	            		"AddRootClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:258:4: ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:258:4: ({...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:259:5: {...}? => ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "getUnorderedGroupHelper().canSelect(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 6)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:259:110: ( ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:260:6: ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModificationsAccess().getUnorderedGroup_0(), 6);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:263:6: ({...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:263:7: {...}? => (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModifications", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:263:16: (otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:263:18: otherlv_8= 'addNameClass' ( (lv_addNameClass_9_0= ruleAddNameClass ) )
            	    {
            	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModifications682); 

            	        	newLeafNode(otherlv_8, grammarAccess.getModificationsAccess().getAddNameClassKeyword_0_6_0());
            	        
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:267:1: ( (lv_addNameClass_9_0= ruleAddNameClass ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:268:1: (lv_addNameClass_9_0= ruleAddNameClass )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:268:1: (lv_addNameClass_9_0= ruleAddNameClass )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:269:3: lv_addNameClass_9_0= ruleAddNameClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModificationsAccess().getAddNameClassAddNameClassParserRuleCall_0_6_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAddNameClass_in_ruleModifications703);
            	    lv_addNameClass_9_0=ruleAddNameClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModificationsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"addNameClass",
            	            		lv_addNameClass_9_0, 
            	            		"AddNameClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getModificationsAccess().getUnorderedGroup_0());
            	

            }

            otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModifications756); 

                	newLeafNode(otherlv_10, grammarAccess.getModificationsAccess().getRootKeyword_1());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:303:1: ( (lv_rootPackageModification_11_0= rulePackageModification ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:304:1: (lv_rootPackageModification_11_0= rulePackageModification )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:304:1: (lv_rootPackageModification_11_0= rulePackageModification )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:305:3: lv_rootPackageModification_11_0= rulePackageModification
            {
             
            	        newCompositeNode(grammarAccess.getModificationsAccess().getRootPackageModificationPackageModificationParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePackageModification_in_ruleModifications777);
            lv_rootPackageModification_11_0=rulePackageModification();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModificationsRule());
            	        }
                   		set(
                   			current, 
                   			"rootPackageModification",
                    		lv_rootPackageModification_11_0, 
                    		"PackageModification");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifications"


    // $ANTLR start "entryRuleAddDerived"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:329:1: entryRuleAddDerived returns [EObject current=null] : iv_ruleAddDerived= ruleAddDerived EOF ;
    public final EObject entryRuleAddDerived() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddDerived = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:330:2: (iv_ruleAddDerived= ruleAddDerived EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:331:2: iv_ruleAddDerived= ruleAddDerived EOF
            {
             newCompositeNode(grammarAccess.getAddDerivedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddDerived_in_entryRuleAddDerived813);
            iv_ruleAddDerived=ruleAddDerived();

            state._fsp--;

             current =iv_ruleAddDerived; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddDerived823); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddDerived"


    // $ANTLR start "ruleAddDerived"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:338:1: ruleAddDerived returns [EObject current=null] : (this_AddDerivedReference_0= ruleAddDerivedReference | this_AddDerivedAttribute_1= ruleAddDerivedAttribute ) ;
    public final EObject ruleAddDerived() throws RecognitionException {
        EObject current = null;

        EObject this_AddDerivedReference_0 = null;

        EObject this_AddDerivedAttribute_1 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:341:28: ( (this_AddDerivedReference_0= ruleAddDerivedReference | this_AddDerivedAttribute_1= ruleAddDerivedAttribute ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:342:1: (this_AddDerivedReference_0= ruleAddDerivedReference | this_AddDerivedAttribute_1= ruleAddDerivedAttribute )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:342:1: (this_AddDerivedReference_0= ruleAddDerivedReference | this_AddDerivedAttribute_1= ruleAddDerivedAttribute )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==59) ) {
                alt2=1;
            }
            else if ( (LA2_0==61) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:343:5: this_AddDerivedReference_0= ruleAddDerivedReference
                    {
                     
                            newCompositeNode(grammarAccess.getAddDerivedAccess().getAddDerivedReferenceParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddDerivedReference_in_ruleAddDerived870);
                    this_AddDerivedReference_0=ruleAddDerivedReference();

                    state._fsp--;

                     
                            current = this_AddDerivedReference_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:353:5: this_AddDerivedAttribute_1= ruleAddDerivedAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAddDerivedAccess().getAddDerivedAttributeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddDerivedAttribute_in_ruleAddDerived897);
                    this_AddDerivedAttribute_1=ruleAddDerivedAttribute();

                    state._fsp--;

                     
                            current = this_AddDerivedAttribute_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddDerived"


    // $ANTLR start "entryRulePackageModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:369:1: entryRulePackageModification returns [EObject current=null] : iv_rulePackageModification= rulePackageModification EOF ;
    public final EObject entryRulePackageModification() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:370:2: (iv_rulePackageModification= rulePackageModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:371:2: iv_rulePackageModification= rulePackageModification EOF
            {
             newCompositeNode(grammarAccess.getPackageModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePackageModification_in_entryRulePackageModification932);
            iv_rulePackageModification=rulePackageModification();

            state._fsp--;

             current =iv_rulePackageModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageModification942); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageModification"


    // $ANTLR start "rulePackageModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:378:1: rulePackageModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_hide_1_0= 'hide' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'Prefix' ( (lv_oldPrefixName_6_0= ruleEString ) )? otherlv_7= 'to' ( (lv_newPrefixName_8_0= ruleEString ) ) )? (otherlv_9= 'URI' ( (lv_oldURIName_10_0= ruleEString ) )? otherlv_11= 'to' ( (lv_newURIName_12_0= ruleEString ) ) )? ( (lv_removeEAnnotations_13_0= 'removeEAnnotations' ) )? (otherlv_14= 'package' otherlv_15= '{' ( (lv_packageModification_16_0= rulePackageModification ) ) (otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) ) )* otherlv_19= '}' )? (otherlv_20= 'class' otherlv_21= '{' ( (lv_classModification_22_0= ruleClassModification ) ) (otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) ) )* otherlv_25= '}' )? (otherlv_26= 'dataType' otherlv_27= '{' ( (lv_dataTypeModification_28_0= ruleDataTypeModification ) ) (otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) ) )* otherlv_31= '}' )? (otherlv_32= 'enumModification' otherlv_33= '{' ( (lv_enumModification_34_0= ruleEnumModification ) ) (otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) ) )* otherlv_37= '}' )? (otherlv_38= 'annotation' otherlv_39= '{' ( (lv_annotationModification_40_0= ruleAnnotationModification ) ) (otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) ) )* otherlv_43= '}' )? ) ;
    public final EObject rulePackageModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token lv_hide_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_removeEAnnotations_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        AntlrDatatypeRuleToken lv_oldName_2_0 = null;

        AntlrDatatypeRuleToken lv_newName_4_0 = null;

        AntlrDatatypeRuleToken lv_oldPrefixName_6_0 = null;

        AntlrDatatypeRuleToken lv_newPrefixName_8_0 = null;

        AntlrDatatypeRuleToken lv_oldURIName_10_0 = null;

        AntlrDatatypeRuleToken lv_newURIName_12_0 = null;

        EObject lv_packageModification_16_0 = null;

        EObject lv_packageModification_18_0 = null;

        EObject lv_classModification_22_0 = null;

        EObject lv_classModification_24_0 = null;

        EObject lv_dataTypeModification_28_0 = null;

        EObject lv_dataTypeModification_30_0 = null;

        EObject lv_enumModification_34_0 = null;

        EObject lv_enumModification_36_0 = null;

        EObject lv_annotationModification_40_0 = null;

        EObject lv_annotationModification_42_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:381:28: ( ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_hide_1_0= 'hide' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'Prefix' ( (lv_oldPrefixName_6_0= ruleEString ) )? otherlv_7= 'to' ( (lv_newPrefixName_8_0= ruleEString ) ) )? (otherlv_9= 'URI' ( (lv_oldURIName_10_0= ruleEString ) )? otherlv_11= 'to' ( (lv_newURIName_12_0= ruleEString ) ) )? ( (lv_removeEAnnotations_13_0= 'removeEAnnotations' ) )? (otherlv_14= 'package' otherlv_15= '{' ( (lv_packageModification_16_0= rulePackageModification ) ) (otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) ) )* otherlv_19= '}' )? (otherlv_20= 'class' otherlv_21= '{' ( (lv_classModification_22_0= ruleClassModification ) ) (otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) ) )* otherlv_25= '}' )? (otherlv_26= 'dataType' otherlv_27= '{' ( (lv_dataTypeModification_28_0= ruleDataTypeModification ) ) (otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) ) )* otherlv_31= '}' )? (otherlv_32= 'enumModification' otherlv_33= '{' ( (lv_enumModification_34_0= ruleEnumModification ) ) (otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) ) )* otherlv_37= '}' )? (otherlv_38= 'annotation' otherlv_39= '{' ( (lv_annotationModification_40_0= ruleAnnotationModification ) ) (otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) ) )* otherlv_43= '}' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:382:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_hide_1_0= 'hide' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'Prefix' ( (lv_oldPrefixName_6_0= ruleEString ) )? otherlv_7= 'to' ( (lv_newPrefixName_8_0= ruleEString ) ) )? (otherlv_9= 'URI' ( (lv_oldURIName_10_0= ruleEString ) )? otherlv_11= 'to' ( (lv_newURIName_12_0= ruleEString ) ) )? ( (lv_removeEAnnotations_13_0= 'removeEAnnotations' ) )? (otherlv_14= 'package' otherlv_15= '{' ( (lv_packageModification_16_0= rulePackageModification ) ) (otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) ) )* otherlv_19= '}' )? (otherlv_20= 'class' otherlv_21= '{' ( (lv_classModification_22_0= ruleClassModification ) ) (otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) ) )* otherlv_25= '}' )? (otherlv_26= 'dataType' otherlv_27= '{' ( (lv_dataTypeModification_28_0= ruleDataTypeModification ) ) (otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) ) )* otherlv_31= '}' )? (otherlv_32= 'enumModification' otherlv_33= '{' ( (lv_enumModification_34_0= ruleEnumModification ) ) (otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) ) )* otherlv_37= '}' )? (otherlv_38= 'annotation' otherlv_39= '{' ( (lv_annotationModification_40_0= ruleAnnotationModification ) ) (otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) ) )* otherlv_43= '}' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:382:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_hide_1_0= 'hide' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'Prefix' ( (lv_oldPrefixName_6_0= ruleEString ) )? otherlv_7= 'to' ( (lv_newPrefixName_8_0= ruleEString ) ) )? (otherlv_9= 'URI' ( (lv_oldURIName_10_0= ruleEString ) )? otherlv_11= 'to' ( (lv_newURIName_12_0= ruleEString ) ) )? ( (lv_removeEAnnotations_13_0= 'removeEAnnotations' ) )? (otherlv_14= 'package' otherlv_15= '{' ( (lv_packageModification_16_0= rulePackageModification ) ) (otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) ) )* otherlv_19= '}' )? (otherlv_20= 'class' otherlv_21= '{' ( (lv_classModification_22_0= ruleClassModification ) ) (otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) ) )* otherlv_25= '}' )? (otherlv_26= 'dataType' otherlv_27= '{' ( (lv_dataTypeModification_28_0= ruleDataTypeModification ) ) (otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) ) )* otherlv_31= '}' )? (otherlv_32= 'enumModification' otherlv_33= '{' ( (lv_enumModification_34_0= ruleEnumModification ) ) (otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) ) )* otherlv_37= '}' )? (otherlv_38= 'annotation' otherlv_39= '{' ( (lv_annotationModification_40_0= ruleAnnotationModification ) ) (otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) ) )* otherlv_43= '}' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:382:2: ( (lv_remove_0_0= 'remove' ) )? ( (lv_hide_1_0= 'hide' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'Prefix' ( (lv_oldPrefixName_6_0= ruleEString ) )? otherlv_7= 'to' ( (lv_newPrefixName_8_0= ruleEString ) ) )? (otherlv_9= 'URI' ( (lv_oldURIName_10_0= ruleEString ) )? otherlv_11= 'to' ( (lv_newURIName_12_0= ruleEString ) ) )? ( (lv_removeEAnnotations_13_0= 'removeEAnnotations' ) )? (otherlv_14= 'package' otherlv_15= '{' ( (lv_packageModification_16_0= rulePackageModification ) ) (otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) ) )* otherlv_19= '}' )? (otherlv_20= 'class' otherlv_21= '{' ( (lv_classModification_22_0= ruleClassModification ) ) (otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) ) )* otherlv_25= '}' )? (otherlv_26= 'dataType' otherlv_27= '{' ( (lv_dataTypeModification_28_0= ruleDataTypeModification ) ) (otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) ) )* otherlv_31= '}' )? (otherlv_32= 'enumModification' otherlv_33= '{' ( (lv_enumModification_34_0= ruleEnumModification ) ) (otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) ) )* otherlv_37= '}' )? (otherlv_38= 'annotation' otherlv_39= '{' ( (lv_annotationModification_40_0= ruleAnnotationModification ) ) (otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) ) )* otherlv_43= '}' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:382:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:383:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:383:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:384:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePackageModification985); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getPackageModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPackageModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:397:3: ( (lv_hide_1_0= 'hide' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:398:1: (lv_hide_1_0= 'hide' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:398:1: (lv_hide_1_0= 'hide' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:399:3: lv_hide_1_0= 'hide'
                    {
                    lv_hide_1_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePackageModification1017); 

                            newLeafNode(lv_hide_1_0, grammarAccess.getPackageModificationAccess().getHideHideKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPackageModificationRule());
                    	        }
                           		setWithLastConsumed(current, "hide", true, "hide");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:412:3: ( (lv_oldName_2_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:413:1: (lv_oldName_2_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:413:1: (lv_oldName_2_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:414:3: lv_oldName_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getPackageModificationAccess().getOldNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePackageModification1052);
            lv_oldName_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldName",
                    		lv_oldName_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:430:2: (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:430:4: otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePackageModification1065); 

                        	newLeafNode(otherlv_3, grammarAccess.getPackageModificationAccess().getToKeyword_3_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:434:1: ( (lv_newName_4_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:435:1: (lv_newName_4_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:435:1: (lv_newName_4_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:436:3: lv_newName_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getNewNameEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePackageModification1086);
                    lv_newName_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newName",
                            		lv_newName_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:452:4: (otherlv_5= 'Prefix' ( (lv_oldPrefixName_6_0= ruleEString ) )? otherlv_7= 'to' ( (lv_newPrefixName_8_0= ruleEString ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:452:6: otherlv_5= 'Prefix' ( (lv_oldPrefixName_6_0= ruleEString ) )? otherlv_7= 'to' ( (lv_newPrefixName_8_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePackageModification1101); 

                        	newLeafNode(otherlv_5, grammarAccess.getPackageModificationAccess().getPrefixKeyword_4_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:456:1: ( (lv_oldPrefixName_6_0= ruleEString ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:457:1: (lv_oldPrefixName_6_0= ruleEString )
                            {
                            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:457:1: (lv_oldPrefixName_6_0= ruleEString )
                            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:458:3: lv_oldPrefixName_6_0= ruleEString
                            {
                             
                            	        newCompositeNode(grammarAccess.getPackageModificationAccess().getOldPrefixNameEStringParserRuleCall_4_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePackageModification1122);
                            lv_oldPrefixName_6_0=ruleEString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"oldPrefixName",
                                    		lv_oldPrefixName_6_0, 
                                    		"EString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePackageModification1135); 

                        	newLeafNode(otherlv_7, grammarAccess.getPackageModificationAccess().getToKeyword_4_2());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:478:1: ( (lv_newPrefixName_8_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:479:1: (lv_newPrefixName_8_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:479:1: (lv_newPrefixName_8_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:480:3: lv_newPrefixName_8_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getNewPrefixNameEStringParserRuleCall_4_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePackageModification1156);
                    lv_newPrefixName_8_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newPrefixName",
                            		lv_newPrefixName_8_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:496:4: (otherlv_9= 'URI' ( (lv_oldURIName_10_0= ruleEString ) )? otherlv_11= 'to' ( (lv_newURIName_12_0= ruleEString ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:496:6: otherlv_9= 'URI' ( (lv_oldURIName_10_0= ruleEString ) )? otherlv_11= 'to' ( (lv_newURIName_12_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,23,FollowSets000.FOLLOW_23_in_rulePackageModification1171); 

                        	newLeafNode(otherlv_9, grammarAccess.getPackageModificationAccess().getURIKeyword_5_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:500:1: ( (lv_oldURIName_10_0= ruleEString ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:501:1: (lv_oldURIName_10_0= ruleEString )
                            {
                            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:501:1: (lv_oldURIName_10_0= ruleEString )
                            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:502:3: lv_oldURIName_10_0= ruleEString
                            {
                             
                            	        newCompositeNode(grammarAccess.getPackageModificationAccess().getOldURINameEStringParserRuleCall_5_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePackageModification1192);
                            lv_oldURIName_10_0=ruleEString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"oldURIName",
                                    		lv_oldURIName_10_0, 
                                    		"EString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePackageModification1205); 

                        	newLeafNode(otherlv_11, grammarAccess.getPackageModificationAccess().getToKeyword_5_2());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:522:1: ( (lv_newURIName_12_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:523:1: (lv_newURIName_12_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:523:1: (lv_newURIName_12_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:524:3: lv_newURIName_12_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getNewURINameEStringParserRuleCall_5_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePackageModification1226);
                    lv_newURIName_12_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newURIName",
                            		lv_newURIName_12_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:540:4: ( (lv_removeEAnnotations_13_0= 'removeEAnnotations' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:541:1: (lv_removeEAnnotations_13_0= 'removeEAnnotations' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:541:1: (lv_removeEAnnotations_13_0= 'removeEAnnotations' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:542:3: lv_removeEAnnotations_13_0= 'removeEAnnotations'
                    {
                    lv_removeEAnnotations_13_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_rulePackageModification1246); 

                            newLeafNode(lv_removeEAnnotations_13_0, grammarAccess.getPackageModificationAccess().getRemoveEAnnotationsRemoveEAnnotationsKeyword_6_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPackageModificationRule());
                    	        }
                           		setWithLastConsumed(current, "removeEAnnotations", true, "removeEAnnotations");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:555:3: (otherlv_14= 'package' otherlv_15= '{' ( (lv_packageModification_16_0= rulePackageModification ) ) (otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) ) )* otherlv_19= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:555:5: otherlv_14= 'package' otherlv_15= '{' ( (lv_packageModification_16_0= rulePackageModification ) ) (otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) ) )* otherlv_19= '}'
                    {
                    otherlv_14=(Token)match(input,25,FollowSets000.FOLLOW_25_in_rulePackageModification1273); 

                        	newLeafNode(otherlv_14, grammarAccess.getPackageModificationAccess().getPackageKeyword_7_0());
                        
                    otherlv_15=(Token)match(input,26,FollowSets000.FOLLOW_26_in_rulePackageModification1285); 

                        	newLeafNode(otherlv_15, grammarAccess.getPackageModificationAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:563:1: ( (lv_packageModification_16_0= rulePackageModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:564:1: (lv_packageModification_16_0= rulePackageModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:564:1: (lv_packageModification_16_0= rulePackageModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:565:3: lv_packageModification_16_0= rulePackageModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getPackageModificationPackageModificationParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePackageModification_in_rulePackageModification1306);
                    lv_packageModification_16_0=rulePackageModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"packageModification",
                            		lv_packageModification_16_0, 
                            		"PackageModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:581:2: (otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==27) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:581:4: otherlv_17= ';' ( (lv_packageModification_18_0= rulePackageModification ) )
                    	    {
                    	    otherlv_17=(Token)match(input,27,FollowSets000.FOLLOW_27_in_rulePackageModification1319); 

                    	        	newLeafNode(otherlv_17, grammarAccess.getPackageModificationAccess().getSemicolonKeyword_7_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:585:1: ( (lv_packageModification_18_0= rulePackageModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:586:1: (lv_packageModification_18_0= rulePackageModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:586:1: (lv_packageModification_18_0= rulePackageModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:587:3: lv_packageModification_18_0= rulePackageModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getPackageModificationPackageModificationParserRuleCall_7_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_rulePackageModification_in_rulePackageModification1340);
                    	    lv_packageModification_18_0=rulePackageModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"packageModification",
                    	            		lv_packageModification_18_0, 
                    	            		"PackageModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,28,FollowSets000.FOLLOW_28_in_rulePackageModification1354); 

                        	newLeafNode(otherlv_19, grammarAccess.getPackageModificationAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:607:3: (otherlv_20= 'class' otherlv_21= '{' ( (lv_classModification_22_0= ruleClassModification ) ) (otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) ) )* otherlv_25= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:607:5: otherlv_20= 'class' otherlv_21= '{' ( (lv_classModification_22_0= ruleClassModification ) ) (otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) ) )* otherlv_25= '}'
                    {
                    otherlv_20=(Token)match(input,29,FollowSets000.FOLLOW_29_in_rulePackageModification1369); 

                        	newLeafNode(otherlv_20, grammarAccess.getPackageModificationAccess().getClassKeyword_8_0());
                        
                    otherlv_21=(Token)match(input,26,FollowSets000.FOLLOW_26_in_rulePackageModification1381); 

                        	newLeafNode(otherlv_21, grammarAccess.getPackageModificationAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:615:1: ( (lv_classModification_22_0= ruleClassModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:616:1: (lv_classModification_22_0= ruleClassModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:616:1: (lv_classModification_22_0= ruleClassModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:617:3: lv_classModification_22_0= ruleClassModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getClassModificationClassModificationParserRuleCall_8_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleClassModification_in_rulePackageModification1402);
                    lv_classModification_22_0=ruleClassModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"classModification",
                            		lv_classModification_22_0, 
                            		"ClassModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:633:2: (otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==27) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:633:4: otherlv_23= ';' ( (lv_classModification_24_0= ruleClassModification ) )
                    	    {
                    	    otherlv_23=(Token)match(input,27,FollowSets000.FOLLOW_27_in_rulePackageModification1415); 

                    	        	newLeafNode(otherlv_23, grammarAccess.getPackageModificationAccess().getSemicolonKeyword_8_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:637:1: ( (lv_classModification_24_0= ruleClassModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:638:1: (lv_classModification_24_0= ruleClassModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:638:1: (lv_classModification_24_0= ruleClassModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:639:3: lv_classModification_24_0= ruleClassModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getClassModificationClassModificationParserRuleCall_8_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleClassModification_in_rulePackageModification1436);
                    	    lv_classModification_24_0=ruleClassModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"classModification",
                    	            		lv_classModification_24_0, 
                    	            		"ClassModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_25=(Token)match(input,28,FollowSets000.FOLLOW_28_in_rulePackageModification1450); 

                        	newLeafNode(otherlv_25, grammarAccess.getPackageModificationAccess().getRightCurlyBracketKeyword_8_4());
                        

                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:659:3: (otherlv_26= 'dataType' otherlv_27= '{' ( (lv_dataTypeModification_28_0= ruleDataTypeModification ) ) (otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) ) )* otherlv_31= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==30) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:659:5: otherlv_26= 'dataType' otherlv_27= '{' ( (lv_dataTypeModification_28_0= ruleDataTypeModification ) ) (otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) ) )* otherlv_31= '}'
                    {
                    otherlv_26=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePackageModification1465); 

                        	newLeafNode(otherlv_26, grammarAccess.getPackageModificationAccess().getDataTypeKeyword_9_0());
                        
                    otherlv_27=(Token)match(input,26,FollowSets000.FOLLOW_26_in_rulePackageModification1477); 

                        	newLeafNode(otherlv_27, grammarAccess.getPackageModificationAccess().getLeftCurlyBracketKeyword_9_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:667:1: ( (lv_dataTypeModification_28_0= ruleDataTypeModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:668:1: (lv_dataTypeModification_28_0= ruleDataTypeModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:668:1: (lv_dataTypeModification_28_0= ruleDataTypeModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:669:3: lv_dataTypeModification_28_0= ruleDataTypeModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getDataTypeModificationDataTypeModificationParserRuleCall_9_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDataTypeModification_in_rulePackageModification1498);
                    lv_dataTypeModification_28_0=ruleDataTypeModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"dataTypeModification",
                            		lv_dataTypeModification_28_0, 
                            		"DataTypeModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:685:2: (otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==27) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:685:4: otherlv_29= ';' ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) )
                    	    {
                    	    otherlv_29=(Token)match(input,27,FollowSets000.FOLLOW_27_in_rulePackageModification1511); 

                    	        	newLeafNode(otherlv_29, grammarAccess.getPackageModificationAccess().getSemicolonKeyword_9_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:689:1: ( (lv_dataTypeModification_30_0= ruleDataTypeModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:690:1: (lv_dataTypeModification_30_0= ruleDataTypeModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:690:1: (lv_dataTypeModification_30_0= ruleDataTypeModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:691:3: lv_dataTypeModification_30_0= ruleDataTypeModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getDataTypeModificationDataTypeModificationParserRuleCall_9_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleDataTypeModification_in_rulePackageModification1532);
                    	    lv_dataTypeModification_30_0=ruleDataTypeModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dataTypeModification",
                    	            		lv_dataTypeModification_30_0, 
                    	            		"DataTypeModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_31=(Token)match(input,28,FollowSets000.FOLLOW_28_in_rulePackageModification1546); 

                        	newLeafNode(otherlv_31, grammarAccess.getPackageModificationAccess().getRightCurlyBracketKeyword_9_4());
                        

                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:711:3: (otherlv_32= 'enumModification' otherlv_33= '{' ( (lv_enumModification_34_0= ruleEnumModification ) ) (otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) ) )* otherlv_37= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==31) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:711:5: otherlv_32= 'enumModification' otherlv_33= '{' ( (lv_enumModification_34_0= ruleEnumModification ) ) (otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) ) )* otherlv_37= '}'
                    {
                    otherlv_32=(Token)match(input,31,FollowSets000.FOLLOW_31_in_rulePackageModification1561); 

                        	newLeafNode(otherlv_32, grammarAccess.getPackageModificationAccess().getEnumModificationKeyword_10_0());
                        
                    otherlv_33=(Token)match(input,26,FollowSets000.FOLLOW_26_in_rulePackageModification1573); 

                        	newLeafNode(otherlv_33, grammarAccess.getPackageModificationAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:719:1: ( (lv_enumModification_34_0= ruleEnumModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:720:1: (lv_enumModification_34_0= ruleEnumModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:720:1: (lv_enumModification_34_0= ruleEnumModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:721:3: lv_enumModification_34_0= ruleEnumModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getEnumModificationEnumModificationParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEnumModification_in_rulePackageModification1594);
                    lv_enumModification_34_0=ruleEnumModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"enumModification",
                            		lv_enumModification_34_0, 
                            		"EnumModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:737:2: (otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==27) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:737:4: otherlv_35= ';' ( (lv_enumModification_36_0= ruleEnumModification ) )
                    	    {
                    	    otherlv_35=(Token)match(input,27,FollowSets000.FOLLOW_27_in_rulePackageModification1607); 

                    	        	newLeafNode(otherlv_35, grammarAccess.getPackageModificationAccess().getSemicolonKeyword_10_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:741:1: ( (lv_enumModification_36_0= ruleEnumModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:742:1: (lv_enumModification_36_0= ruleEnumModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:742:1: (lv_enumModification_36_0= ruleEnumModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:743:3: lv_enumModification_36_0= ruleEnumModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getEnumModificationEnumModificationParserRuleCall_10_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumModification_in_rulePackageModification1628);
                    	    lv_enumModification_36_0=ruleEnumModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"enumModification",
                    	            		lv_enumModification_36_0, 
                    	            		"EnumModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_37=(Token)match(input,28,FollowSets000.FOLLOW_28_in_rulePackageModification1642); 

                        	newLeafNode(otherlv_37, grammarAccess.getPackageModificationAccess().getRightCurlyBracketKeyword_10_4());
                        

                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:763:3: (otherlv_38= 'annotation' otherlv_39= '{' ( (lv_annotationModification_40_0= ruleAnnotationModification ) ) (otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) ) )* otherlv_43= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:763:5: otherlv_38= 'annotation' otherlv_39= '{' ( (lv_annotationModification_40_0= ruleAnnotationModification ) ) (otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) ) )* otherlv_43= '}'
                    {
                    otherlv_38=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePackageModification1657); 

                        	newLeafNode(otherlv_38, grammarAccess.getPackageModificationAccess().getAnnotationKeyword_11_0());
                        
                    otherlv_39=(Token)match(input,26,FollowSets000.FOLLOW_26_in_rulePackageModification1669); 

                        	newLeafNode(otherlv_39, grammarAccess.getPackageModificationAccess().getLeftCurlyBracketKeyword_11_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:771:1: ( (lv_annotationModification_40_0= ruleAnnotationModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:772:1: (lv_annotationModification_40_0= ruleAnnotationModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:772:1: (lv_annotationModification_40_0= ruleAnnotationModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:773:3: lv_annotationModification_40_0= ruleAnnotationModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_11_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_rulePackageModification1690);
                    lv_annotationModification_40_0=ruleAnnotationModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"annotationModification",
                            		lv_annotationModification_40_0, 
                            		"AnnotationModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:789:2: (otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==27) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:789:4: otherlv_41= ';' ( (lv_annotationModification_42_0= ruleAnnotationModification ) )
                    	    {
                    	    otherlv_41=(Token)match(input,27,FollowSets000.FOLLOW_27_in_rulePackageModification1703); 

                    	        	newLeafNode(otherlv_41, grammarAccess.getPackageModificationAccess().getSemicolonKeyword_11_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:793:1: ( (lv_annotationModification_42_0= ruleAnnotationModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:794:1: (lv_annotationModification_42_0= ruleAnnotationModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:794:1: (lv_annotationModification_42_0= ruleAnnotationModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:795:3: lv_annotationModification_42_0= ruleAnnotationModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPackageModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_11_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_rulePackageModification1724);
                    	    lv_annotationModification_42_0=ruleAnnotationModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPackageModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotationModification",
                    	            		lv_annotationModification_42_0, 
                    	            		"AnnotationModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_43=(Token)match(input,28,FollowSets000.FOLLOW_28_in_rulePackageModification1738); 

                        	newLeafNode(otherlv_43, grammarAccess.getPackageModificationAccess().getRightCurlyBracketKeyword_11_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageModification"


    // $ANTLR start "entryRuleAddRootClass"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:823:1: entryRuleAddRootClass returns [EObject current=null] : iv_ruleAddRootClass= ruleAddRootClass EOF ;
    public final EObject entryRuleAddRootClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddRootClass = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:824:2: (iv_ruleAddRootClass= ruleAddRootClass EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:825:2: iv_ruleAddRootClass= ruleAddRootClass EOF
            {
             newCompositeNode(grammarAccess.getAddRootClassRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddRootClass_in_entryRuleAddRootClass1776);
            iv_ruleAddRootClass=ruleAddRootClass();

            state._fsp--;

             current =iv_ruleAddRootClass; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddRootClass1786); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddRootClass"


    // $ANTLR start "ruleAddRootClass"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:832:1: ruleAddRootClass returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleAddRootClass() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:835:28: ( ( () ( (lv_name_1_0= ruleEString ) ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:836:1: ( () ( (lv_name_1_0= ruleEString ) ) )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:836:1: ( () ( (lv_name_1_0= ruleEString ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:836:2: () ( (lv_name_1_0= ruleEString ) )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:836:2: ()
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:837:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAddRootClassAccess().getAddRootClassAction_0(),
                        current);
                

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:842:2: ( (lv_name_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:843:1: (lv_name_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:843:1: (lv_name_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:844:3: lv_name_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddRootClassAccess().getNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddRootClass1841);
            lv_name_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddRootClassRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddRootClass"


    // $ANTLR start "entryRuleAddNameClass"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:868:1: entryRuleAddNameClass returns [EObject current=null] : iv_ruleAddNameClass= ruleAddNameClass EOF ;
    public final EObject entryRuleAddNameClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddNameClass = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:869:2: (iv_ruleAddNameClass= ruleAddNameClass EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:870:2: iv_ruleAddNameClass= ruleAddNameClass EOF
            {
             newCompositeNode(grammarAccess.getAddNameClassRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddNameClass_in_entryRuleAddNameClass1877);
            iv_ruleAddNameClass=ruleAddNameClass();

            state._fsp--;

             current =iv_ruleAddNameClass; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddNameClass1887); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddNameClass"


    // $ANTLR start "ruleAddNameClass"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:877:1: ruleAddNameClass returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( (lv_nameName_2_0= ruleEString ) ) otherlv_3= ')' ) ;
    public final EObject ruleAddNameClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_nameName_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:880:28: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( (lv_nameName_2_0= ruleEString ) ) otherlv_3= ')' ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:881:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( (lv_nameName_2_0= ruleEString ) ) otherlv_3= ')' )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:881:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( (lv_nameName_2_0= ruleEString ) ) otherlv_3= ')' )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:881:2: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( (lv_nameName_2_0= ruleEString ) ) otherlv_3= ')'
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:881:2: ( (lv_name_0_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:882:1: (lv_name_0_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:882:1: (lv_name_0_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:883:3: lv_name_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddNameClassAccess().getNameEStringParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddNameClass1933);
            lv_name_0_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddNameClassRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAddNameClass1945); 

                	newLeafNode(otherlv_1, grammarAccess.getAddNameClassAccess().getLeftParenthesisKeyword_1());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:903:1: ( (lv_nameName_2_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:904:1: (lv_nameName_2_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:904:1: (lv_nameName_2_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:905:3: lv_nameName_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddNameClassAccess().getNameNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddNameClass1966);
            lv_nameName_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddNameClassRule());
            	        }
                   		set(
                   			current, 
                   			"nameName",
                    		lv_nameName_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAddNameClass1978); 

                	newLeafNode(otherlv_3, grammarAccess.getAddNameClassAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddNameClass"


    // $ANTLR start "entryRuleAnnotationModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:933:1: entryRuleAnnotationModification returns [EObject current=null] : iv_ruleAnnotationModification= ruleAnnotationModification EOF ;
    public final EObject entryRuleAnnotationModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:934:2: (iv_ruleAnnotationModification= ruleAnnotationModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:935:2: iv_ruleAnnotationModification= ruleAnnotationModification EOF
            {
             newCompositeNode(grammarAccess.getAnnotationModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_entryRuleAnnotationModification2014);
            iv_ruleAnnotationModification=ruleAnnotationModification();

            state._fsp--;

             current =iv_ruleAnnotationModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnnotationModification2024); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationModification"


    // $ANTLR start "ruleAnnotationModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:942:1: ruleAnnotationModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldSource_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newSource_3_0= ruleEString ) ) )? ( (lv_removeEAnnotations_4_0= 'removeEAnnotations' ) )? (otherlv_5= 'detailsEntry' otherlv_6= '{' ( (lv_detailsEntryModification_7_0= ruleDetailsEntryModification ) ) (otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) ) )* otherlv_10= '}' )? (otherlv_11= 'annotation' otherlv_12= '{' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) (otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) )* otherlv_16= '}' )? ) ;
    public final EObject ruleAnnotationModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token otherlv_2=null;
        Token lv_removeEAnnotations_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_oldSource_1_0 = null;

        AntlrDatatypeRuleToken lv_newSource_3_0 = null;

        EObject lv_detailsEntryModification_7_0 = null;

        EObject lv_detailsEntryModification_9_0 = null;

        EObject lv_annotationModification_13_0 = null;

        EObject lv_annotationModification_15_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:945:28: ( ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldSource_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newSource_3_0= ruleEString ) ) )? ( (lv_removeEAnnotations_4_0= 'removeEAnnotations' ) )? (otherlv_5= 'detailsEntry' otherlv_6= '{' ( (lv_detailsEntryModification_7_0= ruleDetailsEntryModification ) ) (otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) ) )* otherlv_10= '}' )? (otherlv_11= 'annotation' otherlv_12= '{' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) (otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) )* otherlv_16= '}' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:946:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldSource_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newSource_3_0= ruleEString ) ) )? ( (lv_removeEAnnotations_4_0= 'removeEAnnotations' ) )? (otherlv_5= 'detailsEntry' otherlv_6= '{' ( (lv_detailsEntryModification_7_0= ruleDetailsEntryModification ) ) (otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) ) )* otherlv_10= '}' )? (otherlv_11= 'annotation' otherlv_12= '{' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) (otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) )* otherlv_16= '}' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:946:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldSource_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newSource_3_0= ruleEString ) ) )? ( (lv_removeEAnnotations_4_0= 'removeEAnnotations' ) )? (otherlv_5= 'detailsEntry' otherlv_6= '{' ( (lv_detailsEntryModification_7_0= ruleDetailsEntryModification ) ) (otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) ) )* otherlv_10= '}' )? (otherlv_11= 'annotation' otherlv_12= '{' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) (otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) )* otherlv_16= '}' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:946:2: ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldSource_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newSource_3_0= ruleEString ) ) )? ( (lv_removeEAnnotations_4_0= 'removeEAnnotations' ) )? (otherlv_5= 'detailsEntry' otherlv_6= '{' ( (lv_detailsEntryModification_7_0= ruleDetailsEntryModification ) ) (otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) ) )* otherlv_10= '}' )? (otherlv_11= 'annotation' otherlv_12= '{' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) (otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) )* otherlv_16= '}' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:946:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:947:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:947:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:948:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAnnotationModification2067); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getAnnotationModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAnnotationModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:961:3: ( (lv_oldSource_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:962:1: (lv_oldSource_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:962:1: (lv_oldSource_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:963:3: lv_oldSource_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAnnotationModificationAccess().getOldSourceEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAnnotationModification2102);
            lv_oldSource_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAnnotationModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldSource",
                    		lv_oldSource_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:979:2: (otherlv_2= 'to' ( (lv_newSource_3_0= ruleEString ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==21) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:979:4: otherlv_2= 'to' ( (lv_newSource_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAnnotationModification2115); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationModificationAccess().getToKeyword_2_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:983:1: ( (lv_newSource_3_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:984:1: (lv_newSource_3_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:984:1: (lv_newSource_3_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:985:3: lv_newSource_3_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationModificationAccess().getNewSourceEStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAnnotationModification2136);
                    lv_newSource_3_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newSource",
                            		lv_newSource_3_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1001:4: ( (lv_removeEAnnotations_4_0= 'removeEAnnotations' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1002:1: (lv_removeEAnnotations_4_0= 'removeEAnnotations' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1002:1: (lv_removeEAnnotations_4_0= 'removeEAnnotations' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1003:3: lv_removeEAnnotations_4_0= 'removeEAnnotations'
                    {
                    lv_removeEAnnotations_4_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAnnotationModification2156); 

                            newLeafNode(lv_removeEAnnotations_4_0, grammarAccess.getAnnotationModificationAccess().getRemoveEAnnotationsRemoveEAnnotationsKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAnnotationModificationRule());
                    	        }
                           		setWithLastConsumed(current, "removeEAnnotations", true, "removeEAnnotations");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1016:3: (otherlv_5= 'detailsEntry' otherlv_6= '{' ( (lv_detailsEntryModification_7_0= ruleDetailsEntryModification ) ) (otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) ) )* otherlv_10= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1016:5: otherlv_5= 'detailsEntry' otherlv_6= '{' ( (lv_detailsEntryModification_7_0= ruleDetailsEntryModification ) ) (otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) ) )* otherlv_10= '}'
                    {
                    otherlv_5=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAnnotationModification2183); 

                        	newLeafNode(otherlv_5, grammarAccess.getAnnotationModificationAccess().getDetailsEntryKeyword_4_0());
                        
                    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAnnotationModification2195); 

                        	newLeafNode(otherlv_6, grammarAccess.getAnnotationModificationAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1024:1: ( (lv_detailsEntryModification_7_0= ruleDetailsEntryModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1025:1: (lv_detailsEntryModification_7_0= ruleDetailsEntryModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1025:1: (lv_detailsEntryModification_7_0= ruleDetailsEntryModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1026:3: lv_detailsEntryModification_7_0= ruleDetailsEntryModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationModificationAccess().getDetailsEntryModificationDetailsEntryModificationParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDetailsEntryModification_in_ruleAnnotationModification2216);
                    lv_detailsEntryModification_7_0=ruleDetailsEntryModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"detailsEntryModification",
                            		lv_detailsEntryModification_7_0, 
                            		"DetailsEntryModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1042:2: (otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==27) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1042:4: otherlv_8= ';' ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) )
                    	    {
                    	    otherlv_8=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAnnotationModification2229); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getAnnotationModificationAccess().getSemicolonKeyword_4_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1046:1: ( (lv_detailsEntryModification_9_0= ruleDetailsEntryModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1047:1: (lv_detailsEntryModification_9_0= ruleDetailsEntryModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1047:1: (lv_detailsEntryModification_9_0= ruleDetailsEntryModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1048:3: lv_detailsEntryModification_9_0= ruleDetailsEntryModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationModificationAccess().getDetailsEntryModificationDetailsEntryModificationParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleDetailsEntryModification_in_ruleAnnotationModification2250);
                    	    lv_detailsEntryModification_9_0=ruleDetailsEntryModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAnnotationModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"detailsEntryModification",
                    	            		lv_detailsEntryModification_9_0, 
                    	            		"DetailsEntryModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAnnotationModification2264); 

                        	newLeafNode(otherlv_10, grammarAccess.getAnnotationModificationAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1068:3: (otherlv_11= 'annotation' otherlv_12= '{' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) (otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) )* otherlv_16= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1068:5: otherlv_11= 'annotation' otherlv_12= '{' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) (otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) )* otherlv_16= '}'
                    {
                    otherlv_11=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAnnotationModification2279); 

                        	newLeafNode(otherlv_11, grammarAccess.getAnnotationModificationAccess().getAnnotationKeyword_5_0());
                        
                    otherlv_12=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAnnotationModification2291); 

                        	newLeafNode(otherlv_12, grammarAccess.getAnnotationModificationAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1076:1: ( (lv_annotationModification_13_0= ruleAnnotationModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1077:1: (lv_annotationModification_13_0= ruleAnnotationModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1077:1: (lv_annotationModification_13_0= ruleAnnotationModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1078:3: lv_annotationModification_13_0= ruleAnnotationModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleAnnotationModification2312);
                    lv_annotationModification_13_0=ruleAnnotationModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"annotationModification",
                            		lv_annotationModification_13_0, 
                            		"AnnotationModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1094:2: (otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==27) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1094:4: otherlv_14= ';' ( (lv_annotationModification_15_0= ruleAnnotationModification ) )
                    	    {
                    	    otherlv_14=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAnnotationModification2325); 

                    	        	newLeafNode(otherlv_14, grammarAccess.getAnnotationModificationAccess().getSemicolonKeyword_5_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1098:1: ( (lv_annotationModification_15_0= ruleAnnotationModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1099:1: (lv_annotationModification_15_0= ruleAnnotationModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1099:1: (lv_annotationModification_15_0= ruleAnnotationModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1100:3: lv_annotationModification_15_0= ruleAnnotationModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleAnnotationModification2346);
                    	    lv_annotationModification_15_0=ruleAnnotationModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAnnotationModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotationModification",
                    	            		lv_annotationModification_15_0, 
                    	            		"AnnotationModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAnnotationModification2360); 

                        	newLeafNode(otherlv_16, grammarAccess.getAnnotationModificationAccess().getRightCurlyBracketKeyword_5_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationModification"


    // $ANTLR start "entryRuleClassModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1128:1: entryRuleClassModification returns [EObject current=null] : iv_ruleClassModification= ruleClassModification EOF ;
    public final EObject entryRuleClassModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1129:2: (iv_ruleClassModification= ruleClassModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1130:2: iv_ruleClassModification= ruleClassModification EOF
            {
             newCompositeNode(grammarAccess.getClassModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleClassModification_in_entryRuleClassModification2398);
            iv_ruleClassModification=ruleClassModification();

            state._fsp--;

             current =iv_ruleClassModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleClassModification2408); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassModification"


    // $ANTLR start "ruleClassModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1137:1: ruleClassModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* ) ) ) ( (lv_oldName_5_0= ruleEString ) ) (otherlv_6= 'to' ( (lv_newName_7_0= ruleEString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* ) ) ) (otherlv_12= '{' ( (lv_featureModification_13_0= ruleStructuralFeatureModification ) )* ( (lv_addFeatures_14_0= ruleAddFeature ) )* ( (lv_addDeriveds_15_0= ruleAddDerived ) )* otherlv_16= '}' )? (otherlv_17= 'annotation' otherlv_18= '{' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) (otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) ) )* otherlv_22= '}' )? ) ;
    public final EObject ruleClassModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token lv_hide_2_0=null;
        Token lv_flatten_3_0=null;
        Token lv_flattenAll_4_0=null;
        Token otherlv_6=null;
        Token lv_changeAbstract_9_0=null;
        Token lv_removeEAnnotations_10_0=null;
        Token otherlv_12=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_oldName_5_0 = null;

        AntlrDatatypeRuleToken lv_newName_7_0 = null;

        EObject lv_enumerate_11_0 = null;

        EObject lv_featureModification_13_0 = null;

        EObject lv_addFeatures_14_0 = null;

        EObject lv_addDeriveds_15_0 = null;

        EObject lv_annotationModification_19_0 = null;

        EObject lv_annotationModification_21_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1140:28: ( ( ( (lv_remove_0_0= 'remove' ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* ) ) ) ( (lv_oldName_5_0= ruleEString ) ) (otherlv_6= 'to' ( (lv_newName_7_0= ruleEString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* ) ) ) (otherlv_12= '{' ( (lv_featureModification_13_0= ruleStructuralFeatureModification ) )* ( (lv_addFeatures_14_0= ruleAddFeature ) )* ( (lv_addDeriveds_15_0= ruleAddDerived ) )* otherlv_16= '}' )? (otherlv_17= 'annotation' otherlv_18= '{' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) (otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) ) )* otherlv_22= '}' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1141:1: ( ( (lv_remove_0_0= 'remove' ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* ) ) ) ( (lv_oldName_5_0= ruleEString ) ) (otherlv_6= 'to' ( (lv_newName_7_0= ruleEString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* ) ) ) (otherlv_12= '{' ( (lv_featureModification_13_0= ruleStructuralFeatureModification ) )* ( (lv_addFeatures_14_0= ruleAddFeature ) )* ( (lv_addDeriveds_15_0= ruleAddDerived ) )* otherlv_16= '}' )? (otherlv_17= 'annotation' otherlv_18= '{' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) (otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) ) )* otherlv_22= '}' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1141:1: ( ( (lv_remove_0_0= 'remove' ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* ) ) ) ( (lv_oldName_5_0= ruleEString ) ) (otherlv_6= 'to' ( (lv_newName_7_0= ruleEString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* ) ) ) (otherlv_12= '{' ( (lv_featureModification_13_0= ruleStructuralFeatureModification ) )* ( (lv_addFeatures_14_0= ruleAddFeature ) )* ( (lv_addDeriveds_15_0= ruleAddDerived ) )* otherlv_16= '}' )? (otherlv_17= 'annotation' otherlv_18= '{' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) (otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) ) )* otherlv_22= '}' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1141:2: ( (lv_remove_0_0= 'remove' ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* ) ) ) ( (lv_oldName_5_0= ruleEString ) ) (otherlv_6= 'to' ( (lv_newName_7_0= ruleEString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* ) ) ) (otherlv_12= '{' ( (lv_featureModification_13_0= ruleStructuralFeatureModification ) )* ( (lv_addFeatures_14_0= ruleAddFeature ) )* ( (lv_addDeriveds_15_0= ruleAddDerived ) )* otherlv_16= '}' )? (otherlv_17= 'annotation' otherlv_18= '{' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) (otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) ) )* otherlv_22= '}' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1141:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==19) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1142:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1142:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1143:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleClassModification2451); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getClassModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1156:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1158:1: ( ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* ) )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1158:1: ( ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1159:2: ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getClassModificationAccess().getUnorderedGroup_1());
            	
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1162:2: ( ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )* )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1163:3: ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )*
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1163:3: ( ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) ) )*
            loop29:
            do {
                int alt29=4;
                int LA29_0 = input.LA(1);

                if ( LA29_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 0) ) {
                    alt29=1;
                }
                else if ( LA29_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 1) ) {
                    alt29=2;
                }
                else if ( LA29_0 ==37 && getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 2) ) {
                    alt29=3;
                }


                switch (alt29) {
            	case 1 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1165:4: ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1165:4: ({...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1166:5: {...}? => ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1166:114: ( ({...}? => ( (lv_hide_2_0= 'hide' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1167:6: ({...}? => ( (lv_hide_2_0= 'hide' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1170:6: ({...}? => ( (lv_hide_2_0= 'hide' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1170:7: {...}? => ( (lv_hide_2_0= 'hide' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1170:16: ( (lv_hide_2_0= 'hide' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1171:1: (lv_hide_2_0= 'hide' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1171:1: (lv_hide_2_0= 'hide' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1172:3: lv_hide_2_0= 'hide'
            	    {
            	    lv_hide_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleClassModification2528); 

            	            newLeafNode(lv_hide_2_0, grammarAccess.getClassModificationAccess().getHideHideKeyword_1_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getClassModificationRule());
            	    	        }
            	           		setWithLastConsumed(current, "hide", true, "hide");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassModificationAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1192:4: ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1192:4: ({...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1193:5: {...}? => ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1193:114: ( ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1194:6: ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1197:6: ({...}? => ( (lv_flatten_3_0= 'flatten' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1197:7: {...}? => ( (lv_flatten_3_0= 'flatten' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1197:16: ( (lv_flatten_3_0= 'flatten' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1198:1: (lv_flatten_3_0= 'flatten' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1198:1: (lv_flatten_3_0= 'flatten' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1199:3: lv_flatten_3_0= 'flatten'
            	    {
            	    lv_flatten_3_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleClassModification2613); 

            	            newLeafNode(lv_flatten_3_0, grammarAccess.getClassModificationAccess().getFlattenFlattenKeyword_1_1_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getClassModificationRule());
            	    	        }
            	           		setWithLastConsumed(current, "flatten", true, "flatten");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassModificationAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1219:4: ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1219:4: ({...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1220:5: {...}? => ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1220:114: ( ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1221:6: ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getClassModificationAccess().getUnorderedGroup_1(), 2);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1224:6: ({...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1224:7: {...}? => ( (lv_flattenAll_4_0= 'flattenAll' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1224:16: ( (lv_flattenAll_4_0= 'flattenAll' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1225:1: (lv_flattenAll_4_0= 'flattenAll' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1225:1: (lv_flattenAll_4_0= 'flattenAll' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1226:3: lv_flattenAll_4_0= 'flattenAll'
            	    {
            	    lv_flattenAll_4_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleClassModification2698); 

            	            newLeafNode(lv_flattenAll_4_0, grammarAccess.getClassModificationAccess().getFlattenAllFlattenAllKeyword_1_2_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getClassModificationRule());
            	    	        }
            	           		setWithLastConsumed(current, "flattenAll", true, "flattenAll");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassModificationAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getClassModificationAccess().getUnorderedGroup_1());
            	

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1253:2: ( (lv_oldName_5_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1254:1: (lv_oldName_5_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1254:1: (lv_oldName_5_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1255:3: lv_oldName_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getClassModificationAccess().getOldNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleClassModification2772);
            lv_oldName_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClassModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldName",
                    		lv_oldName_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1271:2: (otherlv_6= 'to' ( (lv_newName_7_0= ruleEString ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==21) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1271:4: otherlv_6= 'to' ( (lv_newName_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleClassModification2785); 

                        	newLeafNode(otherlv_6, grammarAccess.getClassModificationAccess().getToKeyword_3_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1275:1: ( (lv_newName_7_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1276:1: (lv_newName_7_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1276:1: (lv_newName_7_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1277:3: lv_newName_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getClassModificationAccess().getNewNameEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleClassModification2806);
                    lv_newName_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClassModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newName",
                            		lv_newName_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1293:4: ( ( ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1295:1: ( ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* ) )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1295:1: ( ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1296:2: ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getClassModificationAccess().getUnorderedGroup_4());
            	
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1299:2: ( ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )* )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1300:3: ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )*
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1300:3: ( ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) ) )*
            loop31:
            do {
                int alt31=4;
                int LA31_0 = input.LA(1);

                if ( LA31_0 ==38 && getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 0) ) {
                    alt31=1;
                }
                else if ( LA31_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 1) ) {
                    alt31=2;
                }
                else if ( LA31_0 ==62 && getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 2) ) {
                    alt31=3;
                }


                switch (alt31) {
            	case 1 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1302:4: ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1302:4: ({...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1303:5: {...}? => ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1303:114: ( ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1304:6: ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 0);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1307:6: ({...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1307:7: {...}? => ( (lv_changeAbstract_9_0= 'changeAbstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1307:16: ( (lv_changeAbstract_9_0= 'changeAbstract' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1308:1: (lv_changeAbstract_9_0= 'changeAbstract' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1308:1: (lv_changeAbstract_9_0= 'changeAbstract' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1309:3: lv_changeAbstract_9_0= 'changeAbstract'
            	    {
            	    lv_changeAbstract_9_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleClassModification2871); 

            	            newLeafNode(lv_changeAbstract_9_0, grammarAccess.getClassModificationAccess().getChangeAbstractChangeAbstractKeyword_4_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getClassModificationRule());
            	    	        }
            	           		setWithLastConsumed(current, "changeAbstract", true, "changeAbstract");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassModificationAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1329:4: ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1329:4: ({...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1330:5: {...}? => ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1330:114: ( ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1331:6: ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 1);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1334:6: ({...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1334:7: {...}? => ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1334:16: ( (lv_removeEAnnotations_10_0= 'removeEAnnotations' ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1335:1: (lv_removeEAnnotations_10_0= 'removeEAnnotations' )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1335:1: (lv_removeEAnnotations_10_0= 'removeEAnnotations' )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1336:3: lv_removeEAnnotations_10_0= 'removeEAnnotations'
            	    {
            	    lv_removeEAnnotations_10_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleClassModification2956); 

            	            newLeafNode(lv_removeEAnnotations_10_0, grammarAccess.getClassModificationAccess().getRemoveEAnnotationsRemoveEAnnotationsKeyword_4_1_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getClassModificationRule());
            	    	        }
            	           		setWithLastConsumed(current, "removeEAnnotations", true, "removeEAnnotations");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassModificationAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1356:4: ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1356:4: ({...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1357:5: {...}? => ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1357:114: ( ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1358:6: ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getClassModificationAccess().getUnorderedGroup_4(), 2);
            	    	 				
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1361:6: ({...}? => ( (lv_enumerate_11_0= ruleEnumerate ) ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1361:7: {...}? => ( (lv_enumerate_11_0= ruleEnumerate ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleClassModification", "true");
            	    }
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1361:16: ( (lv_enumerate_11_0= ruleEnumerate ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1362:1: (lv_enumerate_11_0= ruleEnumerate )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1362:1: (lv_enumerate_11_0= ruleEnumerate )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1363:3: lv_enumerate_11_0= ruleEnumerate
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassModificationAccess().getEnumerateEnumerateParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumerate_in_ruleClassModification3044);
            	    lv_enumerate_11_0=ruleEnumerate();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassModificationRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"enumerate",
            	            		lv_enumerate_11_0, 
            	            		"Enumerate");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassModificationAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getClassModificationAccess().getUnorderedGroup_4());
            	

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1393:2: (otherlv_12= '{' ( (lv_featureModification_13_0= ruleStructuralFeatureModification ) )* ( (lv_addFeatures_14_0= ruleAddFeature ) )* ( (lv_addDeriveds_15_0= ruleAddDerived ) )* otherlv_16= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==26) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1393:4: otherlv_12= '{' ( (lv_featureModification_13_0= ruleStructuralFeatureModification ) )* ( (lv_addFeatures_14_0= ruleAddFeature ) )* ( (lv_addDeriveds_15_0= ruleAddDerived ) )* otherlv_16= '}'
                    {
                    otherlv_12=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleClassModification3097); 

                        	newLeafNode(otherlv_12, grammarAccess.getClassModificationAccess().getLeftCurlyBracketKeyword_5_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1397:1: ( (lv_featureModification_13_0= ruleStructuralFeatureModification ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==19||LA32_0==48||LA32_0==50) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1398:1: (lv_featureModification_13_0= ruleStructuralFeatureModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1398:1: (lv_featureModification_13_0= ruleStructuralFeatureModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1399:3: lv_featureModification_13_0= ruleStructuralFeatureModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getClassModificationAccess().getFeatureModificationStructuralFeatureModificationParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleStructuralFeatureModification_in_ruleClassModification3118);
                    	    lv_featureModification_13_0=ruleStructuralFeatureModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getClassModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureModification",
                    	            		lv_featureModification_13_0, 
                    	            		"StructuralFeatureModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1415:3: ( (lv_addFeatures_14_0= ruleAddFeature ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==44||LA33_0==46) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1416:1: (lv_addFeatures_14_0= ruleAddFeature )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1416:1: (lv_addFeatures_14_0= ruleAddFeature )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1417:3: lv_addFeatures_14_0= ruleAddFeature
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getClassModificationAccess().getAddFeaturesAddFeatureParserRuleCall_5_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAddFeature_in_ruleClassModification3140);
                    	    lv_addFeatures_14_0=ruleAddFeature();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getClassModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"addFeatures",
                    	            		lv_addFeatures_14_0, 
                    	            		"AddFeature");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1433:3: ( (lv_addDeriveds_15_0= ruleAddDerived ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==59||LA34_0==61) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1434:1: (lv_addDeriveds_15_0= ruleAddDerived )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1434:1: (lv_addDeriveds_15_0= ruleAddDerived )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1435:3: lv_addDeriveds_15_0= ruleAddDerived
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getClassModificationAccess().getAddDerivedsAddDerivedParserRuleCall_5_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAddDerived_in_ruleClassModification3162);
                    	    lv_addDeriveds_15_0=ruleAddDerived();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getClassModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"addDeriveds",
                    	            		lv_addDeriveds_15_0, 
                    	            		"AddDerived");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleClassModification3175); 

                        	newLeafNode(otherlv_16, grammarAccess.getClassModificationAccess().getRightCurlyBracketKeyword_5_4());
                        

                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1455:3: (otherlv_17= 'annotation' otherlv_18= '{' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) (otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) ) )* otherlv_22= '}' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==32) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1455:5: otherlv_17= 'annotation' otherlv_18= '{' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) (otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) ) )* otherlv_22= '}'
                    {
                    otherlv_17=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleClassModification3190); 

                        	newLeafNode(otherlv_17, grammarAccess.getClassModificationAccess().getAnnotationKeyword_6_0());
                        
                    otherlv_18=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleClassModification3202); 

                        	newLeafNode(otherlv_18, grammarAccess.getClassModificationAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1463:1: ( (lv_annotationModification_19_0= ruleAnnotationModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1464:1: (lv_annotationModification_19_0= ruleAnnotationModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1464:1: (lv_annotationModification_19_0= ruleAnnotationModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1465:3: lv_annotationModification_19_0= ruleAnnotationModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getClassModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleClassModification3223);
                    lv_annotationModification_19_0=ruleAnnotationModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClassModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"annotationModification",
                            		lv_annotationModification_19_0, 
                            		"AnnotationModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1481:2: (otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==27) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1481:4: otherlv_20= ';' ( (lv_annotationModification_21_0= ruleAnnotationModification ) )
                    	    {
                    	    otherlv_20=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleClassModification3236); 

                    	        	newLeafNode(otherlv_20, grammarAccess.getClassModificationAccess().getSemicolonKeyword_6_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1485:1: ( (lv_annotationModification_21_0= ruleAnnotationModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1486:1: (lv_annotationModification_21_0= ruleAnnotationModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1486:1: (lv_annotationModification_21_0= ruleAnnotationModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1487:3: lv_annotationModification_21_0= ruleAnnotationModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getClassModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleClassModification3257);
                    	    lv_annotationModification_21_0=ruleAnnotationModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getClassModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotationModification",
                    	            		lv_annotationModification_21_0, 
                    	            		"AnnotationModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleClassModification3271); 

                        	newLeafNode(otherlv_22, grammarAccess.getClassModificationAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassModification"


    // $ANTLR start "entryRuleDataTypeModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1515:1: entryRuleDataTypeModification returns [EObject current=null] : iv_ruleDataTypeModification= ruleDataTypeModification EOF ;
    public final EObject entryRuleDataTypeModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1516:2: (iv_ruleDataTypeModification= ruleDataTypeModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1517:2: iv_ruleDataTypeModification= ruleDataTypeModification EOF
            {
             newCompositeNode(grammarAccess.getDataTypeModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeModification_in_entryRuleDataTypeModification3309);
            iv_ruleDataTypeModification=ruleDataTypeModification();

            state._fsp--;

             current =iv_ruleDataTypeModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypeModification3319); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTypeModification"


    // $ANTLR start "ruleDataTypeModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1524:1: ruleDataTypeModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldInstanceType' ( (lv_oldInstanceTypeName_5_0= ruleEString ) ) )? (otherlv_6= 'newInstanceType' ( (lv_newInstanceTypeName_7_0= ruleEString ) ) )? ( (lv_removeEAnnotations_8_0= 'removeEAnnotations' ) )? (otherlv_9= 'annotation' otherlv_10= '{' ( (lv_annotationModification_11_0= ruleAnnotationModification ) ) (otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) )* otherlv_14= '}' )? ) ;
    public final EObject ruleDataTypeModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_removeEAnnotations_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_oldName_1_0 = null;

        AntlrDatatypeRuleToken lv_newName_3_0 = null;

        AntlrDatatypeRuleToken lv_oldInstanceTypeName_5_0 = null;

        AntlrDatatypeRuleToken lv_newInstanceTypeName_7_0 = null;

        EObject lv_annotationModification_11_0 = null;

        EObject lv_annotationModification_13_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1527:28: ( ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldInstanceType' ( (lv_oldInstanceTypeName_5_0= ruleEString ) ) )? (otherlv_6= 'newInstanceType' ( (lv_newInstanceTypeName_7_0= ruleEString ) ) )? ( (lv_removeEAnnotations_8_0= 'removeEAnnotations' ) )? (otherlv_9= 'annotation' otherlv_10= '{' ( (lv_annotationModification_11_0= ruleAnnotationModification ) ) (otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) )* otherlv_14= '}' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1528:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldInstanceType' ( (lv_oldInstanceTypeName_5_0= ruleEString ) ) )? (otherlv_6= 'newInstanceType' ( (lv_newInstanceTypeName_7_0= ruleEString ) ) )? ( (lv_removeEAnnotations_8_0= 'removeEAnnotations' ) )? (otherlv_9= 'annotation' otherlv_10= '{' ( (lv_annotationModification_11_0= ruleAnnotationModification ) ) (otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) )* otherlv_14= '}' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1528:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldInstanceType' ( (lv_oldInstanceTypeName_5_0= ruleEString ) ) )? (otherlv_6= 'newInstanceType' ( (lv_newInstanceTypeName_7_0= ruleEString ) ) )? ( (lv_removeEAnnotations_8_0= 'removeEAnnotations' ) )? (otherlv_9= 'annotation' otherlv_10= '{' ( (lv_annotationModification_11_0= ruleAnnotationModification ) ) (otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) )* otherlv_14= '}' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1528:2: ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldInstanceType' ( (lv_oldInstanceTypeName_5_0= ruleEString ) ) )? (otherlv_6= 'newInstanceType' ( (lv_newInstanceTypeName_7_0= ruleEString ) ) )? ( (lv_removeEAnnotations_8_0= 'removeEAnnotations' ) )? (otherlv_9= 'annotation' otherlv_10= '{' ( (lv_annotationModification_11_0= ruleAnnotationModification ) ) (otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) )* otherlv_14= '}' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1528:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1529:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1529:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1530:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDataTypeModification3362); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getDataTypeModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataTypeModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1543:3: ( (lv_oldName_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1544:1: (lv_oldName_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1544:1: (lv_oldName_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1545:3: lv_oldName_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getDataTypeModificationAccess().getOldNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDataTypeModification3397);
            lv_oldName_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDataTypeModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldName",
                    		lv_oldName_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1561:2: (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==21) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1561:4: otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDataTypeModification3410); 

                        	newLeafNode(otherlv_2, grammarAccess.getDataTypeModificationAccess().getToKeyword_2_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1565:1: ( (lv_newName_3_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1566:1: (lv_newName_3_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1566:1: (lv_newName_3_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1567:3: lv_newName_3_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataTypeModificationAccess().getNewNameEStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDataTypeModification3431);
                    lv_newName_3_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataTypeModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newName",
                            		lv_newName_3_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1583:4: (otherlv_4= 'oldInstanceType' ( (lv_oldInstanceTypeName_5_0= ruleEString ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==39) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1583:6: otherlv_4= 'oldInstanceType' ( (lv_oldInstanceTypeName_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleDataTypeModification3446); 

                        	newLeafNode(otherlv_4, grammarAccess.getDataTypeModificationAccess().getOldInstanceTypeKeyword_3_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1587:1: ( (lv_oldInstanceTypeName_5_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1588:1: (lv_oldInstanceTypeName_5_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1588:1: (lv_oldInstanceTypeName_5_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1589:3: lv_oldInstanceTypeName_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataTypeModificationAccess().getOldInstanceTypeNameEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDataTypeModification3467);
                    lv_oldInstanceTypeName_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataTypeModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"oldInstanceTypeName",
                            		lv_oldInstanceTypeName_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1605:4: (otherlv_6= 'newInstanceType' ( (lv_newInstanceTypeName_7_0= ruleEString ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==40) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1605:6: otherlv_6= 'newInstanceType' ( (lv_newInstanceTypeName_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleDataTypeModification3482); 

                        	newLeafNode(otherlv_6, grammarAccess.getDataTypeModificationAccess().getNewInstanceTypeKeyword_4_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1609:1: ( (lv_newInstanceTypeName_7_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1610:1: (lv_newInstanceTypeName_7_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1610:1: (lv_newInstanceTypeName_7_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1611:3: lv_newInstanceTypeName_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataTypeModificationAccess().getNewInstanceTypeNameEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDataTypeModification3503);
                    lv_newInstanceTypeName_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataTypeModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newInstanceTypeName",
                            		lv_newInstanceTypeName_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1627:4: ( (lv_removeEAnnotations_8_0= 'removeEAnnotations' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==24) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1628:1: (lv_removeEAnnotations_8_0= 'removeEAnnotations' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1628:1: (lv_removeEAnnotations_8_0= 'removeEAnnotations' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1629:3: lv_removeEAnnotations_8_0= 'removeEAnnotations'
                    {
                    lv_removeEAnnotations_8_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleDataTypeModification3523); 

                            newLeafNode(lv_removeEAnnotations_8_0, grammarAccess.getDataTypeModificationAccess().getRemoveEAnnotationsRemoveEAnnotationsKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataTypeModificationRule());
                    	        }
                           		setWithLastConsumed(current, "removeEAnnotations", true, "removeEAnnotations");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1642:3: (otherlv_9= 'annotation' otherlv_10= '{' ( (lv_annotationModification_11_0= ruleAnnotationModification ) ) (otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) )* otherlv_14= '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==32) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1642:5: otherlv_9= 'annotation' otherlv_10= '{' ( (lv_annotationModification_11_0= ruleAnnotationModification ) ) (otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) )* otherlv_14= '}'
                    {
                    otherlv_9=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleDataTypeModification3550); 

                        	newLeafNode(otherlv_9, grammarAccess.getDataTypeModificationAccess().getAnnotationKeyword_6_0());
                        
                    otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleDataTypeModification3562); 

                        	newLeafNode(otherlv_10, grammarAccess.getDataTypeModificationAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1650:1: ( (lv_annotationModification_11_0= ruleAnnotationModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1651:1: (lv_annotationModification_11_0= ruleAnnotationModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1651:1: (lv_annotationModification_11_0= ruleAnnotationModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1652:3: lv_annotationModification_11_0= ruleAnnotationModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataTypeModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleDataTypeModification3583);
                    lv_annotationModification_11_0=ruleAnnotationModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataTypeModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"annotationModification",
                            		lv_annotationModification_11_0, 
                            		"AnnotationModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1668:2: (otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==27) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1668:4: otherlv_12= ';' ( (lv_annotationModification_13_0= ruleAnnotationModification ) )
                    	    {
                    	    otherlv_12=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleDataTypeModification3596); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getDataTypeModificationAccess().getSemicolonKeyword_6_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1672:1: ( (lv_annotationModification_13_0= ruleAnnotationModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1673:1: (lv_annotationModification_13_0= ruleAnnotationModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1673:1: (lv_annotationModification_13_0= ruleAnnotationModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1674:3: lv_annotationModification_13_0= ruleAnnotationModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getDataTypeModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleDataTypeModification3617);
                    	    lv_annotationModification_13_0=ruleAnnotationModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getDataTypeModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotationModification",
                    	            		lv_annotationModification_13_0, 
                    	            		"AnnotationModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDataTypeModification3631); 

                        	newLeafNode(otherlv_14, grammarAccess.getDataTypeModificationAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTypeModification"


    // $ANTLR start "entryRuleEnumModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1702:1: entryRuleEnumModification returns [EObject current=null] : iv_ruleEnumModification= ruleEnumModification EOF ;
    public final EObject entryRuleEnumModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1703:2: (iv_ruleEnumModification= ruleEnumModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1704:2: iv_ruleEnumModification= ruleEnumModification EOF
            {
             newCompositeNode(grammarAccess.getEnumModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumModification_in_entryRuleEnumModification3669);
            iv_ruleEnumModification=ruleEnumModification();

            state._fsp--;

             current =iv_ruleEnumModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumModification3679); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumModification"


    // $ANTLR start "ruleEnumModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1711:1: ruleEnumModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_reify_1_0= 'reify' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'oldInstanceType' ( (lv_oldInstanceTypeName_6_0= ruleEString ) ) )? (otherlv_7= 'newInstanceType' ( (lv_newInstanceTypeName_8_0= ruleEString ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= '{' ( (lv_enumLiteralModification_11_0= ruleEnumLiteralModification ) ) (otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) ) )* otherlv_14= '}' )? (otherlv_15= 'annotation' otherlv_16= '{' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) (otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) )* otherlv_20= '}' )? ) ;
    public final EObject ruleEnumModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token lv_reify_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_removeEAnnotations_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_oldName_2_0 = null;

        AntlrDatatypeRuleToken lv_newName_4_0 = null;

        AntlrDatatypeRuleToken lv_oldInstanceTypeName_6_0 = null;

        AntlrDatatypeRuleToken lv_newInstanceTypeName_8_0 = null;

        EObject lv_enumLiteralModification_11_0 = null;

        EObject lv_enumLiteralModification_13_0 = null;

        EObject lv_annotationModification_17_0 = null;

        EObject lv_annotationModification_19_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1714:28: ( ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_reify_1_0= 'reify' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'oldInstanceType' ( (lv_oldInstanceTypeName_6_0= ruleEString ) ) )? (otherlv_7= 'newInstanceType' ( (lv_newInstanceTypeName_8_0= ruleEString ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= '{' ( (lv_enumLiteralModification_11_0= ruleEnumLiteralModification ) ) (otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) ) )* otherlv_14= '}' )? (otherlv_15= 'annotation' otherlv_16= '{' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) (otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) )* otherlv_20= '}' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1715:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_reify_1_0= 'reify' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'oldInstanceType' ( (lv_oldInstanceTypeName_6_0= ruleEString ) ) )? (otherlv_7= 'newInstanceType' ( (lv_newInstanceTypeName_8_0= ruleEString ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= '{' ( (lv_enumLiteralModification_11_0= ruleEnumLiteralModification ) ) (otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) ) )* otherlv_14= '}' )? (otherlv_15= 'annotation' otherlv_16= '{' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) (otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) )* otherlv_20= '}' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1715:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_reify_1_0= 'reify' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'oldInstanceType' ( (lv_oldInstanceTypeName_6_0= ruleEString ) ) )? (otherlv_7= 'newInstanceType' ( (lv_newInstanceTypeName_8_0= ruleEString ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= '{' ( (lv_enumLiteralModification_11_0= ruleEnumLiteralModification ) ) (otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) ) )* otherlv_14= '}' )? (otherlv_15= 'annotation' otherlv_16= '{' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) (otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) )* otherlv_20= '}' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1715:2: ( (lv_remove_0_0= 'remove' ) )? ( (lv_reify_1_0= 'reify' ) )? ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? (otherlv_5= 'oldInstanceType' ( (lv_oldInstanceTypeName_6_0= ruleEString ) ) )? (otherlv_7= 'newInstanceType' ( (lv_newInstanceTypeName_8_0= ruleEString ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= '{' ( (lv_enumLiteralModification_11_0= ruleEnumLiteralModification ) ) (otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) ) )* otherlv_14= '}' )? (otherlv_15= 'annotation' otherlv_16= '{' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) (otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) )* otherlv_20= '}' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1715:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==19) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1716:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1716:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1717:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEnumModification3722); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getEnumModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEnumModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1730:3: ( (lv_reify_1_0= 'reify' ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1731:1: (lv_reify_1_0= 'reify' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1731:1: (lv_reify_1_0= 'reify' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1732:3: lv_reify_1_0= 'reify'
                    {
                    lv_reify_1_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEnumModification3754); 

                            newLeafNode(lv_reify_1_0, grammarAccess.getEnumModificationAccess().getReifyReifyKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEnumModificationRule());
                    	        }
                           		setWithLastConsumed(current, "reify", true, "reify");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1745:3: ( (lv_oldName_2_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1746:1: (lv_oldName_2_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1746:1: (lv_oldName_2_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1747:3: lv_oldName_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEnumModificationAccess().getOldNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumModification3789);
            lv_oldName_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldName",
                    		lv_oldName_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1763:2: (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==21) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1763:4: otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumModification3802); 

                        	newLeafNode(otherlv_3, grammarAccess.getEnumModificationAccess().getToKeyword_3_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1767:1: ( (lv_newName_4_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1768:1: (lv_newName_4_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1768:1: (lv_newName_4_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1769:3: lv_newName_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumModificationAccess().getNewNameEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumModification3823);
                    lv_newName_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newName",
                            		lv_newName_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1785:4: (otherlv_5= 'oldInstanceType' ( (lv_oldInstanceTypeName_6_0= ruleEString ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==39) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1785:6: otherlv_5= 'oldInstanceType' ( (lv_oldInstanceTypeName_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleEnumModification3838); 

                        	newLeafNode(otherlv_5, grammarAccess.getEnumModificationAccess().getOldInstanceTypeKeyword_4_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1789:1: ( (lv_oldInstanceTypeName_6_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1790:1: (lv_oldInstanceTypeName_6_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1790:1: (lv_oldInstanceTypeName_6_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1791:3: lv_oldInstanceTypeName_6_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumModificationAccess().getOldInstanceTypeNameEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumModification3859);
                    lv_oldInstanceTypeName_6_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"oldInstanceTypeName",
                            		lv_oldInstanceTypeName_6_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1807:4: (otherlv_7= 'newInstanceType' ( (lv_newInstanceTypeName_8_0= ruleEString ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==40) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1807:6: otherlv_7= 'newInstanceType' ( (lv_newInstanceTypeName_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEnumModification3874); 

                        	newLeafNode(otherlv_7, grammarAccess.getEnumModificationAccess().getNewInstanceTypeKeyword_5_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1811:1: ( (lv_newInstanceTypeName_8_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1812:1: (lv_newInstanceTypeName_8_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1812:1: (lv_newInstanceTypeName_8_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1813:3: lv_newInstanceTypeName_8_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumModificationAccess().getNewInstanceTypeNameEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumModification3895);
                    lv_newInstanceTypeName_8_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newInstanceTypeName",
                            		lv_newInstanceTypeName_8_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1829:4: ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==24) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1830:1: (lv_removeEAnnotations_9_0= 'removeEAnnotations' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1830:1: (lv_removeEAnnotations_9_0= 'removeEAnnotations' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1831:3: lv_removeEAnnotations_9_0= 'removeEAnnotations'
                    {
                    lv_removeEAnnotations_9_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEnumModification3915); 

                            newLeafNode(lv_removeEAnnotations_9_0, grammarAccess.getEnumModificationAccess().getRemoveEAnnotationsRemoveEAnnotationsKeyword_6_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEnumModificationRule());
                    	        }
                           		setWithLastConsumed(current, "removeEAnnotations", true, "removeEAnnotations");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1844:3: (otherlv_10= '{' ( (lv_enumLiteralModification_11_0= ruleEnumLiteralModification ) ) (otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) ) )* otherlv_14= '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==26) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1844:5: otherlv_10= '{' ( (lv_enumLiteralModification_11_0= ruleEnumLiteralModification ) ) (otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleEnumModification3942); 

                        	newLeafNode(otherlv_10, grammarAccess.getEnumModificationAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1848:1: ( (lv_enumLiteralModification_11_0= ruleEnumLiteralModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1849:1: (lv_enumLiteralModification_11_0= ruleEnumLiteralModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1849:1: (lv_enumLiteralModification_11_0= ruleEnumLiteralModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1850:3: lv_enumLiteralModification_11_0= ruleEnumLiteralModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumModificationAccess().getEnumLiteralModificationEnumLiteralModificationParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralModification_in_ruleEnumModification3963);
                    lv_enumLiteralModification_11_0=ruleEnumLiteralModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"enumLiteralModification",
                            		lv_enumLiteralModification_11_0, 
                            		"EnumLiteralModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1866:2: (otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==27) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1866:4: otherlv_12= ';' ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) )
                    	    {
                    	    otherlv_12=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEnumModification3976); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getEnumModificationAccess().getSemicolonKeyword_7_2_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1870:1: ( (lv_enumLiteralModification_13_0= ruleEnumLiteralModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1871:1: (lv_enumLiteralModification_13_0= ruleEnumLiteralModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1871:1: (lv_enumLiteralModification_13_0= ruleEnumLiteralModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1872:3: lv_enumLiteralModification_13_0= ruleEnumLiteralModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEnumModificationAccess().getEnumLiteralModificationEnumLiteralModificationParserRuleCall_7_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralModification_in_ruleEnumModification3997);
                    	    lv_enumLiteralModification_13_0=ruleEnumLiteralModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEnumModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"enumLiteralModification",
                    	            		lv_enumLiteralModification_13_0, 
                    	            		"EnumLiteralModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEnumModification4011); 

                        	newLeafNode(otherlv_14, grammarAccess.getEnumModificationAccess().getRightCurlyBracketKeyword_7_3());
                        

                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1892:3: (otherlv_15= 'annotation' otherlv_16= '{' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) (otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) )* otherlv_20= '}' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==32) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1892:5: otherlv_15= 'annotation' otherlv_16= '{' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) (otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEnumModification4026); 

                        	newLeafNode(otherlv_15, grammarAccess.getEnumModificationAccess().getAnnotationKeyword_8_0());
                        
                    otherlv_16=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleEnumModification4038); 

                        	newLeafNode(otherlv_16, grammarAccess.getEnumModificationAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1900:1: ( (lv_annotationModification_17_0= ruleAnnotationModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1901:1: (lv_annotationModification_17_0= ruleAnnotationModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1901:1: (lv_annotationModification_17_0= ruleAnnotationModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1902:3: lv_annotationModification_17_0= ruleAnnotationModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_8_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleEnumModification4059);
                    lv_annotationModification_17_0=ruleAnnotationModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"annotationModification",
                            		lv_annotationModification_17_0, 
                            		"AnnotationModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1918:2: (otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==27) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1918:4: otherlv_18= ';' ( (lv_annotationModification_19_0= ruleAnnotationModification ) )
                    	    {
                    	    otherlv_18=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEnumModification4072); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getEnumModificationAccess().getSemicolonKeyword_8_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1922:1: ( (lv_annotationModification_19_0= ruleAnnotationModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1923:1: (lv_annotationModification_19_0= ruleAnnotationModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1923:1: (lv_annotationModification_19_0= ruleAnnotationModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1924:3: lv_annotationModification_19_0= ruleAnnotationModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEnumModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_8_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleEnumModification4093);
                    	    lv_annotationModification_19_0=ruleAnnotationModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEnumModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotationModification",
                    	            		lv_annotationModification_19_0, 
                    	            		"AnnotationModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEnumModification4107); 

                        	newLeafNode(otherlv_20, grammarAccess.getEnumModificationAccess().getRightCurlyBracketKeyword_8_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumModification"


    // $ANTLR start "entryRuleEnumLiteralModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1952:1: entryRuleEnumLiteralModification returns [EObject current=null] : iv_ruleEnumLiteralModification= ruleEnumLiteralModification EOF ;
    public final EObject entryRuleEnumLiteralModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1953:2: (iv_ruleEnumLiteralModification= ruleEnumLiteralModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1954:2: iv_ruleEnumLiteralModification= ruleEnumLiteralModification EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralModification_in_entryRuleEnumLiteralModification4145);
            iv_ruleEnumLiteralModification=ruleEnumLiteralModification();

            state._fsp--;

             current =iv_ruleEnumLiteralModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralModification4155); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteralModification"


    // $ANTLR start "ruleEnumLiteralModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1961:1: ruleEnumLiteralModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldLiteral' ( (lv_oldLiteral_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newLiteral_7_0= ruleEString ) ) )? (otherlv_8= 'oldValue' ( (lv_oldValue_9_0= ruleEInt ) ) otherlv_10= 'to' ( (lv_newValue_11_0= ruleEInt ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )? ) ;
    public final EObject ruleEnumLiteralModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_removeEAnnotations_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_oldName_1_0 = null;

        AntlrDatatypeRuleToken lv_newName_3_0 = null;

        AntlrDatatypeRuleToken lv_oldLiteral_5_0 = null;

        AntlrDatatypeRuleToken lv_newLiteral_7_0 = null;

        AntlrDatatypeRuleToken lv_oldValue_9_0 = null;

        AntlrDatatypeRuleToken lv_newValue_11_0 = null;

        EObject lv_annotationModification_15_0 = null;

        EObject lv_annotationModification_17_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1964:28: ( ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldLiteral' ( (lv_oldLiteral_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newLiteral_7_0= ruleEString ) ) )? (otherlv_8= 'oldValue' ( (lv_oldValue_9_0= ruleEInt ) ) otherlv_10= 'to' ( (lv_newValue_11_0= ruleEInt ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1965:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldLiteral' ( (lv_oldLiteral_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newLiteral_7_0= ruleEString ) ) )? (otherlv_8= 'oldValue' ( (lv_oldValue_9_0= ruleEInt ) ) otherlv_10= 'to' ( (lv_newValue_11_0= ruleEInt ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1965:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldLiteral' ( (lv_oldLiteral_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newLiteral_7_0= ruleEString ) ) )? (otherlv_8= 'oldValue' ( (lv_oldValue_9_0= ruleEInt ) ) otherlv_10= 'to' ( (lv_newValue_11_0= ruleEInt ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1965:2: ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldName_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )? (otherlv_4= 'oldLiteral' ( (lv_oldLiteral_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newLiteral_7_0= ruleEString ) ) )? (otherlv_8= 'oldValue' ( (lv_oldValue_9_0= ruleEInt ) ) otherlv_10= 'to' ( (lv_newValue_11_0= ruleEInt ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1965:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==19) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1966:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1966:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1967:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEnumLiteralModification4198); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getEnumLiteralModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEnumLiteralModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1980:3: ( (lv_oldName_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1981:1: (lv_oldName_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1981:1: (lv_oldName_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1982:3: lv_oldName_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEnumLiteralModificationAccess().getOldNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumLiteralModification4233);
            lv_oldName_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumLiteralModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldName",
                    		lv_oldName_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1998:2: (otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==21) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:1998:4: otherlv_2= 'to' ( (lv_newName_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumLiteralModification4246); 

                        	newLeafNode(otherlv_2, grammarAccess.getEnumLiteralModificationAccess().getToKeyword_2_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2002:1: ( (lv_newName_3_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2003:1: (lv_newName_3_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2003:1: (lv_newName_3_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2004:3: lv_newName_3_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralModificationAccess().getNewNameEStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumLiteralModification4267);
                    lv_newName_3_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumLiteralModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newName",
                            		lv_newName_3_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2020:4: (otherlv_4= 'oldLiteral' ( (lv_oldLiteral_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newLiteral_7_0= ruleEString ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==42) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2020:6: otherlv_4= 'oldLiteral' ( (lv_oldLiteral_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newLiteral_7_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEnumLiteralModification4282); 

                        	newLeafNode(otherlv_4, grammarAccess.getEnumLiteralModificationAccess().getOldLiteralKeyword_3_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2024:1: ( (lv_oldLiteral_5_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2025:1: (lv_oldLiteral_5_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2025:1: (lv_oldLiteral_5_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2026:3: lv_oldLiteral_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralModificationAccess().getOldLiteralEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumLiteralModification4303);
                    lv_oldLiteral_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumLiteralModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"oldLiteral",
                            		lv_oldLiteral_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumLiteralModification4315); 

                        	newLeafNode(otherlv_6, grammarAccess.getEnumLiteralModificationAccess().getToKeyword_3_2());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2046:1: ( (lv_newLiteral_7_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2047:1: (lv_newLiteral_7_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2047:1: (lv_newLiteral_7_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2048:3: lv_newLiteral_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralModificationAccess().getNewLiteralEStringParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumLiteralModification4336);
                    lv_newLiteral_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumLiteralModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newLiteral",
                            		lv_newLiteral_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2064:4: (otherlv_8= 'oldValue' ( (lv_oldValue_9_0= ruleEInt ) ) otherlv_10= 'to' ( (lv_newValue_11_0= ruleEInt ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==43) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2064:6: otherlv_8= 'oldValue' ( (lv_oldValue_9_0= ruleEInt ) ) otherlv_10= 'to' ( (lv_newValue_11_0= ruleEInt ) )
                    {
                    otherlv_8=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEnumLiteralModification4351); 

                        	newLeafNode(otherlv_8, grammarAccess.getEnumLiteralModificationAccess().getOldValueKeyword_4_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2068:1: ( (lv_oldValue_9_0= ruleEInt ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2069:1: (lv_oldValue_9_0= ruleEInt )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2069:1: (lv_oldValue_9_0= ruleEInt )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2070:3: lv_oldValue_9_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralModificationAccess().getOldValueEIntParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEnumLiteralModification4372);
                    lv_oldValue_9_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumLiteralModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"oldValue",
                            		lv_oldValue_9_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumLiteralModification4384); 

                        	newLeafNode(otherlv_10, grammarAccess.getEnumLiteralModificationAccess().getToKeyword_4_2());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2090:1: ( (lv_newValue_11_0= ruleEInt ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2091:1: (lv_newValue_11_0= ruleEInt )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2091:1: (lv_newValue_11_0= ruleEInt )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2092:3: lv_newValue_11_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralModificationAccess().getNewValueEIntParserRuleCall_4_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEnumLiteralModification4405);
                    lv_newValue_11_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumLiteralModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newValue",
                            		lv_newValue_11_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2108:4: ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==24) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2109:1: (lv_removeEAnnotations_12_0= 'removeEAnnotations' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2109:1: (lv_removeEAnnotations_12_0= 'removeEAnnotations' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2110:3: lv_removeEAnnotations_12_0= 'removeEAnnotations'
                    {
                    lv_removeEAnnotations_12_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEnumLiteralModification4425); 

                            newLeafNode(lv_removeEAnnotations_12_0, grammarAccess.getEnumLiteralModificationAccess().getRemoveEAnnotationsRemoveEAnnotationsKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEnumLiteralModificationRule());
                    	        }
                           		setWithLastConsumed(current, "removeEAnnotations", true, "removeEAnnotations");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2123:3: (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==32) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2123:5: otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}'
                    {
                    otherlv_13=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEnumLiteralModification4452); 

                        	newLeafNode(otherlv_13, grammarAccess.getEnumLiteralModificationAccess().getAnnotationKeyword_6_0());
                        
                    otherlv_14=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleEnumLiteralModification4464); 

                        	newLeafNode(otherlv_14, grammarAccess.getEnumLiteralModificationAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2131:1: ( (lv_annotationModification_15_0= ruleAnnotationModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2132:1: (lv_annotationModification_15_0= ruleAnnotationModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2132:1: (lv_annotationModification_15_0= ruleAnnotationModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2133:3: lv_annotationModification_15_0= ruleAnnotationModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleEnumLiteralModification4485);
                    lv_annotationModification_15_0=ruleAnnotationModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumLiteralModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"annotationModification",
                            		lv_annotationModification_15_0, 
                            		"AnnotationModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2149:2: (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==27) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2149:4: otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) )
                    	    {
                    	    otherlv_16=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEnumLiteralModification4498); 

                    	        	newLeafNode(otherlv_16, grammarAccess.getEnumLiteralModificationAccess().getSemicolonKeyword_6_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2153:1: ( (lv_annotationModification_17_0= ruleAnnotationModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2154:1: (lv_annotationModification_17_0= ruleAnnotationModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2154:1: (lv_annotationModification_17_0= ruleAnnotationModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2155:3: lv_annotationModification_17_0= ruleAnnotationModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEnumLiteralModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleEnumLiteralModification4519);
                    	    lv_annotationModification_17_0=ruleAnnotationModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEnumLiteralModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotationModification",
                    	            		lv_annotationModification_17_0, 
                    	            		"AnnotationModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEnumLiteralModification4533); 

                        	newLeafNode(otherlv_18, grammarAccess.getEnumLiteralModificationAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiteralModification"


    // $ANTLR start "entryRuleDetailsEntryModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2183:1: entryRuleDetailsEntryModification returns [EObject current=null] : iv_ruleDetailsEntryModification= ruleDetailsEntryModification EOF ;
    public final EObject entryRuleDetailsEntryModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailsEntryModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2184:2: (iv_ruleDetailsEntryModification= ruleDetailsEntryModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2185:2: iv_ruleDetailsEntryModification= ruleDetailsEntryModification EOF
            {
             newCompositeNode(grammarAccess.getDetailsEntryModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDetailsEntryModification_in_entryRuleDetailsEntryModification4571);
            iv_ruleDetailsEntryModification=ruleDetailsEntryModification();

            state._fsp--;

             current =iv_ruleDetailsEntryModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDetailsEntryModification4581); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDetailsEntryModification"


    // $ANTLR start "ruleDetailsEntryModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2192:1: ruleDetailsEntryModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldKey_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newKey_3_0= ruleEString ) ) )? (otherlv_4= 'oldValue' ( (lv_oldValue_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newValue_7_0= ruleEString ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleDetailsEntryModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_oldKey_1_0 = null;

        AntlrDatatypeRuleToken lv_newKey_3_0 = null;

        AntlrDatatypeRuleToken lv_oldValue_5_0 = null;

        AntlrDatatypeRuleToken lv_newValue_7_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2195:28: ( ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldKey_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newKey_3_0= ruleEString ) ) )? (otherlv_4= 'oldValue' ( (lv_oldValue_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newValue_7_0= ruleEString ) ) )? otherlv_8= '}' ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2196:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldKey_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newKey_3_0= ruleEString ) ) )? (otherlv_4= 'oldValue' ( (lv_oldValue_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newValue_7_0= ruleEString ) ) )? otherlv_8= '}' )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2196:1: ( ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldKey_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newKey_3_0= ruleEString ) ) )? (otherlv_4= 'oldValue' ( (lv_oldValue_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newValue_7_0= ruleEString ) ) )? otherlv_8= '}' )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2196:2: ( (lv_remove_0_0= 'remove' ) )? ( (lv_oldKey_1_0= ruleEString ) ) (otherlv_2= 'to' ( (lv_newKey_3_0= ruleEString ) ) )? (otherlv_4= 'oldValue' ( (lv_oldValue_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newValue_7_0= ruleEString ) ) )? otherlv_8= '}'
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2196:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==19) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2197:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2197:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2198:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDetailsEntryModification4624); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getDetailsEntryModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDetailsEntryModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2211:3: ( (lv_oldKey_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2212:1: (lv_oldKey_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2212:1: (lv_oldKey_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2213:3: lv_oldKey_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getDetailsEntryModificationAccess().getOldKeyEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDetailsEntryModification4659);
            lv_oldKey_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDetailsEntryModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldKey",
                    		lv_oldKey_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2229:2: (otherlv_2= 'to' ( (lv_newKey_3_0= ruleEString ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==21) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2229:4: otherlv_2= 'to' ( (lv_newKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDetailsEntryModification4672); 

                        	newLeafNode(otherlv_2, grammarAccess.getDetailsEntryModificationAccess().getToKeyword_2_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2233:1: ( (lv_newKey_3_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2234:1: (lv_newKey_3_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2234:1: (lv_newKey_3_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2235:3: lv_newKey_3_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDetailsEntryModificationAccess().getNewKeyEStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDetailsEntryModification4693);
                    lv_newKey_3_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDetailsEntryModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newKey",
                            		lv_newKey_3_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2251:4: (otherlv_4= 'oldValue' ( (lv_oldValue_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newValue_7_0= ruleEString ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==43) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2251:6: otherlv_4= 'oldValue' ( (lv_oldValue_5_0= ruleEString ) ) otherlv_6= 'to' ( (lv_newValue_7_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleDetailsEntryModification4708); 

                        	newLeafNode(otherlv_4, grammarAccess.getDetailsEntryModificationAccess().getOldValueKeyword_3_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2255:1: ( (lv_oldValue_5_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2256:1: (lv_oldValue_5_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2256:1: (lv_oldValue_5_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2257:3: lv_oldValue_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDetailsEntryModificationAccess().getOldValueEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDetailsEntryModification4729);
                    lv_oldValue_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDetailsEntryModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"oldValue",
                            		lv_oldValue_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDetailsEntryModification4741); 

                        	newLeafNode(otherlv_6, grammarAccess.getDetailsEntryModificationAccess().getToKeyword_3_2());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2277:1: ( (lv_newValue_7_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2278:1: (lv_newValue_7_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2278:1: (lv_newValue_7_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2279:3: lv_newValue_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDetailsEntryModificationAccess().getNewValueEStringParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDetailsEntryModification4762);
                    lv_newValue_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDetailsEntryModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newValue",
                            		lv_newValue_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDetailsEntryModification4776); 

                	newLeafNode(otherlv_8, grammarAccess.getDetailsEntryModificationAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDetailsEntryModification"


    // $ANTLR start "entryRuleAddFeature"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2307:1: entryRuleAddFeature returns [EObject current=null] : iv_ruleAddFeature= ruleAddFeature EOF ;
    public final EObject entryRuleAddFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddFeature = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2308:2: (iv_ruleAddFeature= ruleAddFeature EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2309:2: iv_ruleAddFeature= ruleAddFeature EOF
            {
             newCompositeNode(grammarAccess.getAddFeatureRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddFeature_in_entryRuleAddFeature4812);
            iv_ruleAddFeature=ruleAddFeature();

            state._fsp--;

             current =iv_ruleAddFeature; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddFeature4822); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddFeature"


    // $ANTLR start "ruleAddFeature"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2316:1: ruleAddFeature returns [EObject current=null] : (this_AddAttribute_0= ruleAddAttribute | this_AddReference_1= ruleAddReference ) ;
    public final EObject ruleAddFeature() throws RecognitionException {
        EObject current = null;

        EObject this_AddAttribute_0 = null;

        EObject this_AddReference_1 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2319:28: ( (this_AddAttribute_0= ruleAddAttribute | this_AddReference_1= ruleAddReference ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2320:1: (this_AddAttribute_0= ruleAddAttribute | this_AddReference_1= ruleAddReference )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2320:1: (this_AddAttribute_0= ruleAddAttribute | this_AddReference_1= ruleAddReference )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==44) ) {
                alt65=1;
            }
            else if ( (LA65_0==46) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2321:5: this_AddAttribute_0= ruleAddAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAddFeatureAccess().getAddAttributeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddAttribute_in_ruleAddFeature4869);
                    this_AddAttribute_0=ruleAddAttribute();

                    state._fsp--;

                     
                            current = this_AddAttribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2331:5: this_AddReference_1= ruleAddReference
                    {
                     
                            newCompositeNode(grammarAccess.getAddFeatureAccess().getAddReferenceParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddReference_in_ruleAddFeature4896);
                    this_AddReference_1=ruleAddReference();

                    state._fsp--;

                     
                            current = this_AddReference_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddFeature"


    // $ANTLR start "entryRuleAddAttribute"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2347:1: entryRuleAddAttribute returns [EObject current=null] : iv_ruleAddAttribute= ruleAddAttribute EOF ;
    public final EObject entryRuleAddAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddAttribute = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2348:2: (iv_ruleAddAttribute= ruleAddAttribute EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2349:2: iv_ruleAddAttribute= ruleAddAttribute EOF
            {
             newCompositeNode(grammarAccess.getAddAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddAttribute_in_entryRuleAddAttribute4931);
            iv_ruleAddAttribute=ruleAddAttribute();

            state._fsp--;

             current =iv_ruleAddAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddAttribute4941); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddAttribute"


    // $ANTLR start "ruleAddAttribute"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2356:1: ruleAddAttribute returns [EObject current=null] : (otherlv_0= 'addAttribute' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= rulePrimitiveType ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ',' ( (lv_defaultValue_10_0= ruleEString ) ) otherlv_11= ')' ) ;
    public final EObject ruleAddAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_type_4_0 = null;

        AntlrDatatypeRuleToken lv_lower_6_0 = null;

        AntlrDatatypeRuleToken lv_upper_8_0 = null;

        AntlrDatatypeRuleToken lv_defaultValue_10_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2359:28: ( (otherlv_0= 'addAttribute' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= rulePrimitiveType ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ',' ( (lv_defaultValue_10_0= ruleEString ) ) otherlv_11= ')' ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2360:1: (otherlv_0= 'addAttribute' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= rulePrimitiveType ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ',' ( (lv_defaultValue_10_0= ruleEString ) ) otherlv_11= ')' )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2360:1: (otherlv_0= 'addAttribute' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= rulePrimitiveType ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ',' ( (lv_defaultValue_10_0= ruleEString ) ) otherlv_11= ')' )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2360:3: otherlv_0= 'addAttribute' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= rulePrimitiveType ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ',' ( (lv_defaultValue_10_0= ruleEString ) ) otherlv_11= ')'
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleAddAttribute4978); 

                	newLeafNode(otherlv_0, grammarAccess.getAddAttributeAccess().getAddAttributeKeyword_0());
                
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAddAttribute4990); 

                	newLeafNode(otherlv_1, grammarAccess.getAddAttributeAccess().getLeftParenthesisKeyword_1());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2368:1: ( (lv_name_2_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2369:1: (lv_name_2_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2369:1: (lv_name_2_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2370:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddAttributeAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddAttribute5011);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddAttribute5023); 

                	newLeafNode(otherlv_3, grammarAccess.getAddAttributeAccess().getCommaKeyword_3());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2390:1: ( (lv_type_4_0= rulePrimitiveType ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2391:1: (lv_type_4_0= rulePrimitiveType )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2391:1: (lv_type_4_0= rulePrimitiveType )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2392:3: lv_type_4_0= rulePrimitiveType
            {
             
            	        newCompositeNode(grammarAccess.getAddAttributeAccess().getTypePrimitiveTypeParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveType_in_ruleAddAttribute5044);
            lv_type_4_0=rulePrimitiveType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_4_0, 
                    		"PrimitiveType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddAttribute5056); 

                	newLeafNode(otherlv_5, grammarAccess.getAddAttributeAccess().getCommaKeyword_5());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2412:1: ( (lv_lower_6_0= ruleEInt ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2413:1: (lv_lower_6_0= ruleEInt )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2413:1: (lv_lower_6_0= ruleEInt )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2414:3: lv_lower_6_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getAddAttributeAccess().getLowerEIntParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleAddAttribute5077);
            lv_lower_6_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"lower",
                    		lv_lower_6_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddAttribute5089); 

                	newLeafNode(otherlv_7, grammarAccess.getAddAttributeAccess().getCommaKeyword_7());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2434:1: ( (lv_upper_8_0= ruleEInt ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2435:1: (lv_upper_8_0= ruleEInt )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2435:1: (lv_upper_8_0= ruleEInt )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2436:3: lv_upper_8_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getAddAttributeAccess().getUpperEIntParserRuleCall_8_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleAddAttribute5110);
            lv_upper_8_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"upper",
                    		lv_upper_8_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_9=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddAttribute5122); 

                	newLeafNode(otherlv_9, grammarAccess.getAddAttributeAccess().getCommaKeyword_9());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2456:1: ( (lv_defaultValue_10_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2457:1: (lv_defaultValue_10_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2457:1: (lv_defaultValue_10_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2458:3: lv_defaultValue_10_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddAttributeAccess().getDefaultValueEStringParserRuleCall_10_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddAttribute5143);
            lv_defaultValue_10_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"defaultValue",
                    		lv_defaultValue_10_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAddAttribute5155); 

                	newLeafNode(otherlv_11, grammarAccess.getAddAttributeAccess().getRightParenthesisKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddAttribute"


    // $ANTLR start "entryRuleAddReference"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2486:1: entryRuleAddReference returns [EObject current=null] : iv_ruleAddReference= ruleAddReference EOF ;
    public final EObject entryRuleAddReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddReference = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2487:2: (iv_ruleAddReference= ruleAddReference EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2488:2: iv_ruleAddReference= ruleAddReference EOF
            {
             newCompositeNode(grammarAccess.getAddReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddReference_in_entryRuleAddReference5191);
            iv_ruleAddReference=ruleAddReference();

            state._fsp--;

             current =iv_ruleAddReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddReference5201); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddReference"


    // $ANTLR start "ruleAddReference"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2495:1: ruleAddReference returns [EObject current=null] : (otherlv_0= 'addReference' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ')' ) ;
    public final EObject ruleAddReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_type_4_0 = null;

        AntlrDatatypeRuleToken lv_lower_6_0 = null;

        AntlrDatatypeRuleToken lv_upper_8_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2498:28: ( (otherlv_0= 'addReference' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ')' ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2499:1: (otherlv_0= 'addReference' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ')' )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2499:1: (otherlv_0= 'addReference' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ')' )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2499:3: otherlv_0= 'addReference' otherlv_1= '(' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ',' ( (lv_type_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_lower_6_0= ruleEInt ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleEInt ) ) otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleAddReference5238); 

                	newLeafNode(otherlv_0, grammarAccess.getAddReferenceAccess().getAddReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAddReference5250); 

                	newLeafNode(otherlv_1, grammarAccess.getAddReferenceAccess().getLeftParenthesisKeyword_1());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2507:1: ( (lv_name_2_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2508:1: (lv_name_2_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2508:1: (lv_name_2_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2509:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddReferenceAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddReference5271);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddReferenceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddReference5283); 

                	newLeafNode(otherlv_3, grammarAccess.getAddReferenceAccess().getCommaKeyword_3());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2529:1: ( (lv_type_4_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2530:1: (lv_type_4_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2530:1: (lv_type_4_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2531:3: lv_type_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddReferenceAccess().getTypeEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddReference5304);
            lv_type_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddReferenceRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddReference5316); 

                	newLeafNode(otherlv_5, grammarAccess.getAddReferenceAccess().getCommaKeyword_5());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2551:1: ( (lv_lower_6_0= ruleEInt ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2552:1: (lv_lower_6_0= ruleEInt )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2552:1: (lv_lower_6_0= ruleEInt )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2553:3: lv_lower_6_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getAddReferenceAccess().getLowerEIntParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleAddReference5337);
            lv_lower_6_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddReferenceRule());
            	        }
                   		set(
                   			current, 
                   			"lower",
                    		lv_lower_6_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddReference5349); 

                	newLeafNode(otherlv_7, grammarAccess.getAddReferenceAccess().getCommaKeyword_7());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2573:1: ( (lv_upper_8_0= ruleEInt ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2574:1: (lv_upper_8_0= ruleEInt )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2574:1: (lv_upper_8_0= ruleEInt )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2575:3: lv_upper_8_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getAddReferenceAccess().getUpperEIntParserRuleCall_8_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleAddReference5370);
            lv_upper_8_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddReferenceRule());
            	        }
                   		set(
                   			current, 
                   			"upper",
                    		lv_upper_8_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_9=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAddReference5382); 

                	newLeafNode(otherlv_9, grammarAccess.getAddReferenceAccess().getRightParenthesisKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddReference"


    // $ANTLR start "entryRuleStructuralFeatureModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2603:1: entryRuleStructuralFeatureModification returns [EObject current=null] : iv_ruleStructuralFeatureModification= ruleStructuralFeatureModification EOF ;
    public final EObject entryRuleStructuralFeatureModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuralFeatureModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2604:2: (iv_ruleStructuralFeatureModification= ruleStructuralFeatureModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2605:2: iv_ruleStructuralFeatureModification= ruleStructuralFeatureModification EOF
            {
             newCompositeNode(grammarAccess.getStructuralFeatureModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStructuralFeatureModification_in_entryRuleStructuralFeatureModification5418);
            iv_ruleStructuralFeatureModification=ruleStructuralFeatureModification();

            state._fsp--;

             current =iv_ruleStructuralFeatureModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStructuralFeatureModification5428); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructuralFeatureModification"


    // $ANTLR start "ruleStructuralFeatureModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2612:1: ruleStructuralFeatureModification returns [EObject current=null] : (this_AttributeModification_0= ruleAttributeModification | this_ReferenceModification_1= ruleReferenceModification ) ;
    public final EObject ruleStructuralFeatureModification() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeModification_0 = null;

        EObject this_ReferenceModification_1 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2615:28: ( (this_AttributeModification_0= ruleAttributeModification | this_ReferenceModification_1= ruleReferenceModification ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2616:1: (this_AttributeModification_0= ruleAttributeModification | this_ReferenceModification_1= ruleReferenceModification )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2616:1: (this_AttributeModification_0= ruleAttributeModification | this_ReferenceModification_1= ruleReferenceModification )
            int alt66=2;
            switch ( input.LA(1) ) {
            case 19:
                {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==48) ) {
                    alt66=1;
                }
                else if ( (LA66_1==50) ) {
                    alt66=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 1, input);

                    throw nvae;
                }
                }
                break;
            case 48:
                {
                alt66=1;
                }
                break;
            case 50:
                {
                alt66=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2617:5: this_AttributeModification_0= ruleAttributeModification
                    {
                     
                            newCompositeNode(grammarAccess.getStructuralFeatureModificationAccess().getAttributeModificationParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeModification_in_ruleStructuralFeatureModification5475);
                    this_AttributeModification_0=ruleAttributeModification();

                    state._fsp--;

                     
                            current = this_AttributeModification_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2627:5: this_ReferenceModification_1= ruleReferenceModification
                    {
                     
                            newCompositeNode(grammarAccess.getStructuralFeatureModificationAccess().getReferenceModificationParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceModification_in_ruleStructuralFeatureModification5502);
                    this_ReferenceModification_1=ruleReferenceModification();

                    state._fsp--;

                     
                            current = this_ReferenceModification_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructuralFeatureModification"


    // $ANTLR start "entryRuleChangeBounds"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2643:1: entryRuleChangeBounds returns [EObject current=null] : iv_ruleChangeBounds= ruleChangeBounds EOF ;
    public final EObject entryRuleChangeBounds() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChangeBounds = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2644:2: (iv_ruleChangeBounds= ruleChangeBounds EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2645:2: iv_ruleChangeBounds= ruleChangeBounds EOF
            {
             newCompositeNode(grammarAccess.getChangeBoundsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChangeBounds_in_entryRuleChangeBounds5537);
            iv_ruleChangeBounds=ruleChangeBounds();

            state._fsp--;

             current =iv_ruleChangeBounds; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChangeBounds5547); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChangeBounds"


    // $ANTLR start "ruleChangeBounds"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2652:1: ruleChangeBounds returns [EObject current=null] : ( () otherlv_1= 'bounds' otherlv_2= '(' ( (lv_oldLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oldUpper_5_0= ruleEInt ) ) otherlv_6= ')' (otherlv_7= 'to' otherlv_8= '(' ( (lv_newLower_9_0= ruleEInt ) ) otherlv_10= ',' ( (lv_newUpper_11_0= ruleEInt ) ) otherlv_12= ')' )? ) ;
    public final EObject ruleChangeBounds() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_oldLower_3_0 = null;

        AntlrDatatypeRuleToken lv_oldUpper_5_0 = null;

        AntlrDatatypeRuleToken lv_newLower_9_0 = null;

        AntlrDatatypeRuleToken lv_newUpper_11_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2655:28: ( ( () otherlv_1= 'bounds' otherlv_2= '(' ( (lv_oldLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oldUpper_5_0= ruleEInt ) ) otherlv_6= ')' (otherlv_7= 'to' otherlv_8= '(' ( (lv_newLower_9_0= ruleEInt ) ) otherlv_10= ',' ( (lv_newUpper_11_0= ruleEInt ) ) otherlv_12= ')' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2656:1: ( () otherlv_1= 'bounds' otherlv_2= '(' ( (lv_oldLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oldUpper_5_0= ruleEInt ) ) otherlv_6= ')' (otherlv_7= 'to' otherlv_8= '(' ( (lv_newLower_9_0= ruleEInt ) ) otherlv_10= ',' ( (lv_newUpper_11_0= ruleEInt ) ) otherlv_12= ')' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2656:1: ( () otherlv_1= 'bounds' otherlv_2= '(' ( (lv_oldLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oldUpper_5_0= ruleEInt ) ) otherlv_6= ')' (otherlv_7= 'to' otherlv_8= '(' ( (lv_newLower_9_0= ruleEInt ) ) otherlv_10= ',' ( (lv_newUpper_11_0= ruleEInt ) ) otherlv_12= ')' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2656:2: () otherlv_1= 'bounds' otherlv_2= '(' ( (lv_oldLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oldUpper_5_0= ruleEInt ) ) otherlv_6= ')' (otherlv_7= 'to' otherlv_8= '(' ( (lv_newLower_9_0= ruleEInt ) ) otherlv_10= ',' ( (lv_newUpper_11_0= ruleEInt ) ) otherlv_12= ')' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2656:2: ()
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2657:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getChangeBoundsAccess().getChangeBoundsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleChangeBounds5593); 

                	newLeafNode(otherlv_1, grammarAccess.getChangeBoundsAccess().getBoundsKeyword_1());
                
            otherlv_2=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleChangeBounds5605); 

                	newLeafNode(otherlv_2, grammarAccess.getChangeBoundsAccess().getLeftParenthesisKeyword_2());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2670:1: ( (lv_oldLower_3_0= ruleEInt ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2671:1: (lv_oldLower_3_0= ruleEInt )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2671:1: (lv_oldLower_3_0= ruleEInt )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2672:3: lv_oldLower_3_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getChangeBoundsAccess().getOldLowerEIntParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleChangeBounds5626);
            lv_oldLower_3_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getChangeBoundsRule());
            	        }
                   		set(
                   			current, 
                   			"oldLower",
                    		lv_oldLower_3_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleChangeBounds5638); 

                	newLeafNode(otherlv_4, grammarAccess.getChangeBoundsAccess().getCommaKeyword_4());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2692:1: ( (lv_oldUpper_5_0= ruleEInt ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2693:1: (lv_oldUpper_5_0= ruleEInt )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2693:1: (lv_oldUpper_5_0= ruleEInt )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2694:3: lv_oldUpper_5_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getChangeBoundsAccess().getOldUpperEIntParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleChangeBounds5659);
            lv_oldUpper_5_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getChangeBoundsRule());
            	        }
                   		set(
                   			current, 
                   			"oldUpper",
                    		lv_oldUpper_5_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleChangeBounds5671); 

                	newLeafNode(otherlv_6, grammarAccess.getChangeBoundsAccess().getRightParenthesisKeyword_6());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2714:1: (otherlv_7= 'to' otherlv_8= '(' ( (lv_newLower_9_0= ruleEInt ) ) otherlv_10= ',' ( (lv_newUpper_11_0= ruleEInt ) ) otherlv_12= ')' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==21) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2714:3: otherlv_7= 'to' otherlv_8= '(' ( (lv_newLower_9_0= ruleEInt ) ) otherlv_10= ',' ( (lv_newUpper_11_0= ruleEInt ) ) otherlv_12= ')'
                    {
                    otherlv_7=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleChangeBounds5684); 

                        	newLeafNode(otherlv_7, grammarAccess.getChangeBoundsAccess().getToKeyword_7_0());
                        
                    otherlv_8=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleChangeBounds5696); 

                        	newLeafNode(otherlv_8, grammarAccess.getChangeBoundsAccess().getLeftParenthesisKeyword_7_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2722:1: ( (lv_newLower_9_0= ruleEInt ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2723:1: (lv_newLower_9_0= ruleEInt )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2723:1: (lv_newLower_9_0= ruleEInt )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2724:3: lv_newLower_9_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getChangeBoundsAccess().getNewLowerEIntParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleChangeBounds5717);
                    lv_newLower_9_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getChangeBoundsRule());
                    	        }
                           		set(
                           			current, 
                           			"newLower",
                            		lv_newLower_9_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleChangeBounds5729); 

                        	newLeafNode(otherlv_10, grammarAccess.getChangeBoundsAccess().getCommaKeyword_7_3());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2744:1: ( (lv_newUpper_11_0= ruleEInt ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2745:1: (lv_newUpper_11_0= ruleEInt )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2745:1: (lv_newUpper_11_0= ruleEInt )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2746:3: lv_newUpper_11_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getChangeBoundsAccess().getNewUpperEIntParserRuleCall_7_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleChangeBounds5750);
                    lv_newUpper_11_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getChangeBoundsRule());
                    	        }
                           		set(
                           			current, 
                           			"newUpper",
                            		lv_newUpper_11_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleChangeBounds5762); 

                        	newLeafNode(otherlv_12, grammarAccess.getChangeBoundsAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChangeBounds"


    // $ANTLR start "entryRuleAttributeModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2774:1: entryRuleAttributeModification returns [EObject current=null] : iv_ruleAttributeModification= ruleAttributeModification EOF ;
    public final EObject entryRuleAttributeModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2775:2: (iv_ruleAttributeModification= ruleAttributeModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2776:2: iv_ruleAttributeModification= ruleAttributeModification EOF
            {
             newCompositeNode(grammarAccess.getAttributeModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeModification_in_entryRuleAttributeModification5800);
            iv_ruleAttributeModification=ruleAttributeModification();

            state._fsp--;

             current =iv_ruleAttributeModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeModification5810); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeModification"


    // $ANTLR start "ruleAttributeModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2783:1: ruleAttributeModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'att' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( ( (lv_changeType_6_0= 'changeType' ) ) otherlv_7= 'to' ( (lv_newType_8_0= rulePrimitiveType ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= 'annotation' otherlv_11= '{' ( (lv_annotationModification_12_0= ruleAnnotationModification ) ) (otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) ) )* otherlv_15= '}' )? ) ;
    public final EObject ruleAttributeModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_changeType_6_0=null;
        Token otherlv_7=null;
        Token lv_removeEAnnotations_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_oldName_2_0 = null;

        AntlrDatatypeRuleToken lv_newName_4_0 = null;

        EObject lv_changeBounds_5_0 = null;

        AntlrDatatypeRuleToken lv_newType_8_0 = null;

        EObject lv_annotationModification_12_0 = null;

        EObject lv_annotationModification_14_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2786:28: ( ( ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'att' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( ( (lv_changeType_6_0= 'changeType' ) ) otherlv_7= 'to' ( (lv_newType_8_0= rulePrimitiveType ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= 'annotation' otherlv_11= '{' ( (lv_annotationModification_12_0= ruleAnnotationModification ) ) (otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) ) )* otherlv_15= '}' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2787:1: ( ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'att' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( ( (lv_changeType_6_0= 'changeType' ) ) otherlv_7= 'to' ( (lv_newType_8_0= rulePrimitiveType ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= 'annotation' otherlv_11= '{' ( (lv_annotationModification_12_0= ruleAnnotationModification ) ) (otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) ) )* otherlv_15= '}' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2787:1: ( ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'att' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( ( (lv_changeType_6_0= 'changeType' ) ) otherlv_7= 'to' ( (lv_newType_8_0= rulePrimitiveType ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= 'annotation' otherlv_11= '{' ( (lv_annotationModification_12_0= ruleAnnotationModification ) ) (otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) ) )* otherlv_15= '}' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2787:2: ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'att' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( ( (lv_changeType_6_0= 'changeType' ) ) otherlv_7= 'to' ( (lv_newType_8_0= rulePrimitiveType ) ) )? ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )? (otherlv_10= 'annotation' otherlv_11= '{' ( (lv_annotationModification_12_0= ruleAnnotationModification ) ) (otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) ) )* otherlv_15= '}' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2787:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==19) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2788:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2788:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2789:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAttributeModification5853); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getAttributeModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleAttributeModification5879); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeModificationAccess().getAttKeyword_1());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2806:1: ( (lv_oldName_2_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2807:1: (lv_oldName_2_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2807:1: (lv_oldName_2_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2808:3: lv_oldName_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAttributeModificationAccess().getOldNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAttributeModification5900);
            lv_oldName_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldName",
                    		lv_oldName_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2824:2: (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==21) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2824:4: otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAttributeModification5913); 

                        	newLeafNode(otherlv_3, grammarAccess.getAttributeModificationAccess().getToKeyword_3_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2828:1: ( (lv_newName_4_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2829:1: (lv_newName_4_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2829:1: (lv_newName_4_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2830:3: lv_newName_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeModificationAccess().getNewNameEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAttributeModification5934);
                    lv_newName_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newName",
                            		lv_newName_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2846:4: ( (lv_changeBounds_5_0= ruleChangeBounds ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==47) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2847:1: (lv_changeBounds_5_0= ruleChangeBounds )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2847:1: (lv_changeBounds_5_0= ruleChangeBounds )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2848:3: lv_changeBounds_5_0= ruleChangeBounds
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeModificationAccess().getChangeBoundsChangeBoundsParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChangeBounds_in_ruleAttributeModification5957);
                    lv_changeBounds_5_0=ruleChangeBounds();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"changeBounds",
                            		lv_changeBounds_5_0, 
                            		"ChangeBounds");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2864:3: ( ( (lv_changeType_6_0= 'changeType' ) ) otherlv_7= 'to' ( (lv_newType_8_0= rulePrimitiveType ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==49) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2864:4: ( (lv_changeType_6_0= 'changeType' ) ) otherlv_7= 'to' ( (lv_newType_8_0= rulePrimitiveType ) )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2864:4: ( (lv_changeType_6_0= 'changeType' ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2865:1: (lv_changeType_6_0= 'changeType' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2865:1: (lv_changeType_6_0= 'changeType' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2866:3: lv_changeType_6_0= 'changeType'
                    {
                    lv_changeType_6_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleAttributeModification5977); 

                            newLeafNode(lv_changeType_6_0, grammarAccess.getAttributeModificationAccess().getChangeTypeChangeTypeKeyword_5_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeModificationRule());
                    	        }
                           		setWithLastConsumed(current, "changeType", true, "changeType");
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAttributeModification6002); 

                        	newLeafNode(otherlv_7, grammarAccess.getAttributeModificationAccess().getToKeyword_5_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2883:1: ( (lv_newType_8_0= rulePrimitiveType ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2884:1: (lv_newType_8_0= rulePrimitiveType )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2884:1: (lv_newType_8_0= rulePrimitiveType )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2885:3: lv_newType_8_0= rulePrimitiveType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeModificationAccess().getNewTypePrimitiveTypeParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveType_in_ruleAttributeModification6023);
                    lv_newType_8_0=rulePrimitiveType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newType",
                            		lv_newType_8_0, 
                            		"PrimitiveType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2901:4: ( (lv_removeEAnnotations_9_0= 'removeEAnnotations' ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==24) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2902:1: (lv_removeEAnnotations_9_0= 'removeEAnnotations' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2902:1: (lv_removeEAnnotations_9_0= 'removeEAnnotations' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2903:3: lv_removeEAnnotations_9_0= 'removeEAnnotations'
                    {
                    lv_removeEAnnotations_9_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAttributeModification6043); 

                            newLeafNode(lv_removeEAnnotations_9_0, grammarAccess.getAttributeModificationAccess().getRemoveEAnnotationsRemoveEAnnotationsKeyword_6_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeModificationRule());
                    	        }
                           		setWithLastConsumed(current, "removeEAnnotations", true, "removeEAnnotations");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2916:3: (otherlv_10= 'annotation' otherlv_11= '{' ( (lv_annotationModification_12_0= ruleAnnotationModification ) ) (otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) ) )* otherlv_15= '}' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==32) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2916:5: otherlv_10= 'annotation' otherlv_11= '{' ( (lv_annotationModification_12_0= ruleAnnotationModification ) ) (otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) ) )* otherlv_15= '}'
                    {
                    otherlv_10=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAttributeModification6070); 

                        	newLeafNode(otherlv_10, grammarAccess.getAttributeModificationAccess().getAnnotationKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAttributeModification6082); 

                        	newLeafNode(otherlv_11, grammarAccess.getAttributeModificationAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2924:1: ( (lv_annotationModification_12_0= ruleAnnotationModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2925:1: (lv_annotationModification_12_0= ruleAnnotationModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2925:1: (lv_annotationModification_12_0= ruleAnnotationModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2926:3: lv_annotationModification_12_0= ruleAnnotationModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleAttributeModification6103);
                    lv_annotationModification_12_0=ruleAnnotationModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"annotationModification",
                            		lv_annotationModification_12_0, 
                            		"AnnotationModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2942:2: (otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==27) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2942:4: otherlv_13= ';' ( (lv_annotationModification_14_0= ruleAnnotationModification ) )
                    	    {
                    	    otherlv_13=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAttributeModification6116); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getAttributeModificationAccess().getSemicolonKeyword_7_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2946:1: ( (lv_annotationModification_14_0= ruleAnnotationModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2947:1: (lv_annotationModification_14_0= ruleAnnotationModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2947:1: (lv_annotationModification_14_0= ruleAnnotationModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2948:3: lv_annotationModification_14_0= ruleAnnotationModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttributeModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_7_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleAttributeModification6137);
                    	    lv_annotationModification_14_0=ruleAnnotationModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttributeModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotationModification",
                    	            		lv_annotationModification_14_0, 
                    	            		"AnnotationModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAttributeModification6151); 

                        	newLeafNode(otherlv_15, grammarAccess.getAttributeModificationAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeModification"


    // $ANTLR start "entryRuleReferenceModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2976:1: entryRuleReferenceModification returns [EObject current=null] : iv_ruleReferenceModification= ruleReferenceModification EOF ;
    public final EObject entryRuleReferenceModification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceModification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2977:2: (iv_ruleReferenceModification= ruleReferenceModification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2978:2: iv_ruleReferenceModification= ruleReferenceModification EOF
            {
             newCompositeNode(grammarAccess.getReferenceModificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceModification_in_entryRuleReferenceModification6189);
            iv_ruleReferenceModification=ruleReferenceModification();

            state._fsp--;

             current =iv_ruleReferenceModification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceModification6199); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceModification"


    // $ANTLR start "ruleReferenceModification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2985:1: ruleReferenceModification returns [EObject current=null] : ( ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'ref' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( (lv_changeContainement_6_0= 'changeContainement' ) )? ( (lv_removeOpposite_7_0= 'removeOpposite' ) )? (otherlv_8= 'addOpposite' ( (lv_addOpposite_9_0= ruleAddOpposite ) ) )? (otherlv_10= 'reify' ( (lv_reify_11_0= ruleReferenceReification ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )? ) ;
    public final EObject ruleReferenceModification() throws RecognitionException {
        EObject current = null;

        Token lv_remove_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_changeContainement_6_0=null;
        Token lv_removeOpposite_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_removeEAnnotations_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_oldName_2_0 = null;

        AntlrDatatypeRuleToken lv_newName_4_0 = null;

        EObject lv_changeBounds_5_0 = null;

        EObject lv_addOpposite_9_0 = null;

        EObject lv_reify_11_0 = null;

        EObject lv_annotationModification_15_0 = null;

        EObject lv_annotationModification_17_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2988:28: ( ( ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'ref' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( (lv_changeContainement_6_0= 'changeContainement' ) )? ( (lv_removeOpposite_7_0= 'removeOpposite' ) )? (otherlv_8= 'addOpposite' ( (lv_addOpposite_9_0= ruleAddOpposite ) ) )? (otherlv_10= 'reify' ( (lv_reify_11_0= ruleReferenceReification ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )? ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2989:1: ( ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'ref' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( (lv_changeContainement_6_0= 'changeContainement' ) )? ( (lv_removeOpposite_7_0= 'removeOpposite' ) )? (otherlv_8= 'addOpposite' ( (lv_addOpposite_9_0= ruleAddOpposite ) ) )? (otherlv_10= 'reify' ( (lv_reify_11_0= ruleReferenceReification ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )? )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2989:1: ( ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'ref' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( (lv_changeContainement_6_0= 'changeContainement' ) )? ( (lv_removeOpposite_7_0= 'removeOpposite' ) )? (otherlv_8= 'addOpposite' ( (lv_addOpposite_9_0= ruleAddOpposite ) ) )? (otherlv_10= 'reify' ( (lv_reify_11_0= ruleReferenceReification ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )? )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2989:2: ( (lv_remove_0_0= 'remove' ) )? otherlv_1= 'ref' ( (lv_oldName_2_0= ruleEString ) ) (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )? ( (lv_changeBounds_5_0= ruleChangeBounds ) )? ( (lv_changeContainement_6_0= 'changeContainement' ) )? ( (lv_removeOpposite_7_0= 'removeOpposite' ) )? (otherlv_8= 'addOpposite' ( (lv_addOpposite_9_0= ruleAddOpposite ) ) )? (otherlv_10= 'reify' ( (lv_reify_11_0= ruleReferenceReification ) ) )? ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )? (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )?
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2989:2: ( (lv_remove_0_0= 'remove' ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==19) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2990:1: (lv_remove_0_0= 'remove' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2990:1: (lv_remove_0_0= 'remove' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:2991:3: lv_remove_0_0= 'remove'
                    {
                    lv_remove_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferenceModification6242); 

                            newLeafNode(lv_remove_0_0, grammarAccess.getReferenceModificationAccess().getRemoveRemoveKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceModificationRule());
                    	        }
                           		setWithLastConsumed(current, "remove", true, "remove");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleReferenceModification6268); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceModificationAccess().getRefKeyword_1());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3008:1: ( (lv_oldName_2_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3009:1: (lv_oldName_2_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3009:1: (lv_oldName_2_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3010:3: lv_oldName_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReferenceModificationAccess().getOldNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReferenceModification6289);
            lv_oldName_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceModificationRule());
            	        }
                   		set(
                   			current, 
                   			"oldName",
                    		lv_oldName_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3026:2: (otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==21) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3026:4: otherlv_3= 'to' ( (lv_newName_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReferenceModification6302); 

                        	newLeafNode(otherlv_3, grammarAccess.getReferenceModificationAccess().getToKeyword_3_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3030:1: ( (lv_newName_4_0= ruleEString ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3031:1: (lv_newName_4_0= ruleEString )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3031:1: (lv_newName_4_0= ruleEString )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3032:3: lv_newName_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceModificationAccess().getNewNameEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReferenceModification6323);
                    lv_newName_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"newName",
                            		lv_newName_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3048:4: ( (lv_changeBounds_5_0= ruleChangeBounds ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==47) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3049:1: (lv_changeBounds_5_0= ruleChangeBounds )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3049:1: (lv_changeBounds_5_0= ruleChangeBounds )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3050:3: lv_changeBounds_5_0= ruleChangeBounds
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceModificationAccess().getChangeBoundsChangeBoundsParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChangeBounds_in_ruleReferenceModification6346);
                    lv_changeBounds_5_0=ruleChangeBounds();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"changeBounds",
                            		lv_changeBounds_5_0, 
                            		"ChangeBounds");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3066:3: ( (lv_changeContainement_6_0= 'changeContainement' ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==51) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3067:1: (lv_changeContainement_6_0= 'changeContainement' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3067:1: (lv_changeContainement_6_0= 'changeContainement' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3068:3: lv_changeContainement_6_0= 'changeContainement'
                    {
                    lv_changeContainement_6_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleReferenceModification6365); 

                            newLeafNode(lv_changeContainement_6_0, grammarAccess.getReferenceModificationAccess().getChangeContainementChangeContainementKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceModificationRule());
                    	        }
                           		setWithLastConsumed(current, "changeContainement", true, "changeContainement");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3081:3: ( (lv_removeOpposite_7_0= 'removeOpposite' ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==52) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3082:1: (lv_removeOpposite_7_0= 'removeOpposite' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3082:1: (lv_removeOpposite_7_0= 'removeOpposite' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3083:3: lv_removeOpposite_7_0= 'removeOpposite'
                    {
                    lv_removeOpposite_7_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleReferenceModification6397); 

                            newLeafNode(lv_removeOpposite_7_0, grammarAccess.getReferenceModificationAccess().getRemoveOppositeRemoveOppositeKeyword_6_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceModificationRule());
                    	        }
                           		setWithLastConsumed(current, "removeOpposite", true, "removeOpposite");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3096:3: (otherlv_8= 'addOpposite' ( (lv_addOpposite_9_0= ruleAddOpposite ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==53) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3096:5: otherlv_8= 'addOpposite' ( (lv_addOpposite_9_0= ruleAddOpposite ) )
                    {
                    otherlv_8=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleReferenceModification6424); 

                        	newLeafNode(otherlv_8, grammarAccess.getReferenceModificationAccess().getAddOppositeKeyword_7_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3100:1: ( (lv_addOpposite_9_0= ruleAddOpposite ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3101:1: (lv_addOpposite_9_0= ruleAddOpposite )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3101:1: (lv_addOpposite_9_0= ruleAddOpposite )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3102:3: lv_addOpposite_9_0= ruleAddOpposite
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceModificationAccess().getAddOppositeAddOppositeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAddOpposite_in_ruleReferenceModification6445);
                    lv_addOpposite_9_0=ruleAddOpposite();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"addOpposite",
                            		lv_addOpposite_9_0, 
                            		"AddOpposite");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3118:4: (otherlv_10= 'reify' ( (lv_reify_11_0= ruleReferenceReification ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==41) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3118:6: otherlv_10= 'reify' ( (lv_reify_11_0= ruleReferenceReification ) )
                    {
                    otherlv_10=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleReferenceModification6460); 

                        	newLeafNode(otherlv_10, grammarAccess.getReferenceModificationAccess().getReifyKeyword_8_0());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3122:1: ( (lv_reify_11_0= ruleReferenceReification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3123:1: (lv_reify_11_0= ruleReferenceReification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3123:1: (lv_reify_11_0= ruleReferenceReification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3124:3: lv_reify_11_0= ruleReferenceReification
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceModificationAccess().getReifyReferenceReificationParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceReification_in_ruleReferenceModification6481);
                    lv_reify_11_0=ruleReferenceReification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceModificationRule());
                    	        }
                           		set(
                           			current, 
                           			"reify",
                            		lv_reify_11_0, 
                            		"ReferenceReification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3140:4: ( (lv_removeEAnnotations_12_0= 'removeEAnnotations' ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==24) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3141:1: (lv_removeEAnnotations_12_0= 'removeEAnnotations' )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3141:1: (lv_removeEAnnotations_12_0= 'removeEAnnotations' )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3142:3: lv_removeEAnnotations_12_0= 'removeEAnnotations'
                    {
                    lv_removeEAnnotations_12_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleReferenceModification6501); 

                            newLeafNode(lv_removeEAnnotations_12_0, grammarAccess.getReferenceModificationAccess().getRemoveEAnnotationsRemoveEAnnotationsKeyword_9_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceModificationRule());
                    	        }
                           		setWithLastConsumed(current, "removeEAnnotations", true, "removeEAnnotations");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3155:3: (otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==32) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3155:5: otherlv_13= 'annotation' otherlv_14= '{' ( (lv_annotationModification_15_0= ruleAnnotationModification ) ) (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )* otherlv_18= '}'
                    {
                    otherlv_13=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleReferenceModification6528); 

                        	newLeafNode(otherlv_13, grammarAccess.getReferenceModificationAccess().getAnnotationKeyword_10_0());
                        
                    otherlv_14=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleReferenceModification6540); 

                        	newLeafNode(otherlv_14, grammarAccess.getReferenceModificationAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3163:1: ( (lv_annotationModification_15_0= ruleAnnotationModification ) )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3164:1: (lv_annotationModification_15_0= ruleAnnotationModification )
                    {
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3164:1: (lv_annotationModification_15_0= ruleAnnotationModification )
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3165:3: lv_annotationModification_15_0= ruleAnnotationModification
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleReferenceModification6561);
                    lv_annotationModification_15_0=ruleAnnotationModification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceModificationRule());
                    	        }
                           		add(
                           			current, 
                           			"annotationModification",
                            		lv_annotationModification_15_0, 
                            		"AnnotationModification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3181:2: (otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==27) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3181:4: otherlv_16= ';' ( (lv_annotationModification_17_0= ruleAnnotationModification ) )
                    	    {
                    	    otherlv_16=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleReferenceModification6574); 

                    	        	newLeafNode(otherlv_16, grammarAccess.getReferenceModificationAccess().getSemicolonKeyword_10_3_0());
                    	        
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3185:1: ( (lv_annotationModification_17_0= ruleAnnotationModification ) )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3186:1: (lv_annotationModification_17_0= ruleAnnotationModification )
                    	    {
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3186:1: (lv_annotationModification_17_0= ruleAnnotationModification )
                    	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3187:3: lv_annotationModification_17_0= ruleAnnotationModification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReferenceModificationAccess().getAnnotationModificationAnnotationModificationParserRuleCall_10_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnnotationModification_in_ruleReferenceModification6595);
                    	    lv_annotationModification_17_0=ruleAnnotationModification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReferenceModificationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotationModification",
                    	            		lv_annotationModification_17_0, 
                    	            		"AnnotationModification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleReferenceModification6609); 

                        	newLeafNode(otherlv_18, grammarAccess.getReferenceModificationAccess().getRightCurlyBracketKeyword_10_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceModification"


    // $ANTLR start "entryRulePrimitiveType"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3215:1: entryRulePrimitiveType returns [String current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final String entryRulePrimitiveType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveType = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3216:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3217:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType6648);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveType6659); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3224:1: rulePrimitiveType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'int' | kw= 'string' | kw= 'boolean' | kw= 'char' | kw= 'float' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3227:28: ( (kw= 'int' | kw= 'string' | kw= 'boolean' | kw= 'char' | kw= 'float' ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3228:1: (kw= 'int' | kw= 'string' | kw= 'boolean' | kw= 'char' | kw= 'float' )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3228:1: (kw= 'int' | kw= 'string' | kw= 'boolean' | kw= 'char' | kw= 'float' )
            int alt85=5;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt85=1;
                }
                break;
            case 55:
                {
                alt85=2;
                }
                break;
            case 56:
                {
                alt85=3;
                }
                break;
            case 57:
                {
                alt85=4;
                }
                break;
            case 58:
                {
                alt85=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3229:2: kw= 'int'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_54_in_rulePrimitiveType6697); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3236:2: kw= 'string'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_rulePrimitiveType6716); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3243:2: kw= 'boolean'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_rulePrimitiveType6735); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3250:2: kw= 'char'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_rulePrimitiveType6754); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3257:2: kw= 'float'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveType6773); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_4()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleAddOpposite"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3270:1: entryRuleAddOpposite returns [EObject current=null] : iv_ruleAddOpposite= ruleAddOpposite EOF ;
    public final EObject entryRuleAddOpposite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOpposite = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3271:2: (iv_ruleAddOpposite= ruleAddOpposite EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3272:2: iv_ruleAddOpposite= ruleAddOpposite EOF
            {
             newCompositeNode(grammarAccess.getAddOppositeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddOpposite_in_entryRuleAddOpposite6813);
            iv_ruleAddOpposite=ruleAddOpposite();

            state._fsp--;

             current =iv_ruleAddOpposite; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddOpposite6823); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddOpposite"


    // $ANTLR start "ruleAddOpposite"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3279:1: ruleAddOpposite returns [EObject current=null] : (otherlv_0= '(' ( (lv_oppositeName_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_oppositeLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oppositeUpper_5_0= ruleEInt ) ) otherlv_6= ')' ) ;
    public final EObject ruleAddOpposite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_oppositeName_1_0 = null;

        AntlrDatatypeRuleToken lv_oppositeLower_3_0 = null;

        AntlrDatatypeRuleToken lv_oppositeUpper_5_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3282:28: ( (otherlv_0= '(' ( (lv_oppositeName_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_oppositeLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oppositeUpper_5_0= ruleEInt ) ) otherlv_6= ')' ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3283:1: (otherlv_0= '(' ( (lv_oppositeName_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_oppositeLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oppositeUpper_5_0= ruleEInt ) ) otherlv_6= ')' )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3283:1: (otherlv_0= '(' ( (lv_oppositeName_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_oppositeLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oppositeUpper_5_0= ruleEInt ) ) otherlv_6= ')' )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3283:3: otherlv_0= '(' ( (lv_oppositeName_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_oppositeLower_3_0= ruleEInt ) ) otherlv_4= ',' ( (lv_oppositeUpper_5_0= ruleEInt ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAddOpposite6860); 

                	newLeafNode(otherlv_0, grammarAccess.getAddOppositeAccess().getLeftParenthesisKeyword_0());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3287:1: ( (lv_oppositeName_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3288:1: (lv_oppositeName_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3288:1: (lv_oppositeName_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3289:3: lv_oppositeName_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddOppositeAccess().getOppositeNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddOpposite6881);
            lv_oppositeName_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddOppositeRule());
            	        }
                   		set(
                   			current, 
                   			"oppositeName",
                    		lv_oppositeName_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddOpposite6893); 

                	newLeafNode(otherlv_2, grammarAccess.getAddOppositeAccess().getCommaKeyword_2());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3309:1: ( (lv_oppositeLower_3_0= ruleEInt ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3310:1: (lv_oppositeLower_3_0= ruleEInt )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3310:1: (lv_oppositeLower_3_0= ruleEInt )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3311:3: lv_oppositeLower_3_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getAddOppositeAccess().getOppositeLowerEIntParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleAddOpposite6914);
            lv_oppositeLower_3_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddOppositeRule());
            	        }
                   		set(
                   			current, 
                   			"oppositeLower",
                    		lv_oppositeLower_3_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddOpposite6926); 

                	newLeafNode(otherlv_4, grammarAccess.getAddOppositeAccess().getCommaKeyword_4());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3331:1: ( (lv_oppositeUpper_5_0= ruleEInt ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3332:1: (lv_oppositeUpper_5_0= ruleEInt )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3332:1: (lv_oppositeUpper_5_0= ruleEInt )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3333:3: lv_oppositeUpper_5_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getAddOppositeAccess().getOppositeUpperEIntParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleAddOpposite6947);
            lv_oppositeUpper_5_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddOppositeRule());
            	        }
                   		set(
                   			current, 
                   			"oppositeUpper",
                    		lv_oppositeUpper_5_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAddOpposite6959); 

                	newLeafNode(otherlv_6, grammarAccess.getAddOppositeAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddOpposite"


    // $ANTLR start "entryRuleReferenceReification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3361:1: entryRuleReferenceReification returns [EObject current=null] : iv_ruleReferenceReification= ruleReferenceReification EOF ;
    public final EObject entryRuleReferenceReification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceReification = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3362:2: (iv_ruleReferenceReification= ruleReferenceReification EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3363:2: iv_ruleReferenceReification= ruleReferenceReification EOF
            {
             newCompositeNode(grammarAccess.getReferenceReificationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceReification_in_entryRuleReferenceReification6995);
            iv_ruleReferenceReification=ruleReferenceReification();

            state._fsp--;

             current =iv_ruleReferenceReification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceReification7005); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceReification"


    // $ANTLR start "ruleReferenceReification"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3370:1: ruleReferenceReification returns [EObject current=null] : (otherlv_0= '(' ( (lv_nameClass_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_nameFirstReference_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_nameSecondReference_5_0= ruleEString ) ) otherlv_6= ')' ) ;
    public final EObject ruleReferenceReification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_nameClass_1_0 = null;

        AntlrDatatypeRuleToken lv_nameFirstReference_3_0 = null;

        AntlrDatatypeRuleToken lv_nameSecondReference_5_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3373:28: ( (otherlv_0= '(' ( (lv_nameClass_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_nameFirstReference_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_nameSecondReference_5_0= ruleEString ) ) otherlv_6= ')' ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3374:1: (otherlv_0= '(' ( (lv_nameClass_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_nameFirstReference_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_nameSecondReference_5_0= ruleEString ) ) otherlv_6= ')' )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3374:1: (otherlv_0= '(' ( (lv_nameClass_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_nameFirstReference_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_nameSecondReference_5_0= ruleEString ) ) otherlv_6= ')' )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3374:3: otherlv_0= '(' ( (lv_nameClass_1_0= ruleEString ) ) otherlv_2= ',' ( (lv_nameFirstReference_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_nameSecondReference_5_0= ruleEString ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleReferenceReification7042); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceReificationAccess().getLeftParenthesisKeyword_0());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3378:1: ( (lv_nameClass_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3379:1: (lv_nameClass_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3379:1: (lv_nameClass_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3380:3: lv_nameClass_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReferenceReificationAccess().getNameClassEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReferenceReification7063);
            lv_nameClass_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceReificationRule());
            	        }
                   		set(
                   			current, 
                   			"nameClass",
                    		lv_nameClass_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleReferenceReification7075); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceReificationAccess().getCommaKeyword_2());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3400:1: ( (lv_nameFirstReference_3_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3401:1: (lv_nameFirstReference_3_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3401:1: (lv_nameFirstReference_3_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3402:3: lv_nameFirstReference_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReferenceReificationAccess().getNameFirstReferenceEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReferenceReification7096);
            lv_nameFirstReference_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceReificationRule());
            	        }
                   		set(
                   			current, 
                   			"nameFirstReference",
                    		lv_nameFirstReference_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleReferenceReification7108); 

                	newLeafNode(otherlv_4, grammarAccess.getReferenceReificationAccess().getCommaKeyword_4());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3422:1: ( (lv_nameSecondReference_5_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3423:1: (lv_nameSecondReference_5_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3423:1: (lv_nameSecondReference_5_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3424:3: lv_nameSecondReference_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReferenceReificationAccess().getNameSecondReferenceEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReferenceReification7129);
            lv_nameSecondReference_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceReificationRule());
            	        }
                   		set(
                   			current, 
                   			"nameSecondReference",
                    		lv_nameSecondReference_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleReferenceReification7141); 

                	newLeafNode(otherlv_6, grammarAccess.getReferenceReificationAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceReification"


    // $ANTLR start "entryRuleAddDerivedReference"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3452:1: entryRuleAddDerivedReference returns [EObject current=null] : iv_ruleAddDerivedReference= ruleAddDerivedReference EOF ;
    public final EObject entryRuleAddDerivedReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddDerivedReference = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3453:2: (iv_ruleAddDerivedReference= ruleAddDerivedReference EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3454:2: iv_ruleAddDerivedReference= ruleAddDerivedReference EOF
            {
             newCompositeNode(grammarAccess.getAddDerivedReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddDerivedReference_in_entryRuleAddDerivedReference7177);
            iv_ruleAddDerivedReference=ruleAddDerivedReference();

            state._fsp--;

             current =iv_ruleAddDerivedReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddDerivedReference7187); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddDerivedReference"


    // $ANTLR start "ruleAddDerivedReference"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3461:1: ruleAddDerivedReference returns [EObject current=null] : (otherlv_0= 'addDerivedRef' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* ) ;
    public final EObject ruleAddDerivedReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_newName_1_0 = null;

        AntlrDatatypeRuleToken lv_referenceName_3_0 = null;

        AntlrDatatypeRuleToken lv_referenceName_5_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3464:28: ( (otherlv_0= 'addDerivedRef' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3465:1: (otherlv_0= 'addDerivedRef' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3465:1: (otherlv_0= 'addDerivedRef' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3465:3: otherlv_0= 'addDerivedRef' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )*
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleAddDerivedReference7224); 

                	newLeafNode(otherlv_0, grammarAccess.getAddDerivedReferenceAccess().getAddDerivedRefKeyword_0());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3469:1: ( (lv_newName_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3470:1: (lv_newName_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3470:1: (lv_newName_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3471:3: lv_newName_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddDerivedReferenceAccess().getNewNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddDerivedReference7245);
            lv_newName_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddDerivedReferenceRule());
            	        }
                   		set(
                   			current, 
                   			"newName",
                    		lv_newName_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleAddDerivedReference7257); 

                	newLeafNode(otherlv_2, grammarAccess.getAddDerivedReferenceAccess().getColonKeyword_2());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3491:1: ( (lv_referenceName_3_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3492:1: (lv_referenceName_3_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3492:1: (lv_referenceName_3_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3493:3: lv_referenceName_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddDerivedReferenceAccess().getReferenceNameEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddDerivedReference7278);
            lv_referenceName_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddDerivedReferenceRule());
            	        }
                   		add(
                   			current, 
                   			"referenceName",
                    		lv_referenceName_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3509:2: (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==45) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3509:4: otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddDerivedReference7291); 

            	        	newLeafNode(otherlv_4, grammarAccess.getAddDerivedReferenceAccess().getCommaKeyword_4_0());
            	        
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3513:1: ( (lv_referenceName_5_0= ruleEString ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3514:1: (lv_referenceName_5_0= ruleEString )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3514:1: (lv_referenceName_5_0= ruleEString )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3515:3: lv_referenceName_5_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddDerivedReferenceAccess().getReferenceNameEStringParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddDerivedReference7312);
            	    lv_referenceName_5_0=ruleEString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAddDerivedReferenceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"referenceName",
            	            		lv_referenceName_5_0, 
            	            		"EString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddDerivedReference"


    // $ANTLR start "entryRuleAddDerivedAttribute"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3539:1: entryRuleAddDerivedAttribute returns [EObject current=null] : iv_ruleAddDerivedAttribute= ruleAddDerivedAttribute EOF ;
    public final EObject entryRuleAddDerivedAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddDerivedAttribute = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3540:2: (iv_ruleAddDerivedAttribute= ruleAddDerivedAttribute EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3541:2: iv_ruleAddDerivedAttribute= ruleAddDerivedAttribute EOF
            {
             newCompositeNode(grammarAccess.getAddDerivedAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddDerivedAttribute_in_entryRuleAddDerivedAttribute7350);
            iv_ruleAddDerivedAttribute=ruleAddDerivedAttribute();

            state._fsp--;

             current =iv_ruleAddDerivedAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddDerivedAttribute7360); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddDerivedAttribute"


    // $ANTLR start "ruleAddDerivedAttribute"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3548:1: ruleAddDerivedAttribute returns [EObject current=null] : (otherlv_0= 'addDerivedAtt' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* otherlv_6= ':' ( (lv_attributeName_7_0= ruleEString ) ) ) ;
    public final EObject ruleAddDerivedAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_newName_1_0 = null;

        AntlrDatatypeRuleToken lv_referenceName_3_0 = null;

        AntlrDatatypeRuleToken lv_referenceName_5_0 = null;

        AntlrDatatypeRuleToken lv_attributeName_7_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3551:28: ( (otherlv_0= 'addDerivedAtt' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* otherlv_6= ':' ( (lv_attributeName_7_0= ruleEString ) ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3552:1: (otherlv_0= 'addDerivedAtt' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* otherlv_6= ':' ( (lv_attributeName_7_0= ruleEString ) ) )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3552:1: (otherlv_0= 'addDerivedAtt' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* otherlv_6= ':' ( (lv_attributeName_7_0= ruleEString ) ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3552:3: otherlv_0= 'addDerivedAtt' ( (lv_newName_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_referenceName_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )* otherlv_6= ':' ( (lv_attributeName_7_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleAddDerivedAttribute7397); 

                	newLeafNode(otherlv_0, grammarAccess.getAddDerivedAttributeAccess().getAddDerivedAttKeyword_0());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3556:1: ( (lv_newName_1_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3557:1: (lv_newName_1_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3557:1: (lv_newName_1_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3558:3: lv_newName_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddDerivedAttributeAccess().getNewNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddDerivedAttribute7418);
            lv_newName_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddDerivedAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"newName",
                    		lv_newName_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleAddDerivedAttribute7430); 

                	newLeafNode(otherlv_2, grammarAccess.getAddDerivedAttributeAccess().getColonKeyword_2());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3578:1: ( (lv_referenceName_3_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3579:1: (lv_referenceName_3_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3579:1: (lv_referenceName_3_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3580:3: lv_referenceName_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddDerivedAttributeAccess().getReferenceNameEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddDerivedAttribute7451);
            lv_referenceName_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddDerivedAttributeRule());
            	        }
                   		add(
                   			current, 
                   			"referenceName",
                    		lv_referenceName_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3596:2: (otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==45) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3596:4: otherlv_4= ',' ( (lv_referenceName_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleAddDerivedAttribute7464); 

            	        	newLeafNode(otherlv_4, grammarAccess.getAddDerivedAttributeAccess().getCommaKeyword_4_0());
            	        
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3600:1: ( (lv_referenceName_5_0= ruleEString ) )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3601:1: (lv_referenceName_5_0= ruleEString )
            	    {
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3601:1: (lv_referenceName_5_0= ruleEString )
            	    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3602:3: lv_referenceName_5_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddDerivedAttributeAccess().getReferenceNameEStringParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddDerivedAttribute7485);
            	    lv_referenceName_5_0=ruleEString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAddDerivedAttributeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"referenceName",
            	            		lv_referenceName_5_0, 
            	            		"EString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            otherlv_6=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleAddDerivedAttribute7499); 

                	newLeafNode(otherlv_6, grammarAccess.getAddDerivedAttributeAccess().getColonKeyword_5());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3622:1: ( (lv_attributeName_7_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3623:1: (lv_attributeName_7_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3623:1: (lv_attributeName_7_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3624:3: lv_attributeName_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAddDerivedAttributeAccess().getAttributeNameEStringParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAddDerivedAttribute7520);
            lv_attributeName_7_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAddDerivedAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"attributeName",
                    		lv_attributeName_7_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddDerivedAttribute"


    // $ANTLR start "entryRuleEnumerate"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3648:1: entryRuleEnumerate returns [EObject current=null] : iv_ruleEnumerate= ruleEnumerate EOF ;
    public final EObject entryRuleEnumerate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerate = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3649:2: (iv_ruleEnumerate= ruleEnumerate EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3650:2: iv_ruleEnumerate= ruleEnumerate EOF
            {
             newCompositeNode(grammarAccess.getEnumerateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumerate_in_entryRuleEnumerate7556);
            iv_ruleEnumerate=ruleEnumerate();

            state._fsp--;

             current =iv_ruleEnumerate; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumerate7566); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerate"


    // $ANTLR start "ruleEnumerate"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3657:1: ruleEnumerate returns [EObject current=null] : ( () otherlv_1= 'enumerate' otherlv_2= '(' ( (lv_enumName_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_attributeName_5_0= ruleEString ) ) otherlv_6= ')' ) ;
    public final EObject ruleEnumerate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_enumName_3_0 = null;

        AntlrDatatypeRuleToken lv_attributeName_5_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3660:28: ( ( () otherlv_1= 'enumerate' otherlv_2= '(' ( (lv_enumName_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_attributeName_5_0= ruleEString ) ) otherlv_6= ')' ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3661:1: ( () otherlv_1= 'enumerate' otherlv_2= '(' ( (lv_enumName_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_attributeName_5_0= ruleEString ) ) otherlv_6= ')' )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3661:1: ( () otherlv_1= 'enumerate' otherlv_2= '(' ( (lv_enumName_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_attributeName_5_0= ruleEString ) ) otherlv_6= ')' )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3661:2: () otherlv_1= 'enumerate' otherlv_2= '(' ( (lv_enumName_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_attributeName_5_0= ruleEString ) ) otherlv_6= ')'
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3661:2: ()
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3662:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEnumerateAccess().getEnumerateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleEnumerate7612); 

                	newLeafNode(otherlv_1, grammarAccess.getEnumerateAccess().getEnumerateKeyword_1());
                
            otherlv_2=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEnumerate7624); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumerateAccess().getLeftParenthesisKeyword_2());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3675:1: ( (lv_enumName_3_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3676:1: (lv_enumName_3_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3676:1: (lv_enumName_3_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3677:3: lv_enumName_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEnumerateAccess().getEnumNameEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumerate7645);
            lv_enumName_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumerateRule());
            	        }
                   		set(
                   			current, 
                   			"enumName",
                    		lv_enumName_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEnumerate7657); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumerateAccess().getCommaKeyword_4());
                
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3697:1: ( (lv_attributeName_5_0= ruleEString ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3698:1: (lv_attributeName_5_0= ruleEString )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3698:1: (lv_attributeName_5_0= ruleEString )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3699:3: lv_attributeName_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEnumerateAccess().getAttributeNameEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEnumerate7678);
            lv_attributeName_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumerateRule());
            	        }
                   		set(
                   			current, 
                   			"attributeName",
                    		lv_attributeName_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEnumerate7690); 

                	newLeafNode(otherlv_6, grammarAccess.getEnumerateAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerate"


    // $ANTLR start "entryRuleEInt"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3727:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3728:2: (iv_ruleEInt= ruleEInt EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3729:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt7727);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt7738); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3736:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3739:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3740:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3740:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3740:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3740:2: (kw= '-' )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==63) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3741:2: kw= '-'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleEInt7777); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt7794); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEString"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3763:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3764:2: (iv_ruleEString= ruleEString EOF )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3765:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString7842);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString7853); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3772:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3775:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3776:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3776:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_STRING) ) {
                alt89=1;
            }
            else if ( (LA89_0==RULE_ID) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3776:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString7893); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../xtext.modif/src-gen/xtext/parser/antlr/internal/InternalXModif.g:3784:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString7919); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModifications_in_entryRuleModifications75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifications85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModifications173 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_12_in_ruleModifications258 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_13_in_ruleModifications343 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_14_in_ruleModifications428 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_15_in_ruleModifications513 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_16_in_ruleModifications593 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleAddRootClass_in_ruleModifications614 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_17_in_ruleModifications682 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleAddNameClass_in_ruleModifications703 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_18_in_ruleModifications756 = new BitSet(new long[]{0x0000000000180060L});
        public static final BitSet FOLLOW_rulePackageModification_in_ruleModifications777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddDerived_in_entryRuleAddDerived813 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddDerived823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddDerivedReference_in_ruleAddDerived870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddDerivedAttribute_in_ruleAddDerived897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageModification_in_entryRulePackageModification932 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageModification942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rulePackageModification985 = new BitSet(new long[]{0x0000000000100060L});
        public static final BitSet FOLLOW_20_in_rulePackageModification1017 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_rulePackageModification1052 = new BitSet(new long[]{0x00000001E3E00002L});
        public static final BitSet FOLLOW_21_in_rulePackageModification1065 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_rulePackageModification1086 = new BitSet(new long[]{0x00000001E3C00002L});
        public static final BitSet FOLLOW_22_in_rulePackageModification1101 = new BitSet(new long[]{0x0000000000200060L});
        public static final BitSet FOLLOW_ruleEString_in_rulePackageModification1122 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_rulePackageModification1135 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_rulePackageModification1156 = new BitSet(new long[]{0x00000001E3800002L});
        public static final BitSet FOLLOW_23_in_rulePackageModification1171 = new BitSet(new long[]{0x0000000000200060L});
        public static final BitSet FOLLOW_ruleEString_in_rulePackageModification1192 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_rulePackageModification1205 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_rulePackageModification1226 = new BitSet(new long[]{0x00000001E3000002L});
        public static final BitSet FOLLOW_24_in_rulePackageModification1246 = new BitSet(new long[]{0x00000001E2000002L});
        public static final BitSet FOLLOW_25_in_rulePackageModification1273 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_rulePackageModification1285 = new BitSet(new long[]{0x0000000000180060L});
        public static final BitSet FOLLOW_rulePackageModification_in_rulePackageModification1306 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_rulePackageModification1319 = new BitSet(new long[]{0x0000000000180060L});
        public static final BitSet FOLLOW_rulePackageModification_in_rulePackageModification1340 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_rulePackageModification1354 = new BitSet(new long[]{0x00000001E0000002L});
        public static final BitSet FOLLOW_29_in_rulePackageModification1369 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_rulePackageModification1381 = new BitSet(new long[]{0x0000003000180060L});
        public static final BitSet FOLLOW_ruleClassModification_in_rulePackageModification1402 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_rulePackageModification1415 = new BitSet(new long[]{0x0000003000180060L});
        public static final BitSet FOLLOW_ruleClassModification_in_rulePackageModification1436 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_rulePackageModification1450 = new BitSet(new long[]{0x00000001C0000002L});
        public static final BitSet FOLLOW_30_in_rulePackageModification1465 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_rulePackageModification1477 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleDataTypeModification_in_rulePackageModification1498 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_rulePackageModification1511 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleDataTypeModification_in_rulePackageModification1532 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_rulePackageModification1546 = new BitSet(new long[]{0x0000000180000002L});
        public static final BitSet FOLLOW_31_in_rulePackageModification1561 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_rulePackageModification1573 = new BitSet(new long[]{0x0000020000080060L});
        public static final BitSet FOLLOW_ruleEnumModification_in_rulePackageModification1594 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_rulePackageModification1607 = new BitSet(new long[]{0x0000020000080060L});
        public static final BitSet FOLLOW_ruleEnumModification_in_rulePackageModification1628 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_rulePackageModification1642 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_rulePackageModification1657 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_rulePackageModification1669 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_rulePackageModification1690 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_rulePackageModification1703 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_rulePackageModification1724 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_rulePackageModification1738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddRootClass_in_entryRuleAddRootClass1776 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddRootClass1786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddRootClass1841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddNameClass_in_entryRuleAddNameClass1877 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddNameClass1887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddNameClass1933 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleAddNameClass1945 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddNameClass1966 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAddNameClass1978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_entryRuleAnnotationModification2014 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationModification2024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleAnnotationModification2067 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAnnotationModification2102 = new BitSet(new long[]{0x0000000901200002L});
        public static final BitSet FOLLOW_21_in_ruleAnnotationModification2115 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAnnotationModification2136 = new BitSet(new long[]{0x0000000901000002L});
        public static final BitSet FOLLOW_24_in_ruleAnnotationModification2156 = new BitSet(new long[]{0x0000000900000002L});
        public static final BitSet FOLLOW_35_in_ruleAnnotationModification2183 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleAnnotationModification2195 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleDetailsEntryModification_in_ruleAnnotationModification2216 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleAnnotationModification2229 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleDetailsEntryModification_in_ruleAnnotationModification2250 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleAnnotationModification2264 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleAnnotationModification2279 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleAnnotationModification2291 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleAnnotationModification2312 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleAnnotationModification2325 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleAnnotationModification2346 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleAnnotationModification2360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleClassModification_in_entryRuleClassModification2398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleClassModification2408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleClassModification2451 = new BitSet(new long[]{0x0000003000100060L});
        public static final BitSet FOLLOW_20_in_ruleClassModification2528 = new BitSet(new long[]{0x0000003000100060L});
        public static final BitSet FOLLOW_36_in_ruleClassModification2613 = new BitSet(new long[]{0x0000003000100060L});
        public static final BitSet FOLLOW_37_in_ruleClassModification2698 = new BitSet(new long[]{0x0000003000100060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleClassModification2772 = new BitSet(new long[]{0x4000004105200002L});
        public static final BitSet FOLLOW_21_in_ruleClassModification2785 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleClassModification2806 = new BitSet(new long[]{0x4000004105000002L});
        public static final BitSet FOLLOW_38_in_ruleClassModification2871 = new BitSet(new long[]{0x4000004105000002L});
        public static final BitSet FOLLOW_24_in_ruleClassModification2956 = new BitSet(new long[]{0x4000004105000002L});
        public static final BitSet FOLLOW_ruleEnumerate_in_ruleClassModification3044 = new BitSet(new long[]{0x4000004105000002L});
        public static final BitSet FOLLOW_26_in_ruleClassModification3097 = new BitSet(new long[]{0x2805500010080000L});
        public static final BitSet FOLLOW_ruleStructuralFeatureModification_in_ruleClassModification3118 = new BitSet(new long[]{0x2805500010080000L});
        public static final BitSet FOLLOW_ruleAddFeature_in_ruleClassModification3140 = new BitSet(new long[]{0x2800500010000000L});
        public static final BitSet FOLLOW_ruleAddDerived_in_ruleClassModification3162 = new BitSet(new long[]{0x2800000010000000L});
        public static final BitSet FOLLOW_28_in_ruleClassModification3175 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleClassModification3190 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleClassModification3202 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleClassModification3223 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleClassModification3236 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleClassModification3257 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleClassModification3271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeModification_in_entryRuleDataTypeModification3309 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeModification3319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleDataTypeModification3362 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDataTypeModification3397 = new BitSet(new long[]{0x0000018101200002L});
        public static final BitSet FOLLOW_21_in_ruleDataTypeModification3410 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDataTypeModification3431 = new BitSet(new long[]{0x0000018101000002L});
        public static final BitSet FOLLOW_39_in_ruleDataTypeModification3446 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDataTypeModification3467 = new BitSet(new long[]{0x0000010101000002L});
        public static final BitSet FOLLOW_40_in_ruleDataTypeModification3482 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDataTypeModification3503 = new BitSet(new long[]{0x0000000101000002L});
        public static final BitSet FOLLOW_24_in_ruleDataTypeModification3523 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleDataTypeModification3550 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleDataTypeModification3562 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleDataTypeModification3583 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleDataTypeModification3596 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleDataTypeModification3617 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleDataTypeModification3631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumModification_in_entryRuleEnumModification3669 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumModification3679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleEnumModification3722 = new BitSet(new long[]{0x0000020000000060L});
        public static final BitSet FOLLOW_41_in_ruleEnumModification3754 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumModification3789 = new BitSet(new long[]{0x0000018105200002L});
        public static final BitSet FOLLOW_21_in_ruleEnumModification3802 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumModification3823 = new BitSet(new long[]{0x0000018105000002L});
        public static final BitSet FOLLOW_39_in_ruleEnumModification3838 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumModification3859 = new BitSet(new long[]{0x0000010105000002L});
        public static final BitSet FOLLOW_40_in_ruleEnumModification3874 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumModification3895 = new BitSet(new long[]{0x0000000105000002L});
        public static final BitSet FOLLOW_24_in_ruleEnumModification3915 = new BitSet(new long[]{0x0000000104000002L});
        public static final BitSet FOLLOW_26_in_ruleEnumModification3942 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleEnumLiteralModification_in_ruleEnumModification3963 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleEnumModification3976 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleEnumLiteralModification_in_ruleEnumModification3997 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleEnumModification4011 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleEnumModification4026 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleEnumModification4038 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleEnumModification4059 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleEnumModification4072 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleEnumModification4093 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleEnumModification4107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralModification_in_entryRuleEnumLiteralModification4145 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralModification4155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleEnumLiteralModification4198 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumLiteralModification4233 = new BitSet(new long[]{0x00000C0101200002L});
        public static final BitSet FOLLOW_21_in_ruleEnumLiteralModification4246 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumLiteralModification4267 = new BitSet(new long[]{0x00000C0101000002L});
        public static final BitSet FOLLOW_42_in_ruleEnumLiteralModification4282 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumLiteralModification4303 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleEnumLiteralModification4315 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumLiteralModification4336 = new BitSet(new long[]{0x0000080101000002L});
        public static final BitSet FOLLOW_43_in_ruleEnumLiteralModification4351 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEnumLiteralModification4372 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleEnumLiteralModification4384 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEnumLiteralModification4405 = new BitSet(new long[]{0x0000000101000002L});
        public static final BitSet FOLLOW_24_in_ruleEnumLiteralModification4425 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleEnumLiteralModification4452 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleEnumLiteralModification4464 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleEnumLiteralModification4485 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleEnumLiteralModification4498 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleEnumLiteralModification4519 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleEnumLiteralModification4533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDetailsEntryModification_in_entryRuleDetailsEntryModification4571 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDetailsEntryModification4581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleDetailsEntryModification4624 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDetailsEntryModification4659 = new BitSet(new long[]{0x0000080010200000L});
        public static final BitSet FOLLOW_21_in_ruleDetailsEntryModification4672 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDetailsEntryModification4693 = new BitSet(new long[]{0x0000080010000000L});
        public static final BitSet FOLLOW_43_in_ruleDetailsEntryModification4708 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDetailsEntryModification4729 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleDetailsEntryModification4741 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDetailsEntryModification4762 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleDetailsEntryModification4776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddFeature_in_entryRuleAddFeature4812 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddFeature4822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddAttribute_in_ruleAddFeature4869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddReference_in_ruleAddFeature4896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddAttribute_in_entryRuleAddAttribute4931 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddAttribute4941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleAddAttribute4978 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleAddAttribute4990 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddAttribute5011 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddAttribute5023 = new BitSet(new long[]{0x07C0000000000000L});
        public static final BitSet FOLLOW_rulePrimitiveType_in_ruleAddAttribute5044 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddAttribute5056 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleAddAttribute5077 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddAttribute5089 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleAddAttribute5110 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddAttribute5122 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddAttribute5143 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAddAttribute5155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddReference_in_entryRuleAddReference5191 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddReference5201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleAddReference5238 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleAddReference5250 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddReference5271 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddReference5283 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddReference5304 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddReference5316 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleAddReference5337 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddReference5349 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleAddReference5370 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAddReference5382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStructuralFeatureModification_in_entryRuleStructuralFeatureModification5418 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStructuralFeatureModification5428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeModification_in_ruleStructuralFeatureModification5475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceModification_in_ruleStructuralFeatureModification5502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChangeBounds_in_entryRuleChangeBounds5537 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChangeBounds5547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleChangeBounds5593 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleChangeBounds5605 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleChangeBounds5626 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleChangeBounds5638 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleChangeBounds5659 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleChangeBounds5671 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleChangeBounds5684 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleChangeBounds5696 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleChangeBounds5717 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleChangeBounds5729 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleChangeBounds5750 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleChangeBounds5762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeModification_in_entryRuleAttributeModification5800 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeModification5810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleAttributeModification5853 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleAttributeModification5879 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAttributeModification5900 = new BitSet(new long[]{0x0002800101200002L});
        public static final BitSet FOLLOW_21_in_ruleAttributeModification5913 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAttributeModification5934 = new BitSet(new long[]{0x0002800101000002L});
        public static final BitSet FOLLOW_ruleChangeBounds_in_ruleAttributeModification5957 = new BitSet(new long[]{0x0002000101000002L});
        public static final BitSet FOLLOW_49_in_ruleAttributeModification5977 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleAttributeModification6002 = new BitSet(new long[]{0x07C0000000000000L});
        public static final BitSet FOLLOW_rulePrimitiveType_in_ruleAttributeModification6023 = new BitSet(new long[]{0x0000000101000002L});
        public static final BitSet FOLLOW_24_in_ruleAttributeModification6043 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleAttributeModification6070 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleAttributeModification6082 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleAttributeModification6103 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleAttributeModification6116 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleAttributeModification6137 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleAttributeModification6151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceModification_in_entryRuleReferenceModification6189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceModification6199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleReferenceModification6242 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_50_in_ruleReferenceModification6268 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReferenceModification6289 = new BitSet(new long[]{0x0038820101200002L});
        public static final BitSet FOLLOW_21_in_ruleReferenceModification6302 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReferenceModification6323 = new BitSet(new long[]{0x0038820101000002L});
        public static final BitSet FOLLOW_ruleChangeBounds_in_ruleReferenceModification6346 = new BitSet(new long[]{0x0038020101000002L});
        public static final BitSet FOLLOW_51_in_ruleReferenceModification6365 = new BitSet(new long[]{0x0030020101000002L});
        public static final BitSet FOLLOW_52_in_ruleReferenceModification6397 = new BitSet(new long[]{0x0020020101000002L});
        public static final BitSet FOLLOW_53_in_ruleReferenceModification6424 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_ruleAddOpposite_in_ruleReferenceModification6445 = new BitSet(new long[]{0x0000020101000002L});
        public static final BitSet FOLLOW_41_in_ruleReferenceModification6460 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_ruleReferenceReification_in_ruleReferenceModification6481 = new BitSet(new long[]{0x0000000101000002L});
        public static final BitSet FOLLOW_24_in_ruleReferenceModification6501 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleReferenceModification6528 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleReferenceModification6540 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleReferenceModification6561 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleReferenceModification6574 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_ruleAnnotationModification_in_ruleReferenceModification6595 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleReferenceModification6609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType6648 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveType6659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rulePrimitiveType6697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rulePrimitiveType6716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rulePrimitiveType6735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rulePrimitiveType6754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveType6773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddOpposite_in_entryRuleAddOpposite6813 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddOpposite6823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleAddOpposite6860 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddOpposite6881 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddOpposite6893 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleAddOpposite6914 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddOpposite6926 = new BitSet(new long[]{0x8000000000000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleAddOpposite6947 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAddOpposite6959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceReification_in_entryRuleReferenceReification6995 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceReification7005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleReferenceReification7042 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReferenceReification7063 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleReferenceReification7075 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReferenceReification7096 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleReferenceReification7108 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReferenceReification7129 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleReferenceReification7141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddDerivedReference_in_entryRuleAddDerivedReference7177 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddDerivedReference7187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleAddDerivedReference7224 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddDerivedReference7245 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_60_in_ruleAddDerivedReference7257 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddDerivedReference7278 = new BitSet(new long[]{0x0000200000000002L});
        public static final BitSet FOLLOW_45_in_ruleAddDerivedReference7291 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddDerivedReference7312 = new BitSet(new long[]{0x0000200000000002L});
        public static final BitSet FOLLOW_ruleAddDerivedAttribute_in_entryRuleAddDerivedAttribute7350 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddDerivedAttribute7360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleAddDerivedAttribute7397 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddDerivedAttribute7418 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_60_in_ruleAddDerivedAttribute7430 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddDerivedAttribute7451 = new BitSet(new long[]{0x1000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleAddDerivedAttribute7464 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddDerivedAttribute7485 = new BitSet(new long[]{0x1000200000000000L});
        public static final BitSet FOLLOW_60_in_ruleAddDerivedAttribute7499 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAddDerivedAttribute7520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumerate_in_entryRuleEnumerate7556 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumerate7566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleEnumerate7612 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleEnumerate7624 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumerate7645 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleEnumerate7657 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEnumerate7678 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleEnumerate7690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt7727 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt7738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleEInt7777 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt7794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString7842 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString7853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString7893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString7919 = new BitSet(new long[]{0x0000000000000002L});
    }


}