package articalc.brute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import articalc.artifact.Artifact;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Domain;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.Stat;
import articalc.math.Substat;

public class MassArt {

	static boolean doWeighted = true;
	static float baseValues[] = {0.75f, 0.8f, 0.85f, 0.9f};
	static float updatedMod[] = {0.00f, 0.0f, 0.0f, 0.0f};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean updatedMethod = true;
		boolean domain = true;
		boolean doStrongbox = false; 
		boolean leveled = true;
		Set domainSet1 = Set.Tenacity;
		Set domainSet2 = Set.OceanHued;
		Set strongboxSet = Set.Crimson;
		int runs = 10000*9;
		
		if (false) {
		for (Domain hoi: Domain.values()) {
			runMassDomain(runs, hoi, false, true, updatedMethod, leveled);
			if (doStrongbox && hoi.StrongBoxable) {
				runStrongbox(runs/2, hoi.set1, false, updatedMethod, leveled);
				runStrongbox(runs/2, hoi.set2, false, updatedMethod, leveled);
			}
		}
		}
		
		//runMassDomain(runs, Domain.MomijiDyed, false, false, true);
		runMassDomain(runs, Domain.MomijiDyed, false, true, true, false);
		
	}

	public static void runMassDomain(int runs, Domain domain, boolean printBuilds, boolean printSlots, boolean updated, boolean leveled) {
		runMassDomain(runs, domain.set1, domain.set2, printBuilds, printSlots, updated, leveled);
	}

	public static void runMassDomain(int runs, Set set1, Set set2, boolean printBuilds, boolean printSlots, boolean updated, boolean leveled) {
		System.out.printf("Domain of %s and %s:%s", set1.key, set2.key, System.lineSeparator());
		List<Build> charas = new ArrayList<Build>();
		ArrayList<Integer> goods = new ArrayList<Integer>();
		ArrayList<Integer> greats = new ArrayList<Integer>();
		ArrayList<Integer> excellents = new ArrayList<Integer>();
		ArrayList<Integer> perfect = new ArrayList<Integer>();

		goods.add(0);
		greats.add(0);
		excellents.add(0);
		perfect.add(0);
		//Add builds
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {
				charas.add(hoi);
				goods.add(0);
				greats.add(0);
				excellents.add(0);
				perfect.add(0);
			}
		}
		//Add slots
		for (int i = 0; i < 5; i++) {
			goods.add(0);
			greats.add(0);
			excellents.add(0);
			perfect.add(0);
		}
		
		for (int yarr = 0; yarr < runs; yarr++) {
		Artifact art = Artifact.newRandomArtifactDomain(set1, set2);
		if (leveled)
			art.randomlyLevel(20);
		float goodValue = baseValues[0] + ((updated)?updatedMod[0]:0f);
		float greatValue = baseValues[1] + ((updated)?updatedMod[1]:0f);
		float excellentValue = baseValues[2] + ((updated)?updatedMod[2]:0f);
		float perfectValue = baseValues[3] + ((updated)?updatedMod[3]:0f);
		int maxValue = 0;
			for (int i = 0; i < charas.size(); i++) {
				Build hoi = charas.get(i);
				//float value = hoi.getValue(art);
				float fvalue = (updated)?hoi.getFutureValueUpdated(art, doWeighted):hoi.getFutureValue(art, doWeighted);
				float opvalue = (updated)?hoi.getFutureOffPieceValueUpdated(art, doWeighted):hoi.getFutureOffPieceValue(art, doWeighted);
				if (fvalue > perfectValue || opvalue > perfectValue) {
					perfect.set(i+1, perfect.get(i+1) + 1);
					if (maxValue < 4) {
						maxValue = 4;
					}
				}
				else if (fvalue > excellentValue || opvalue > excellentValue) {
					excellents.set(i+1, excellents.get(i+1) + 1);
					if (maxValue < 3) {
						maxValue = 3;
					}
				}
				else if (fvalue > greatValue || opvalue > greatValue) {
					greats.set(i+1, greats.get(i+1) + 1);
					if (maxValue < 2) {
						maxValue = 2;
					}
				}
				else if (fvalue > goodValue || opvalue > goodValue) {
					goods.set(i+1, goods.get(i+1) + 1);
					if (maxValue < 1) {
						maxValue = 1;
					}
				}
			}
			switch (maxValue) {
			case 1:
				goods.set(0, goods.get(0) +1);
				//if (art.mainStat == Stat.Dendro)
				goods.set(charas.size() + art.slot.slot + 1, goods.get(charas.size() + art.slot.slot + 1) + 1);
				break;
			case 2:
				greats.set(0, greats.get(0) +1);
				//if (art.mainStat == Stat.Dendro)
				greats.set(charas.size() + art.slot.slot + 1, greats.get(charas.size() + art.slot.slot + 1) + 1);
				break;
			case 3:
				excellents.set(0, excellents.get(0) +1);
				//if (art.mainStat == Stat.Dendro)
				excellents.set(charas.size() + art.slot.slot + 1, excellents.get(charas.size() + art.slot.slot + 1) + 1);
				break;
			case 4:
				perfect.set(0, perfect.get(0) +1);
				//if (art.mainStat == Stat.Dendro)
				perfect.set(charas.size() + art.slot.slot + 1, perfect.get(charas.size() + art.slot.slot + 1) + 1);
				break;
				default:
			}
		}
		System.out.println(" Overall out of " + runs +":");
		System.out.printf("  goods: %d %.2f%c, greats: %d %.2f%c, excellantes: %d %.2f%c, perfect: %d %.2f%c%s", goods.get(0), goods.get(0)*100f/(float)runs, '%',
				greats.get(0), greats.get(0)*100f/(float)runs, '%',
				excellents.get(0), excellents.get(0)*100f/(float)runs, '%',
				perfect.get(0), perfect.get(0)*100f/(float)runs, '%', System.lineSeparator());
		if (printBuilds) {
		for (int i = 0; i < charas.size(); i++) {
			if (goods.get(i+1) > 0) {
			System.out.println(charas.get(i));
			System.out.printf("  goods: %d, greats: %d, excellantes: %d, perfect: %d%s", goods.get(i+1), greats.get(i+1), excellents.get(i+1), perfect.get(i+1), System.lineSeparator());
		}
		}
		System.out.println(" Overall out of " + runs +":");
		System.out.printf("  goods: %d %.2f%c, greats: %d %.2f%c, excellantes: %d %.2f%c, perfect: %d %.2f%c%s", goods.get(0), goods.get(0)*100f/(float)runs, '%',
				greats.get(0), greats.get(0)*100f/(float)runs, '%',
				excellents.get(0), excellents.get(0)*100f/(float)runs, '%',
				perfect.get(0), perfect.get(0)*100f/(float)runs, '%', System.lineSeparator());
	}if (printSlots) {
		for (Slot slot: Slot.values()) {
			if (goods.get(1 + charas.size() + slot.slot) > 0) {
			System.out.println(slot.key);
			System.out.printf("  goods: %d, greats: %d, excellantes: %d, perfect: %d%s", goods.get(1 + charas.size() + slot.slot), greats.get(1 + charas.size() + slot.slot), excellents.get(1 + charas.size() + slot.slot), perfect.get(1 + charas.size() + slot.slot), System.lineSeparator());
		}
		}
	}
	}
	
	public static void runStrongbox(int runs, Set set, boolean printBuilds, boolean updated, boolean leveled) {
		System.out.printf("Strongbox %s:%s", set.key, System.lineSeparator());
		List<Build> charas = new ArrayList<Build>();
		ArrayList<Integer> goods = new ArrayList<Integer>();
		ArrayList<Integer> greats = new ArrayList<Integer>();
		ArrayList<Integer> excellents = new ArrayList<Integer>();
		ArrayList<Integer> perfect = new ArrayList<Integer>();

		goods.add(0);
		greats.add(0);
		excellents.add(0);
		perfect.add(0);
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {
				charas.add(hoi);
				goods.add(0);
				greats.add(0);
				excellents.add(0);
				perfect.add(0);
			}
		}
		for (int yarr = 0; yarr < runs; yarr++) {
		Artifact art = Artifact.newRandomArtifactStrongbox(set);
		if (leveled)
			art.randomlyLevel(20);
		float goodValue = baseValues[0] + ((updated)?updatedMod[0]:0f);
		float greatValue = baseValues[1] + ((updated)?updatedMod[1]:0f);
		float excellentValue = baseValues[2] + ((updated)?updatedMod[2]:0f);
		float perfectValue = baseValues[3] + ((updated)?updatedMod[3]:0f);
		int maxValue = 0;
			for (int i = 0; i < charas.size(); i++) {
				Build hoi = charas.get(i);
				//float value = hoi.getValue(art);
				float fvalue = (updated)?hoi.getFutureValueUpdated(art, doWeighted):hoi.getFutureValue(art, doWeighted);
				float opvalue = (updated)?hoi.getFutureOffPieceValueUpdated(art, doWeighted):hoi.getFutureOffPieceValue(art, doWeighted);
				if (fvalue > perfectValue || opvalue > perfectValue) {
					perfect.set(i+1, perfect.get(i+1) + 1);
					if (maxValue < 4) {
						maxValue = 4;
					}
				}
				else if (fvalue > excellentValue || opvalue > excellentValue) {
					excellents.set(i+1, excellents.get(i+1) + 1);
					if (maxValue < 3) {
						maxValue = 3;
					}
				}
				else if (fvalue > greatValue || opvalue > greatValue) {
					greats.set(i+1, greats.get(i+1) + 1);
					if (maxValue < 2) {
						maxValue = 2;
					}
				}
				else if (fvalue > goodValue || opvalue > goodValue) {
					goods.set(i+1, goods.get(i+1) + 1);
					if (maxValue < 1) {
						maxValue = 1;
					}
				}
			}
			switch (maxValue) {
			case 1:
				goods.set(0, goods.get(0) +1);
				break;
			case 2:
				greats.set(0, greats.get(0) +1);
				break;
			case 3:
				excellents.set(0, excellents.get(0) +1);
				break;
			case 4:
				perfect.set(0, perfect.get(0) +1);
				break;
				default:
			}
		}
		System.out.println(" Overall out of " + runs +":");
		System.out.printf("  goods: %d %.2f%c, greats: %d %.2f%c, excellantes: %d %.2f%c, perfect: %d %.2f%c%s", goods.get(0), goods.get(0)*100f/(float)runs, '%',
				greats.get(0), greats.get(0)*100f/(float)runs, '%',
				excellents.get(0), excellents.get(0)*100f/(float)runs, '%',
				perfect.get(0), perfect.get(0)*100f/(float)runs, '%', System.lineSeparator());
		if (printBuilds) {
		for (int i = 0; i < charas.size(); i++) {
			if (goods.get(i+1) > 0) {
			System.out.println(charas.get(i));
			System.out.printf("  goods: %d, greats: %d, excellantes: %d, perfect: %d%s", goods.get(i+1), greats.get(i+1), excellents.get(i+1), perfect.get(i+1), System.lineSeparator());
		}
		}
		System.out.println(" Overall out of " + runs +":");
		System.out.printf("  goods: %d %.2f%c, greats: %d %.2f%c, excellantes: %d %.2f%c, perfect: %d %.2f%c%s", goods.get(0), goods.get(0)*100f/(float)runs, '%',
				greats.get(0), greats.get(0)*100f/(float)runs, '%',
				excellents.get(0), excellents.get(0)*100f/(float)runs, '%',
				perfect.get(0), perfect.get(0)*100f/(float)runs, '%', System.lineSeparator());
	}
	}
	
	public static void runMainStat(int runs, Set set, Stat mainStat, Slot slot, int levels) {
		System.out.printf("Strongbox %s:%s", set.key, System.lineSeparator());
		//List<Build> charas = new ArrayList<Build>();
		int[] values = new int[101];

		Substat.FOURPIECECHANCE = 0.2f;
		for (int i = 0; i < runs; i++) {
			int subs = (Math.random() > Substat.FOURPIECECHANCE)?3:4;
			Artifact next = new Artifact(set, 0);
			next.randomize(subs, slot, mainStat);
			
			next.randomlyLevel(levels);
			
			values[(int)(next.getFutureValueUpdated()*100)]++;
		}
		int runningCount = 0;
		for (int i = values.length-1; runningCount < runs; i--) {
			runningCount += values[i];
			System.out.printf("%d%c: %d %.2f%c (%.2f%c)%s", i, '%', values[i], (values[i]*100f)/(runs), '%',(runningCount*100f)/(runs), '%', System.lineSeparator());
		}
		
	}
}
