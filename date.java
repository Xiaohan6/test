package triangle;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class date {
	// 声明整个窗口的位置，布局等
	public date() {
		jFrame.setBounds(800, 400, 350, 300);
		container.setLayout(new BorderLayout());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 初始化
		init();
		jFrame.setVisible(true);
	}

	// 声明和实现相关部件
	private JFrame jFrame = new JFrame("计算下一天");
	private Container container = jFrame.getContentPane();

	private JLabel title = new JLabel("请分别输入年、月、日：");

	private JLabel year = new JLabel("年");
	private JTextField input_year = new JTextField();

	private JLabel month = new JLabel("月");
	private JTextField input_month = new JTextField();

	private JLabel day = new JLabel("日");
	private JTextField input_day = new JTextField();

	private JLabel res = new JLabel("下一天");
	private JTextField tfRes = new JTextField();

	private JButton judge = new JButton("计算下一天");
	private JButton reset = new JButton("重新输入");

	private static final HashSet<Integer> day_30month = new HashSet<>();

	// 把天数为30的月份专门记录下来
	static {
		day_30month.add(4);
		day_30month.add(6);
		day_30month.add(9);
		day_30month.add(11);
	}

	// 布局内部的实现
	public void init() {

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		// 设置标签的位置
		title.setBounds(100, 20, 200, 20);
		year.setBounds(50, 60, 50, 20);
		month.setBounds(50, 100, 50, 20);
		day.setBounds(50, 140, 50, 20);
		res.setBounds(25, 180, 75, 20);

		// 添加标签
		fieldPanel.add(title);
		fieldPanel.add(year);
		fieldPanel.add(month);
		fieldPanel.add(day);
		fieldPanel.add(res);

		// 设置输入框的位置
		input_year.setBounds(110, 60, 120, 20);
		input_month.setBounds(110, 100, 120, 20);
		input_day.setBounds(110, 140, 120, 20);
		tfRes.setBounds(110, 180, 120, 20);

		// 添加输入框
		fieldPanel.add(input_year);
		fieldPanel.add(input_month);
		fieldPanel.add(input_day);
		fieldPanel.add(tfRes);

		container.add(fieldPanel, "Center");

		// 添加按钮
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(judge);
		buttonPanel.add(reset);

		// 添加监听
		listerner();

		container.add(buttonPanel, "South");
	}

	public void listerner() {
		// 获取输入的值，并计算下一天
		judge.addActionListener(e -> {
			String input_Year = input_year.getText();
			String input_Month = input_month.getText();
			String input_Day = input_day.getText();
			String judgeRes = checkInput(input_Year, input_Month, input_Day);
			tfRes.setText(judgeRes);
		});
		// 重新输入
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
			return "参数输入非法";
		}
		if (monthInt == 2) {// 2月
			if (yearInt % 4 == 0) {// 闰年
				if (dayInt < 29) { // 2月29之前
					++dayInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				} else if (dayInt > 29) {
					judgeRes = " 不可能";
				} else { // 2月29
					dayInt = 1;
					++monthInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				}
			} else { // 非闰年
				if (dayInt < 28) { // 2月28之前
					++dayInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				} else if (dayInt > 28) {
					judgeRes = " 不可能";
				} else { // 2月28日
					dayInt = 1;
					++monthInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				}
			}
		} else { // 非2月
			if (day_30month.contains(monthInt)) { // 仅有30天的月份
				if (dayInt < 30) { // 29及之前
					++dayInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				} else if (dayInt > 30) { //
					judgeRes = " 不可能";
				} else { // 某一个月最后一天
					dayInt = 1;
					++monthInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				}
			} else { // 有31天的月份
				if (dayInt < 31) { // 30及之前
					++dayInt;
					judgeRes = yearInt + "/" + monthInt + "/" + dayInt;
				} else if (dayInt > 31) {
					judgeRes = " 不可能";
				} else {
					dayInt = 1; // 天数置为1
					if (monthInt == 12) { // 12月31日
						monthInt = 1; // 月份置为1
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

	// 最终对代码进行测试
	public static void main(String[] args) {
		new date();
	}
}
