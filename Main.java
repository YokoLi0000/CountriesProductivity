
public class Main {
	public static String firstLetterToUppercase(String name) {
	    String firstLetter = name.substring(0, 1);
	    String remainingLetters = name.substring(1, name.length());
	    firstLetter = firstLetter.toUpperCase();
	    name = firstLetter + remainingLetters;
	    return name;
	}
	
	public static void generateGraph(String region[],String compare[],String compareShort[]) {
		for (int i=0;i<region.length;i++) {
			System.out.println("\n\n");
			for (int j=0;j<compare.length;j++) {
				System.out.println(region[i] + compareShort[j] + " = " + region[i] + "['" + compare[j] + "']");
			}
			
			System.out.println("\n\nsize = 50\n"
					+ "color = \"green\"");
			
			for (int j=0;j<compare.length;j++) {
			if (j!=3) {
				System.out.println("plt.scatter(" + region[i] + compareShort[3] + ", "
						+ region[i] + compareShort[j] + ", s=size, c=color, alpha=0.2)\r\n"
						+ "plt.title('"+ firstLetterToUppercase(region[i]) +"')\r\n"
						+ "plt.xlabel(\""+ compare[3] +"\")\r\n"
						+ "plt.ylabel(\""+ compare[j] +"\")\r\n"
						+ "plt.savefig(\""+ firstLetterToUppercase(region[i]) + "_" + j + "_" + compareShort[3] + "vs" + compareShort[j] + ".PNG\")\r\n"
						+ "plt.close()\n");
			}
			}
		}
	}
	
	public static void findCorrelation(String region[],String compare[],String compareShort[]) {
		System.out.println("\n\n");
		for (int i=0;i<region.length;i++) {
			System.out.println("\n\n");
			for (int j=0;j<compare.length;j++) {
				if (j!=3) {
					System.out.println("covariance_matrix=np.cov(" + region[i] + compareShort[3] + ", " + region[i] + compareShort[j] + ")\r\n"
							+ "corr, _ = pearsonr(" + region[i] + compareShort[3] + ", " + region[i] + compareShort[j] + ")\r\n"
							+ "print('Correlation of " + firstLetterToUppercase(region[i]) + "\\'s " + compare[3] + " and " + compare[j] + " per capita is: %.3f' % corr)\n");
				}
			}
		}
	}

	public static void main(String[] args) {
		String region[] = {"lessDevelop","moreDevelop"};
		String compare[] = {"Output-side real GDP","Average annual hours","Number of persons engaged",
				"Productivity","CPI score","Life Expectancy","Health Care Index",
				"Crime Rate","Quality of Life Index","Human Capital Index"};
		String compareShort[] = {"GDP","AAH","NOPE","P","CS","LE","HCI","CR","QOLI","HCII"};

		generateGraph(region,compare,compareShort);
		findCorrelation(region,compare,compareShort);
	}
	
}

