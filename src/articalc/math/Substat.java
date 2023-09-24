package articalc.math;

import articalc.enums.*;

public class Substat {
	public static float FOURPIECECHANCE = .2f;
	public static float getChance(Stat main, Stat...subs) {
		float chanceSum = 0f;
		Stat[] stats = new Stat[4];
		
		for (int i1 = 0; i1 < 4; i1++) {
			stats[0] = subs[i1];
			for (int i2 = 0; i2 < 4; i2++) {
				if (i1 != i2) {
					stats[1] = subs[i2];
					for (int i3 = 0; i3 < 4; i3++) {
						if (i1 != i3 && i2 != i3) {
							stats[2] = subs[i3];
							for (int i4 = 0; i4 < 4; i4++) {
								if (i1 != i4 && i2 != i4 && i3 != i4) {
									stats[3] = subs[i4];
									float output = 1f;
									float chanceSumTemp = main.subChance;
									for (Stat stat : stats) {
										if (stat != Stat.NULL && stat != null) {
											float chance = stat.subChance;
											output *= chance/(1f - chanceSumTemp);
											chanceSumTemp += chance;
										}
									}
									chanceSum += output;
								}
							}
						}
					}
				}
			}
		}
		if (subs[3] == null || subs[3] == Stat.NULL) {
			chanceSum *= (1 - FOURPIECECHANCE)/4f;
		} else {
			chanceSum *= FOURPIECECHANCE;
		}
		/*System.out.print("{");
		for (int i = 0; i < 4; i++) {
			System.out.print(subs[i] + " ");
		}
		System.out.println("}: " + chanceSum);*/
		return chanceSum;
	}
	public static float getChance(Slot slot, Stat main, Stat...subs) {
		float chanceSum = 0f;
		Stat[] stats = new Stat[4];
		
		for (int i1 = 0; i1 < 4; i1++) {
			stats[0] = subs[i1];
			for (int i2 = 0; i2 < 4; i2++) {
				if (i1 != i2) {
					stats[1] = subs[i2];
					for (int i3 = 0; i3 < 4; i3++) {
						if (i1 != i3 && i2 != i3) {
							stats[2] = subs[i3];
							for (int i4 = 0; i4 < 4; i4++) {
								if (i1 != i4 && i2 != i4 && i3 != i4) {
									stats[3] = subs[i4];
									float output = 1f;
									float chanceSumTemp = main.subChance;
									for (Stat stat : stats) {
										float chance = stat.subChance;
										output *= chance/(1f - chanceSumTemp);
										chanceSumTemp += chance;
									}
									chanceSum += output;
								}
							}
						}
					}
				}
			}
		}
		return chanceSum;
	}
}
