package articalc.brute;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import articalc.artifact.Artifact;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.Stat;
import articalc.math.FutureSubs;

public class MassAutoLock {

	public static void main(String[] args) {
		ArrayList<ArrayList<Artifact>> artiStats = getAllTriples(0.7f);
		System.out.println(artiStats.size());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("LockVisualMinValues.csv"))) {
			bw.write("Set,Sub1,Sub2,Sub3,Sands:,ATKP,HPP,DEFP,ER,EM,Goblet:,ATKP,HPP,DEFP,EM,ANEMO,GEO,ELECTRO,DENDRO,HYDRO,PYRO,CRYO,PHYS,Circlet:,ATKP,HPP,DEFP,EM,CR,CD,HB");
			bw.newLine();
			for (Set set: Set.values()) {
				
				if (set.fiveStar) {
					for (ArrayList<Artifact> artArray: artiStats) {
						if (validArtifactArray(artArray, set)) {
							bw.write(String.format("%s,%s,%s,%s,,", set.key,artArray.get(0).subs[0],artArray.get(0).subs[1],artArray.get(0).subs[2]));
								//System.out.println(art);
							int[] output = validMainStatArray(artArray, set);
							for (int i = 0; i < output.length; i++) {
								switch (output[i]) {
								case 0:
									bw.write(",");
									break;
								case 1:
									bw.write("1,");
									break;
								case -1:
									bw.write("-,");
									break;
								}
								if (i == 4 || i == 16) {
									bw.write(",");
								}
							}
							bw.newLine();
						}
					}
					System.out.println("Set done: " + set);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean validArtifactArray(ArrayList<Artifact> arts, Set set) {
		int runs = 0;
		for (Artifact art: arts) {
			if (art.subs[0] != Stat.ATK && art.subs[1] != Stat.ATK && art.subs[2] != Stat.ATK && art.subs[3] != Stat.ATK) {
				runs++;
				art.mainStat = Stat.ATK;
				art.slot = Slot.plume;
				art.set = set;
				if (FutureSubs.getFutureValue(art) < .1f) {
					return false;
				}
			}
			if (art.subs[0] != Stat.HP && art.subs[1] != Stat.HP && art.subs[2] != Stat.HP && art.subs[3] != Stat.HP) {
				runs++;
				art.mainStat = Stat.HP;
				art.slot = Slot.flower;
				art.set = set;
				if (FutureSubs.getFutureValue(art) < .1f) {
					return false;
				}
			}
			if (runs == 0) {
				return false;
			}
		}
			
		return true;
	}
	public static int[] validMainStatArray(ArrayList<Artifact> arts, Set set) {
		int[] output = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1, 1, 1, 1, 1,1, 1, 1, 1, 1, 1, 1, 1, 1};
		for (Artifact art: arts) {
			art.set = set;
			art.slot = Slot.sands;
			
			art.mainStat= Stat.ATKP;
			//System.out.println(checkFinalSub(art) + ": " + art);
			output[0] = Math.min(output[0],checkFinalSub(art));
			
			art.mainStat= Stat.HPP;
			output[1] = Math.min(output[1],checkFinalSub(art));
			
			art.mainStat= Stat.DEFP;
			output[2] = Math.min(output[2],checkFinalSub(art));
			
			art.mainStat= Stat.ER;
			output[3] = Math.min(output[3],checkFinalSub(art));
			
			art.mainStat= Stat.EM;
			output[4] = Math.min(output[4],checkFinalSub(art));
			
			
			art.slot = Slot.goblet;
			
			art.mainStat= Stat.ATKP;
			output[5] = Math.min(output[5],checkFinalSub(art));
			
			art.mainStat= Stat.HPP;
			output[6] = Math.min(output[6],checkFinalSub(art));
			
			art.mainStat= Stat.DEFP;
			output[7] = Math.min(output[7],checkFinalSub(art));
			
			art.mainStat= Stat.EM;
			output[8] = Math.min(output[8],checkFinalSub(art));
			
			art.mainStat= Stat.Anemo;
			output[9] = Math.min(output[9],checkFinalSub(art));
			
			art.mainStat= Stat.Geo;
			output[10] = Math.min(output[10],checkFinalSub(art));
			
			art.mainStat= Stat.Electro;
			output[11] = Math.min(output[11],checkFinalSub(art));
			
			art.mainStat= Stat.Dendro;
			output[12] = Math.min(output[12],checkFinalSub(art));
			
			art.mainStat= Stat.Hydro;
			output[13] = Math.min(output[13],checkFinalSub(art));
			
			art.mainStat= Stat.Pyro;
			output[14] = Math.min(output[14] ,checkFinalSub(art));
			
			art.mainStat= Stat.Cryo;
			output[15] = Math.min(output[15] ,checkFinalSub(art));
			
			art.mainStat= Stat.Physical;
			output[16] = Math.min(output[16] ,checkFinalSub(art));
			
			
			art.slot = Slot.circlet;
			
			art.mainStat= Stat.ATKP;
			output[17] = Math.min(output[17],checkFinalSub(art));
			
			art.mainStat= Stat.HPP;
			output[18] = Math.min(output[18],checkFinalSub(art));
			
			art.mainStat= Stat.DEFP;
			output[19] = Math.min(output[19],checkFinalSub(art));
			
			art.mainStat= Stat.EM;
			output[20] = Math.min(output[20],checkFinalSub(art));
			
			art.mainStat= Stat.CR;
			output[21] = Math.min(output[21],checkFinalSub(art));
			
			art.mainStat= Stat.CD;
			output[22] = Math.min(output[22],checkFinalSub(art));
			
			art.mainStat= Stat.HB;
			output[23] = Math.min(output[23],checkFinalSub(art));
			
			
		}
			
		return output;
	}
	
	public static float validArtifact(Artifact art) {
		if (art.mainStat == art.subs[0] || art.mainStat == art.subs[1] || art.mainStat == art.subs[2] || art.mainStat == art.subs[3]) {
			return 0f;
		}
		float value = FutureSubs.getFutureValue(art);
		return (value < .1f)?0f:value;
	}
	
	public static int checkFinalSub(Artifact art) {
		if (art.mainStat == art.subs[0] || art.mainStat == art.subs[1] || art.mainStat == art.subs[2]) {
			return -1;
		}
		if (art.mainStat == art.subs[3] || art.subs[0] == art.subs[3] || art.subs[1] == art.subs[3]|| art.subs[2] == art.subs[3]) {
			return 1;
		}
		return (FutureSubs.getFutureValue(art) >= 0.1f)?1:0;
	}
	
	
	public static ArrayList<ArrayList<Artifact>> getAllTriples(float subMultiplier) {
		ArrayList<Stat> subs = Stat.subs();
		ArrayList<ArrayList<Artifact>> allSubs = new ArrayList<ArrayList<Artifact>>(64);
			for (int i1 = 0; i1 < subs.size(); i1++) {
					for (int i2 = i1+1; i2 < subs.size(); i2++) {
							for (int i3 = i2+1; i3 < subs.size(); i3++) {
								ArrayList<Artifact> output = new ArrayList<Artifact>();
								allSubs.add(output);
									for (Stat sub: subs) {
										if (sub != subs.get(i1) && sub != subs.get(i2) && sub != subs.get(i3)) {
											Artifact subStack = new Artifact();
											subStack.addSub(0, subs.get(i1), subs.get(i1).subMax * subMultiplier);
											subStack.addSub(1, subs.get(i2), subs.get(i2).subMax * subMultiplier);
											subStack.addSub(2, subs.get(i3), subs.get(i3).subMax * subMultiplier);
											subStack.addSub(3, sub, sub.subMax * subMultiplier);
											//subStack.calcChance();
											output.add(subStack);
										}
										}
									}
								}
							}
		return allSubs;
	}

}
