import java.util.Scanner;
class EB_1{
	String consumer_no;
	String consumer_name;
	double previous_month_reading;
	double current_month_reading;
	String typeOfEBConnection;
	
	
	public EB_1(String consumer_no,String consumer_name,double previous_month_reading,
		double current_month_reading, String typeOfEBConnection)
	{
	this.consumer_no = consumer_no;
	this.consumer_name = consumer_name;
	this.previous_month_reading = previous_month_reading;
	this.current_month_reading = current_month_reading;
	this.typeOfEBConnection = typeOfEBConnection;
	}

	double computeEB(){
		double unitsConsumed = current_month_reading - previous_month_reading;
        double amount = 0.0;
		if(typeOfEBConnection.equals("Domestic"))
		{
			 if (unitsConsumed <= 100) {
                amount = unitsConsumed * 1;
            } else if (unitsConsumed <= 200) {
                amount = 100 * 1 + (unitsConsumed - 100) * 2.5;
            } else if (unitsConsumed <= 500) {
                amount = 100 * 1 + 100 * 2.5 + (unitsConsumed - 200) * 4;
            } else {
                amount = 100 * 1 + 100 * 2.5 + 300 * 4 + (unitsConsumed - 500) * 6;
            }
        } else if (typeOfEBConnection.equalsIgnoreCase("commercial")) {
            if (unitsConsumed <= 100) {
                amount = unitsConsumed * 2;
            } else if (unitsConsumed <= 200) {
                amount = 100 * 2 + (unitsConsumed - 100) * 4.5;
            } else if (unitsConsumed <= 500) {
                amount = 100 * 2 + 100 * 4.5 + (unitsConsumed - 200) * 6;
            } else {
                amount = 100 * 2 + 100 * 4.5 + 300 * 6 + (unitsConsumed - 500) * 7;
            }
        }

		return amount;
	}
}

class EB{
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Consumer Number: ");
        String consumer_no = scanner.nextLine();

        System.out.println("Enter Consumer Name: ");
        String consumer_name = scanner.nextLine();

        System.out.println("Enter Previous Month Reading: ");
        double previous_month_reading = scanner.nextDouble();

        System.out.println("Enter Current Month Reading: ");
        double current_month_reading = scanner.nextDouble();
		
		scanner.nextLine();

        System.out.println("Enter Connection Type (Domestic/Commercial): ");
        String typeOfEBConnection = scanner.nextLine();


        EB_1 bill = new EB_1(consumer_no,consumer_name,previous_month_reading,current_month_reading,typeOfEBConnection);
		double amount = bill.computeEB();

        System.out.println("Electricity Bill: Rs. " + amount);
   
	}
}