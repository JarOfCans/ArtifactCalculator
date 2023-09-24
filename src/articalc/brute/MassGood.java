package articalc.brute;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import articalc.artifact.Artifact;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.Stat;

public class MassGood {
	
	public static void main(String[] args) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("DaGOODs.json"))) {
			
			bw.write("{\"format\":\"GOOD\",\"version\":2,\"source\":\"ArtiCalc\",\"artifacts\":[");
			//
			boolean addComma = false;
			boolean write;
			for (Set set: Arrays.asList(Set.Marechaussee, Set.Vermillion)) {
				if (set.fiveStar) {
					for (Slot slot: Slot.values()) {
						for (Stat mainStat: Slot.slotStats(slot)) {
							for (Stat sub1: Stat.subsNotNULL()) {
								if (sub1 != mainStat) {
								for (Stat sub2: Stat.subsNotNULL()) {
									if (sub2 != sub1 && sub2 != mainStat) {
										Artifact art = new Artifact(set, 20);
										art.slot = slot;
										art.mainStat = mainStat;
										art.locked = true;
										switch (slot) {
										case flower:
											art.addSub(0, Stat.ATKP, Stat.ATKP.twoSubs);
											art.addSub(1, Stat.DEFP, Stat.DEFP.twoSubs);
											write = isNotDuo(sub1, sub2, Stat.ATKP, Stat.DEFP);
											break;
										case plume:
											art.addSub(0, Stat.EM, Stat.EM.twoSubs);
											art.addSub(1, Stat.HPP, Stat.HPP.twoSubs);
											write = isNotDuo(sub1, sub2, Stat.EM, Stat.HPP);
											break;
										case sands:
											art.addSub(0, Stat.CR, Stat.CR.twoSubs);
											art.addSub(1, Stat.HP, Stat.HP.twoSubs);
											write = isNotDuo(sub1, sub2, Stat.CR, Stat.HP);
											break;
										case goblet:
											art.addSub(0, Stat.ATK, Stat.ATK.twoSubs);
											art.addSub(1, Stat.CD, Stat.CD.twoSubs);
											write = isNotDuo(sub1, sub2, Stat.ATK, Stat.CD);
											break;
										case circlet:
											art.addSub(0, Stat.ER, Stat.ER.twoSubs);
											art.addSub(1, Stat.DEF, Stat.DEF.twoSubs);
											write = isNotDuo(sub1, sub2, Stat.ER, Stat.DEF);
											break;
										default:
											write = false;
										}
										if (write) {
											art.addSub(2, sub1, sub1.twoSubs);
											art.addSub(3, sub2, sub2.twoSubs);
											if (addComma) {
												bw.write(",");
											}
											else {
												addComma = true;
											}
											bw.write(art.toGood());
										}
										
									}
								}}
							}
						}
					}
				}
			}
			
			
			bw.write("]}");
			bw.newLine();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public static boolean isNotDuo (Stat sub1, Stat sub2, Stat not1, Stat not2) {
		return sub1 != not1 && sub1 != not2 && sub2 != not1 && sub2 != not2 && oneFlat(sub1, sub2, not1, not2);
	}
	
	public static boolean oneFlat (Stat... stats) {
		int good = 0;
		for (Stat hoi: stats) {
			if (hoi == Stat.ATK || hoi == Stat.DEF || hoi == Stat.HP) {
				good++;
				if (good > 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
