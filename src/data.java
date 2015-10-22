
/**
 * Main heating class
 * 
 * @author William Grey
 * @version 18th October 2015
 * 
 *  This is free and unencumbered software released into the public domain
 *  For more information, please refer to http://unlicence.org
 * 
 */


public class data {
	
	public data() {
		  
	}
	
	// Number of air changes per hour for 20 mph wind. 
	 public static final int ACH50=2;     
	
	 public static final String[] month = {"Jan","Feb","Mar","Apr",
		                                   "May","Jun","Jul","Aug",
		                                   "Sep","Oct","Nov","Dec"};
	 
	 // Mean monthly min and max for UK
     // temperature from Met Office
	 
	 public static final double[] minAmbientT = { 0.9, 0.7, 2.1, 3.4, 6.0, 8.8,
		                                         10.9,10.8, 8.8, 6.2, 3.3, 1.1};
	 
	 public static final double[] maxAmbientT = { 6.4,  6.6,  8.9, 11.4, 14.7, 17.3, 
		                                         19.4, 19.1, 16.5, 12.8,  9.1,  6.7};
	 
	 
	 public static final String[] wall = {  "poorly insulated walls",  "moderately insulated walls", "well insulated walls" };
	 public static final String[] floor = {  "poorly insulated floor",  "modeerately insulated floor", "well insulated floor" };
	 public static final String[] roof = {  "poorly insulated roof",  "modeerately insulated roof", "well insulated roof" };
	 public static final String[] win = {  "single glazing", "double glazing", "triple glazing"};
	 public static final String[] door = {  "poorly insulated door", "moderately insulated door",  "well insulated door" };
	 
	 public static final double[] UWall = {1.5,0.85,0.25};
	 public static final double[] UFloor = {1.0,0.6,0.2};
	 public static final double[] URoof = {1.0,0.6,0.15};
	 public static final double[] UWin = {5.7,3.3,1.8};
	 public static final double[] UDoor = {2.0,1.0,0.5};
	 
	 public static final String[] k_description = {"wooden door",
                                                   "clay bricks",
                                                   "Glass fibre",
                                                   "Concrete blocks"};

	public static final double[] k_values = {0.09,0.85,0.044,0.25};
    public static final double[] k_thickness = {0.1,0.1,0.1,0.1};
	 
    // U= 1/R_1 + 1/R_2 + 1/R_3
	 // R = resistance
     // R = 1/k * d
    // k = conductivity
	 // U = thermal transmissivity
	 // d = thickness 
	 
	 // source of data Wikipedia 

     public static final String[] R_description = {"outside surface", "inside surface"}; 
     public static final double[] R = {0.04,0.13};
     
     public static final int NoUTypes = 13;
     
     public static final String[] U_description = {
    	 "single glazing",
         "single glazed windows, allowing for frames",
         "double glazed windows, allowing for frames",
         "double glazed windows with advanced coatings",
         "double glazed windows with advanced coatings and frames",
         "triple glazed windows, allowing for frames",
         "triple glazed windows, with advanced coatings and frames",
         "well-insulated roofs",
         "poorly insulated roofs",
         "well-insulated walls",
         "poorly insulated walls",
         "well-insulated floors",
         "poorly insulated floors"};
	

     public static final double[] U_values = {5.7,4.5,3.3,2.2,1.2,1.8,
	                                          0.8,0.15,1.0,0.25,1.5,0.2,1.0};

	 // Dimensions of flat
     
     // width, length, height
     public static final double[] buildingDims={5.0,7.0,2.5};
     public static final double[] DoorDims={2.0,1.0};
     public static final double[] WindowDims={2.0,2.0,1.0,1.0,1.0,1.0,1.0,1.0};
     public static final int NUM_WINDOWS=4;	
     public static final int NUM_DOORS=1;	
}
