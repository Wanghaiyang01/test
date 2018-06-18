import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.io.FileWriter;
class Student implements Serializable{
	private String id;
	private String name;
	private int age;
	public Student(String id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	@Override public String toString(){
		return id+" "+name+" "+age;
	}
}
	public class ObjectStreamDemo{
		private static Scanner scanner=new Scanner(System.in);
		public void read() throws Exception{
			ObjectInputStream objin=new ObjectInputStream(new FileInputStream("stu.txt"));
			int num=objin.readInt();
			Student[] stus=new Student[num];
			for(int i=0;i<num;i++)
			{
			stus[i]=(Student)objin.readObject();
		}
		objin.close();
		disp(stus);
	}
	public void disp(Student[] stus){
		System.out.println("the information of student is:");
		for(Student stu:stus){
			if(stu==null) 
				break;
			System.out.println(stu);
		}		
}

	 public static void method2(String fileName, String content) {     
	        try {     
	            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件     
	            FileWriter writer = new FileWriter(fileName, true);     
	            writer.write(content);     
	            writer.close();     
	        } catch (IOException e) {     
	            e.printStackTrace();     
	        }     
	    }  //可追加学生信息   
	public static void main(String[] args)throws Exception{
		int count1,count2,i=0;
		ObjectStreamDemo demo=new ObjectStreamDemo();
		System.out.println("please input number:");
		System.out.println("1:save student's information");
		System.out.println("2:display student's information");
		count1=scanner.nextInt();
		if(count1==1){
		String id;
		String name;
		int age;
		System.out.println("input the number of students:");
		//count2=scanner.nextInt();
		Student[] stus=new Student[50];
		while(true) {
	    try {
	    	//ArrayList<Student> stus = new ArrayList<Student>();
	    	//ArrayList stus = new ArrayList ();
			System.out.println("input id:");
			id=scanner.next();
			System.out.println("input name:");
			name=scanner.next();
			System.out.println("input age:");
			age=scanner.nextInt();
			System.out.println("do you want continue add?");
			System.out.println("input 0 is exit");
			System.out.println("input other is continue");
			stus[i]=new Student(id,name,age);
			i++;
			int count=scanner.nextInt();
			if(count==0)
				break;
		}catch(InputMismatchException ex) {
			scanner.nextLine();
			System.out.println("input error,retry");
		}
		}
	    //demo.save(stus);
		demo.method2("stu.txt", "zhuijia");
		System.out.println("student's information has saved");
		}
		if(count1==2){
		demo.read();
		}
	}
}