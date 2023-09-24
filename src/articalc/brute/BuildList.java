package articalc.brute;

import java.util.ArrayList;

import articalc.enums.Characters;
import articalc.enums.*;
import articalc.character.*;

public class BuildList {
	public static void main(String[] args) {
		Characters[] characters = Characters.values();
		ArrayList<Build> builds = new ArrayList<Build>();
		for (int i = 0; i < characters.length; i++) {
			for (Build hoi: characters[i].cb.cb) {
				builds.add(hoi);
			}
		}
		for (int i = 0; i < builds.size(); i++) {
			System.out.printf("%d. %s %s%s", i+1, builds.get(i).character,builds.get(i).getClass().getSimpleName(), System.lineSeparator());
		}
	}
	
}
