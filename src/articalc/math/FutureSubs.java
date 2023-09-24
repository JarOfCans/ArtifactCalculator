package articalc.math;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.artifact.Artifact;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Slot;
import articalc.enums.Stat;

public class FutureSubs {
	static ArrayList<HashMap<int[], Integer>> arrayMap;
	
	public static int[] test = {0,0,0,0};
	/*
	public static void main(String [] args) {
		//ToFindValues
		int[][][][] dalist = new int[6][6][6][6];
		int[] values = {0,0,0,0};
		//Level 4/8
		for (int i = 0; i < 4; i++) {
			values[i]++;
			//Level 8/12
			for (int j = 0; j < 4; j++) {
				values[j]++;
				//Level 12/16
				for (int k = 0; k < 4; k++) {
					values[k]++;
					//Level 16/20
					for (int l = 0; l < 4; l++) {
						values[l]++;
						//Level 20/-
						for (int m = 0; m < 4; m++) {
							values[m]++;
							values[m]--;
						}
						//dalist[values[0]][values[1]][values[2]][values[3]]++;
						values[l]--;
					}
					values[k]--;
				}
				values[j]--;
			}
			values[i]--;
		}
		dalist[values[0]][values[1]][values[2]][values[3]]++;
		int sum = 0, count = 0;
		for (int i = 0; i< 6; i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					for (int l = 0; l < 6; l++) {
						if (dalist[i][j][k][l] > 0) {
							//System.out.printf("{%d,%d,%d,%d} x%d%s", i, j, k, l, dalist[i][j][k][l], System.lineSeparator());
							//System.out.printf("map.put(new int[]{%d,%d,%d,%d}, %d);%s", i, j, k, l, dalist[i][j][k][l], System.lineSeparator());
							StringBuilder sb = new StringBuilder();
							sb.append("map.put(new int[]{");
							boolean loopedOnce = false;
							int[] intArray = {i, j, k, l};
							for (int itt = 0; itt < 4; itt++) {
								for (int loop = 0; loop < intArray[itt]; loop++) {
									if (loopedOnce) {
										sb.append(",");
									}
									sb.append(itt);
									loopedOnce = true;
								}
							}
							sb.append(String.format("}, %d);%s", dalist[i][j][k][l], System.lineSeparator()));
							System.out.print(sb.toString());
							count++;
							sum += dalist[i][j][k][l];
						}
					}
				}
			}
		}
		System.out.printf("Total: %d from %d combinations", sum, count, System.lineSeparator());
	}
	*/
	public static HashMap<int[], Integer> getAll(int subCount) {
		if (arrayMap == null) {
			arrayMap = new ArrayList<HashMap<int[], Integer>>();
			setUpArrayMap();
		}
		return arrayMap.get(subCount);
	}
	
	private static void setUpArrayMap() {
		for (int value = 0; value < 6; value++) {
			HashMap<int[], Integer> map = new HashMap<int[], Integer>();
		switch(value) {
		case 0:
			map.put(new int[]{}, 1);
			break;
		case 1:
			map.put(new int[]{3}, 1);
			map.put(new int[]{2}, 1);
			map.put(new int[]{1}, 1);
			map.put(new int[]{0}, 1);
			break;
		case 2:
			map.put(new int[]{3,3}, 1);
			map.put(new int[]{2,3}, 2);
			map.put(new int[]{2,2}, 1);
			map.put(new int[]{1,3}, 2);
			map.put(new int[]{1,2}, 2);
			map.put(new int[]{1,1}, 1);
			map.put(new int[]{0,3}, 2);
			map.put(new int[]{0,2}, 2);
			map.put(new int[]{0,1}, 2);
			map.put(new int[]{0,0}, 1);
			break;
		case 3:
			map.put(new int[]{3,3,3}, 1);
			map.put(new int[]{2,3,3}, 3);
			map.put(new int[]{2,2,3}, 3);
			map.put(new int[]{2,2,2}, 1);
			map.put(new int[]{1,3,3}, 3);
			map.put(new int[]{1,2,3}, 6);
			map.put(new int[]{1,2,2}, 3);
			map.put(new int[]{1,1,3}, 3);
			map.put(new int[]{1,1,2}, 3);
			map.put(new int[]{1,1,1}, 1);
			map.put(new int[]{0,3,3}, 3);
			map.put(new int[]{0,2,3}, 6);
			map.put(new int[]{0,2,2}, 3);
			map.put(new int[]{0,1,3}, 6);
			map.put(new int[]{0,1,2}, 6);
			map.put(new int[]{0,1,1}, 3);
			map.put(new int[]{0,0,3}, 3);
			map.put(new int[]{0,0,2}, 3);
			map.put(new int[]{0,0,1}, 3);
			map.put(new int[]{0,0,0}, 1);
			break;
		case 4:
			map.put(new int[]{3,3,3,3}, 1);
			map.put(new int[]{2,3,3,3}, 4);
			map.put(new int[]{2,2,3,3}, 6);
			map.put(new int[]{2,2,2,3}, 4);
			map.put(new int[]{2,2,2,2}, 1);
			map.put(new int[]{1,3,3,3}, 4);
			map.put(new int[]{1,2,3,3}, 12);
			map.put(new int[]{1,2,2,3}, 12);
			map.put(new int[]{1,2,2,2}, 4);
			map.put(new int[]{1,1,3,3}, 6);
			map.put(new int[]{1,1,2,3}, 12);
			map.put(new int[]{1,1,2,2}, 6);
			map.put(new int[]{1,1,1,3}, 4);
			map.put(new int[]{1,1,1,2}, 4);
			map.put(new int[]{1,1,1,1}, 1);
			map.put(new int[]{0,3,3,3}, 4);
			map.put(new int[]{0,2,3,3}, 12);
			map.put(new int[]{0,2,2,3}, 12);
			map.put(new int[]{0,2,2,2}, 4);
			map.put(new int[]{0,1,3,3}, 12);
			map.put(new int[]{0,1,2,3}, 24);
			map.put(new int[]{0,1,2,2}, 12);
			map.put(new int[]{0,1,1,3}, 12);
			map.put(new int[]{0,1,1,2}, 12);
			map.put(new int[]{0,1,1,1}, 4);
			map.put(new int[]{0,0,3,3}, 6);
			map.put(new int[]{0,0,2,3}, 12);
			map.put(new int[]{0,0,2,2}, 6);
			map.put(new int[]{0,0,1,3}, 12);
			map.put(new int[]{0,0,1,2}, 12);
			map.put(new int[]{0,0,1,1}, 6);
			map.put(new int[]{0,0,0,3}, 4);
			map.put(new int[]{0,0,0,2}, 4);
			map.put(new int[]{0,0,0,1}, 4);
			map.put(new int[]{0,0,0,0}, 1);
			break;
		case 5:
			map.put(new int[]{3,3,3,3,3}, 1);
			map.put(new int[]{2,3,3,3,3}, 5);
			map.put(new int[]{2,2,3,3,3}, 10);
			map.put(new int[]{2,2,2,3,3}, 10);
			map.put(new int[]{2,2,2,2,3}, 5);
			map.put(new int[]{2,2,2,2,2}, 1);
			map.put(new int[]{1,3,3,3,3}, 5);
			map.put(new int[]{1,2,3,3,3}, 20);
			map.put(new int[]{1,2,2,3,3}, 30);
			map.put(new int[]{1,2,2,2,3}, 20);
			map.put(new int[]{1,2,2,2,2}, 5);
			map.put(new int[]{1,1,3,3,3}, 10);
			map.put(new int[]{1,1,2,3,3}, 30);
			map.put(new int[]{1,1,2,2,3}, 30);
			map.put(new int[]{1,1,2,2,2}, 10);
			map.put(new int[]{1,1,1,3,3}, 10);
			map.put(new int[]{1,1,1,2,3}, 20);
			map.put(new int[]{1,1,1,2,2}, 10);
			map.put(new int[]{1,1,1,1,3}, 5);
			map.put(new int[]{1,1,1,1,2}, 5);
			map.put(new int[]{1,1,1,1,1}, 1);
			map.put(new int[]{0,3,3,3,3}, 5);
			map.put(new int[]{0,2,3,3,3}, 20);
			map.put(new int[]{0,2,2,3,3}, 30);
			map.put(new int[]{0,2,2,2,3}, 20);
			map.put(new int[]{0,2,2,2,2}, 5);
			map.put(new int[]{0,1,3,3,3}, 20);
			map.put(new int[]{0,1,2,3,3}, 60);
			map.put(new int[]{0,1,2,2,3}, 60);
			map.put(new int[]{0,1,2,2,2}, 20);
			map.put(new int[]{0,1,1,3,3}, 30);
			map.put(new int[]{0,1,1,2,3}, 60);
			map.put(new int[]{0,1,1,2,2}, 30);
			map.put(new int[]{0,1,1,1,3}, 20);
			map.put(new int[]{0,1,1,1,2}, 20);
			map.put(new int[]{0,1,1,1,1}, 5);
			map.put(new int[]{0,0,3,3,3}, 10);
			map.put(new int[]{0,0,2,3,3}, 30);
			map.put(new int[]{0,0,2,2,3}, 30);
			map.put(new int[]{0,0,2,2,2}, 10);
			map.put(new int[]{0,0,1,3,3}, 30);
			map.put(new int[]{0,0,1,2,3}, 60);
			map.put(new int[]{0,0,1,2,2}, 30);
			map.put(new int[]{0,0,1,1,3}, 30);
			map.put(new int[]{0,0,1,1,2}, 30);
			map.put(new int[]{0,0,1,1,1}, 10);
			map.put(new int[]{0,0,0,3,3}, 10);
			map.put(new int[]{0,0,0,2,3}, 20);
			map.put(new int[]{0,0,0,2,2}, 10);
			map.put(new int[]{0,0,0,1,3}, 20);
			map.put(new int[]{0,0,0,1,2}, 20);
			map.put(new int[]{0,0,0,1,1}, 10);
			map.put(new int[]{0,0,0,0,3}, 5);
			map.put(new int[]{0,0,0,0,2}, 5);
			map.put(new int[]{0,0,0,0,1}, 5);
			map.put(new int[]{0,0,0,0,0}, 1);
			break;
		}
		arrayMap.add(map);
		}
	}
	
	public static float getFutureValue(Build b, Artifact art, boolean onPiece, float valMin) {
		Artifact clone = art.clone();
		float output = 0f;
		float totals = 0;
		int levelups = 5 - art.level/4;
		//if 3-sub artifact
		if (art.subs[3] == null || art.subs[3] == Stat.NULL) {
			//1 level dedicated to gaining a sub
			levelups--;
			//for each sub
			for (Stat sub: Stat.subsNotNULL()) {
				//ignore subs that are duplicates
				if (art.subs[0] != sub && art.subs[1] != sub && art.subs[2] != sub && art.mainStat != sub) {
					//float[] temp
					Artifact current4sub = art.clone();
					current4sub.subs[3] = sub;
					float subChance = sub.subChance/(1-current4sub.subs[0].subChance-current4sub.subs[1].subChance-current4sub.subs[2].subChance);
					for (int subVal = 0; subVal < 4; subVal++) {
						current4sub.subValues[3] = current4sub.subs[3].subMax*(0.7f + 0.1f*subVal);
						//now a 4 sub artifact
						HashMap<int[], Integer> map = getAll(levelups);
						for (int[] subs: map.keySet()) {
							for (int[] subIncreases: map.keySet()) {
								clone = current4sub.clone();
								for (int i = 0; i < subs.length; i++) {
									clone.subValues[subs[i]] += clone.subs[subs[i]].subMax * (0.7f + 0.1f*subIncreases[i]);
								}
								clone.level = 20;
								if (((onPiece)?b.getValueUpdated(clone):b.getOffPieceValueUpdated(clone)) >= valMin) {
									output +=subChance*map.get(subs) * map.get(subIncreases);
								}
								totals+= map.get(subs) * map.get(subIncreases) * subChance;
							}
						}
					}
				}
			}
			output /= totals;
		} else {
			//else 4 sub artifact
			HashMap<int[], Integer> map = getAll(levelups);
			for (int[] subs: map.keySet()) {
				for (int[] subIncreases: map.keySet()) {
					clone = art.clone();
					for (int i = 0; i < subs.length; i++) {
						clone.subValues[subs[i]] += clone.subs[subs[i]].subMax * (0.7f + 0.1f*subIncreases[i]);
					}
					clone.level = 20;
					if (((onPiece)?b.getValueUpdated(clone):b.getOffPieceValueUpdated(clone)) >= valMin) {
						output += map.get(subs) * map.get(subIncreases);
					}
					totals+= map.get(subs) * map.get(subIncreases);
				}
			}
			output /= (float)totals;
		}
		return output;
	}
	public static float getFutureValue(Artifact art, float valMin) {
		Artifact clone = art.clone();
		//System.out.println(clone);
		float output = 0f;
		float totals = 0f;
		int levelups = 5 - art.level/4;
		//if 3-sub artifact
		if (art.subs[3] == Stat.NULL || art.subs[3] == null) {
			//1 level dedicated to gaining a sub
			levelups--;
			//for each sub
			for (Stat sub: Stat.subsNotNULL()) {
				//ignore subs that are duplicates
				if (art.subs[0] != sub && art.subs[1] != sub && art.subs[2] != sub && art.mainStat != sub) {
					Artifact current4sub = art.clone();
					current4sub.subs[3] = sub;
					float subChance = sub.subChance/(1-current4sub.subs[0].subChance-current4sub.subs[1].subChance-current4sub.subs[2].subChance);
					for (int subVal = 0; subVal < 4; subVal++) {
						current4sub.subValues[3] = current4sub.subs[3].subMax*(0.7f + 0.1f*subVal);
						//now a 4 sub artifact
						HashMap<int[], Integer> map = getAll(levelups);
						for (int[] subs: map.keySet()) {
							for (int[] subIncreases: map.keySet()) {
								clone = current4sub.clone();
								for (int i = 0; i < subs.length; i++) {
									clone.subValues[subs[i]] += clone.subs[subs[i]].subMax * (0.7f + 0.1f*subIncreases[i]);
								}
								clone.level = 20;
								//System.out.println(clone);
								boolean doBreak = false;
								for (Characters c: Characters.values()) {
									for (Build b: c.cb.cb) {
										if (b.getValueUpdated(clone) >= valMin) {
											output +=(1f*subChance*map.get(subs) * map.get(subIncreases));
											doBreak = true;
											break;
										}
										if (b.getOffPieceValueUpdated(clone) - Slot.rarityMod(clone.slot, clone.mainStat) >= valMin) {
											output +=(1f*subChance*map.get(subs) * map.get(subIncreases));
											doBreak = true;
											break;
										}
										
									}
									if (doBreak) {
										break;
									}
								}
								totals+=(1f*subChance*map.get(subs) * map.get(subIncreases));
							}
						}
					}
				}
			}
			System.out.println(output);
			System.out.println(totals);
			output /= (float)totals;
		} else {
			//else 4 sub artifact
			HashMap<int[], Integer> map = getAll(levelups);
			//For each combination of increased subs
			for (int[] subs: map.keySet()) {
				//For each combination of increase amounts
				for (int[] subIncreases: map.keySet()) {
					clone = art.clone();
					for (int i = 0; i < subs.length; i++) {
						clone.subValues[subs[i]] += clone.subs[subs[i]].subMax * (0.7f + 0.1f*subIncreases[i]);
					}
					clone.level = 20;
					boolean doBreak = false;
					for (Characters c: Characters.values()) {
						for (Build b: c.cb.cb) {
							if (b.getValueUpdated(clone) >= valMin) {
								output += map.get(subs) * map.get(subIncreases);
								doBreak = true;
								break;
							}
							if (b.getOffPieceValueUpdated(clone) - Slot.rarityMod(clone.slot, clone.mainStat) >= valMin) {
								output += map.get(subs) * map.get(subIncreases);
								doBreak = true;
								break;
							}
							
						}
						if (doBreak) {
							break;
						}
					}
					totals += map.get(subs) * map.get(subIncreases);
				}
			}
			output /= (float)totals;
		}
		return (float)(((int)(output*10000))*0.0001);
	}
	public static float[] getFutureValueArray(Build b, Artifact art, boolean onPiece) {
		Artifact clone = art.clone();
		float[] output = new float[101];
		int totals = 0;
		int levelups = 5 - art.level/4;
		//if 3-sub artifact
		if (art.subs[3] == null || art.subs[3] == Stat.NULL) {
			//1 level dedicated to gaining a sub
			levelups--;
			//for each sub
			for (Stat sub: Stat.subsNotNULL()) {
				//ignore subs that are duplicates
				if (art.subs[0] != sub && art.subs[1] != sub && art.subs[2] != sub && art.mainStat != sub) {
					//float[] temp
					Artifact current4sub = art.clone();
					current4sub.subs[3] = sub;
					float subChance = sub.subChance/(1-current4sub.subs[0].subChance-current4sub.subs[1].subChance-current4sub.subs[2].subChance);
					for (int subVal = 0; subVal < 4; subVal++) {
						current4sub.subValues[3] = current4sub.subs[3].subMax*(0.7f + 0.1f*subVal);
						//now a 4 sub artifact
						HashMap<int[], Integer> map = getAll(levelups);
						for (int[] subs: map.keySet()) {
							for (int[] subIncreases: map.keySet()) {
								clone = current4sub.clone();
								for (int i = 0; i < subs.length; i++) {
									clone.subValues[subs[i]] += clone.subs[subs[i]].subMax * (0.7f + 0.1f*subIncreases[i]);
								}
								clone.level = 20;
								output[(int) (((onPiece)?b.getValueUpdated(clone):b.getOffPieceValueUpdated(clone))*100)]+= (1f*subChance);
								totals++;
							}
						}
					}
				}
			}
			for (int i = 0; i < output.length; i++) {
				output[i] /= (float)totals/7f;
			}
		} else {
			//else 4 sub artifact
			HashMap<int[], Integer> map = getAll(levelups);
			for (int[] subs: map.keySet()) {
				for (int[] subIncreases: map.keySet()) {
					clone = art.clone();
					for (int i = 0; i < subs.length; i++) {
						clone.subValues[subs[i]] += clone.subs[subs[i]].subMax * (0.7f + 0.1f*subIncreases[i]);
					}
					clone.level = 20;
					output[(int) (((onPiece)?b.getValueUpdated(clone):b.getOffPieceValueUpdated(clone))*100)]++;
					totals++;
				}
			}
			for (int i = 0; i < output.length; i++) {
				output[i] /= (float)totals;
			}
		}
		return output;
	}
	public static float[] getFutureValueArray(Artifact art) {
		Artifact clone = art.clone();
		float[] output = new float[101];
		float[] fourthSub = new float[Stat.subsNotNULL().size()];
		int totals = 0;
		int levelups = 5 - art.level/4;
		//if 3-sub artifact
		if (art.subs[3] == null || art.subs[3] == Stat.NULL) {
			//1 level dedicated to gaining a sub
			levelups--;
			//for each sub
			for (Stat sub: Stat.subsNotNULL()) {
				//ignore subs that are duplicates
				if (art.subs[0] != sub && art.subs[1] != sub && art.subs[2] != sub && art.mainStat != sub) {
					//float[] temp
					Artifact current4sub = art.clone();
					current4sub.subs[3] = sub;
					float subChance = sub.subChance/(1-current4sub.subs[0].subChance-current4sub.subs[1].subChance-current4sub.subs[2].subChance);
					fourthSub[Stat.subsNotNULL().indexOf(current4sub.subs[3])]+= (1f*subChance);
					for (int subVal = 0; subVal < 4; subVal++) {
						current4sub.subValues[3] = current4sub.subs[3].subMax*(0.7f + 0.1f*subVal);
						//now a 4 sub artifact
						HashMap<int[], Integer> map = getAll(levelups);
						for (int[] subs: map.keySet()) {
							for (int[] subIncreases: map.keySet()) {
								clone = current4sub.clone();
								for (int i = 0; i < subs.length; i++) {
									clone.subValues[subs[i]] += clone.subs[subs[i]].subMax * (0.7f + 0.1f*subIncreases[i]);
								}
								clone.level = 20;
								float value = 0f;
								for (Characters cb: Characters.values()) {
									for (Build b: cb.cb.cb) {
										float max = Math.max(b.getValueUpdated(clone), b.getOffPieceValueUpdated(clone) - Slot.rarityMod(clone.slot, clone.mainStat));
										value = Math.max(value, max);
									}
								}
								output[(int) ((value)*100)]+= (1f*subChance);
								totals++;
							}
						}
					}
				}
			}
			for (int i = 0; i < output.length; i++) {
				output[i] /= (float)totals/7f;
			}
		} else {
			//else 4 sub artifact
			HashMap<int[], Integer> map = getAll(levelups);
			for (int[] subs: map.keySet()) {
				for (int[] subIncreases: map.keySet()) {
					clone = art.clone();
					for (int i = 0; i < subs.length; i++) {
						clone.subValues[subs[i]] += clone.subs[subs[i]].subMax * (0.7f + 0.1f*subIncreases[i]);
					}
					clone.level = 20;
					float value = 0f;
					for (Characters cb: Characters.values()) {
						for (Build b: cb.cb.cb) {
							float max = Math.max(b.getValueUpdated(clone), b.getOffPieceValueUpdated(clone) - Slot.rarityMod(clone.slot, clone.mainStat));
							value = Math.max(value, max);
						}
					}
					output[(int) ((value)*100)]++;
					totals++;
				}
			}
			for (int i = 0; i < output.length; i++) {
				output[i] /= (float)totals;
			}
		}
		for (int i = 0; i < Stat.subsNotNULL().size();i++) {
			System.out.printf("%s: %.1f%c%s", Stat.subsNotNULL().get(i),fourthSub[i]*100f,'%', System.lineSeparator());
		}
		return output;
	}
	

}