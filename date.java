package triangle;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class date {
	// �����������ڵ�λ�ã����ֵ�
	public date() {
		jFrame.setBounds(800, 400, 350, 300);
		container.setLayout(new BorderLayout());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ��ʼ��
		init();
		jFrame.setVisible(true);
	}

	// ������ʵ����ز���
	private JFrame jFrame = new JFrame("������һ��");
	private Container container = jFrame.getContentPane();

	private JLabel title = new JLabel("��ֱ������ꡢ�¡��գ�");

	private JLabel year = new JLabel("��");
	private JTextField input_year = new JTextField();

	private JLabel month = new JLabel("��");
	private JTextField input_month = new JTextField();

	private JLabel day = new JLabel("��");
	private JTextField input_day = new JTextField();

	private JLabel res = new JLabel("��һ��");
	private JTextField tfRes = new JTextField();

	private JButton judge = new JButton("������һ��");
	private JButton reset = new JButton("��������");

	private static final HashSet<Integer> day_30month = new HashSet<>();

	// ������Ϊ30���·�ר�ż�¼����
	static {
		day_30month.add(4);
		day_30month.add(6);
		day_30month.add(9);
		day_30month.add(11);
	}

	// �����ڲ���ʵ��
	public void init() {

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		// ���ñ�ǩ��λ��
		title.setBounds(100, 20, 200, 20);
		year.setBounds(50, 60, 50, 20);
		month.setBounds(50, 100, 50, 20);
		day.setBounds(50, 140, 50, 20);
		res.setBounds(25, 180, 75, 20);

		// ��ӱ�ǩ
		fieldPanel.add(title);
		fieldPanel.add(year);
		fieldPanel.add(month);
		fieldPanel.add(day);
		fieldPanel.add(res);

		// ����������λ��
		input_year.setBounds(110, 60, 120, 20);
		input_month.setBounds(110, 100, 120, 20);
		input_day.setBounds(110, 140, 120, 20);
		tfRes.setBounds(110, 180, 120, 20);

		// ��������
		fieldPanel.add(input_year);
		fieldPanel.add(input_month);
		fieldPanel.add(input_day);
		fieldPanel.add(tfRes);

		container.add(fieldPanel, "Center");

		// ��Ӱ�ť
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(judge);
		buttonPanel.add(reset);

		// ��Ӽ���
		listerner();

		container.add(buttonPanel, "South");
	}

	public void listerner() {
		// ��ȡ�����ֵ����������һ��
		judge.addActionListener(e -> {
			String input_Year = input_year.getText();
			String input_Month = input_month.getText();
			String input_Day = input_day.getText();
			String judgeRes = checkInput(input_Year, input_Month, input_Day);
			tfRes.setText(judgeRes);
		});
		// ��������
		reset.addActionListener(e -> {
			input_year.setText("");
			input_month.setText("");
			input_day.setText("");
			tfRes.setText("");
		});
	}

	private String checkInput(String year, String month, String day) {

		String judgeRes = null;
		int yearInt = 0;
		int monthInt = 0;
		int dayInt = 0;

		try {
			yearInt = Integer.parseInt(year);
			monthInt = Integer.parseInt(month);
			dayInt = Integer.parseInt(day);
		} catch (Exception e) {
			return "��������Ƿ�";
		}
		if (monthInt == 2) {// 2��
			if (yearInt % 4 == 0) {// ����
				if (dayInt < 29) { // 2��29֮ǰ
					++dayInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				} else if (dayInt > 29) {
					judgeRes = " ������";
				} else { // 2��29
					dayInt = 1;
					++monthInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				}
			} else { // ������
				if (dayInt < 28) { // 2��28֮ǰ
					++dayInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				} else if (dayInt > 28) {
					judgeRes = " ������";
				} else { // 2��28��
					dayInt = 1;
					++monthInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				}
			}
		} else { // ��2��
			if (day_30month.contains(monthInt)) { // ����30����·�
				if (dayInt < 30) { // 29��֮ǰ
					++dayInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				} else if (dayInt > 30) { //
					judgeRes = " ������";
				} else { // ĳһ�������һ��
					dayInt = 1;
					++monthInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				}
			} else { // ��31����·�
				if (dayInt < 31) { // 30��֮ǰ
					++dayInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				} else if (dayInt > 31) {
					judgeRes = " ������";
				} else {
					dayInt = 1; // ������Ϊ1
					if (monthInt == 12) { // 12��31��
						monthInt = 1; // �·���Ϊ1
						++yearInt;
						judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
					} else {
						++monthInt;
						judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
					}
				}
			}
		}

		return judgeRes;
	}

	// ���նԴ�����в���
	public static void main(String[] args) {
		new date();
	}
}
