package triangle;

import javax.swing.*;
import java.awt.*;

public class jframe {
	
	// �����������ڵ�λ�ã����ֵ�
	public jframe() {
		jFrame.setBounds(800, 400, 350, 300);
		container.setLayout(new BorderLayout());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ��ʼ��
		init();
		jFrame.setVisible(true);
	}

	// ������ʵ����ز���
	private JFrame jFrame = new JFrame("�ж���������״");
	private Container container = jFrame.getContentPane();
	private JLabel a = new JLabel("A");
	private JTextField input_A = new JTextField();

	private JLabel b = new JLabel("B");
	private JTextField input_B = new JTextField();

	private JLabel c = new JLabel("C");
	private JTextField input_C = new JTextField();

	private JButton check = new JButton("�ж���״ ");
	private JButton reset = new JButton("��������");

	private JLabel res = new JLabel("��״");
	private JTextField tfRes = new JTextField();


	public void init() {//�����ڲ���ʵ��

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("����������1��200��������"));
		container.add(titlePanel, "North");

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		// ���ñ�ǩ��λ��
		a.setBounds(50, 20, 50, 20);
		b.setBounds(50, 60, 50, 20);
		c.setBounds(50, 100, 50, 20);
		res.setBounds(50, 140, 150, 20);

		// ��ӱ�ǩ
		fieldPanel.add(a);
		fieldPanel.add(b);
		fieldPanel.add(c);
		fieldPanel.add(res);

		// ����������λ��
		input_A.setBounds(110, 20, 120, 20);
		input_B.setBounds(110, 60, 120, 20);
		input_C.setBounds(110, 100, 120, 20);
		tfRes.setBounds(110, 140, 120, 20);

		// ��������
		fieldPanel.add(input_A);
		fieldPanel.add(input_B);
		fieldPanel.add(input_C);
		fieldPanel.add(tfRes);

		container.add(fieldPanel, "Center");

		// ��Ӱ�ť
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(check);
		buttonPanel.add(reset);

		// ��Ӽ���
		listerner();

		container.add(buttonPanel, "South");
	}

	public void listerner() {
		// ��ȡ�����ֵ�����ж�
		check.addActionListener(e -> {
			String A = input_A.getText();
			String B = input_B.getText();
			String C = input_C.getText();
			String result = checkInput(A, B, C);
			tfRes.setText(result);
		});
		// ���
		reset.addActionListener(e -> {
			input_A.setText("");
			input_B.setText("");
			input_C.setText("");
			tfRes.setText("");
		});
	}

	private String checkInput(String a, String b, String c) {
		String result = null;
		if (a == null || b == null || c == null || a.equals("") || b.equals("") || c.equals("") || a.equals(" ")
				|| b.equals(" ") || c.equals(" ")) {
			result = "��������Ƿ�";
		} else if (a.indexOf('.') != -1 || b.indexOf('.') != -1 || c.indexOf('.') != -1) {
			result = "��������Ƿ�";
		} else if (a.indexOf('-') != -1 || b.indexOf('-') != -1 || c.indexOf('-') != -1) {
			result = "�������볬��";
		} else {
			int aInt = 0;
			int bInt = 0;
			int cInt = 0;
			try {
				aInt = Integer.parseInt(a);
				bInt = Integer.parseInt(b);
				cInt = Integer.parseInt(c);
			} catch (Exception e) {
				return "��������Ƿ�";
			}
			if (aInt > 200 || bInt > 200 || cInt > 200) {
				result = "�������볬��";
			} else if (aInt + bInt < cInt || bInt + cInt < aInt || cInt + aInt < bInt || aInt + bInt == cInt
					|| bInt + cInt == aInt || cInt + aInt == bInt) {
				result = "���ܹ���������";
			} else if (aInt == bInt && bInt == cInt) {
				result = "�ȱ�������";
			} else if (aInt == bInt || bInt == cInt || cInt == aInt) {
				result = "����������";
			} else {
				result = "һ��������";
			}
		}
		return result;
	}

	// ���նԴ�����в���
	public static void main(String[] args) {
		new jframe();
	}
}
