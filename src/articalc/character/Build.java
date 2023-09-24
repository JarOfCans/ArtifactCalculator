package articalc.character;

import java.util.Arrays;
import java.util.HashMap;

import articalc.artifact.Artifact;
import articalc.enums.*;
import articalc.enums.Characters;

public abstract class Build {
	public Characters character;
	public float priority;
	public HashMap<Stat, Float> sands;
	public HashMap<Stat, Float> goblet;
	public HashMap<Stat, Float> circlet;
	public HashMap<Stat, Float> subs;
	public HashMap<Stat, Float> set2pc;
	public HashMap<Set, Float> set4pc;
	public HashMap<Stat, Float> expectedSubsValue;
	public HashMap<Stat, Float> highestSubValue;
	public HashMap<Stat, Float> bestFourValues;
	public Build(Characters character, float priority) {
		this.character = character;
		this.priority = priority;
		this.sands = new HashMap<Stat, Float>();
		this.goblet = new HashMap<Stat, Float>();
		this.circlet = new HashMap<Stat, Float>();
		this.subs = new HashMap<Stat, Float>();
		this.set2pc = new HashMap<Stat, Float>();
		this.set4pc = new HashMap<Set, Float>();
		this.expectedSubsValue = new HashMap<Stat, Float>();
		this.highestSubValue = new HashMap<Stat, Float>();
		this.bestFourValues = new HashMap<Stat, Float>();
		sands(sands);
		goblet(goblet);
		circlet(circlet);
		subs(subs);
		twoPiece(set2pc);
		fourPiece(set4pc);
		
		for (Stat mainstat: Stat.mains()) {
			float val1=0f;
			float val2=0f;
			float val3=0f;
			float val4=0f;
			for (Stat hoi: subs.keySet()) {
				if (mainstat != hoi) {
					float value = subs.get(hoi);
					if (value > val1) {
						val4 = val3;
						val3 = val2;
						val2 = val1;
						val1 = value;
					}
					else if (value > val2) {
						val4 = val3;
						val3 = val2;
						val2 = value;
					}
					else if (value > val3) {
						val4 = val3;
						val3 = value;
					}
					else if (value > val4) {
						val4 = value;
					}
				}
			}
			expectedSubsValue.put(mainstat, expectedValue(val1,val2,val3,val4));
			highestSubValue.put(mainstat, val1);
			bestFourValues.put(mainstat, val1+val2+val3+val4);
		}
		
	}
	public abstract void twoPiece(HashMap<Stat, Float> stats);
	public abstract void fourPiece(HashMap<Set, Float> sets);
	public abstract void sands(HashMap<Stat, Float> stats);
	public abstract void goblet(HashMap<Stat, Float> stats);
	public abstract void circlet(HashMap<Stat, Float> stats);
	public abstract void subs(HashMap<Stat, Float> stats);

	@Deprecated
	public float getValue(Artifact art) {
		float set2pcValue = (set2pc.containsKey(art.set.set2pc))?set2pc.get(art.set.set2pc):0f;
		float set4pcValue = (set4pc.containsKey(art.set))?set4pc.get(art.set):0f;
		float output = Math.max(set2pcValue, set4pcValue) * 6f;
		
		float base = 9+6;
		switch (art.slot) {
		case flower:
		case plume:
			break;
		case sands:
			if (sands.containsKey(art.mainStat))
			output += sands.get(art.mainStat) * 9f;
			base += 9;
			break;
		case goblet:
			if (goblet.containsKey(art.mainStat))
			output += goblet.get(art.mainStat) * 9f;
			base += 9;
			break;
		case circlet:
			if (circlet.containsKey(art.mainStat))
			output += circlet.get(art.mainStat) * 9f;
			base += 9;
			break;
		}
		
		
		for (int i = 0; i < 4; i++) {
			Stat stat = art.subs[i];
			if (stat != null && subs.containsKey(stat)) {
				output += subs.get(stat) * art.subValues[i] / stat.subMax;
			}
		}
		return output/base;
	}
	

	public float getValueUpdated(Artifact art) {
		float set2pcValue = (set2pc.containsKey(art.set.set2pc))?set2pc.get(art.set.set2pc):0f;
		float set4pcValue = (set4pc.containsKey(art.set))?set4pc.get(art.set):0f;
		float output = Math.max(set2pcValue, set4pcValue) * 6f;
		//Set base score
		float base = 6;
		//Mainstat base score
		switch (art.slot) {
		case flower:
		case plume:
			break;
		case sands:
			if (sands.containsKey(art.mainStat))
			output += sands.get(art.mainStat) * 9f;
			base += 9;
			break;
		case goblet:
			if (goblet.containsKey(art.mainStat))
			output += goblet.get(art.mainStat) * 9f;
			base += 9;
			break;
		case circlet:
			if (circlet.containsKey(art.mainStat))
			output += circlet.get(art.mainStat) * 9f;
			base += 9;
			break;
		}
		
		//Subs base score
		for (int i = 0; i < 4; i++) {
			Stat stat = art.subs[i];
			if (stat != null && subs.containsKey(stat)) {
				output += subs.get(stat) * art.subValues[i] / stat.subMax;
			}
		}
		base += bestFourValues.get(art.mainStat);
		base += highestSubValue.get(art.mainStat)*5f;
		return output/base;
	}

	@Deprecated
	public float getFutureValue(Artifact art, boolean scale) {
		if (art.set == null) {
			System.out.println(art);
		}
		float set2pcValue = (set2pc.containsKey(art.set.set2pc))?set2pc.get(art.set.set2pc):0f;
		float set4pcValue = (set4pc.containsKey(art.set))?set4pc.get(art.set):0f;
		float output = Math.max(set2pcValue, set4pcValue) * 6f;
		
		float base = 6+9;
		switch (art.slot) {
		case flower:
		case plume:
			break;
		case sands:
			if (sands.containsKey(art.mainStat))
			output += sands.get(art.mainStat) * 9f;
			base += 9;
			break;
		case goblet:
			if (goblet.containsKey(art.mainStat))
			output += goblet.get(art.mainStat) * 9f;
			base += 9;
			break;
		case circlet:
			if (circlet.containsKey(art.mainStat))
			output += circlet.get(art.mainStat) * 9f;
			base += 9;
			break;
		}
		
		
		for (int i = 0; i < 4; i++) {
			Stat stat = art.subs[i];
			if (stat != null && subs.containsKey(stat)) {
				output += subs.get(stat) * art.subValues[i] / stat.subMax;
			}
		}
		
		if (art.level < 20) {
			if (scale) {
				float[] array = {subs.containsKey(art.subs[0])?subs.get(art.subs[0]):0f, subs.containsKey(art.subs[1])?subs.get(art.subs[1]):0f,
						subs.containsKey(art.subs[2])?subs.get(art.subs[2]):0f, subs.containsKey(art.subs[3])?subs.get(art.subs[3]):0f};
				Arrays.sort(array);
				float avgMaxValue = array[0] * 0.15f + array[1] * 0.15f + array[2] * 0.3f + array[3] * 0.4f;
				output += avgMaxValue * (5 - art.level/4);
			} else {
				float avgMaxValue = (subs.containsKey(art.subs[0])?subs.get(art.subs[0]):0f) + 
						(subs.containsKey(art.subs[1])?subs.get(art.subs[1]):0f) +
						(subs.containsKey(art.subs[2])?subs.get(art.subs[2]):0f) +
						(subs.containsKey(art.subs[3])?subs.get(art.subs[3]):0f);
				output += avgMaxValue * (5 - art.level/4) / ((art.subs[3] == null)?3.5f:4);
			}
		}
		return output/base;
	}
	
	public float getFutureValueUpdated(Artifact art, boolean scale) {
		if (art.set == null) {
			System.out.println(art);
		}
		float set2pcValue = (set2pc.containsKey(art.set.set2pc))?set2pc.get(art.set.set2pc):0f;
		float set4pcValue = (set4pc.containsKey(art.set))?set4pc.get(art.set):0f;
		float output = Math.max(set2pcValue, set4pcValue) * 6f;
		
		float base = 6;
		switch (art.slot) {
		case flower:
		case plume:
			break;
		case sands:
			if (sands.containsKey(art.mainStat))
			output += sands.get(art.mainStat) * 9f;
			base += 9;
			break;
		case goblet:
			if (goblet.containsKey(art.mainStat))
			output += goblet.get(art.mainStat) * 9f;
			base += 9;
			break;
		case circlet:
			if (circlet.containsKey(art.mainStat))
			output += circlet.get(art.mainStat) * 9f;
			base += 9;
			break;
		}
		
		
		for (int i = 0; i < 4; i++) {
			Stat stat = art.subs[i];
			if (stat != null && subs.containsKey(stat)) {
				output += subs.get(stat) * art.subValues[i] / stat.subMax;
			}
		}
		base += bestFourValues.get(art.mainStat);
		base += highestSubValue.get(art.mainStat) * art.level/4 + expectedSubsValue.get(art.mainStat) * (5 - art.level/4);
		
		if (art.level < 20) {
			if (scale) {
				float[] array = {subs.containsKey(art.subs[0])?subs.get(art.subs[0]):0f, subs.containsKey(art.subs[1])?subs.get(art.subs[1]):0f,
						subs.containsKey(art.subs[2])?subs.get(art.subs[2]):0f, subs.containsKey(art.subs[3])?subs.get(art.subs[3]):0f};
				Arrays.sort(array);
				float avgMaxValue = array[0] * 0.15f + array[1] * 0.15f + array[2] * 0.3f + array[3] * 0.4f;
				output += avgMaxValue * (5 - art.level/4);
			} else {
				float avgMaxValue = (subs.containsKey(art.subs[0])?subs.get(art.subs[0]):0f) + 
						(subs.containsKey(art.subs[1])?subs.get(art.subs[1]):0f) +
						(subs.containsKey(art.subs[2])?subs.get(art.subs[2]):0f) +
						(subs.containsKey(art.subs[3])?subs.get(art.subs[3]):0f);
				output += avgMaxValue * (5 - art.level/4) / ((art.subs[3] == null)?3.5f:4);
			}
		}
		return output/base;
	}


	@Deprecated
	public float getFutureOffPieceValue(Artifact art, boolean scale) {
		//float set2pcValue = (set2pc.containsKey(art.set.set2pc))?set2pc.get(art.set.set2pc):0f;
		//float set4pcValue = (set4pc.containsKey(art.set))?set4pc.get(art.set):0f;
		float output = 0;
		
		float base = 9;
		switch (art.slot) {
		case flower:
		case plume:
			break;
		case sands:
			if (sands.containsKey(art.mainStat))
			output += sands.get(art.mainStat) * 9f;
			base += 9;
			break;
		case goblet:
			if (goblet.containsKey(art.mainStat))
			output += goblet.get(art.mainStat) * 9f;
			base += 9;
			break;
		case circlet:
			if (circlet.containsKey(art.mainStat))
			output += circlet.get(art.mainStat) * 9f;
			base += 9;
			break;
		}
		
		for (int i = 0; i < 4; i++) {
			Stat stat = art.subs[i];
			if (stat != null && subs.containsKey(stat)) {
				output += subs.get(stat) * art.subValues[i] / stat.subMax;
			}
		}
		
		if (art.level < 20) {
			if (scale) {
				float[] array = {subs.containsKey(art.subs[0])?subs.get(art.subs[0]):0f, subs.containsKey(art.subs[1])?subs.get(art.subs[1]):0f,
						subs.containsKey(art.subs[2])?subs.get(art.subs[2]):0f, subs.containsKey(art.subs[3])?subs.get(art.subs[3]):0f};
				Arrays.sort(array);
				float avgMaxValue = array[0] * 0.15f + array[1] * 0.15f + array[2] * 0.3f + array[3] * 0.4f;
				output += avgMaxValue * (5 - art.level/4);				
			} else {
				float avgMaxValue = (subs.containsKey(art.subs[0])?subs.get(art.subs[0]):0f) + 
						(subs.containsKey(art.subs[1])?subs.get(art.subs[1]):0f) +
						(subs.containsKey(art.subs[2])?subs.get(art.subs[2]):0f) +
						(subs.containsKey(art.subs[3])?subs.get(art.subs[3]):0f);
				output += avgMaxValue * (5 - art.level/4) / ((art.subs[3] == null)?3.5f:4);
			}
		}
		return output/base;
	}
	
	public float getFutureOffPieceValueUpdated(Artifact art, boolean scale) {
		//float set2pcValue = (set2pc.containsKey(art.set.set2pc))?set2pc.get(art.set.set2pc):0f;
		//float set4pcValue = (set4pc.containsKey(art.set))?set4pc.get(art.set):0f;
		float output = 0;
		
		float base = 0;
		switch (art.slot) {
		case flower:
		case plume:
			break;
		case sands:
			if (sands.containsKey(art.mainStat))
			output += sands.get(art.mainStat) * 9f;
			base += 9;
			break;
		case goblet:
			if (goblet.containsKey(art.mainStat))
			output += goblet.get(art.mainStat) * 9f;
			base += 9;
			break;
		case circlet:
			if (circlet.containsKey(art.mainStat))
			output += circlet.get(art.mainStat) * 9f;
			base += 9;
			break;
		}
		
		for (int i = 0; i < 4; i++) {
			Stat stat = art.subs[i];
			if (stat != null && subs.containsKey(stat)) {
				output += subs.get(stat) * art.subValues[i] / stat.subMax;
			}
		}
		base += bestFourValues.get(art.mainStat);
		base += highestSubValue.get(art.mainStat) * art.level/4 + expectedSubsValue.get(art.mainStat) * (5 - art.level/4);
		
		if (art.level < 20) {
			if (scale) {
				float[] array = {subs.containsKey(art.subs[0])?subs.get(art.subs[0]):0f, subs.containsKey(art.subs[1])?subs.get(art.subs[1]):0f,
						subs.containsKey(art.subs[2])?subs.get(art.subs[2]):0f, subs.containsKey(art.subs[3])?subs.get(art.subs[3]):0f};
				Arrays.sort(array);
				float avgMaxValue = array[0] * 0.15f + array[1] * 0.15f + array[2] * 0.3f + array[3] * 0.4f;
				output += avgMaxValue * (5 - art.level/4);				
			} else {
				float avgMaxValue = (subs.containsKey(art.subs[0])?subs.get(art.subs[0]):0f) + 
						(subs.containsKey(art.subs[1])?subs.get(art.subs[1]):0f) +
						(subs.containsKey(art.subs[2])?subs.get(art.subs[2]):0f) +
						(subs.containsKey(art.subs[3])?subs.get(art.subs[3]):0f);
				output += avgMaxValue * (5 - art.level/4) / ((art.subs[3] == null)?3.5f:4);
			}
		}
		//System.out.println(System.lineSeparator() + this.toString() + " base : " + base);
		return output/base;
	}

	public float getOffPieceValueUpdated(Artifact art) {
		//No mainstat bonus
		float output = 0;
		//Set base score
		float base = 0;
		//Mainstat base score
		switch (art.slot) {
		case flower:
		case plume:
			break;
		case sands:
			if (sands.containsKey(art.mainStat))
			output += sands.get(art.mainStat) * 9f;
			base += 9;
			break;
		case goblet:
			if (goblet.containsKey(art.mainStat))
			output += goblet.get(art.mainStat) * 9f;
			base += 9;
			break;
		case circlet:
			if (circlet.containsKey(art.mainStat))
			output += circlet.get(art.mainStat) * 9f;
			base += 9;
			break;
		}
		
		//Subs base score
		for (int i = 0; i < 4; i++) {
			Stat stat = art.subs[i];
			if (stat != null && subs.containsKey(stat)) {
				output += subs.get(stat) * art.subValues[i] / stat.subMax;
			}
		}
		base += bestFourValues.get(art.mainStat);
		base += highestSubValue.get(art.mainStat)*5f;
		return output/base;
	}
	
	public Float expectedValue(float val1, float val2, float val3, float val4) {
		return (val1*0.4f + val2*0.3f + val3*0.15f + val4*0.15f);
	}
	
	@Override
	public String toString() {
		return character.toString() + " " + this.getClass().getSimpleName();
	}
}
