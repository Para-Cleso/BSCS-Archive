import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PayrollManagement extends JFrame {

	static String $emplyName;
	static double $hrRate, $hrWorked;
    static ArrayList<String> lines;
	static DefaultTableModel model;
	static JTable table;
	static JScrollPane scrollPane;
	static JTextField txtEmplyName, txtHrRate, txtHrWorked;

	public static void main(String[] args) {
		new PayrollManagement();
	}

	PayrollManagement() {

		// Labels
		JLabel lblEmplyName = new JLabel("Employee Name");
		add(lblEmplyName).setBounds(40, 50, 188, 27);

		JLabel lblHrRate = new JLabel("Hourly Rate");
		add(lblHrRate).setBounds(40, 110, 188, 27);

		JLabel lblHrWorked = new JLabel("Hours Worked");
		add(lblHrWorked).setBounds(40, 170, 188, 27);

		// Text Fields
		txtEmplyName = new JTextField("Employee Name");
		add(txtEmplyName).setBounds(40, 80, 170, 27);

		txtHrRate = new JTextField("Hourly Rate");
		add(txtHrRate).setBounds(40, 140, 170, 27);

		txtHrWorked = new JTextField("Hours Worked");
		add(txtHrWorked).setBounds(40, 200, 170, 27);

		// Buttons
		JButton btnCalcSlry = new JButton("Calculate Salary");
		add(btnCalcSlry).setBounds(40, 250, 170, 34);

		JButton btnAdd = new JButton("Add to Table");
		add(btnAdd).setBounds(40, 300, 170, 34);

		JButton btnClear = new JButton("Clear");
		add(btnClear).setBounds(40, 350, 170, 34);

        JButton btnDel = new JButton("Delete");
		add(btnDel).setBounds(40, 400, 170, 34);

		// Table
		String[] columns = {
			"Employee Name",
			"Hourly Rate",
			"Hours Worked",
			"Gross Pay",
			"Tax Deduction",
			"Net Pay"
		};

		model = new DefaultTableModel(columns, 0);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		add(scrollPane).setBounds(230, 30, 600, 400);

		// Calculate Salary Button
		btnCalcSlry.addActionListener(e -> {
			try {
				refreshTableWithSalaries();
				JOptionPane.showMessageDialog(null, "Calculated for all employees");
			} catch (Exception ie) {
				JOptionPane.showMessageDialog(null,
					"Error: " + ie.getMessage() +
					"\nMake sure Employees.txt exists and has valid data.");
			}
		});

		// Add Button
		btnAdd.addActionListener(e -> {
			try {
				$emplyName = txtEmplyName.getText();
				$hrRate = Double.parseDouble(txtHrRate.getText());
				$hrWorked = Double.parseDouble(txtHrWorked.getText());

				saveToFile();
				setTextField();
			} catch (NumberFormatException | IOException xe) {
				JOptionPane.showMessageDialog(null,
					"Please input numbers on the hourly rate and hours worked. Try again");
			}
			refreshTable();
		});

        btnClear.addActionListener(e -> setTextField());

        btnDel.addActionListener(e -> delete());

		// Frame Settings
		setLayout(null);
		setTitle("JU Enrollment System");
		setSize(850, 500);
		setVisible(true);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private static void saveToFile() throws IOException {
		FileWriter file = new FileWriter("Employees.txt", true);
		BufferedWriter bw = new BufferedWriter(file);

		bw.write($emplyName + "#" + $hrRate + "#" + $hrWorked);
		bw.newLine();
		bw.close();

		JOptionPane.showMessageDialog(null, "Added to the table");
	}

	private static void setTextField() {
		txtEmplyName.setText("");
		txtHrRate.setText("");
		txtHrWorked.setText("");
	}

	private static void refreshTableWithSalaries() throws IOException {

		model.setRowCount(0);

		try (BufferedReader br =
			 new BufferedReader(new FileReader("Employees.txt"))) {

			String line;

			while ((line = br.readLine()) != null) {

				String[] parts = line.split("#");

				if (parts.length >= 3) {

					String name = parts[0];
					double hrRate = Double.parseDouble(parts[1].trim());
					double hrWorked = Double.parseDouble(parts[2].trim());

					double gp;

					if (hrWorked <= 40) {
						gp = hrRate * hrWorked;
					} else {
						double rp = 40 * hrRate;
						double op = (hrWorked - 40) * (hrRate * 1.5);
						gp = rp + op;
					}

					double tax = gp * 0.12;
					double net = gp - tax;

					String[] row = {
						name,
						String.valueOf(hrRate),
						String.valueOf(hrWorked),
						String.format("%.2f", gp),
						String.format("%.2f", tax),
						String.format("%.2f", net)
					};

					model.addRow(row);
				}
			}
		}
	}

	private static void refreshTable() {

		model.setRowCount(0);

		try (BufferedReader br =
			 new BufferedReader(new FileReader("Employees.txt"))) {

			String line;

			while ((line = br.readLine()) != null) {
				String[] row = line.split("#");
				model.addRow(row);
			}

		} catch (Exception r) {
			JOptionPane.showMessageDialog(null, "Lmao " + r);
		}
	}
    private static void delete(){
        int selectRow = table.getSelectedRow();
        if (selectRow == -1){
            JOptionPane.showMessageDialog(null,"Select record to delete." );
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this record?" );

        if (confirm != JOptionPane.YES_OPTION) return;

        lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("Employees.txt"))){
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null){
                if (rowIndex != selectRow) lines.add(line);
                rowIndex++;
            }
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,"File does not exist." );
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Employees.txt"))){
            for (String record : lines) bw.write(record + "\n");
        } catch (IOException o){
            JOptionPane.showMessageDialog(null,"File does not exist." );
        }
        
        JOptionPane.showMessageDialog(null,"Record Deleted" );
        setTextField();
        refreshTable();
    }
}
