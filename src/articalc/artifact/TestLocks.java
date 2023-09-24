package articalc.artifact;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.Stat;

public class TestLocks {

	public static void main(String[] args) {
		ArtifactParser parse = new ArtifactParser("genshinData_GOOD_2023_07_23_12_13.json");
		
		int levelMax = 20;
		Set set = null; 
		
		boolean ignoreSetFlag = set == null;
		boolean ignoreFineFlag = true;
		
		HashMap<Slot, HashMap<Stat, Integer>> offPieces = new HashMap<Slot, HashMap<Stat, Integer>>();
		int oglocks = 0, newlocks = 0;
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Locks.txt"))) {
			

		for (Artifact art : parse.artifacts) {
			if ((ignoreSetFlag||art.set == set) && art.level <= levelMax) {
				Build bestBuild = null;
				float bestFValue = -1f;
				float bestCValue = 0f;
		
				Build bestBuildOff = null;
				float bestOPValue = -1f;
				for (Characters cha: Characters.values()) {
					for (Build hoi: cha.cb.cb) {
						float value = hoi.getValueUpdated(art);
						float fvalue = hoi.getFutureValueUpdated(art, true);
						float opvalue = hoi.getFutureOffPieceValueUpdated(art, true);
						if (fvalue > bestFValue) {
							bestBuild = hoi;
							bestFValue = fvalue;
							bestCValue = value;
						}
						if (opvalue > bestOPValue) {
							bestBuildOff = hoi;
							bestOPValue = opvalue;
						}
					}
				}
				float weightedValue = art.getUpdatedWeightedValue();
				boolean toLock = weightedValue >= 0.8f;
				if (toLock && bestFValue < 0.8f) {
					increment(offPieces, art.slot, art.mainStat);
					if (art.slot == Slot.flower || art.slot == Slot.plume) {
						System.out.println(art);
						System.out.println(bestFValue);
					}
				}
				if (art.locked) {
					oglocks++;
				}
				if (toLock) {
					newlocks++;
				}
				if (!ignoreFineFlag || ( (toLock && !art.locked)||(!toLock && art.locked) )) {
					bw.write("Best builds for " + art.toString());
					bw.newLine();
					bw.write(String.format("onpiece %s %s: %.2f%c - %.2f%c%s",bestBuild.character, bestBuild.getClass().getSimpleName(), bestCValue*100f,'%',bestFValue*100f,'%',System.lineSeparator()));
					bw.write(String.format("offpiece %s %s: %.2f%c%s",bestBuildOff.character, bestBuildOff.getClass().getSimpleName(), bestOPValue*100f,'%',System.lineSeparator()));
					bw.write(String.format("Value: %.2f%c%s", weightedValue*100f, '%', System.lineSeparator()));
					if (toLock && !art.locked) {
						bw.write("Look into locking");
						bw.newLine();
					} else if (!toLock && art.locked){
						bw.write("Look into unlocking");
						bw.newLine();
					}
					bw.newLine();
				}
			}
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("Locks: %d -> %d%s", oglocks, newlocks, System.lineSeparator());
		print(offPieces);
	}
	
	public static void increment(HashMap<Slot, HashMap<Stat, Integer>> map, Slot slot, Stat stat) {
		if (!map.containsKey(slot)) {
			map.put(slot, new HashMap<Stat, Integer>());
		}
		if (!map.get(slot).containsKey(stat)) {
			map.get(slot).put(stat, 0);
		}
		map.get(slot).put(stat, map.get(slot).get(stat).intValue() + 1);
	}
	
	public static void print(HashMap<Slot, HashMap<Stat, Integer>> map) {
		System.out.println("Off pieces locked:");
		for (Slot smolMap: map.keySet()) {
			System.out.println(smolMap.key + ":");
			for (Stat mapmap: map.get(smolMap).keySet()) {
				System.out.printf("  %s: %d%s", mapmap.key, map.get(smolMap).get(mapmap).intValue(), System.lineSeparator());
			}
		}
	}
	
}
