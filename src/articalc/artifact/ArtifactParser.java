package articalc.artifact;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import articalc.enums.*;
import articalc.enums.Characters;

public class ArtifactParser {
	public ArrayList<Artifact> artifacts;
	
	public ArtifactParser(String filename) {
		JSONParser parser = new JSONParser();
		artifacts = new ArrayList<Artifact>();
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(filename));
			JSONArray artifactsJSON = (JSONArray) json.get("artifacts");
			for (Object goods: artifactsJSON) {
				//System.out.println(goods);
				JSONObject artifact = (JSONObject)goods;
				switch(((Long)artifact.get("rarity")).intValue()) {
				case 5:
					int level = ((Long)artifact.get("level")).intValue();
					Set set = Set.setKey.get((String)artifact.get("setKey"));
					Artifact temp = new Artifact(set, level);
					temp.slot = Slot.slotKey.get((String)artifact.get("slotKey"));
					temp.mainStat = Stat.statKey.get((String)artifact.get("mainStatKey"));
					temp.locked = (Boolean)artifact.get("lock");
					JSONArray subsArray = (JSONArray) artifact.get("substats");
					for (int i = 0; i < subsArray.size(); i++) {
						temp.subs[i] = Stat.statKey.get((String)((JSONObject)subsArray.get(i)).get("key"));
						//System.out.println(subs[i]);
						temp.subValues[i] = ((Double)((JSONObject)subsArray.get(i)).get("value")).floatValue();
					}
					artifacts.add(temp);
				default:
					//Nothing
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*BestN albedoN = new BestN(4, Characters.Ganyu.cb, false);
		BestN albedoNfuture = new BestN(4, Characters.Ganyu.cb, true);
		for (Artifact hoi: artifacts) {
			albedoN.addArtifact(hoi);
			albedoNfuture.addArtifact(hoi);
		}
		System.out.println(albedoN);
		System.out.println(albedoNfuture);*/
	}
	
	
}
