import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Object {
	static String driver="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/dataname?characterEncoding=utf8&useSSL=false";//耗时极长
	static String user="root";
	static String pass="123456";
	private Connection conn;
	public Object()throws ClassNotFoundException{
		String sql="create table if not exists student(name varchar(15),ID bigint,";
				sql+="math int,os int,java int)";
		try{
			if(conn!=null)  return;
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pass);
			Statement sta=conn.createStatement();
			sta.executeUpdate(sql);
			sta.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void close()throws SQLException{
		if(conn!=null) conn.close();
	}
	
	public void add(Student stu){
		String sql="insert into student(name,ID,math,os,java)"+"values(?,?,?,?,?)";//values赋值
		try{
			PreparedStatement p=conn.prepareStatement(sql);
			p.setString(1,stu.getname());
			p.setLong(2, stu.getID());
			p.setDouble(3, stu.getmath());
			p.setDouble(4, stu.getos());
			p.setDouble(5, stu.getjava());
			p.executeUpdate();
			p.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void dispALL()throws Exception{
		Statement sta=conn.createStatement();
		String sql="select * from student";
		ResultSet rs=sta.executeQuery(sql);
		System.out.println("姓名"+"\t"+"学号"+"\t"+"数学"+"\t"+"操作系统"+"\t"+"java");
		while(rs.next()){
			/*String name=rs.getString("name");
			long ID=rs.getLong("ID");
			int math=rs.getInt("math");
			int os=rs.getInt("os");
			int java=rs.getInt("java");
			System.out.printf("%s,%d,%d,%d,%d", name,ID,math,os,java);*/
			System.out.println(rs.getString(1)+"\t"+rs.getLong(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
		}
		rs.close();
		sta.close();
	}
	
	public void findByID(long ID)throws Exception{
		String sql="select * from student where ID="+ID;
		Statement sta=conn.createStatement();
		ResultSet r=sta.executeQuery(sql);
		while(r.next()){
			String name=r.getString("name");
			long ID1=r.getLong("ID");
			int math=r.getInt("math");
			int os=r.getInt("os");
			int java=r.getInt("java");
			Student stu=new Student();
			stu.setname(name);
			stu.setID(ID1);
			stu.setmath(math);
			stu.setos(os);
			stu.setjava(java);
			System.out.println(stu.toString());
		}
	}
	
	public void findByname(String name)throws Exception{
		String sql="select * from student where name=?";
		PreparedStatement p=conn.prepareStatement(sql);
		p.setString(1,name);//name跟数据里存储过程里的第一个字段比较
		ResultSet r=p.executeQuery();
		while(r.next()){
			String name1=r.getString("name");
			long ID=r.getLong("ID");
			int math=r.getInt("math");
			int os=r.getInt("os");
			int java=r.getInt("java");
			Student stu=new Student();
			stu.setname(name1);
			stu.setID(ID);
			stu.setmath(math);
			stu.setos(os);
			stu.setjava(java);
			System.out.println(stu.toString());
		}
	}
	
	public void Revise(String name,long ID,int math,int os,int java,long id)throws Exception{
		String sql="update student set name=?,ID=?,math=?,os=?,java=? where ID='"+id+"'";	
		PreparedStatement p=conn.prepareStatement(sql);
		//ResultSet r=p.executeQuery();
		try{
			p.setString(1,name);
			p.setLong(2,ID);
			p.setInt(3, math);
			p.setInt(4, os);
			p.setInt(5, java);
			System.out.println("修改学生信息成功");
			p.executeUpdate();
			p.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void Revise1(String name,long ID)throws Exception{
		String sql="update student set name=? where ID='"+ID+"'";	
		PreparedStatement p=conn.prepareStatement(sql);
		//ResultSet r=p.executeQuery();
		try{
			p.setString(1,name);
			//p.setLong(2,ID);,			System.out.println("修改姓名成功");
			p.executeUpdate();
			p.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void Revise2(long ID,long id)throws Exception{//不以学号作参照;以学号做参照耗时极长
		String sql="update student set ID=? where ID='"+id+"'";	
		PreparedStatement p=conn.prepareStatement(sql);
		//ResultSet r=p.executeQuery();
		try{
			p.setLong(1,ID);
			//p.setLong(2,ID);
			System.out.println("修改成功");
			p.executeUpdate();
			p.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void Revise3(int math,long ID)throws Exception{
		String sql="update student set math=? where ID='"+ID+"'";	
		PreparedStatement p=conn.prepareStatement(sql);
		//ResultSet r=p.executeQuery();
		try{
			p.setInt(1,math);
			//p.setLong(2,ID);
			System.out.println("修改成功");
			p.executeUpdate();
			p.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void Revise4(int os,long ID)throws Exception{
		String sql="update student set os=? where ID='"+ID+"'";	
		PreparedStatement p=conn.prepareStatement(sql);
		//ResultSet r=p.executeQuery();
		try{
			p.setInt(1,os);
			//p.setLong(2,ID);
			System.out.println("修改成功");
			p.executeUpdate();
			p.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void Revise5(int java,long ID)throws Exception{
		String sql="update student set java=? where ID='"+ID+"'";	
		PreparedStatement p=conn.prepareStatement(sql);
		//ResultSet r=p.executeQuery();
		try{
			p.setInt(1,java);
			//p.setLong(2,ID);
			System.out.println("修改成功");
			p.executeUpdate();
			p.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void delyByID(long ID){
		String sql="delete from student where ID="+ID;
		try{
			Statement sta=conn.createStatement();
			sta.executeUpdate(sql);
			sta.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void delyByname(String name){
		String sql="delete from student where name='"+name+"'";//耗时极长
		try{
			//PreparedStatement p=conn.prepareStatement(sql);
			//p.setString(1,name);
			//p.executeUpdate(sql);
			Statement sta=conn.createStatement();
			sta.executeUpdate(sql);
			sta.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void sort(String course)throws Exception{
		String sql="select * from student";
		Statement s=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//允许前后特定访问；只允许向前访问一次
		ResultSet r=s.executeQuery(sql);
		r.last();//尾节点
		int total=r.getRow();
		Student[]stu=new Student[total];
		int index=0;
		r.beforeFirst();//ResultSet.TYPE_FORWARD_ONLY，只向前的游标
		while(r.next()){
			String name=r.getString("name");
			long ID=r.getLong("ID");
			int math=r.getInt("math");
			int os=r.getInt("os");
			int java=r.getInt("java");
			Student stu1=new Student();
			stu1.setname(name);
			stu1.setID(ID);
			stu1.setmath(math);
			stu1.setos(os);
			stu1.setjava(java);
			stu[index]=stu1;
			index++;
		}
		courseChoose(stu,course);
		System.out.println("姓名"+"\t"+"学号"+"\t"+"数学"+"\t"+"操作系统"+"\t"+"java");
		for(int m=0;m<stu.length;m++){
			System.out.println(stu[m].getname()+"\t"+stu[m].getID()+"\t"+stu[m].getmath()+"\t"+stu[m].getos()+"\t"+stu[m].getjava());
		}
		r.close();
		s.close();
	}
	
	public void courseChoose(Student[]stu,String course){
		if(course.equals("math")){//匹配
			for(int i=0;i<stu.length;i++){
				for(int j=i+1;j<stu.length;j++){
					Student stu2=new Student();
					if(stu[i].getmath()<stu[j].getmath()){
						stu2=stu[i];
						stu[i]=stu[j];
						stu[j]=stu2;
					}
				}
			}
		}
		else if(course.equals("os")){
			for(int i=0;i<stu.length;i++){
				for(int j=i+1;j<stu.length;j++){
					Student stu2=new Student();
					if(stu[i].getos()<stu[j].getos()){
						stu2=stu[i];
						stu[i]=stu[j];
						stu[j]=stu2;
					}
				}
			}
		}
		else if(course.equals("java")){
			for(int i=0;i<stu.length;i++){
				for(int j=i+1;j<stu.length;j++){
					Student stu2=new Student();
					if(stu[i].getjava()<stu[j].getjava()){
						stu2=stu[i];
						stu[i]=stu[j];
						stu[j]=stu2;
					}
				}
			}
		}
	}
	public void PassStu()throws Exception{
		Statement sta=conn.createStatement();
		String sql="select * from student";
		ResultSet rs=sta.executeQuery(sql);
		int count=0;
         while(rs.next()) {  
        	String name=rs.getString(1);
            long ID=rs.getLong(2);   
            int math = rs.getInt(3);
            int os=rs.getInt(4);
            int java=rs.getInt(5);
            if(math>= 60 && os>=60 && java>=60){  
            	System.out.println(rs.getString(1)+"\t"+rs.getLong(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
            	count++;
            }
            }
         System.out.println("及格人数:"+count);       
     }
	public void menu() throws Exception{
		String name;
		long ID;
		int math;
		int os;
		int java;
		Scanner scanner=new Scanner(System.in);
		System.out.println("                 学生信息管理系统                    ");
		System.out.println("    1.添加学生信息                        2.显示学生信息");
		System.out.println("   3.按学号查找                                4.按姓名查找");
		System.out.println("  5.按学号删除                                    6.按姓名删除");
		System.out.println(" 7.按成绩排序                                        8.及格学生");
		System.out.println("9.修改学生信息                                        10.退出");
		switch(scanner.nextInt()){
		case 1:
			System.out.println("输入姓名：");  
			name=scanner.next();
			System.out.println("输入学号：");  
			ID=scanner.nextLong();
			System.out.println("输入数学成绩：");  
			math=scanner.nextInt();
			System.out.println("输入操作系统成绩：");  
			os=scanner.nextInt();
			System.out.println("输入java成绩：");  
			java=scanner.nextInt();
			Student stu=new Student();
			stu.setID(ID);   stu.setname(name);  stu.setmath(math);
			stu.setos(os);    stu.setjava(java);
			add(stu);
			System.out.println("添加学生信息成功。");
			menu();
			break;
		case 2:
			dispALL();
			menu();
			break;
		case 3:
			System.out.println("输入要查找的学号：");
			ID=scanner.nextLong();
			findByID(ID);
			menu();
			break;
		case 4:
			System.out.println("输入要查找的姓名:");
			name=scanner.next();
			findByname(name);
			menu();
			break;
		case 5:
			System.out.println("输入要删除的学生学号：");
			ID=scanner.nextLong();
			delyByID(ID);
			menu();
			break;
		case 6:
			System.out.println("输入要删除的学生姓名：");
			name=scanner.next();
			delyByname(name);
			menu();
			break;
		case 7:
			System.out.println("1：按数学成绩     2：按os成绩        3：按java成绩");
			int choice=scanner.nextInt();
			if(choice==1)
				sort("math");
			if(choice==2)
				sort("os");
			if(choice==3)
				sort("java");
			menu();
			break;
		case 8:
			System.out.println("及格学生");
			PassStu();
			menu();
			break;
		case 9:
			System.out.println("1:单项修改                  2：全部修改");
			int choice1=scanner.nextInt();
			if(choice1==1)
			{
			System.out.println("1:修改姓名     2：修改学号      3：修改数学    4：修改OS    5:修改java");
			int choice2=scanner.nextInt();
			if(choice2==1) {
				System.out.println("输入所修改学生学号");
				ID=scanner.nextLong();
				System.out.println("输入修改姓名");
				name=scanner.next();
				Revise1(name,ID);
				System.out.println("修改学生姓名成功");
				}
			if(choice2==2) {
				long id;
				System.out.println("输入所修改学生学号");
				id=scanner.nextLong();
				System.out.println("输入修改学号");
				ID=scanner.nextLong();
				Revise2(ID,id);
				System.out.println("修改学生学号成功");
				}
			if(choice2==3) {
				System.out.println("输入所修改学生学号");
				ID=scanner.nextLong();
				System.out.println("输入修改数学成绩");
				math=scanner.nextInt();
				Revise3(math,ID);
				System.out.println("修改数学成绩成功");
			}
			if(choice2==4) {
				System.out.println("输入所修改学生学号");
				ID=scanner.nextLong();
				System.out.println("输入修改操作系统成绩");
				os=scanner.nextInt();
				Revise4(os,ID);
				System.out.println("修改学生os成绩成功");
				}
			if(choice2==5) {
				System.out.println("输入所修改学生学号");
				ID=scanner.nextLong();
				System.out.println("输入修改java成绩");
				os=scanner.nextInt();
				Revise4(os,ID);
				System.out.println("修改学生java成绩成功");
				}
			}
			else if(choice1==2) {
				long id;
				System.out.println("输入所修改学生学号");
				id=scanner.nextLong();
				System.out.println("输入修改姓名：");  
				name=scanner.next();
				System.out.println("输入修改学号：");  
				ID=scanner.nextLong();
				System.out.println("输入修改数学成绩：");  
				math=scanner.nextInt();
				System.out.println("输入修改操作系统成绩：");  
				os=scanner.nextInt();
				System.out.println("输入修改java成绩：");  
				java=scanner.nextInt();
				Revise(name, ID, math, os, java, id);
				System.out.println("修改学生信息成功");
			}
			menu();
		case 10:
			scanner.close();
			break;
		default:
			System.out.println("输入错误");
			menu();
		}
	}
	public static void main(String args[]) throws Exception{
		Object o=new Object();
		o.menu();
		o.close();
	}
}
