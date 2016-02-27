/**
 * Benjamin Prud'homme
 * Latest commit: February 27, 2016
 *
 * Solves for one value given several others from the following list:
 * displacement, initial velocity, final velocity, acceleration, and time.
 */

import java.util.Scanner;
import java.math.*;
public class PhysicsCalculator {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input;
		double displacement,
			   initVelocity,
			   finalVelocity,
			   acceleration,
			   time;
		boolean invalidInput;

		do
		{
			System.out.println("Choose one of the following values to solve for: " + 
							"displacement (m) , initial or final velocity (m/s), " +
							"acceleration (m/s^2), or time (s).");
			input = in.nextLine();
			invalidInput = false;
			switch(input)
			{
				case "acceleration":
					do
					{
						try {
							invalidInput = false;
							System.out.println("Enter the following given values:");
							System.out.print("Initial velocity (m/s): ");
							initVelocity = in.nextDouble();
							System.out.print("Final velocity (m/s): ");
							finalVelocity = in.nextDouble();
							System.out.print("Time (s): ");
							time = in.nextDouble();
							acceleration = (finalVelocity-initVelocity)/time;
							System.out.println("Acceleration = " + acceleration + " m/s^2");
						} catch(RuntimeException e) {
							System.out.println("Invalid input, please try again.");
							in.next();
							invalidInput = true;
						}
					}
					while(invalidInput);

					break;
				case "displacement":
					do
					{
						try {
							invalidInput = false;
							System.out.println("Enter the following given values:");
							System.out.print("Initial velocity (m/s): ");
							initVelocity = in.nextDouble();
							System.out.print("Time (s): ");
							time = in.nextDouble();
							in.nextLine(); //consume newline character from input stream
							System.out.print("Do you know (1) acceleration or (2) final velocity? ");
							
							input = in.nextLine();
							switch(input){
								case "1":
								case "acceleration":
									System.out.print("Acceleration (m/s^2): ");
									acceleration = in.nextDouble();
									displacement = (initVelocity*time)+(0.5*acceleration*time*time);
									System.out.println("Displacement: " + displacement + " meters");
									break;
								case "2":
								case "final velocity":
									System.out.print("Final velocity (m/s): ");
									finalVelocity = in.nextDouble();
									displacement = 0.5*(initVelocity+finalVelocity)*time;
									System.out.println("Displacement: " + displacement + " meters");
									break;
								default:
									System.out.println("Invalid input, please try again.");
									invalidInput=true;
							}
						} catch(RuntimeException e) {
							System.out.println("Invalid input, please try again.");
							in.next();
							invalidInput = true;
						}
					}
					while(invalidInput);
					break;

				case "initial velocity":

				case "final velocity":
					do
					{
						try {
							invalidInput = false;
							System.out.println("Enter the following given values:");
							System.out.print("Initial velocity (m/s): ");
							initVelocity = in.nextDouble();
							System.out.print("Acceleration (m/s): ");
							acceleration = in.nextDouble();
							in.nextLine(); //consume newline character from input stream
							System.out.print("Do you know (1) displacement or (2) time? ");
							
							input = in.nextLine();
							switch(input){
								case "1":
								case "displacement":
									System.out.print("Displacement (m): ");
									displacement = in.nextDouble();
									finalVelocity = Math.sqrt(Math.pow(initVelocity, 2)+(2*acceleration*displacement));
									System.out.println("Final velocity: " + finalVelocity + " m/s");
									break;
								case "2":
								case "time":
									System.out.print("Time (s): ");
									time = in.nextDouble();
									finalVelocity = initVelocity+(acceleration*time);
									System.out.println("Final velocity: " + finalVelocity + " m/s");
									break;
								default:
									System.out.println("Invalid input, please try again.");
									invalidInput=true;
							}
						} catch(RuntimeException e) {
							System.out.println("Invalid input, please try again.");
							in.next();
							invalidInput = true;
						}
					}
					while(invalidInput);
					break;
				case "time":

				default:
					System.out.println("Invalid input, please try again.");
					invalidInput = true;
			}
		}
		while(invalidInput);
	}
}