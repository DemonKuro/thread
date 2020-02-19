import java.lang.Thread;
import java.util.Scanner;

class StreamThread extends Thread
{
	String text;
	long pause;
	public StreamThread(String text, long pause){
		this.text = text;
		this.pause = pause;
	}
	public void run(){
		System.out.println(text + " start");
		try {
			Thread.sleep(pause);
		}
		catch (InterruptedException e) {
			System.out.println("Interrupt");
		}
		System.out.println(text + " end");
	}
}

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("First stream text: ");
		String text1 = scan.nextLine();
		System.out.print("First stream pause: ");
		long pause1 = scan.nextLong();
		scan.nextLine();
		System.out.print("Second stream text: ");
		String text2 = scan.nextLine();
		System.out.print("Second stream pause: ");
		long pause2 = scan.nextLong();
		StreamThread thread1 = new StreamThread(text1, pause1);
		StreamThread thread2 = new StreamThread(text2, pause2);
		thread1.start();
		thread2.start();		
	}
}