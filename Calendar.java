import java.util.Calendar;
import java.util.*;
class PrintCalendar1{
	private int year;
	PrintCalendar1(int year){
		this.year=year;
	}
	public void show(){
	System.out.println("������"+year+"��");
	int month=0;
	int[] Month={0,31,28,31,30,31,30,31,31,30,30,30,31};//һ�굱�е�ÿ���µ���Ŀ
	if((year%400==0)||(year%4==0&&year%100!=0))
		Month[2]=29;
	if(month==0){
		for(int k=0;k<12;k++)
		{
			month++;	
	System.out.println(month+"��");
	int w;
	if(month==1||month==2) {
		w=(1+2*(month+12)+3*(month+13)/5+year-1+(year-1)/4-(year-1)/100+(year-1)/400)%7+1;//��ķ����ɭ��ʽ
	}
	else
	{
	w=(1+2*month+3*(month+1)/5+year+year/4-year/100+year/400)%7+1;//���µ�һ�����ڼ�
	}
	if(w==7)
	{
		w=0;
	}
	int count=0;
	System.out.println("Sun\t"+"Mon\t"+"Tue\t"+"Wed\t"+"Thu\t"+"Fri\t"+"Sat\t");
	while(w!=0){
		System.out.print("\t");
		w--;
		count++;
	}
	for(int i=0;i<Month[month];i++){
		System.out.print((i+1)+"\t");
		count++;
		if(count%7==0)
			System.out.println();
	}
	System.out.println();
	}
}
	}
	}

class PrintCalendar2{
	private int year;
	private int month;
	PrintCalendar2(int year,int month){
		this.year=year;
		this.month=month;
	}
	public void show(){
	System.out.println("������"+year+"��"+month+"��");
	int[] Month={0,31,28,31,30,31,30,31,31,30,30,30,31};
	if((year%400==0)||(year%4==0&&year%100!=0))
		Month[2]=29;
	int w;
	if(month==1||month==2) {
		w=(1+2*(month+12)+3*(month+13)/5+year-1+(year-1)/4-(year-1)/100+(year-1)/400)%7+1;
		}
	else
	{
	w=(1+2*month+3*(month+1)/5+year+year/4-year/100+year/400)%7+1;
	}
	if(w==7)
	{
		w=0;
	}
	int count=0;
	System.out.println("Sun\t"+"Mon\t"+"Tue\t"+"Wed\t"+"Thu\t"+"Fri\t"+"Sat\t");
	while(w!=0){
		System.out.print("\t");
		w--;
		count++;
	}
	for(int i=0;i<Month[month];i++){
		System.out.print((i+1)+"\t");
		count++;
		if(count%7==0)
			System.out.println();
	}
	System.out.println();
	}
	}
public class Calendar{
	private static Sacnner scanner=new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("��ѡ��ʹ�÷���");
		System.out.println("1:���������");
		System.out.println("2:���������");
		int count;
		count=scanner.nextInt();
		if(count==1)
		{
			int year;
			System.out.println("���������");
			year=sacnner.nextInt();
			PrintCalendar1 c1=new PrintCalendar1(year);
			c1.show();
		}
		else if(count==2)
		{
			int year;
			int month;
			System.out.println("���������");
			year=sacnner.nextInt();
			System.out.println("�������·�");
			year=sacnner.nextInt();
			PrintCalendar2 c2=new PrintCalendar2(year,month);
			c2.show();
		}
	}
}