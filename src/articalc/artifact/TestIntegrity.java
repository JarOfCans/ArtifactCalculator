package articalc.artifact;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import articalc.enums.Set;
import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;

public class TestIntegrity {
	
	public static void main(String[] args) throws IOException {
		ArtifactParser moo = new ArtifactParser("genshinData_GOOD_2023_07_19_16_49.json");
		float minValue = 0.24f;
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"))) {
			bw.write("Character, Build, %");
			bw.newLine();
		for (Characters cha: Characters.values()) {
			if (cha.characterPriority >= minValue) {
			for (Build hoi: cha.cb.cb) {
				BestN bestn = new BestN(1, hoi, false);
				for (Artifact art: moo.artifacts) {
					if (!art.inUse) {
						bestn.addArtifact(art);
					}
				}
				System.out.println(hoi);
				System.out.println(bestn);
				bestn.inUse(1);
				bw.write(hoi.character.toString() + ",");
				bw.write(hoi.getClass().getSimpleName() + ",");
				float value = 0f;
				for (int i =0; i < 5; i++) {
					value += hoi.getValueUpdated(bestn.artifacts[i][0]);
				}
				bw.write("= " + value + "/" + 5 + ",");
				for (int i =0; i < 5; i++) {
					bw.write(bestn.artifacts[i][0].toString().replaceAll(",", "") + ",");
				}
				bw.newLine();
			}
			}
		}
		}
		
	}
	
	
	
}
