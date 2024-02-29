package articalc.brute;

import articalc.artifact.Artifact;
import articalc.enums.Stat;
import articalc.math.FutureSubs;

public class DataPack implements Comparable<DataPack>{
	public float[] percentGood;
	public float[] value;
	public float[] chance;
	public float[] subValue;
	public Stat[] sub;
	public Artifact artifact;
	float chanceGood;
	public DataPack(Artifact art) {
		artifact = art;
		chanceGood = FutureSubs.getFutureValue(art);
		if (art.subs[3] == null || art.subs[3] == Stat.NULL) {
			int subCount = (Stat.subsNotNULL().size()-((art.mainStat.subChance > 0f)?4:3))*4;
			percentGood = new float[subCount];
			value = new float[subCount];
			chance = new float[subCount];
			subValue = new float[subCount];
			sub = new Stat[subCount];
			float subDivide = (1f-art.subs[0].subChance-art.subs[1].subChance-art.subs[2].subChance - art.mainStat.subChance);
			int slot = 0;
			for (Stat stat: Stat.subsNotNULL()) {
				if (art.subs[0] != stat && art.subs[1] != stat && art.subs[2] != stat && art.mainStat != stat) {
					float statChance = stat.subChance/(subDivide*4f);
					for (int i = 0; i < 4; i++, slot++) {
						sub[slot] = stat;
						chance[slot] = statChance;
						subValue[slot] = stat.subMax*(1-0.1f*i);
						Artifact clone = art.clone();
						clone.subs[3] = stat;
						clone.subValues[3] = subValue[slot];
						clone.level += 4;
						percentGood[slot] = FutureSubs.getFutureValue(clone);
						value[slot] = clone.getFutureValue();
					}
				}
			}
		} else {
			int subCount = 16;
			percentGood = new float[subCount];
			value = new float[subCount];
			chance = new float[subCount];
			subValue = new float[subCount];
			sub = new Stat[subCount];
			for (int i = 0; i < subCount; i++) {
				int slot = i/4;
				sub[i] = art.subs[slot];
				chance[i] = 1f/16f;
				subValue[i] = art.subValues[slot] + art.subs[slot].subMax*(1-0.1f*(i%4));
				Artifact clone = art.clone();
				clone.subValues[slot] = subValue[i];
				clone.level += 4;
				percentGood[i] = FutureSubs.getFutureValue(clone);
				value[i] = clone.getFutureValue();
			}
		}
	}
	@Override
	public String toString() {

		String output = "";
			DataPack dp = this;
			output += artifact + System.lineSeparator();
			output += String.format("  %.2f%c%s",chanceGood*100f,'%',System.lineSeparator());
			for (int i = 0; i < dp.percentGood.length; i++) {
				output += String.format("    %-4s %-6.2f:%5.1f%c,%6.1f value (%.1f%c chance)%s", dp.sub[i], dp.subValue[i], dp.percentGood[i]*100f,'%', dp.value[i]*100f, dp.chance[i]*100f,'%', System.lineSeparator());
			}
		//System.out.println(output);
		return output;
	}
	@Override
	public int compareTo(DataPack o) {
		return (int)(o.chanceGood*1000 - this.chanceGood*1000);
	}
}
