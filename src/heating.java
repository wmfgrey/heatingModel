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

public class heating  {

	// Temperature difference
	public double outsideT(int month){
		return (data.maxAmbientT[month]+data.minAmbientT[month])/2.0;	
	}
	
	// Calculate area of doors and windows
	public double getArea(int n, double [] dims){
		return dims[0]*dims[1]*n;
	}

	// Calculate cost per day
	public double CostPerDay(double CostPerKwh, double heatLossTotal){
		double KWh=heatLossTotal/1000.0;
		return constants.CostPerKWh * KWh * 24;
	}
	
	// Calculate carbon usage per day
	public double carbonUsage(double heatLossTotal){
		double KWh=heatLossTotal/1000.0;
		return constants.co2PerkwhGridElec * KWh * 24;
	}
	
	// heat loss through roof
	private double heatLossRoof(double [] buildingDims, double dT, int uType){
		double areaRoof = buildingDims[1] * buildingDims[2];
		return areaRoof*data.UWall[uType]*dT;	
	}
	
	// heat loss through floor
	private double heatLossFloor(double [] buildingDims, double T, int uType){
		double areaFloor = buildingDims[1] * buildingDims[2];
		double dT=T-constants.soilT;
      		return areaFloor*data.UFloor[uType]*dT;    	
	}
	
	// heat loss through windows
	private double heatLossWin(double winArea, double dT, int uType){
		return winArea*data.UWin[uType]*dT;
	}
	
	// heat loss through door
	private double heatLossDoor(double doorArea, double dT, int uType){
		return doorArea*data.UDoor[uType]*dT;
	}
	
	// Heat loss through walls
	private double heatLossWalls(double[] buildingDims, double winArea, double doorArea, int uType, double dT){
		
		double wallArea=data.buildingDims[0] * data.buildingDims[1] * 2 +
	              data.buildingDims[0] * data.buildingDims[2] * 2 -
	              doorArea - winArea;

		return wallArea*data.UWall[uType]*dT;
	}
		
	public double heatLossConduction(double[] buildingDims, double winArea, double doorArea, double T, double dT, int[] uType){
	
		return  heatLossDoor(doorArea,dT,uType[1]) +  
			heatLossWin(winArea,dT,uType[0]) + 
			heatLossRoof(buildingDims,dT,uType[4]) +  
			heatLossFloor(buildingDims,T,uType[3]) +  
			heatLossWalls(buildingDims,winArea,doorArea,uType[2],dT);              	    
		}

	public double heatLossInfiltration(double [] buildingDims, double dT){
		double volume=data.buildingDims[0] * data.buildingDims[1] * data.buildingDims[2]; 
		double heatLossInfiltration=volume * constants.densityAir * data.ACH50 / 3.6*
			dT * constants.specificHeatCapacityAir ;
		return heatLossInfiltration;
 	}

	// calculate total energy loss
	public double heatLossTotal(double[] buildingDims, double winArea, double doorArea, double T, double dT, int[] uType){
		
		return 	heatLossConduction(buildingDims,winArea,doorArea,T,dT,uType)  + 
			heatLossInfiltration(buildingDims,dT);	               
	}
		
	public static void main(String[] args) {
		new mainWindow();	    
	}
}