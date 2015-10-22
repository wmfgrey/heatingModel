
/**
 * 
 * Help text.
 * 
 * @author will Grey
 * 
 * @version  11/10/2015
 * 
 * This is free and unencumbered software released into the public domain.
 *  For more information, please refer to <http://unlicense.org/>
 */

public class HelpFile {

	public static final String text1 = "HOME (HOuse Model of Energy)\n\n" +
	"THEORY\n\n" +
	"HOME is a heat loss energy balance model for buildings. The total heat loss is:\n\n" +
	"Ht=Hc+Hi\n\n" +
	"where\n" +
	"Ht = total heat loss (W)\n" +
	"Hc = heat loss via conduction (W)\n" +
	"Hi = heat loss via infiltration (W)\n\n" +	
	"Hi is given by:\n\n" +
	"Hi = V * (dT) * (r * n * Cp)\n\n" +
	"where\n" +
	"V = building volume (m3)\n"+ 
	"dT =  difference between desired inside temperature  and outside temperature (C)\n"+
	"r = the density of air (1.27 kg/m3)\n"+ 
	"Cp = the specific heat (1.002 kj/kg.k)\n"+ 
	"n = number of times air exchanges per hour (default is 2)\n\n"+ 	
	"Hc is given by:\n\n" +
	"Hc = Hr + Hg + Hw + Hwin + Hd\n\n" +
	"where\n" +
	"Hr = heat loss through the roof (W)\n" +
	"Hg = heat loss  through the ground (W)\n" +
	"Hw = heat loss  through the walls (W)\n" +
	"Hd = heat loss  through the doors (W)\n" +
	"Hr = heat loss  through the windows (W)\n\n" +	
	"The following set of equations describe conduction:\n"+
    "Hr = Ar * Ur *  dT\n "+
	"Hg = Ag * Ug *  dT\n"+
	"Hw = (Aw - Awin - Ad) * Uw *  dT\n"+
	"Hwin = Awin * Uwin *  dT\n"+
	"Hd = Ad * Ud *  dT\n\n"+
	"where\n" +
	"Ar = area roof (m2)\n"+
	"Ag = area ground (m2), typically Ar=Ag\n"+
	"Aw = area walls (m2)\n"+
	"Awin = area windows (m2)\n"+
	"Ad = area doors (m2)\n"+
	"Ur = heat transmission (conductance) of roof (W/m2C)\n"+
	"Ug = heat transmission (conductance) of ground (W/m2C)\n"+
	"Uw = heat transmission  (conductance) of walls (W/m2C)\n"+
	"Uwin = heat transmission  (conductance) of windows (W/m2C)\n"+
	"Ud = heat transmission (conductance) of doors (W/m2C)\n\n"+
	"Thermal transmission (U) is given by\n" +
     "U= 1/R\n\n"+
	 "where\n"+
     "R = resistance\n"+
     "R = d / k\n\n"+
     "where\n"+
     "k = conductivity (W/mC)\n"+
	 "d = thickness (m)\n\n" +
	 "LIMITATIONS\n" +
     "(1) Only deals with one room buildings e.g studio flats, village halls, warehouses.\n"	+
     "(2) Assumes that all windows and doors in a building are the same size.\n\n" +
	 "REFERENCES\n" +
	 "(1) http://www.engineeringtoolbox.com/heat-loss-buildings-d_113.html (last accessed 11/10/2015)\n" +
	 "(2) http://www.arca53.dsl.pipex.com/index_files/tt1.htm  (last accessed 11/10/2015)\\n"; 
}
