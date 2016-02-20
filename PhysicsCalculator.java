/**
* Benjamin Prud'homme
* February 13, 2016
*
* Solves for one value given several others from the following list:
* displacement, initial velocity, final velocity, acceleration, and time.
*/

import java.util.Scanner;
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
			input = in.next();
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
							System.out.print("Do you know (1) acceleration or (2) final velocity? ");
							
							input = in.next();
							switch(input){
								case "1":
									System.out.print("Acceleration (m/s^2): ");
									acceleration = in.nextDouble();
									displacement = (initVelocity*time)+(0.5*acceleration*time*time);
									System.out.println("Displacement: " + displacement + " meters");
									break;
								case "acceleration":
									System.out.print("Acceleration (m/s^2): ");
									acceleration = in.nextDouble();
									displacement = (initVelocity*time)+(0.5*acceleration*time*time);
									System.out.println("Displacement: " + displacement + " meters");
									break;
								case "2":
									System.out.print("Final velocity (m/s): ");
									finalVelocity = in.nextDouble();
									displacement = 0.5*(initVelocity+finalVelocity)*time;
									System.out.println("Displacement: " + displacement + " meters");
									break;
								case "final velocity":
									System.out.print("Final velocity (m/s): ");
									finalVelocity = in.nextDouble();
									displacement = 0.5*(initVelocity+finalVelocity)*time;
									System.out.println("Displacement: " + displacement + " meters");
									break;
								default:
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

				case "time":

				default:
					System.out.println("Invalid input, please try again.");
					invalidInput = true;
			}
		}
		while(invalidInput);
	}
}