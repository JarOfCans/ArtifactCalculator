package articalc.artifact;

import java.util.Collections;

import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Stat;

public class TestBuilds {

	public static void main(String [] args) throws InterruptedException {
		for (Characters cha: Characters.values()) {
			System.out.println(cha.toString());
			int runs = 0;
			for (Build hoi: cha.cb.cb) {
				runs++;
				String buildname = " " + hoi.getClass().getSimpleName();
				System.out.println(buildname + " (" + hoi.bestFourValues.get(Stat.Physical) + ")");
				if (hoi.set2pc.get(Stat.ATK) != null || hoi.set2pc.get(Stat.DEF) != null || hoi.set2pc.get(Stat.HP) != null) {
					System.err.printf("%s Flat in 2 pc%s", buildname, System.lineSeparator());
				}
				if (hoi.sands.get(Stat.ATK) != null || hoi.sands.get(Stat.DEF) != null || hoi.sands.get(Stat.HP) != null) {
					System.err.printf("%s Flat in Sands%s", buildname, System.lineSeparator());
				}
				if (hoi.goblet.get(Stat.ATK) != null || hoi.goblet.get(Stat.DEF) != null || hoi.goblet.get(Stat.HP) != null) {
					System.err.printf("%s Flat in Goblet%s", buildname, System.lineSeparator());
				}
				if (hoi.circlet.get(Stat.ATK) != null || hoi.circlet.get(Stat.DEF) != null || hoi.circlet.get(Stat.HP) != null) {
					System.err.printf("%s Flat in Circlet%s", buildname, System.lineSeparator());
				}
				if (hoi.subs.get(Stat.ATK) != null && hoi.subs.get(Stat.ATK)/hoi.subs.get(Stat.ATKP) > 0.49f) {
					System.err.printf("%s Abnormally large flat ATK%s", buildname, System.lineSeparator());
				}
				if (hoi.subs.get(Stat.DEF) != null &&hoi.subs.get(Stat.DEF)/hoi.subs.get(Stat.DEFP) > 0.49f) {
					System.err.printf("%s Abnormally large flat DEF%s", buildname, System.lineSeparator());
				}
				if (hoi.subs.get(Stat.HP) != null &&hoi.subs.get(Stat.HP)/hoi.subs.get(Stat.HPP) > 0.49f) {
					System.err.printf("%s Abnormally large flat HP%s", buildname, System.lineSeparator());
				}
				if (hoi.set2pc.values().size() > 0 && Collections.max(hoi.set2pc.values()) > 1f) {
					System.err.printf("%s abnormally large value in 2 pc%s", buildname, System.lineSeparator());
				}
				if (hoi.set4pc.values().size() > 0 && Collections.max(hoi.set4pc.values()) > 1f) {
					System.err.printf("%s abnormally large value in 4 pc%s", buildname, System.lineSeparator());
				}
				if (Collections.max(hoi.sands.values()) > 1f) {
					System.err.printf("%s abnormally large value in Sands%s", buildname, System.lineSeparator());
				}
				if (Collections.max(hoi.goblet.values()) > 1f) {
					System.err.printf("%s abnormally large value in Goblet%s", buildname, System.lineSeparator());
				}
				if (Collections.max(hoi.circlet.values()) > 1f) {
					System.err.printf("%s abnormally large value in Circlet%s", buildname, System.lineSeparator());
				}
				if (Collections.max(hoi.subs.values()) > 1f) {
					System.err.printf("%s abnormally large value in Substats%s", buildname, System.lineSeparator());
				}
				//@Deprecated
				/*if (hoi.bestFourValues.get(Stat.Physical) < 3.5f) {
					System.err.printf("%s needs higher substat values (currently %.2f)%s", buildname, hoi.bestFourValues.get(Stat.Physical), System.lineSeparator());
				}*/
			}
			if (runs == 0) {
				System.err.println(" No builds for character " + cha.toString());
			}
		}
	}
}
