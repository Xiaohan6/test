package triangle;

import javax.swing.*;
import java.awt.*;

public class jframe {
	
	// 声明整个窗口的位置，布局等
	public jframe() {
		jFrame.setBounds(800, 400, 350, 300);
		container.setLayout(new BorderLayout());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 初始化
		init();
		jFrame.setVisible(true);
	}

	// 声明和实现相关部件
	private JFrame jFrame = new JFrame("判断三角形形状");
	private Container container = jFrame.getContentPane();
	private JLabel a = new JLabel("A");
	private JTextField input_A = new JTextField();

	private JLabel b = new JLabel("B");
	private JTextField input_B = new JTextField();

	private JLabel c = new JLabel("C");
	private JTextField input_C = new JTextField();

	private JButton check = new JButton("判断形状 ");
	private JButton reset = new JButton("重新输入");

	private JLabel res = new JLabel("形状");
	private JTextField tfRes = new JTextField();


	public void init() {//布局内部的实现

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("请输入三个1至200的整数："));
		container.add(titlePanel, "North");

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		// 设置标签的位置
		a.setBounds(50, 20, 50, 20);
		b.setBounds(50, 60, 50, 20);
		c.setBounds(50, 100, 50, 20);
		res.setBounds(50, 140, 150, 20);

		// 添加标签
		fieldPanel.add(a);
		fieldPanel.add(b);
		fieldPanel.add(c);
		fieldPanel.add(res);

		// 设置输入框的位置
		input_A.setBounds(110, 20, 120, 20);
		input_B.setBounds(110, 60, 120, 20);
		input_C.setBounds(110, 100, 120, 20);
		tfRes.setBounds(110, 140, 120, 20);

		// 添加输入框
		fieldPanel.add(input_A);
		fieldPanel.add(input_B);
		fieldPanel.add(input_C);
		fieldPanel.add(tfRes);

		container.add(fieldPanel, "Center");

		// 添加按钮
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(check);
		buttonPanel.add(reset);

		// 添加监听
		listerner();

		container.add(buttonPanel, "South");
	}

	public void listerner() {
		// 获取输入的值，并判断
		check.addActionListener(e -> {
			String A = input_A.getText();
			String B = input_B.getText();
			String C = input_C.getText();
			String result = checkInput(A, B, C);
			tfRes.setText(result);
		});
		// 清空
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
			result = "参数输入非法";
		} else if (a.indexOf('.') != -1 || b.indexOf('.') != -1 || c.indexOf('.') != -1) {
			result = "参数输入非法";
		} else if (a.indexOf('-') != -1 || b.indexOf('-') != -1 || c.indexOf('-') != -1) {
			result = "参数输入超限";
		} else {
			int aInt = 0;
			int bInt = 0;
			int cInt = 0;
			try {
				aInt = Integer.parseInt(a);
				bInt = Integer.parseInt(b);
				cInt = Integer.parseInt(c);
			} catch (Exception e) {
				return "参数输入非法";
			}
			if (aInt > 200 || bInt > 200 || cInt > 200) {
				result = "参数输入超限";
			} else if (aInt + bInt < cInt || bInt + cInt < aInt || cInt + aInt < bInt || aInt + bInt == cInt
					|| bInt + cInt == aInt || cInt + aInt == bInt) {
				result = "不能构成三角形";
			} else if (aInt == bInt && bInt == cInt) {
				result = "等边三角形";
			} else if (aInt == bInt || bInt == cInt || cInt == aInt) {
				result = "等腰三角形";
			} else {
				result = "一般三角形";
			}
		}
		return result;
	}

	// 最终对代码进行测试
	public static void main(String[] args) {
		new jframe();
	}
}
