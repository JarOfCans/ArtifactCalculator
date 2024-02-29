package articalc.brute;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import articalc.artifact.Artifact;
import articalc.enums.Stat;
import articalc.math.Substat;

public class GetAllPermutations {
	public static void main (String[] args) {
		ArrayList<Artifact> allSubs = all();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"))) {
			bw.write("Main,Sub1,Sub2,Sub3,Sub4,chance,");
			for (Artifact hoi: allSubs) {
				bw.newLine();
				bw.write(String.format("%s,%s,%s,%s,%s,%.6f,", hoi.mainStat.toString(), hoi.subs[0].toString(),hoi.subs[1].toString(),hoi.subs[2].toString(),hoi.subs[3].toString(),hoi.chance));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Artifact> all() {
		ArrayList<Stat> subs = Stat.subs();
		ArrayList<Artifact> allSubs = new ArrayList<Artifact>(256);
		for (Stat main: Stat.mains()) {
			for (int i1 = 0; i1 < subs.size(); i1++) {
				if (main != subs.get(i1)) {
					for (int i2 = i1+1; i2 < subs.size(); i2++) {
						if (main != subs.get(i2)) {
							for (int i3 = i2+1; i3 < subs.size(); i3++) {
								if (main != subs.get(i3)) {
									for (int i4 = i3+1; i4 < subs.size(); i4++) {
										if (main != subs.get(i4)) {
											Artifact subStack = new Artifact();
											subStack.mainStat = main;
											subStack.addSub(0, subs.get(i1), subs.get(i1).subMax);
											subStack.addSub(1, subs.get(i2), subs.get(i2).subMax);
											subStack.addSub(2, subs.get(i3), subs.get(i3).subMax);
											subStack.addSub(3, subs.get(i4), subs.get(i4).subMax);
											subStack.calcChance();
											allSubs.add(subStack);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return allSubs;
	}
	public static ArrayList<Artifact> allNoMain(float subMultiplier) {
		ArrayList<Stat> subs = Stat.subs();
		ArrayList<Artifact> allSubs = new ArrayList<Artifact>(256);
			for (int i1 = 0; i1 < subs.size(); i1++) {
					for (int i2 = i1+1; i2 < subs.size(); i2++) {
							for (int i3 = i2+1; i3 < subs.size(); i3++) {
									for (int i4 = i3+1; i4 < subs.size(); i4++) {
											Artifact subStack = new Artifact();
											subStack.addSub(0, subs.get(i1), subs.get(i1).subMax * subMultiplier);
											subStack.addSub(1, subs.get(i2), subs.get(i2).subMax * subMultiplier);
											subStack.addSub(2, subs.get(i3), subs.get(i3).subMax * subMultiplier);
											subStack.addSub(3, subs.get(i4), subs.get(i4).subMax * subMultiplier);
											//subStack.calcChance();
											allSubs.add(subStack);
										}
									}
								}
							}
		return allSubs;
	}
	

	
	public static HashMap<Stat, ArrayList<Artifact>> allMap() {
		ArrayList<Stat> subs = Stat.subs();
		HashMap<Stat, ArrayList<Artifact>> output = new HashMap<Stat, ArrayList<Artifact>>();
		for (Stat main: Stat.mains()) {
			ArrayList<Artifact> allSubs = new ArrayList<Artifact>(64);
			for (int i1 = 0; i1 < subs.size(); i1++) {
				if (main != subs.get(i1)) {
					for (int i2 = i1+1; i2 < subs.size(); i2++) {
						if (main != subs.get(i2)) {
							for (int i3 = i2+1; i3 < subs.size(); i3++) {
								if (main != subs.get(i3)) {
									for (int i4 = i3+1; i4 < subs.size(); i4++) {
										if (main != subs.get(i4)) {
											Artifact subStack = new Artifact();
											subStack.mainStat = main;
											subStack.addSub(0, subs.get(i1), subs.get(i1).subMax);
											subStack.addSub(1, subs.get(i2), subs.get(i2).subMax);
											subStack.addSub(2, subs.get(i3), subs.get(i3).subMax);
											subStack.addSub(3, subs.get(i4), subs.get(i4).subMax);
											subStack.calcChance();
											allSubs.add(subStack);
										}
									}
								}
							}
						}
					}
				}
			}
			
			output.put(main, allSubs);
		}
		return output;
	}
	

	

	
	public static HashMap<Stat, ArrayList<Artifact>> allMapCombination() {
		ArrayList<Stat> subs = Stat.subs();
		HashMap<Stat, ArrayList<Artifact>> output = new HashMap<Stat, ArrayList<Artifact>>();
		for (Stat main: Stat.mains()) {
			ArrayList<Artifact> allSubs = new ArrayList<Artifact>(64);
			for (int i1 = 0; i1 < subs.size(); i1++) {
				if (main != subs.get(i1)) {
					for (int i2 = i1+1; i2 < subs.size(); i2++) {
						if (main != subs.get(i2)) {
							for (int i3 = i2+1; i3 < subs.size(); i3++) {
								if (main != subs.get(i3)) {
									for (int i4 = i3+1; i4 < subs.size(); i4++) {
										if (main != subs.get(i4)) {
											//All
											Artifact subStack = new Artifact();
											subStack.mainStat = main;
											subStack.addSub(0, subs.get(i1), subs.get(i1).subMax);
											subStack.addSub(1, subs.get(i2), subs.get(i2).subMax);
											subStack.addSub(2, subs.get(i3), subs.get(i3).subMax);
											subStack.addSub(3, subs.get(i4), subs.get(i4).subMax);
											subStack.calcChance();
											allSubs.add(subStack);
											// /*
											//No 1
											subStack = new Artifact();
											subStack.mainStat = main;
											subStack.addSub(0, subs.get(i2), subs.get(i2).subMax);
											subStack.addSub(1, subs.get(i3), subs.get(i3).subMax);
											subStack.addSub(2, subs.get(i4), subs.get(i4).subMax);
											subStack.calcChance();
											allSubs.add(subStack);
											//No 2
											subStack = new Artifact();
											subStack.mainStat = main;
											subStack.addSub(0, subs.get(i1), subs.get(i1).subMax);
											subStack.addSub(1, subs.get(i3), subs.get(i3).subMax);
											subStack.addSub(2, subs.get(i4), subs.get(i4).subMax);
											subStack.calcChance();
											allSubs.add(subStack);
											//No 3
											subStack = new Artifact();
											subStack.mainStat = main;
											subStack.addSub(0, subs.get(i1), subs.get(i1).subMax);
											subStack.addSub(1, subs.get(i2), subs.get(i2).subMax);
											subStack.addSub(2, subs.get(i4), subs.get(i4).subMax);
											subStack.calcChance();
											allSubs.add(subStack);
											//No 4
											subStack = new Artifact();
											subStack.mainStat = main;
											subStack.addSub(0, subs.get(i1), subs.get(i1).subMax);
											subStack.addSub(1, subs.get(i2), subs.get(i2).subMax);
											subStack.addSub(2, subs.get(i3), subs.get(i3).subMax);
											subStack.calcChance();
											allSubs.add(subStack);//*/
										}
									}
								}
							}
						}
					}
				}
			}
			
			output.put(main, allSubs);
		}
		return output;
	}
}
