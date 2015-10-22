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


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainWindow extends MenuBarSetUp  implements ActionListener{
	
 private static final long serialVersionUID = 1L;

 private JTextField buildingHeight = new JTextField(5);
 private JTextField buildingWidth = new JTextField(5);
 private JTextField buildingLength = new JTextField(5);
 private JTextField numberWindows = new JTextField(5);
 private JTextField windowWidth = new JTextField(5);
 private JTextField windowHeight = new JTextField(5);
 private JTextField numberDoors = new JTextField(5);
 private JTextField doorWidth = new JTextField(5);
 private JTextField doorHeight = new JTextField(5);
 private JTextField costPerKwh = new JTextField(5);
 private JTextField desiredTemperature = new JTextField(5);
 
 private JTextField heatLossConductance = new JTextField(10);
 private JTextField heatLossInfiltration = new JTextField(10);
 private JTextField heatLossTotal = new JTextField(10);
 private JTextField costPerDay = new JTextField(10);
 private JTextField carbonPerDay = new JTextField(10);
 private JTextField costPerMonth = new JTextField(10);
 private JTextField carbonPerMonth = new JTextField(10);

 private JButton run = new JButton("Run");
 private JButton clear = new JButton("Clear");
 private JButton cancel = new JButton("Exit");
 private JButton defaultValues = new JButton("Default");
 
 private  JComboBox wallType = new JComboBox(data.wall);
 private  JComboBox floorType = new JComboBox(data.floor);
 private   JComboBox roofType = new JComboBox(data.roof);
 private  JComboBox winType = new JComboBox(data.win); 
 private  JComboBox doorType = new JComboBox(data.door); 
 private  JComboBox monthList = new JComboBox(data.month); 
 
 private double[] buildingDims= new double[3];
 private double[] doorDims= new double[2];
 private double[] windowDims= new double[2];
 private int[] uType = new int[5];
 
 private int nWin, nDoors;
 private double cost, T;
 
 public mainWindow(){
	 
	 super("Home");
	 
	 final JPanel inputPanel = new JPanel(new BorderLayout());
	 inputPanel.add( createInputPanel(),BorderLayout.WEST);
	 inputPanel.add(createInputPanelFields(),BorderLayout.CENTER);
	 inputPanel.setBorder(BorderFactory.createEtchedBorder());
	 
	 final JPanel outputPanel = new JPanel(new BorderLayout());
	 outputPanel.add( createOutputPanel(),BorderLayout.WEST);
	 outputPanel.add(createOutputPanelFields(),BorderLayout.CENTER);
	 outputPanel.setBorder(BorderFactory.createEtchedBorder());
	
	 final JPanel rightPanel = new JPanel(new BorderLayout());
	 rightPanel.add(outputPanel,BorderLayout.NORTH);
	 rightPanel.add(createButtonPanel(),BorderLayout.SOUTH);
	 
	final JPanel panel = new JPanel(new BorderLayout());
	panel.add( inputPanel,BorderLayout.NORTH);
	panel.add(rightPanel,BorderLayout.SOUTH);  
	
	 JMenuBar menuBar = menuSetUp();
	 setJMenuBar(menuBar);
	createFrame(panel);	   
 }

 private void createFrame(JPanel panel) {
	 setLayout(new BorderLayout());
	 add(panel);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 pack();
	 setResizable(false);
	 setVisible(true);
}
 
 
 private JPanel createButtonPanel(){
	 JPanel P = new JPanel( new GridLayout(1,4));
	 P.add(defaultValues);
	 P.add(run);
	 P.add(clear);
	 P.add(cancel);
	 P.setBorder(BorderFactory.createEtchedBorder());
	  run.addActionListener(this);
	  clear.addActionListener(this);  
	  cancel.addActionListener(this);
	 defaultValues.addActionListener(this);
	 return P;
 }	 
 
 
 private JPanel createInputPanel(){
	 JPanel P = new JPanel( new GridLayout(20,1));
	  
	  P.add(new JLabel("INPUTS"));
	  P.add(new JLabel(""));
	  P.add(new JLabel("Building length (m)"));
	  P.add(new JLabel("Building height (m)"));
	  P.add(new JLabel("Building width (m)"));
	  P.add(new JLabel("Wall type"));
	  P.add(new JLabel("Number of windows"));
	  P.add(new JLabel("window width (m)"));
	  P.add(new JLabel("window height (m)"));
	  P.add(new JLabel("Window type"));
	  P.add(new JLabel("Number of doors"));
	  P.add(new JLabel("Door width (m)"));
	  P.add(new JLabel("Door height (m)"));
	  P.add(new JLabel("Door type"));
	  P.add(new JLabel("Floor type"));
	  P.add(new JLabel("Roof type"));
	  P.add(new JLabel("Month"));
	  P.add(new JLabel("Desired temperature (C)"));
	  P.add(new JLabel("Cost Per Kwh (GBP)"));
	  P.add(new JLabel(""));
	  return P;
 }
 
 private JPanel createInputPanelFields(){
	 
	 JPanel P = new JPanel( new GridLayout(20,1));
	  
	 P.add(new JLabel(""));
	 P.add(new JLabel(""));
	 P.add(buildingHeight);
	  P.add( buildingWidth);
	  P.add(buildingLength);
	  P.add(wallType);
	  P.add(numberWindows);
	  P.add(windowWidth);
	  P.add(windowHeight);
	  P.add(winType);
	  P.add(numberDoors);
	  P.add(doorWidth);
	  P.add(doorHeight);
	  P.add(doorType);
	  P.add(floorType);
	  P.add(roofType);
	  P.add(monthList);
	  P.add(desiredTemperature);
	  P.add(costPerKwh);
	  P.add(new JLabel(""));
	  return P;
 }
 
 private JPanel createOutputPanel(){
	 JPanel P = new JPanel( new GridLayout(10,1));
	 
	  P.add(new JLabel("OUTPUTS"));
	  P.add(new JLabel(""));
	  P.add(new JLabel("Heat loss by conductance (Watts)"));
	  P.add(new JLabel("Heat loss by infiltration (Watts)"));
	  P.add(new JLabel("Total heat loss (Watts)"));
	  P.add(new JLabel("Cost per day (GBP)"));
	  P.add(new JLabel("Carbon usage per day (kg)"));
	  P.add(new JLabel("Cost per month (GBP)"));
	  P.add(new JLabel("Carbon usage per month (kg)"));
	  P.add(new JLabel(""));
	  return P;
 }
 
 private JPanel createOutputPanelFields(){
	 JPanel P = new JPanel( new GridLayout(10,1));
 
	heatLossConductance.setEditable(false);
	heatLossInfiltration.setEditable(false);
	heatLossTotal.setEditable(false);
	costPerDay.setEditable(false);
	carbonPerDay.setEditable(false);
	costPerMonth.setEditable(false);
	carbonPerMonth.setEditable(false);

	 P.add(new JLabel(""));
	  P.add(new JLabel(""));
	  P.add(heatLossConductance);
	  P.add(heatLossInfiltration);
	  P.add(heatLossTotal);
	  P.add(costPerDay);
	  P.add(carbonPerDay);
	  P.add(costPerMonth);
	  P.add(carbonPerMonth);
	  P.add(new JLabel(""));
	  return P;
	 

 }
 
 public void actionPerformed(ActionEvent e){
  if (e.getSource()==run){
	  
	  if (buildingHeight != null && !"".equals(buildingHeight.getText())){
		  buildingDims[0]= Double.parseDouble(buildingHeight.getText()); }
	  if (buildingWidth != null && !"".equals(buildingWidth.getText())){
		  buildingDims[1]= Double.parseDouble(buildingWidth.getText()); }
	  if (buildingLength != null && !"".equals(buildingLength.getText())){ 
		  buildingDims[2]= Double.parseDouble(buildingLength.getText()); }
	  if (numberWindows != null && !"".equals(numberWindows.getText())){
       nWin= Integer.parseInt(numberWindows.getText()); }
	  if (windowWidth != null && !"".equals(windowWidth.getText())){
       windowDims[0]= Double.parseDouble(windowWidth.getText()); }
	  if (windowHeight != null && !"".equals(windowHeight.getText())){
		windowDims[1]= Double.parseDouble(windowHeight.getText()); }
	  if (numberDoors != null && !"".equals(numberDoors.getText())){
      nDoors= Integer.parseInt(numberDoors.getText()); }
	  if (doorWidth != null && !"".equals(doorWidth.getText())){
       doorDims[0]= Double.parseDouble(doorWidth.getText()); }
	  if (doorHeight != null && !"".equals(doorHeight.getText())){
		doorDims[1]= Double.parseDouble(doorHeight.getText()); }
	  if (desiredTemperature!= null && !"".equals(desiredTemperature.getText())){
        T = Double.parseDouble(desiredTemperature.getText()); }
	  if (costPerKwh != null && !"".equals(costPerKwh.getText())){
       cost = Double.parseDouble( costPerKwh.getText()); }
  
	   setSummaryData();
	   	  
  }

  
  if (e.getSource()==defaultValues){
	   buildingHeight.setText("2.5");
	   buildingWidth.setText("5.0");
	   buildingLength.setText("7.0");
	   numberWindows.setText("4");
	   windowWidth.setText("1.0");
	   windowHeight.setText("1.0");
	   numberDoors.setText("1");
	   doorWidth.setText("1.0");
	   doorHeight.setText("2.0");
	   desiredTemperature.setText("21.0"); 
	   costPerKwh.setText("0.16"); 
	   heatLossConductance.setText(null);
	   heatLossInfiltration.setText(null);
	   heatLossTotal.setText(null);
	   costPerDay.setText(null);
	   carbonPerDay.setText(null);
	   costPerMonth.setText(null);
	   carbonPerMonth.setText(null);
	  }
  
  
  if (e.getSource()==clear){
   buildingHeight.setText(null);
   buildingWidth.setText(null);
   buildingLength.setText(null);
   numberWindows.setText(null);
   windowWidth.setText(null);
   windowHeight.setText(null);
   numberDoors.setText(null);
   doorWidth.setText(null);
   doorHeight.setText(null);
   desiredTemperature.setText(null); 
   costPerKwh.setText(null); 
   heatLossConductance.setText(null);
   heatLossInfiltration.setText(null);
   heatLossTotal.setText(null);
   costPerDay.setText(null);
   carbonPerDay.setText(null);
   costPerMonth.setText(null);
   carbonPerMonth.setText(null);
  }
  if (e.getSource()==cancel){
	dispose();
             System.exit(0);
  } else {
}
 } 

 private void getUType(){
	 
	  uType[0] =winType.getSelectedIndex();
	  uType[1]  =doorType.getSelectedIndex();
	  uType[2]  =wallType.getSelectedIndex();
	  uType[3]  =floorType.getSelectedIndex();
	  uType[4]  =roofType.getSelectedIndex();
 };
 
 private void setSummaryData() {
 
	 getUType();
	 
	 double totalHeatLoss = 0.0;
	 double totalHeatLossConductance = 0.0;	 
	 double totalHeatLossInfiltration =0.0;	
	 double cpd = 0.0;
	 double carbon = 0.0;
	 double co2pm = 0.0;
	 double cpm = 0.0;
	
    heating h = new heating();

   double winArea=h.getArea(nWin,windowDims);
   double doorArea=h.getArea(nDoors,doorDims);
   double deltaT = T - h.outsideT(monthList.getSelectedIndex());
    
 //  System.out.printf("  %s \n",winType.getSelectedItem().toString());
  // System.out.printf("  %s \n",monthList.getSelectedItem().toString());
  //  System.out.printf("  %s \n",monthList.getSelectedIndex());
   
  if (deltaT >0){
   
		
  totalHeatLoss = h.heatLossTotal(buildingDims,winArea,doorArea,T,deltaT,uType);
  totalHeatLossConductance = h. heatLossConduction(buildingDims,winArea,doorArea,T,deltaT,uType);	 
  totalHeatLossInfiltration = h.heatLossInfiltration(buildingDims,deltaT);	 

  cpd = h.CostPerDay(cost,totalHeatLoss);
  carbon = h.carbonUsage(totalHeatLoss);
  co2pm = carbon * 30;
  cpm = cpd * 30;
  
   }
   
  heatLossConductance.setText(String.valueOf(String.format("%.2f",totalHeatLossConductance)));
  heatLossInfiltration.setText(String.valueOf(String.format("%.2f",totalHeatLossInfiltration)));
  heatLossTotal.setText(String.valueOf(String.format("%.2f",totalHeatLoss)));
  costPerDay.setText(String.valueOf(String.format("%.2f",cpd)));
  carbonPerDay.setText(String.valueOf(String.format("%.2f",carbon)));
  costPerMonth.setText(String.valueOf(String.format("%.2f",cpm)));
  carbonPerMonth.setText(String.valueOf(String.format("%.2f",co2pm)));	
		
	}

}