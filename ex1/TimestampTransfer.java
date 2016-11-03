package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		//标准输入
		Scanner scanner = new Scanner(System.in);
		//更改日期格式（输入的格式）
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//更改日期格式（输出的日期）
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//用while循环从标准输入获取值
		while (scanner.hasNext()){
			//将获取的值放入line
			String line = scanner.nextLine();
			//定义一个Date类型的变量
			Date lineDate = null;
			//定义一个long类型的变量
			long lineTimestamp;
			//异常处理
			try {
				//将字符串类型转成输入格式的日期类型并赋给lineDate
				lineDate = inputFormat.parse(line);
				//将lineDate中的日期转换成long类型赋给lineTimestamp
				lineTimestamp = lineDate.getTime();
				//将lineDate转换成输出格式的日期类型并输出+to+lineTimestamp
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
