package articalc.brute;

import java.util.ArrayList;
import java.util.Random;

import articalc.artifact.Artifact;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Domain;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.ValueMethod;
import articalc.math.FutureSubs;

public class SimulateBuilds {
	Random r = new Random();
	//public static float penalty = 1f;
	public static boolean doRaisePenalty = true;
	public static void main(String [] args) {
		//float[] penalties = {0f, 0.05f, 0.08f, 0.1f, 0.12f, 0.15f};
		
		
		int totalRuns = 1;
		int totalRunsStrongbox = 0;
		int totalRunsStrongboxless = 0;
		int totalRunsStrongbox2 = 0;
		int totalRunsStrongbox3 = 0;
		int totalTwentyArtifacts = 0;
		int totalArtifacts = 0;
		int totalTwentyArtifacts2 = 0;
		int totalArtifacts2 = 0;
		int totalTwentyArtifacts3 = 0;
		int totalArtifacts3 = 0;
		//for (int p = 0; p < Math.max(1,penalties.length); p++) {
			totalRunsStrongbox = 0;
			totalRunsStrongboxless = 0;
			totalTwentyArtifacts = 0;
			totalArtifacts = 0;
			//if (penalties.length >= 1)
				//penalty = penalties[p];
		for (int i = 0; i < totalRuns; i++) {
			int[] output = new SimulateBuilds().doDomains(true, false, false, ValueMethod.FutureValue, new float[] {.1f, .2f, .2f, .2f, .2f, .2f});
			totalRunsStrongbox += output[0];
			totalTwentyArtifacts += output[1];
			totalArtifacts += output[2];
			//System.out.println("Moo");
			output = new SimulateBuilds().doDomains(true, false, false, ValueMethod.FutureSubs, new float[] {.05f, .0f, .05f, .05f, .0f, .0f});
			totalRunsStrongbox2 += output[0];
			totalTwentyArtifacts2 += output[1];
			totalArtifacts2 += output[2];
			/*output = new SimulateBuilds().doDomains(true, false, false, ValueMethod.FutureSubs, new float[] {.1f, .15f, .15f, .15f, .2f, .2f});
			totalRunsStrongbox3 += output[0];
			totalTwentyArtifacts3 += output[1];
			totalArtifacts3 += output[2];*/
			
			//Strongbox-less
			/*output = new SimulateBuilds().doDomains(false, false, false);
			totalRunsStrongboxless += output[0];
			
			output = new SimulateBuilds().doDomains(true, true, false);
			totalRunsStrongbox2 += output[0];
			totalTwentyArtifacts2 += output[1];
			totalArtifacts2 += output[2];
			/*output = new SimulateBuilds().doDomains(true, true, true);
			totalRunsStrongbox3 += output[0];
			totalTwentyArtifacts3 += output[1];
			totalArtifacts3 += output[2];*/
			//totalTwentyArtifacts += output[1];
			//totalArtifacts += output[2];
			///*
			if (i%(Math.max(totalRuns/500,1)) == 0)
			System.out.println("Runs complete:" + (i +1));//*/
		}
		//if (penalties.length > 1) {
		//System.out.printf("Penalty %.2f%s", penalties[p],System.lineSeparator() );
		//}
		System.out.println("Average number of runs w/ Strongbox+Old method: " + (totalRunsStrongbox/totalRuns) + ", " +(totalRunsStrongbox/totalRuns/9) + " days, with " + (totalTwentyArtifacts/totalRuns) + " average leveled artifacts, " + (totalArtifacts/totalRuns) + " viable artifacts total" );
		System.out.println("Average number of runs w/ Strongbox+New method (10, then 20): " + (totalRunsStrongbox2/totalRuns) + ", " +(totalRunsStrongbox2/totalRuns/9) + " days, with " + (totalTwentyArtifacts2/totalRuns) + " average leveled artifacts, " + (totalArtifacts2/totalRuns) + " viable artifacts total" );
		//System.out.println("Average number of runs w/ Strongbox+New method (10, then 20): " + (totalRunsStrongbox3/totalRuns) + ", " +(totalRunsStrongbox3/totalRuns/9) + " days, with " + (totalTwentyArtifacts3/totalRuns) + " average leveled artifacts, " + (totalArtifacts3/totalRuns) + " viable artifacts total" );
		//System.out.println("Average number of runs w/o Strongbox: " + (totalRunsStrongboxless/totalRuns) + ", " +(totalRunsStrongboxless/totalRuns/9) + " days ");

		//System.out.println("Average number of runs w/ Strongbox2: " + (totalRunsStrongbox2/totalRuns) + ", " +(totalRunsStrongbox2/totalRuns/9) + " days, with " + (totalTwentyArtifacts2/totalRuns) + " average leveled artifacts, " + (totalArtifacts2/totalRuns) + " viable artifacts total" );
		//System.out.println("Average number of runs w/ Strongbox3: " + (totalRunsStrongbox3/totalRuns) + ", " +(totalRunsStrongbox3/totalRuns/9) + " days, with " + (totalTwentyArtifacts3/totalRuns) + " average leveled artifacts, " + (totalArtifacts3/totalRuns) + " viable artifacts total" );//}
		
		
		/*int totalRunsNobox = 0;
		for (int i = 0; i < totalRuns; i++) {
			totalRunsNobox += new SimulateBuilds().doDomains(false);
			if (i%(totalRuns/10) == 0)
			System.out.println("Runs complete:" + i);
		}*/
		
		//System.out.println("Average number of runs without scambox: " + (totalRunsNobox/totalRuns) + ", " +(totalRunsStrongbox/totalRuns/9) + " days" );
	}
	
	public SimulateBuilds() {
		//Need to do to load domains. idk java weirdness
		@SuppressWarnings("unused")
		Object loadDomains = Domain.GoldCity;
	}
	public int[] doDomains(boolean doStrongbox, boolean doStrongbox2, boolean doStrongbox3, ValueMethod vm, float[] leveledRequirement) {
		//int[] output = {0,0};
		int twentyArtifacts = 0;
		Build[] team = new Build[1];
		Set[] sets = new Set[team.length*2];
		Set[] strongboxSets = new Set[team.length];
		Artifact[] bestOnPieces = new Artifact[team.length*10];
		Artifact[] bestOffPieces = new Artifact[team.length*5];
		float[] minValue = new float[team.length];
		ArrayList<Artifact> all5stars = new ArrayList<Artifact>(100);
		int runs = 0, exp = 0, extraArtifacts = 0;
		float minminValue;
		//Char 1
		team[0] = Characters.Nahida.cb.cb.get(0);
		//System.out.println("Character build 1: " + team[0].character + " " + team[0].getClass().getSimpleName());
		sets[0] = Set.Deepwood;
		sets[1] = Set.Deepwood;
		strongboxSets[0] = Set.Deepwood;
		minValue[0] = .8f;
		minminValue = minValue[0];
		//Char 2
		if (team.length > 1) {
		team[1] = Characters.Kuki.cb.cb.get(0);
		//System.out.println("Character build 2: " + team[1].character + " " + team[1].getClass().getSimpleName());
		sets[2] = Set.Gilded;
		sets[3] = Set.Gilded;
		strongboxSets[1] = Set.Noblesse;
		minValue[1] = .8f;
		minminValue = Math.min(minminValue, minValue[1]);
		//Char 3
		if (team.length > 2) {
		team[2] = Characters.Kokomi.cb.cb.get(0);
		//System.out.println("Character build 3: " + team[2].character + " " + team[2].getClass().getSimpleName());
		sets[4] = Set.OceanHued;
		sets[5] = Set.OceanHued;
		strongboxSets[2] = Set.OceanHued;
		minValue[2] = .8f;
		minminValue = Math.min(minminValue, minValue[2]);
		//Char 4
		if (team.length > 3) {
		team[3] = Characters.Beidou.cb.cb.get(0);
		//System.out.println("Character build 4: " + team[3].character + " " + team[3].getClass().getSimpleName());
		sets[6] = Set.Emblem;
		sets[7] = Set.Emblem;
		strongboxSets[3] = Set.Emblem;
		minValue[3] = .8f;
		minminValue = Math.min(minminValue, minValue[3]);
		}
		//Char 1b
		if (team.length > 4) {
			team[4] = Characters.Xiangling.cb.cb.get(0);
			//System.out.println("Character build 4: " + team[3].character + " " + team[3].getClass().getSimpleName());
			sets[8] = Set.Emblem;
			sets[9] = Set.Emblem;
			strongboxSets[4] = Set.Emblem;
			minValue[4] = .8f;
			minminValue = Math.min(minminValue, minValue[3]);
			}
		//Char 2b
		if (team.length > 5) {
			team[5] = Characters.Xingqui.cb.cb.get(0);
			//System.out.println("Character build 4: " + team[3].character + " " + team[3].getClass().getSimpleName());
			sets[10] = Set.Emblem;
			sets[11] = Set.Emblem;
			strongboxSets[5] = Set.Emblem;
			minValue[5] = .8f;
			minminValue = Math.min(minminValue, minValue[3]);
			}
		//Char 3b
		if (team.length > 6) {
			team[6] = Characters.Ei.cb.cb.get(0);
			//System.out.println("Character build 4: " + team[3].character + " " + team[3].getClass().getSimpleName());
			sets[12] = Set.Emblem;
			sets[13] = Set.Emblem;
			strongboxSets[6] = Set.Emblem;
			minValue[6] = .8f;
			minminValue = Math.min(minminValue, minValue[3]);
			}
		//Char 4b
		if (team.length > 7) {
			team[7] = Characters.Bennett.cb.cb.get(0);
			//System.out.println("Character build 4: " + team[3].character + " " + team[3].getClass().getSimpleName());
			sets[14] = Set.Noblesse;
			sets[15] = Set.Noblesse;
			strongboxSets[7] = Set.Noblesse;
			minValue[7] = .8f;
			minminValue = Math.min(minminValue, minValue[3]);
			}}}
		//Run da goods
		for (int i = 0; i < team.length; i++) {
			while (currentValueUpdated(i, team[i], bestOnPieces, bestOffPieces) < minValue[i]) {
				runs++;
				exp += 10722*1.13;
				//Get a new artifact
				Set farmset = (runs/2 == 1)?sets[i*2]:sets[i*2+1];
				Artifact newArt = Artifact.newRandomArtifactDomain(farmset, farmset.coSet);
				
				//check if keep or trash
				if (fasterCheckIfGood(newArt, team, ((vm == ValueMethod.FutureSubs)?leveledRequirement:minValue), vm)) {
					all5stars.add(newArt);
				} else {
					if (doStrongbox) {
						extraArtifacts++;
					} else {
						exp += 3780;
					}
				}
				
				if (extraArtifacts >= 3) {
					extraArtifacts -= 3;
					newArt = Artifact.newRandomArtifactStrongbox(strongboxSets[i]);
					if (fasterCheckIfGood(newArt, team, ((vm == ValueMethod.FutureSubs)?leveledRequirement:minValue), vm)) {
						all5stars.add(newArt);
					} else {
						if (doStrongbox) {
							extraArtifacts++;
						} else {
							exp += 3780;
						}
					}
				}
				
				//check next level
				if (exp >= 270475) {
				Artifact nextLevel = null;
				float value = 0f;
				for (Artifact hoi:all5stars) {
					if (hoi.level < 20) {
						for (int j = 0; j < team.length; j++) {
							float tempValue = team[j].getFutureOffPieceValueUpdated(hoi, true) - ((bestOffPieces[j*5+hoi.slot.slot] != null)?team[j].getFutureOffPieceValueUpdated(bestOffPieces[j*5+hoi.slot.slot], true):0f);
							
							if (hoi.set == sets[j*2]) {
								float tempVal1 = team[j].getFutureValueUpdated(hoi, true) - ((bestOnPieces[j*10+hoi.slot.slot] != null)?team[j].getFutureValueUpdated(bestOnPieces[j*10+hoi.slot.slot], true):0f);
								tempValue = Math.max(tempValue, tempVal1);
							} else if (hoi.set == sets[j*2+1]) {
								float tempVal1 = team[j].getFutureValueUpdated(hoi, true) - ((bestOnPieces[j*10+hoi.slot.slot + 5] != null)?team[j].getFutureValueUpdated(bestOnPieces[j*10+hoi.slot.slot + 5], true):0f);
								tempValue = Math.max(tempValue, tempVal1);
							} else {
								if (doRaisePenalty)
								tempValue -= Slot.rarityMod(hoi.slot, hoi.mainStat);
							}
							
							if (tempValue > value) {
								value = tempValue;
								nextLevel = hoi;
							}
						}
					}
				}
				//System.out.println(value);
				//level
				if (nextLevel != null) {
				nextLevel.randomlyLevel(12);
				exp -= Artifact.levelEXP[12];
				if (fasterCheckIfGood(newArt, team, ((vm == ValueMethod.FutureSubs)?leveledRequirement:minValue), vm)) {
					//Raise to 20
					nextLevel.randomlyLevel(8);
					exp += Artifact.levelEXP[12];
					exp -= Artifact.levelEXP[20];
					if (nextLevel.getUpdatedWeightedValue() >= minminValue) {
						//See if best
						System.out.println("Keeping: " + nextLevel);
						//System.out.println("Raising:" + nextLevel);
						twentyArtifacts++;
						for (int y = 0; y < team.length; y++) {
							if (sets[y*2] == nextLevel.set) {
								int slot = y*10+nextLevel.slot.slot;
								if (bestOnPieces[slot] == null) {
									bestOnPieces[slot] = nextLevel;
									//System.out.println("Piece slotted on " + team[y]);
								} else {
									float tempCheck = team[y].getFutureValueUpdated(nextLevel, true);
									float currentCheck = team[y].getValueUpdated(bestOnPieces[y*10+nextLevel.slot.slot]);
									if (tempCheck > currentCheck) {
										bestOnPieces[slot] = nextLevel;
										//System.out.println("Piece used");
									}
								}
							}
							if (sets[y*2+1] == nextLevel.set) {
								int slot = y*10+nextLevel.slot.slot + 5;
								if (bestOnPieces[slot] == null) {
									bestOnPieces[slot] = nextLevel;
									//System.out.println("Piece slotted");
								} else {
									float tempCheck = team[y].getValueUpdated(nextLevel);
									float currentCheck = team[y].getValueUpdated(bestOnPieces[slot]);
									if (tempCheck > currentCheck) {
										bestOnPieces[slot] = nextLevel;
										//System.out.println("Piece used");
									}
								}
							}
							//Offpiece
							int slot = y*5+nextLevel.slot.slot;
							if (bestOffPieces[slot] == null) {
								bestOffPieces[slot] = nextLevel;
								//System.out.println("Piece slotted");
							} else {
								float tempCheck = team[y].getFutureOffPieceValueUpdated(nextLevel, true);
								float currentCheck = team[y].getFutureOffPieceValueUpdated(bestOffPieces[slot], true);
								if (tempCheck > currentCheck) {
									bestOffPieces[slot] = nextLevel;
									//System.out.println("New best off for " + team[y]);
								}
							}
							}
						} else {
							if (!doStrongbox3) {
							exp += (3780 + Artifact.levelEXP[20]*.8)*1.13;
							} else {
								extraArtifacts++;
							}
							all5stars.remove(nextLevel);
						}
					} else {
						if (!doStrongbox2) {
							exp += (3780 + Artifact.levelEXP[12]*.8)*1.13;
						} else {
							extraArtifacts++;
						}
						all5stars.remove(nextLevel);
					}
				} else {
					//System.out.println("Nothing to raise");
				}
				}
				if (runs%100 == 0) {
					//System.out.println(runs + " runs");
					//System.out.println(bestOffPieces[i*5]);
					//System.out.println(team[i].character + " " + team[i].getClass().getSimpleName());
					//System.out.println(printCurrentValueUpdated(i, team[i], bestOnPieces, bestOffPieces));
				}
			}
			lockCurrentValueUpdated(i, team[i], bestOnPieces, bestOffPieces);
			/*
			
			System.out.println("----------");
			System.out.println("Character done: " + team[i]);
			System.out.println(team[i]);
			System.out.println(printCurrentValueUpdated(i, team[i], bestOnPieces, bestOffPieces));
			System.out.println("----------");
			//*/
		}
		for (int i = 0; i < team.length; i++) {
			/*System.out.println(team[i]);
			System.out.println(printCurrentValueUpdated(i, team[i], bestOnPieces, bestOffPieces));//*/
		}
		
		return new int[]{runs, twentyArtifacts, all5stars.size()};
		
		
		/*Artifact newboi = Artifact.newRandomArtifactStrongbox(Set.Gilded);
		System.out.println(newboi);
		System.out.println("Value: " + newboi.getFutureValueUpdated());
		System.out.println(newboi.randomlyLevel(20));
		System.out.println("Value: " + newboi.getFutureValueUpdated());*/
	}
	
	public static float currentValueUpdated(int num, Build cha, Artifact[] onPieces, Artifact[] offPieces) {
		float[][] pieces = {{(onPieces[num*10+0] != null)?cha.getValueUpdated(onPieces[num*10+0]):0f,
				(onPieces[num*10+1] != null)?cha.getValueUpdated(onPieces[num*10+1]):0f,
				(onPieces[num*10+2] != null)?cha.getValueUpdated(onPieces[num*10+2]):0f,
				(onPieces[num*10+3] != null)?cha.getValueUpdated(onPieces[num*10+3]):0f,
				(onPieces[num*10+4] != null)?cha.getValueUpdated(onPieces[num*10+4]):0f},
				{(onPieces[num*10+5] != null)?cha.getValueUpdated(onPieces[num*10+5]):0f,
				(onPieces[num*10+6] != null)?cha.getValueUpdated(onPieces[num*10+6]):0f,
				(onPieces[num*10+7] != null)?cha.getValueUpdated(onPieces[num*10+7]):0f,
				(onPieces[num*10+8] != null)?cha.getValueUpdated(onPieces[num*10+8]):0f,
				(onPieces[num*10+9] != null)?cha.getValueUpdated(onPieces[num*10+9]):0f},
				{(offPieces[num*5] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5], true):0f,
				(offPieces[num*5+1] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5+1], true):0f,
				(offPieces[num*5+2] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5+2], true):0f,
				(offPieces[num*5+3] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5+3], true):0f,
				(offPieces[num*5+4] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5+4], true):0f}};
		
		int[] counts = {0,0,0};
		int[] maxcounts = {2,2,1};
		float maxValue = 0;
		for (int i1 = 0; i1 < 3; i1++) {
			counts[i1]++;
			for (int i2 = 0; i2 < 3; i2++) {
				counts[i2]++;
				if (counts[i2] <= maxcounts[i2])
				for (int i3 = 0; i3 < 3; i3++) {
					counts[i3]++;
					if (counts[i3] <= maxcounts[i3])
					for (int i4 = 0; i4 < 3; i4++) {
						counts[i4]++;
						if (counts[i4] <= maxcounts[i4])
						for (int i5 = 0; i5 < 3; i5++) {
							counts[i5]++;
							if (counts[i5] <= maxcounts[i5]) {
								float value = (pieces[i1][0] + pieces[i2][1] +pieces[i3][2]+pieces[i4][3]+pieces[i5][4])/5f;
								if (value > maxValue) {
									//System.out.printf("[%d,%d,%d,%d,%d]%s", i1,i2,i3,i4,i5,System.lineSeparator());
									maxValue = value;
								}
							}
								
							counts[i5]--;
						}
						counts[i4]--;
					}
					counts[i3]--;
				}
				counts[i2]--;
			}
			counts[i1]--;
		}
		
		return maxValue;
	}
	
	public static float lockCurrentValueUpdated(int num, Build cha, Artifact[] onPieces, Artifact[] offPieces) {
		float[][] pieces = {{(onPieces[num*10+0] != null)?cha.getValueUpdated(onPieces[num*10+0]):0f,
				(onPieces[num*10+1] != null)?cha.getValueUpdated(onPieces[num*10+1]):0f,
				(onPieces[num*10+2] != null)?cha.getValueUpdated(onPieces[num*10+2]):0f,
				(onPieces[num*10+3] != null)?cha.getValueUpdated(onPieces[num*10+3]):0f,
				(onPieces[num*10+4] != null)?cha.getValueUpdated(onPieces[num*10+4]):0f},
				{(onPieces[num*10+5] != null)?cha.getValueUpdated(onPieces[num*10+5]):0f,
				(onPieces[num*10+6] != null)?cha.getValueUpdated(onPieces[num*10+6]):0f,
				(onPieces[num*10+7] != null)?cha.getValueUpdated(onPieces[num*10+7]):0f,
				(onPieces[num*10+8] != null)?cha.getValueUpdated(onPieces[num*10+8]):0f,
				(onPieces[num*10+9] != null)?cha.getValueUpdated(onPieces[num*10+9]):0f},
				{(offPieces[num*5] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5], true):0f,
				(offPieces[num*5+1] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5+1], true):0f,
				(offPieces[num*5+2] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5+2], true):0f,
				(offPieces[num*5+3] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5+3], true):0f,
				(offPieces[num*5+4] != null)?cha.getFutureOffPieceValueUpdated(offPieces[num*5+4], true):0f}};
		
		int[] counts = {0,0,0};
		int[] bestSlots = {0,0,0,0,0};
		int[] maxcounts = {2,2,1};
		float maxValue = 0;
		for (int i1 = 0; i1 < 3; i1++) {
			counts[i1]++;
			for (int i2 = 0; i2 < 3; i2++) {
				counts[i2]++;
				if (counts[i2] <= maxcounts[i2])
				for (int i3 = 0; i3 < 3; i3++) {
					counts[i3]++;
					if (counts[i3] <= maxcounts[i3])
					for (int i4 = 0; i4 < 3; i4++) {
						counts[i4]++;
						if (counts[i4] <= maxcounts[i4])
						for (int i5 = 0; i5 < 3; i5++) {
							counts[i5]++;
							if (counts[i5] <= maxcounts[i5]) {
								float value = (pieces[i1][0] + pieces[i2][1] +pieces[i3][2]+pieces[i4][3]+pieces[i5][4])/5f;
								if (value > maxValue) {
									bestSlots[0] = i1;
									bestSlots[1] = i2;
									bestSlots[2] = i3;
									bestSlots[3] = i4;
									bestSlots[4] = i5;
									maxValue = value;
								}
							}
								
							counts[i5]--;
						}
						counts[i4]--;
					}
					counts[i3]--;
				}
				counts[i2]--;
			}
			counts[i1]--;
		}
		for (int i = 0; i < 5; i++) {
			switch (bestSlots[i]) {
			case 0:
				//System.out.println(onPieces[num*10+i] + " " + cha.getValueUpdated(onPieces[num*10+i]));
				break;
			case 1:
				//System.out.println(onPieces[num*10+i+5] + " " + cha.getValueUpdated(onPieces[num*10+i+5]));
				break;
			case 2:
				//System.out.println(offPieces[num*5+i] + " " + cha.getFutureOffPieceValueUpdated(offPieces[num*5+i], true));
				break;
			}
		}
		
		return maxValue;
	}
	
	public static boolean fasterCheckIfGood(Artifact art, Build[] builds, float[] requirements, ValueMethod vm) {
		//FutureSubs.getFutureValue(newArt)>=leveledRequirement[newArt.level/4]):
			//()
		switch (vm) {
		case FutureValue:
			return art.getUpdatedWeightedValue()>=0.8f;
			/*for (int i = 0; i < builds.length; i++) {
				Build b = builds[i];
				float requirement = requirements[i];
				return b.getValueUpdated(art) >= requirement;
			}*/
		case FutureSubs:
			for (int i = 0; i < builds.length; i++) {
				Build b = builds[i];
				float requirement = requirements[art.level/4];
				if (FutureSubs.getFutureValue(b, art, false) >= requirement || FutureSubs.getFutureValue(b, art, true) >= requirement ) {
					System.out.println(art);
					return true;
				}
			}
		default: return false;
		}
	}
}
