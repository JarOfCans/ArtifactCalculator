package articalc.artifact;

import java.util.Arrays;
import java.util.HashMap;

import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.Stat;
import articalc.math.FutureSubs;

public class TestArtifact {

	public static void main(String[] args) throws InterruptedException {
		//TestBuilds.main(args);
		
		//Artifact art = new Artifact(Set.Emblem,0);
 		Artifact art = new Artifact(Set.Nymph, 4);
		art.slot = Slot.goblet;
		art.mainStat = Stat.Hydro;
		art.addSub(0, Stat.CR, 3.1f);
		art.addSub(1, Stat.DEF, 16f);
		art.addSub(2, Stat.HPP, 4.1f);
		art.addSub(3, Stat.ATKP, 5.8f);
		//long time = System.currentTimeMillis();
		testArtifact(art, FutureSubs.REQUIREMENT);
		//System.out.println(System.currentTimeMillis() - time);
		//time = System.currentTimeMillis();
		//FutureSubs.getFutureValue(art);
		//System.out.println(System.currentTimeMillis() - time);
		//time = System.currentTimeMillis();
		//System.out.println(Characters.Thoma.cb.cb.get(1).getValueUpdated(art));
		//System.out.println(Characters.Thoma.cb.cb.get(1).getFutureOffPieceValueUpdated(art, true));
		//System.out.println(System.currentTimeMillis() - time);
		//testArtifactBrrrrr(art, FutureSubs.REQUIREMENT, true);
		//System.out.println(FutureSubs.getFutureValue(art));
		//time = System.currentTimeMillis();
		System.out.println(FutureSubs.getFourthSubArray(art));
		//System.out.println(System.currentTimeMillis() - time);
		//printArtBuildArray(art, 75);
		//art = art.newRandomArtifactDomain(Set.Deepwood, Set.Gilded);
		
	}
	
	public static float testArtifact(Artifact art, float threshold) {
		//threshold -= (art.level/4)/100f;
		//System.out.println(threshold);
		Build bestBuild = null;
		float bestFValue = -1f;
		float bestCValue = 0f;
		
		Build bestBuildOff = null;
		float bestOPValue = -1f;
		
		//correct lazy mainstat
		switch (art.slot) {
		case flower:
			art.mainStat = Stat.HP;
			break;
		case plume:
			art.mainStat = Stat.ATK;
			break;
		}
		int good = 0;
		System.out.println(art);
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {
				float value = hoi.getValueUpdated(art);
				float fvalue = hoi.getFutureValueUpdated(art, true);
				float opvalue = hoi.getFutureOffPieceValueUpdated(art, true);
				if (fvalue > threshold) {
					System.out.printf("onpiece %s %s: %.2f%c - %.2f%c%s",hoi.character, hoi.getClass().getSimpleName(), value*100f,'%',fvalue*100f,'%',System.lineSeparator());
					good++;
				}
				if (opvalue > threshold + Slot.rarityMod(art.slot, art.mainStat)) {
					System.out.printf("offpiece %s %s: %.2f%c%s",hoi.character, hoi.getClass().getSimpleName(), opvalue*100f,'%',System.lineSeparator());
					good++;
				}
				if (fvalue >= bestFValue) {
					bestBuild = hoi;
					bestFValue = fvalue;
					bestCValue = value;
				}
				
				if (opvalue >= bestOPValue) {
					bestBuildOff = hoi;
					bestOPValue = opvalue;
				}
			}
		}
		if (good < 1) {
			System.out.println(" None are valid");
		}
		System.out.println("Best build:");
		System.out.printf(" on piece %s %s: %.2f%c - %.2f%c%s",bestBuild.character, bestBuild.getClass().getSimpleName(), bestCValue*100f,'%',bestFValue*100f,'%',System.lineSeparator());
		System.out.printf(" offpiece %s %s: %.2f%c%s",bestBuildOff.character, bestBuildOff.getClass().getSimpleName(), bestOPValue*100f,'%',System.lineSeparator());
		return Math.max(bestCValue, bestOPValue);
	}
	
	public static float testArtifactBrrrrr(Artifact art, float threshold, boolean reduced) {
		//threshold -= (5)/100f;
		
		//if (!reduced)
			//System.out.println(threshold);
		
		Build bestBuild = null;
		float bestFValue = -1f;
		float bestCValue = 0f;
		
		Build bestBuildOff = null;
		float bestOPValue = -1f;
		
		//correct lazy mainstat
		switch (art.slot) {
		case flower:
			art.mainStat = Stat.HP;
			break;
		case plume:
			art.mainStat = Stat.ATK;
			break;
		}
		if (!reduced)
			System.out.println(art);
		
		int runs = 10000;
		HashMap<Build, Float> fValue = new HashMap<Build, Float>();
		HashMap<Build, Float> opValue = new HashMap<Build, Float>();
		HashMap<Build, Integer> fValueNum = new HashMap<Build, Integer>();
		HashMap<Build, Integer> opValueNum = new HashMap<Build, Integer>();
		int num = 0;
		HashMap<Build, Float> cValue = new HashMap<Build, Float>();
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {
				cValue.put(hoi, hoi.getValueUpdated(art));
				fValue.put(hoi, 0f);
				opValue.put(hoi, 0f);
				fValueNum.put(hoi, 0);
				opValueNum.put(hoi, 0);
			}
		}
		for (int i = 0; i < runs; i++) {
			//Clone artifact to not mess with original
			Artifact testArtifact = art.clone();
			//Level the clone to 20
			testArtifact.randomlyLevel(20 - art.level);
			//System.out.println(testArtifact);
			boolean keeper = false;
			//For each Character Build
			for (Characters cha: Characters.values()) {
				for (Build hoi: cha.cb.cb) {
					//Find the On piece and off piece value
					float fvalue = hoi.getValueUpdated(testArtifact);
					float opvalue = hoi.getOffPieceValueUpdated(testArtifact);
					//Add those values to the maps of that build
					fValue.put(hoi, fValue.get(hoi) + fvalue);
					opValue.put(hoi, opValue.get(hoi) + opvalue);
					
					//If either is higher than threshold, mark this clone as a good artifact future
					if (fvalue >= threshold) {
						fValueNum.put(hoi, fValueNum.get(hoi) + 1);
						keeper = true;
					}
					if (opvalue >= threshold + Slot.rarityMod(testArtifact.slot, testArtifact.mainStat)) {
						opValueNum.put(hoi, opValueNum.get(hoi) + 1);
						keeper = true;
					}
				}
			}
			if (keeper) {
				num++;
			}
			
			
			
		}
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {

				fValue.put(hoi, fValue.get(hoi)/(float)runs);
				opValue.put(hoi, opValue.get(hoi)/runs);
				if (fValueNum.get(hoi) + opValueNum.get(hoi) > 0 && !reduced) {
					System.out.printf("%s %s (%.2f%c)%s", hoi.character, hoi.getClass().getSimpleName(), cValue.get(hoi)*100f,'%',System.lineSeparator());
					System.out.printf("   offpiece: %.2f%c, #%d (%.2f%c) valid%s", opValue.get(hoi)*100f,'%',opValueNum.get(hoi), opValueNum.get(hoi)/(float)runs*100f,'%',System.lineSeparator());
					System.out.printf("   onpiece: %.2f%c, #%d (%.2f%c) valid%s", fValue.get(hoi) *100f,'%',fValueNum.get(hoi), fValueNum.get(hoi)/(float)runs*100f,'%',System.lineSeparator());
					}
				if (fValue.get(hoi) > bestFValue) {
					bestBuild = hoi;
					bestFValue = fValue.get(hoi);
				}
				
				if (opValue.get(hoi) > bestOPValue) {
					bestBuildOff = hoi;
					bestOPValue = opValue.get(hoi);
				}
			}
		}
		System.out.println("-----------");
		System.out.println("Best build Prediction:");
		System.out.printf(" on piece %s %s: %.2f%c%s",bestBuild.character, bestBuild.getClass().getSimpleName(), bestFValue*100f,'%',System.lineSeparator());
		System.out.printf(" offpiece %s %s: %.2f%c%s",bestBuildOff.character, bestBuildOff.getClass().getSimpleName(), bestOPValue*100f,'%',System.lineSeparator());

		System.out.printf(" Number Valid: #%d (%.2f%c) %s",num, num/(float)runs*100f,'%',System.lineSeparator());

		
		return Math.max(bestCValue, bestOPValue);
	}
	
	public static void printArtBuildArray(Artifact art, Build b) {
		System.out.println(art);
		System.out.println(b.toString());
		float[] array = FutureSubs.getFutureValueArray(b, art, true);
		float sum = 0f;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				System.out.printf("%d%c: %.1f%c%s", i, '%', array[i]*100f,'%', System.lineSeparator());
				sum += array[i];
			}
		}
		System.out.println(sum);
	}
	
	public static void printArtBuildArray(Artifact art) {
		System.out.println(art);
		float[] array = FutureSubs.getFutureValueArray(art);
		//float sum = 0f;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				System.out.printf("%d%c: %.1f%c%s", i, '%', array[i]*100f,'%', System.lineSeparator());
				//sum += array[i];
			}
		}
		//System.out.println(sum);
	}
	public static void printArtBuildArray(Artifact art, int value) {
		System.out.println(art);
		float[] array = FutureSubs.getFutureValueArray(art);
		float sum = 0f;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				System.out.printf("%d%c: %.1f%c%s", i, '%', array[i]*100f,'%', System.lineSeparator());
				if (i >= value) {
					sum += array[i];
				}
			}
		}
		System.out.println(sum);
	}
	
}
