
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


public class constants {
	
	// deg C
	public static final double standardTemp=25.0;                          
	// KJ/KG.K. Assume constant.
	public static final double specificHeatCapacityAir=1.006;                    
	// number of particles per mole
	public static final double avogardo=6.02214129e23;                           
	public static final double boltzmann=1.3806488e-23;
	// molecular mass of air g/mol
	public static final double MolecularMassAir=28.97;                           
	public static final double GasConstant=287.058;
	// pascals   
	public static final double standardPres=101325.0;                                                  
	 // Cost of energy per KWh in GBP
	public static final double CostPerKWh=0.16;                                 
	// kgco2 equivalent per kwh of electricity (from Carbon Trust)
	public static final double co2PerkwhGridElec=0.44548;                        
	// typical value for room temperature
	public static final double T=21.0;                                             
	// condictivity of dense bricks w/m/deg C
	public static final double k=1.6;
	// thickness of wall 
	public static final double d=0.2;
	// Temperature of soil, assume constant year round.
	public static final double soilT=10.0;   
	// 8.31432e3
	public static final double R = avogardo * boltzmann;                         
	// 287.058 J/kg/K
	public static final double R_specific = R/MolecularMassAir*1000.0; 
	// density of air at STP kg/m3
	public static final double densityAir=1.2754;
	
	public constants() {
  
	}
}
