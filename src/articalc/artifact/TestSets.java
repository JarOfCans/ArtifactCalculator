package articalc.artifact;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.GetAllPermutations;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Slot;
import articalc.enums.Stat;

public class TestSets {
	
	public static final float ONPIECE = .75f;
	public static final float OFFPIECE = .75f;
	public static final float UNOWNEDCHA_INCREASE = 0.05f;
	
	
	public static void main(String[] args) {
		
		HashMap<Stat, ArrayList<Artifact>> arts = GetAllPermutations.allMapCombination();
		
		for (Set set: Set.values()) {
			if (set.fiveStar) {
				float sumChance = 0f;
				for (Slot slot: Slot.values()) {
					for (Stat main: Slot.slotStats(slot)) {
						for (Artifact art: arts.get(main)) {
							art.set = set;
							art.slot = slot;
							boolean addChance = false;
							
							//Block to conditionally set addChance to true
							//addChance = checkWant(Characters.Layla, art) && art.subs[3] == Stat.NULL && art.slot == Slot.flower;
							addChance = checkWant(art);
							//addChance = art.subs[3] != Stat.NULL;
							//End addChance change block
								
							if (addChance) {
								sumChance += art.chance*0.2f*Slot.getChance(slot, main);
							}
						}
					}
				}
				System.out.printf("%s : %.2f%c%s", set.key, sumChance*100f, '%', System.lineSeparator());
			}
		}
	}
	public static boolean checkWant(Artifact art) {

		for (Characters cha: Characters.values()) {
			float inc = (cha.characterPriority > 0.45f)? 0: UNOWNEDCHA_INCREASE;
			for (Build hoi: cha.cb.cb) {
				float fvalue = hoi.getFutureValue(art, true);
				float opvalue = hoi.getFutureOffPieceValue(art, true);
				if (fvalue > ONPIECE + inc || opvalue > OFFPIECE + inc) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean checkWant(Characters cha, Artifact art) {
			float inc = (cha.characterPriority > 0.45f)? 0: UNOWNEDCHA_INCREASE;
			for (Build hoi: cha.cb.cb) {
				float fvalue = hoi.getFutureValue(art, true);
				float opvalue = hoi.getFutureOffPieceValue(art, true);
				if (fvalue > ONPIECE + inc || opvalue > OFFPIECE + inc) {
					return true;
				}
			}
		return false;
	}
}
