/**
 */
package modif.util;

import java.util.Map;

import modif.*;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see modif.ModifPackage
 * @generated
 */
public class ModifValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ModifValidator INSTANCE = new ModifValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "modif";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ModifPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ModifPackage.MODIFICATIONS:
				return validateModifications((Modifications)value, diagnostics, context);
			case ModifPackage.MODIFICATION:
				return validateModification((Modification)value, diagnostics, context);
			case ModifPackage.PACKAGE_MODIFICATION:
				return validatePackageModification((PackageModification)value, diagnostics, context);
			case ModifPackage.CLASS_MODIFICATION:
				return validateClassModification((ClassModification)value, diagnostics, context);
			case ModifPackage.STRUCTURAL_FEATURE_MODIFICATION:
				return validateStructuralFeatureModification((StructuralFeatureModification)value, diagnostics, context);
			case ModifPackage.ATTRIBUTE_MODIFICATION:
				return validateAttributeModification((AttributeModification)value, diagnostics, context);
			case ModifPackage.REFERENCE_MODIFICATION:
				return validateReferenceModification((ReferenceModification)value, diagnostics, context);
			case ModifPackage.CHANGE_BOUNDS:
				return validateChangeBounds((ChangeBounds)value, diagnostics, context);
			case ModifPackage.DATA_TYPE_MODIFICATION:
				return validateDataTypeModification((DataTypeModification)value, diagnostics, context);
			case ModifPackage.ENUM_MODIFICATION:
				return validateEnumModification((EnumModification)value, diagnostics, context);
			case ModifPackage.ENUM_LITERAL_MODIFICATION:
				return validateEnumLiteralModification((EnumLiteralModification)value, diagnostics, context);
			case ModifPackage.ANNOTATION_MODIFICATION:
				return validateAnnotationModification((AnnotationModification)value, diagnostics, context);
			case ModifPackage.DETAILS_ENTRY_MODIFICATION:
				return validateDetailsEntryModification((DetailsEntryModification)value, diagnostics, context);
			case ModifPackage.ADD_FEATURE:
				return validateAddFeature((AddFeature)value, diagnostics, context);
			case ModifPackage.ADD_ATTRIBUTE:
				return validateAddAttribute((AddAttribute)value, diagnostics, context);
			case ModifPackage.ADD_REFERENCE:
				return validateAddReference((AddReference)value, diagnostics, context);
			case ModifPackage.ADD_OPPOSITE:
				return validateAddOpposite((AddOpposite)value, diagnostics, context);
			case ModifPackage.ADD_ROOT_CLASS:
				return validateAddRootClass((AddRootClass)value, diagnostics, context);
			case ModifPackage.ADD_NAME_CLASS:
				return validateAddNameClass((AddNameClass)value, diagnostics, context);
			case ModifPackage.ADD_DERIVED:
				return validateAddDerived((AddDerived)value, diagnostics, context);
			case ModifPackage.ADD_DERIVED_REFERENCE:
				return validateAddDerivedReference((AddDerivedReference)value, diagnostics, context);
			case ModifPackage.ADD_DERIVED_ATTRIBUTE:
				return validateAddDerivedAttribute((AddDerivedAttribute)value, diagnostics, context);
			case ModifPackage.REFERENCE_REIFICATION:
				return validateReferenceReification((ReferenceReification)value, diagnostics, context);
			case ModifPackage.ENUMERATE:
				return validateEnumerate((Enumerate)value, diagnostics, context);
			case ModifPackage.PRIMITIVE_TYPE:
				return validatePrimitiveType((PrimitiveType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModifications(Modifications modifications, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modifications, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModification(Modification modification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageModification(PackageModification packageModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(packageModification, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(packageModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(packageModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(packageModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(packageModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(packageModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(packageModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(packageModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(packageModification, diagnostics, context);
		if (result || diagnostics != null) result &= validatePackageModification_differentName(packageModification, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the differentName constraint of '<em>Package Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PACKAGE_MODIFICATION__DIFFERENT_NAME__EEXPRESSION = "self.classModification->forAll(x : ClassModification, y : ClassModification | x <> y implies x.newName <> y.oldName)";

	/**
	 * Validates the differentName constraint of '<em>Package Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageModification_differentName(PackageModification packageModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(ModifPackage.Literals.PACKAGE_MODIFICATION,
				 packageModification,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "differentName",
				 PACKAGE_MODIFICATION__DIFFERENT_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassModification(ClassModification classModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classModification, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classModification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classModification, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassModification_differentAttributeName(classModification, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the differentAttributeName constraint of '<em>Class Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CLASS_MODIFICATION__DIFFERENT_ATTRIBUTE_NAME__EEXPRESSION = "self.featureModification->forAll(x : StructuralFeatureModification, y : StructuralFeatureModification | x <> y implies x.newName <> y.oldName)";

	/**
	 * Validates the differentAttributeName constraint of '<em>Class Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassModification_differentAttributeName(ClassModification classModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(ModifPackage.Literals.CLASS_MODIFICATION,
				 classModification,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "differentAttributeName",
				 CLASS_MODIFICATION__DIFFERENT_ATTRIBUTE_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureModification(StructuralFeatureModification structuralFeatureModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structuralFeatureModification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeModification(AttributeModification attributeModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeModification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceModification(ReferenceModification referenceModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referenceModification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChangeBounds(ChangeBounds changeBounds, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(changeBounds, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataTypeModification(DataTypeModification dataTypeModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataTypeModification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumModification(EnumModification enumModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumModification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteralModification(EnumLiteralModification enumLiteralModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumLiteralModification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotationModification(AnnotationModification annotationModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(annotationModification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDetailsEntryModification(DetailsEntryModification detailsEntryModification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(detailsEntryModification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddFeature(AddFeature addFeature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddAttribute(AddAttribute addAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddReference(AddReference addReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddOpposite(AddOpposite addOpposite, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addOpposite, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddRootClass(AddRootClass addRootClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addRootClass, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddNameClass(AddNameClass addNameClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addNameClass, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddDerived(AddDerived addDerived, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addDerived, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddDerivedReference(AddDerivedReference addDerivedReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addDerivedReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddDerivedAttribute(AddDerivedAttribute addDerivedAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(addDerivedAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceReification(ReferenceReification referenceReification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referenceReification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerate(Enumerate enumerate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumerate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveType(PrimitiveType primitiveType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ModifValidator
