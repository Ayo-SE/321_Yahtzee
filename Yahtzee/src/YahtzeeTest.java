import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.Canvas;

public class YahtzeeTest extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Roll Dice");
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YahtzeeTest frame = new YahtzeeTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YahtzeeTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		btnNewButton.setBounds(108, 417, 121, 43);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(170, 10, 175, 272);
		table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "My Picks"},
				{"Ones", null},
				{"Twos", null},
				{"Threes", null},
				{"Fours", null},
				{"Fives", null},
				{"Sixes", null},
				{"Sum", null},
				{"Bonus", ""},
				{"Three of a Kind", null},
				{"Four of a Kind", null},
				{"Full House", null},
				{"Small Straight", null},
				{"Large Straight", null},
				{"Chance", null},
				{"YAHTZEE", null},
				{"TOTAL SCORE", ""},
			},
			new String[] {
				"New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		
		// Add mouse listener to table
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (table.getValueAt(row, col) == null) {
		            table.setValueAt("clicked", row, col);
		            table.setEnabled(false); // Disable the table so that the value can't be changed again
		        }
		    }
		});
		
		contentPane.add(table);
	}
}
