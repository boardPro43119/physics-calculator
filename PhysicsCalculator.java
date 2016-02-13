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