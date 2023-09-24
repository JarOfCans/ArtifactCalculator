package articalc.brute;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.Stat;

public class OutputWeights {

	public static void main(String[] args) {
		/*int max2 = 0;
		int max4 = 0;
		int maxSands = 0;
		int maxGoblet = 0;
		int maxCirclet = 0;
		for (Characters hoi: Characters.values()) {
			for (Build b: hoi.cb.cb) {
				int two = b.set2pc.size();
				if (two > max2) {
					max2 = two;
				}
				int four = b.set4pc.size();
				if (four > max4) {
					max4 = four;
				}
				int sands = b.sands.size();
				if (sands > maxSands) {
					maxSands = sands;
				}
				int goblet = b.goblet.size();
				if (goblet > maxGoblet) {
					maxGoblet = goblet;
				}
				int circlet = b.circlet.size();
				if (circlet > maxCirclet) {
					maxCirclet = circlet;
				}
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("BuildWeights.txt"))) {
		} catch (IOException e) {
			
		}*/
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("BuildWeights.csv"))) {
			StringBuilder sb = new StringBuilder();
			sb.append("Character,");
			sb.append("Build,");
			sb.append("Sets,");
			HashSet<Stat> stats2pc = new HashSet<Stat>();
			ArrayList<Set> fiveSets = new ArrayList<Set>();
			for (Set set: Set.values()) {
				if (set.fiveStar) {
					sb.append(set);
					sb.append(",");
					fiveSets.add(set);
					if (set.set2pc != null) {
						stats2pc.add(set.set2pc);
					}
				}
			}
			sb.append("2pcs,");
			for (Stat stat: Stat.values()) {
				if (stats2pc.contains(stat)) {
					sb.append(stat);
					sb.append(",");
				}
			}
			/*for (Stat stat: stats2pc) {
				sb.append(stat);
				sb.append(",");
			}*/
			sb.append("Subs,");
			for (Stat value: Stat.subsNotNULL()) {
				sb.append(value);
				sb.append(",");
			}
			sb.append("Sands,");
			for (Stat value: Slot.slotStats(Slot.sands)) {
				sb.append(value);
				sb.append(",");
			}
			sb.append("Goblet,");
			for (Stat value: Slot.slotStats(Slot.goblet)) {
				sb.append(value);
				sb.append(",");
			}
			sb.append("Circlet,");
			for (Stat value: Slot.slotStats(Slot.circlet)) {
				sb.append(value);
				sb.append(",");
			}
			for (Characters hoi: Characters.values()) {
				for (Build b: hoi.cb.cb) {
					sb.append(System.lineSeparator());
					sb.append(hoi.name());
					sb.append(",");
					sb.append(b.toString());
					sb.append(",");
					sb.append(",");
					for (Set set: fiveSets) {
						int value = (int)((Math.max((b.set4pc.containsKey(set))? b.set4pc.get(set):0, (b.set2pc.containsKey(set.set2pc))?b.set2pc.get(set.set2pc):0)+0.0001)*100);
						sb.append(value);
						sb.append(",");
					}
					sb.append(",");
					for (Stat stat: Stat.values()) {
						if (stats2pc.contains(stat)) {
							int value = (int)((((b.set2pc.containsKey(stat))?b.set2pc.get(stat):0)+0.0001)*100);
							sb.append(value);
							sb.append(",");
						}
					}
					sb.append(",");
					for (Stat stat: Stat.subsNotNULL()) {
							int value = (int)((((b.subs.containsKey(stat))?b.subs.get(stat):0)+0.0001)*100);
							sb.append(value);
							sb.append(",");
					}
					sb.append(",");
					for (Stat stat: Slot.slotStats(Slot.sands)) {
							int value = (int)((((b.sands.containsKey(stat))?b.sands.get(stat):0)+0.0001)*100);
							sb.append(value);
							sb.append(",");
					}
					sb.append(",");
					for (Stat stat: Slot.slotStats(Slot.goblet)) {
							int value = (int)((((b.goblet.containsKey(stat))?b.goblet.get(stat):0)+0.0001)*100);
							sb.append(value);
							sb.append(",");
					}
					sb.append(",");
					for (Stat stat: Slot.slotStats(Slot.circlet)) {
							int value = (int)((((b.circlet.containsKey(stat))?b.circlet.get(stat):0)+0.0001)*100);
							sb.append(value);
							sb.append(",");
					}
					
				}
			}
			bw.write(sb.toString());
		} catch (IOException e) {
			
		}
	}
}
