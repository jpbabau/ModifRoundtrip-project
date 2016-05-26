package uiMigrationSpecificationEdition;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.ecore.EObject;

import utils.UtilEMF;
import migration.Migration;
import migration.MigrationPackage;

/**
 * @version 1.0 04/26/99
 */

public class CustomMigrationSpecification extends JFrame {
	private static final long serialVersionUID = 1L;
	Migration migration;
	String migrationSpecificationName;
	String customMigrationSpecificationName;
	ArrayList<String> mandatoryDeletion = new ArrayList<String>();
	ArrayList<String> customDeletion = new ArrayList<String>();
	boolean isValidMigration;
	JScrollPane sp;
	JPanel panel;

	/**
	 * Constructor
	 */
	public CustomMigrationSpecification() {
		super("Migration Specification Edition");

		migrationSpecificationName = "C:/ModifProject/Test_Vehicles/migration/vehiclestocarsK.migration.xmi";
		migration = (Migration) UtilEMF.loadModel(migrationSpecificationName, MigrationPackage.eINSTANCE);

		final ArrayList<String> strs = new ArrayList<String>();

		for(EObject instance : migration.eContents()){
			String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
			for(EObject deletion : instance.eContents()){
				boolean deleteinstance = (boolean) deletion.eGet(deletion.eClass().getEStructuralFeature("deleteInstance"));
				if(!deleteinstance){ strs.add(instanceuuid); }
			}
		}

		final CheckableItem[] data = createData(strs);
		final JList list = new JList(data);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new EmptyBorder(0, 4, 0, 0));
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = list.locationToIndex(e.getPoint());
				CheckableItem item = (CheckableItem) list.getModel().getElementAt(index);
				item.setSelected(!item.isSelected());
				Rectangle rect = list.getCellBounds(index, index);
				list.repaint(rect);
			}
		});
		sp = new JScrollPane(list);

		JButton validateButton = new JButton("Validate");
		validateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListModel model = list.getModel();
				int n = model.getSize();
				for (int i = 0; i < n; i++) {
					CheckableItem item = (CheckableItem) model.getElementAt(i);
					// modify the migration specification
					try { modifyInstance(strs.get(i), item.isSelected); } 
					catch (IOException e1) { e1.printStackTrace(); }
					// Save a new migration specification (the custom one)
					customMigrationSpecificationName = migrationSpecificationName.replace(".migration", "Customized.migration");
					try { UtilEMF.saveModel((EObject)migration,customMigrationSpecificationName); } 
					catch (IOException e1) { e1.printStackTrace(); }
					// validate the result by applying the new migration specification
					//TODO
				}
			}
		});

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetData(strs.size(), data);
				Rectangle rect = list.getCellBounds(0, strs.size()-1);
				list.repaint(rect);
			}
		});

		panel = new JPanel(new GridLayout(2, 1));
		panel.add(validateButton);
		panel.add(resetButton);

		getContentPane().add(sp, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.EAST);
	}

	/**
	 * 
	 * @return sp
	 */
	public JScrollPane getScrollPane(){
		return sp;
	}

	/**
	 * 
	 * @return panel
	 */
	public JPanel getPanel(){
		return panel;
	}

	/**
	 * 
	 * @param strs list of string to be added to the checkable list
	 * @return items
	 */
	private CheckableItem[] createData(ArrayList<String> strs) {
		int n = strs.size();
		CheckableItem[] items = new CheckableItem[n];   
		for (int i = 0; i < n; i++) { items[i] = new CheckableItem(strs.get(i)); }
		return items;
	}

	/**
	 * 
	 * @param n
	 * @param items
	 * @return
	 */
	private CheckableItem[] resetData(int n, CheckableItem[] items) {
		for (int i = 0; i < n; i++) {
			items[i].setSelected(false);
		}
		return items;
	}

	/**
	 * 
	 * CheckableItem items
	 *
	 */
	class CheckableItem {
		private String str;
		private boolean isSelected;

		/**
		 * 
		 * @param str
		 */
		public CheckableItem(String str) {
			this.str = str;
			isSelected = false;
		}

		/**
		 * 
		 * @param b
		 */
		public void setSelected(boolean b) { 
			isSelected = b;
		}

		/**
		 * 
		 * @return isSelected
		 */
		public boolean isSelected() {
			return isSelected;
		}

		/**
		 * @return str
		 */
		public String toString() {
			return str;
		}
	}

	/**
	 * 
	 * @author PaolaUBO
	 *
	 */
	class CheckListRenderer extends JCheckBox implements ListCellRenderer {
		/**
		 * Constructor
		 */
		public CheckListRenderer() {
			setBackground(UIManager.getColor("List.textBackground"));
			setForeground(UIManager.getColor("List.textForeground"));
		}

		/**
		 * @return Component
		 */
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean hasFocus) {
			setEnabled(list.isEnabled());
			setSelected(((CheckableItem) value).isSelected());
			setFont(list.getFont());
			setText(value.toString());
			return this;
		}
	}

	/**
	 * 
	 * @param instanceUUID instance whose value of deletion has to be modified
	 * @param value value of deletion
	 * @throws IOException
	 */
	public void  modifyInstance(String instanceUUID, boolean value) throws IOException{
		for(EObject instance : migration.eContents()){
			String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
			if(instanceuuid.equals(instanceUUID)){
				for(EObject deletion : instance.eContents()){					
					deletion.eSet(deletion.eClass().getEStructuralFeature("deleteInstance"), value);
				}
			}
		}
	}

	/**
	 * 
	 * @return customMigrationSpecificationName
	 */
	public String getCustomMigrationSpecificationName(){
		return customMigrationSpecificationName;
	}

	/**
	 * 
	 * @return isValidMigration
	 */
	public boolean isAValidMigration(){
		return isValidMigration;
	}

	/**
	 * Main
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception evt) {}

		CustomMigrationSpecification frame = new CustomMigrationSpecification();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}