package articalc.artifact;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import articalc.character.Build;
import articalc.enums.Characters;

public class ArtifactsToRaise {

	public static void main(String[] args) throws IOException {
		ArtifactParser moo = new ArtifactParser("genshinData_GOOD_2023_07_19_16_49.json");

		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("outputArtifacts.csv"))) {
			bw.write("Level, MainStat, Set, Slot, Sub1, Sub2, Sub3, Sub4, Best On Build, Current, Future, Best off Build, Future, Max");
			bw.newLine();
			for (Artifact art: moo.artifacts) {
				Build bestBuild = null;
				float bestFValue = -1f;
				float bestCValue = 0f;
				
				Build bestBuildOff = null;
				float bestOPValue = -1f;
				for (Characters cha: Characters.values()) {
					for (Build hoi: cha.cb.cb) {

						float value = hoi.getValueUpdated(art);
						float fvalue = hoi.getFutureValueUpdated(art, true);
						float opvalue = hoi.getFutureOffPieceValueUpdated(art, true);
						if (fvalue > bestFValue) {
							bestBuild = hoi;
							bestFValue = fvalue;
							bestCValue = value;
						}
						if (opvalue > bestOPValue) {
							bestBuildOff = hoi;
							bestOPValue = opvalue;
						}
					}
				}
				bw.write(String.format("%d, %s, %s, %s, %s, %s, %.2f, %.2f, %s, %.2f, %.2f", art.level, art.mainStat, art.set, art.slot, art.subsString(),  bestBuild.toString().replaceAll(",", ""), bestCValue, bestFValue, bestBuildOff.toString().replaceAll(",", ""), bestOPValue, Math.max(bestOPValue-0.1f, bestFValue)+(art.level/4)*.01f));
				bw.newLine();
				
				
			}
		}
	}

}
