package articalc.brute;

import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.Stat;

public class Sandbox {

	public static void main(String[] args) {
		//MassArt.runMainStat(100000, Set.Exile, Stat.ATK, Slot.plume, 0);
		printBestSubs();
	}
	
	public static void printBestSubs() {
		for (Characters cha: Characters.values()) {
			for (Build hoi: cha.cb.cb) {
			float val1=0f;
			float val2=0f;
			float val3=0f;
			float val4=0f;
			float val5=0f;
			Stat sub1=Stat.NULL;
			Stat sub2=Stat.NULL;
			Stat sub3=Stat.NULL;
			Stat sub4=Stat.NULL;
			Stat sub5=Stat.NULL;
			for (Stat hoiSub: hoi.subs.keySet()) {
					float value = hoi.subs.get(hoiSub);
					if (value > val1) {
						val5 = val4;
						sub5 = sub4;
						val4 = val3;
						sub4 = sub3;
						val3 = val2;
						sub3 = sub2;
						val2 = val1;
						sub2 = sub1;
						val1 = value;
						sub1 = hoiSub;
					}
					else if (value > val2) {
						val5 = val4;
						sub5 = sub4;
						val4 = val3;
						sub4 = sub3;
						val3 = val2;
						sub3 = sub2;
						val2 = value;
						sub2 = hoiSub;
					}
					else if (value > val3) {
						val5 = val4;
						sub5 = sub4;
						val4 = val3;
						sub4 = sub3;
						val3 = value;
						sub3 = hoiSub;
					}
					else if (value > val4) {
						val5 = val4;
						sub5 = sub4;
						val4 = value;
						sub4 = hoiSub;
					} else if (value > val5) {
						val5 = value;
						sub5 = hoiSub;
				}
			}
			System.out.println(hoi + ":");
			if (sub1 != Stat.NULL)
			System.out.println("1. " + sub1 + ": " + val1);
			if (sub2 != Stat.NULL)
			System.out.println("2. " + sub2 + ": " + val2);
			if (sub3 != Stat.NULL)
			System.out.println("3. " + sub3 + ": " + val3);
			if (sub4 != Stat.NULL)
			System.out.println("4. " + sub4 + ": " + val4);
			if (sub5 != Stat.NULL)
			System.out.println("5. " + sub5 + ": " + val5);
			System.out.println("-------------------");
		}}
	}

}
