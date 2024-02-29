package articalc.artifact;

import articalc.math.Substat;
import articalc.character.Build;
import articalc.enums.*;

public class Artifact {
	public Stat mainStat;
	public Stat[] subs;
	public Set set;
	public float[] subValues;
	public Slot slot;
	public float chance;
	public int level;
	public boolean inUse;
	public boolean locked;
	public boolean offPieceLocked;
	public static final int[] levelEXP = {0,3000,6725,11150,16300,22200,28875,36375,44725,53950,64075,
	                              75125,87150,100175,115325,132925,153300,176800,203850,
	                              234900,270475};
	
	
	
	public Artifact() {
		subs = new Stat[4];
		subValues = new float[4];
		chance = 0f;
		this.level = 0;
		inUse = false;
		locked = false;
	}

	
	public Artifact(Set set, int level) {
		subs = new Stat[4];
		subValues = new float[4];
		chance = 0f;
		this.set = set;
		this.level = level;
		inUse = false;
		locked = false;
	}
	public void calcChance() {
		this.chance = Substat.getChance(mainStat, subs);
	}
	
	public Artifact clone() {
		Artifact output = new Artifact(set, level);
		output.subs[0] = subs[0];
		output.subs[1] = subs[1];
		output.subs[2] = subs[2];
		output.subs[3] = subs[3];
		output.subValues[0] = subValues[0];
		output.subValues[1] = subValues[1];
		output.subValues[2] = subValues[2];
		output.subValues[3] = subValues[3];
		output.mainStat = mainStat;
		output.chance = chance;
		output.slot = slot;
		return output;
	}
	
	public Stat addSub(int spot, Stat sub, float value) {
		if (sub == Stat.NULL) {
			value = 0f;
		}
		subs[spot] = sub;
		this.subValues[spot] = value;
		return sub;
	}
	
	public static Artifact newRandomArtifactStrongbox(Set set) {
		Substat.FOURPIECECHANCE = 0.34f;
		int subs = (Math.random() < Substat.FOURPIECECHANCE)?4:3;
		Artifact output = new Artifact(set, 0);
		output.randomize(subs);
		return output;
	}
	
	public static Artifact newRandomArtifactDomain(Set set1, Set set2) {
		Substat.FOURPIECECHANCE = (set1 == Set.Wanderers && set2 == Set.Gladiator || set1 == Set.Gladiator && set2 == Set.Wanderers)?0.34f:0.2f;
		int subs = (Math.random() < Substat.FOURPIECECHANCE)?4:3;
		Artifact output = new Artifact((Math.random() < 0.5)?set1:set2, 0);
		output.randomize(subs);
		return output;
	}
	
	private Artifact randomize(int subs) {
		Slot[] slots = {Slot.flower, Slot.plume, Slot.sands, Slot.goblet, Slot.circlet};
		this.slot = slots[(int) (Math.random()*5)];
		
		double chanceSlot = Math.random();
		float sum = 0f;
		for (Stat hoi: Slot.slotStats(this.slot)) {
			sum += Slot.getChance(this.slot, hoi);
			if (sum > chanceSlot) {
				this.mainStat = hoi;
				break;
			}
		}
		for (int i = 0; i < subs; i++) {
			//System.out.println(i);
			double chanceSub = Math.random();
			sum = 0f;
			for (Stat hoi: Stat.subsNotNULL()) {
				sum += hoi.subChance;
				//System.out.println(sum + "<" + chanceSub);
				if (sum > chanceSub) {
					this.subs[i] = hoi;
					break;
				}
			}
			if (this.subs[i] == this.mainStat) {
				i--;
			}
			else {
				for (int j = 0; j < i; j++) {
					//System.out.println(this.subs[i] + "==" + this.subs[j]);
					if (this.subs[i] == this.subs[j]) {
						i--;
						break;
					}
				}
			}
		}
		for (int i = 0; i < subs; i++) {
			this.subValues[i] = this.subs[i].subMax;
			double chanceDecrease = Math.random();
			if (chanceDecrease < 0.25f) {
				this.subValues[i] *= 0.7f;
			}
			else if (chanceDecrease < 0.5f) {
				this.subValues[i] *= 0.8f;
			}
			else if (chanceDecrease < 0.75f) {
				this.subValues[i] *= 0.9f;
			}
		}
		
		
		return this;
	}
	
	public Artifact randomize(int subs, Slot slot, Stat mainStat) {
		this.slot = slot;
		this.mainStat = mainStat;

		float sum;
		for (int i = 0; i < subs; i++) {
			//System.out.println(i);
			double chanceSub = Math.random();
			sum = 0f;
			for (Stat hoi: Stat.subsNotNULL()) {
				sum += hoi.subChance;
				//System.out.println(sum + "<" + chanceSub);
				if (sum > chanceSub) {
					this.subs[i] = hoi;
					break;
				}
			}
			if (this.subs[i] == this.mainStat) {
				i--;
			}
			else {
				for (int j = 0; j < i; j++) {
					//System.out.println(this.subs[i] + "==" + this.subs[j]);
					if (this.subs[i] == this.subs[j]) {
						i--;
						break;
					}
				}
			}
		}
		for (int i = 0; i < subs; i++) {
			this.subValues[i] = this.subs[i].subMax;
			double chanceDecrease = Math.random();
			if (chanceDecrease < 0.25f) {
				this.subValues[i] *= 0.7f;
			}
			else if (chanceDecrease < 0.5f) {
				this.subValues[i] *= 0.8f;
			}
			else if (chanceDecrease < 0.75f) {
				this.subValues[i] *= 0.9f;
			}
		}
		
		
		return this;
	}
	
	public Artifact randomlyLevel(int levels) {
		if (levels + level > 20 || levels < 0) {
			System.err.println(String.format("%d levels given to level %d artifact", levels, level));
			throw new IllegalArgumentException();
		}
		for (int i = level / 4; i < (levels + level) / 4; i++) {
			if (this.subValues[3] == 0) {
			while (this.subValues[3] == 0) {
				double chanceSub = Math.random();
				float sum = 0f;
				for (Stat hoi: Stat.subsNotNULL()) {
					sum += hoi.subChance;
					if (sum > chanceSub) {
						this.subs[3] = hoi;
						break;
					}
				}
				if (this.subs[3] == this.mainStat) {
					//Don't do anything, let it reroll
				}
				else {
					boolean runStats = true;
					for (int j = 0; j < 3; j++) {
						//System.out.println(this.subs[i] + "==" + this.subs[j]);
						if (this.subs[3] == this.subs[j]) {
							runStats = false;
							break;
						}
					}
					if (runStats) {
						this.subValues[3] = this.subs[3].subMax;
						double chanceDecrease = Math.random();
						if (chanceDecrease < 0.25f) {
							this.subValues[3] *= 0.7f;
						}
						else if (chanceDecrease < 0.5f) {
							this.subValues[3] *= 0.8f;
						}
						else if (chanceDecrease < 0.75f) {
							this.subValues[3] *= 0.9f;
						}
					}
				}
			}
			} else {
				int subSlot = (int)(Math.random() * 4);
				float value = this.subs[subSlot].subMax;
				double chanceDecrease = Math.random();
				if (chanceDecrease < 0.25f) {
					value *= 0.7f;
				}
				else if (chanceDecrease < 0.5f) {
					value *= 0.8f;
				}
				else if (chanceDecrease < 0.75f) {
					value *= 0.9f;
				}
				this.subValues[subSlot] += value;
			}
		}
	
		this.level += levels;
		return this;
	}
	
	public float getFutureValue() {
		float max = 0;
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {
				float value = hoi.getFutureValue(this, true);
				float opvalue = hoi.getFutureOffPieceValue(this, true);
				max = Math.max(value, Math.max(max, opvalue));
			}
		}
		return max;
	}
	
	
	@Override
	public String toString() {
		return String.format("Lv%c %d %s %s %s, %.2f %s, %.2f %s, %.2f %s, %.2f %s",
				(locked)? '.': '_',level, mainStat, set, slot,
				subValues[0], subs[0], subValues[1], subs[1], subValues[2], subs[2], subValues[3], subs[3]);
	}
	public String subsString() {
		return String.format("%.2f %s, %.2f %s, %.2f %s, %.2f %s",
				subValues[0], subs[0], subValues[1], subs[1], subValues[2], subs[2], subValues[3], subs[3]);
	}
	
	public String toGood() {
		return String.format("{\"setKey\":\"%s\",\"slotKey\":\"%s\",\"rarity\":5,\"mainStatKey\":\"%s\",\"level\":%d,\"substats\":[{\"key\":%s,\"value\":%.1f},{\"key\":%s,\"value\":%.1f},{\"key\":%s,\"value\":%.1f},{\"key\":%s,\"value\":%.1f}],\"location\":\"\",\"lock\":%s}",
				set.key,
				slot.key,
				mainStat.key,
				level,
				"\"" + subs[0].key + "\"", subValues[0],
				"\"" + subs[1].key + "\"", subValues[1],
				"\"" + subs[2].key + "\"", subValues[2],
				((subs[3] != null && subs[3] != Stat.NULL)?"\"" + subs[3].key + "\"":"null"),
				((subs[3] != null && subs[3] != Stat.NULL)?subValues[3]:0.0),
				(locked)?"true":"false");
	}


	public float getFutureValueUpdated() {
		float max = 0;
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {
				float value = hoi.getFutureValueUpdated(this, true);
				float opvalue = hoi.getFutureOffPieceValueUpdated(this, true);
				max = Math.max(value, Math.max(max, opvalue));
			}
		}
		return max;
	}
	

	public float getUpdatedWeightedValue() {
		float max = 0;
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {
				float value = hoi.getFutureValueUpdated(this, true);
				float opvalue = hoi.getFutureOffPieceValueUpdated(this, true)-Slot.rarityMod(slot, mainStat);
				max = Math.max(value, Math.max(max, opvalue));
			}
		}
		return max ;//+ (this.level/4)*0.01f;
	}
}
